/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koperasi.dao;

import com.koperasi.db.DBConnection;
import com.koperasi.entities.Admin;
import com.koperasi.entities.PilihBarang;
import com.koperasi.entities.ReportTransaksiPembelian;
import com.koperasi.entities.RequestBarang;
import com.koperasi.entities.RequestDetil;
import com.koperasi.entities.Suplier;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dickajava
 */
public class RequestBarangDAOImpl implements RequestBarangDAO{
    
    
    private Connection connection;
    private PilihBarangDAO pilihBarangDAO;
    private RequestDetilDAOImpl requestDetilDAOImpl;
    private AdminDAO adminDAO;
    private SuplierDAO suplierDAO;
    public RequestBarangDAOImpl(){
        connection=DBConnection.getConnection();
        suplierDAO=new SuplierDAOImpl();
        adminDAO=new AdminDAOImpl();
        pilihBarangDAO=new PilihBarangDAOImpl();
        requestDetilDAOImpl=new RequestDetilDAOImpl();
    }

    @Override
    public String getAutoKode() {
        PreparedStatement statement=null;
        ResultSet rs=null;
        String s,s1;
        String kode=null;
        int j=0;
        int panjang=4;
        String sql="select max(right(idrequest, 4)) from request_barang";
        try {
            statement=connection.prepareStatement(sql);
            rs=statement.executeQuery();
            if(rs.first()==false){
                kode="RB-0001";
            }else{
                rs.last();
                s=Integer.toString(rs.getInt(1)+1);
                j=s.length();
                s1="";
                for(int i=0; i<panjang - j; i++){
                    s1=s1+"0";
                }
                kode="RB-"+s1+s;
            }
            return kode;
        } catch (Exception e) {
            e.printStackTrace();
            return kode;
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(RequestBarangDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(RequestBarangDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public boolean insertRequestBarangFromSuplier(RequestBarang requestBarang) {
      PreparedStatement statement=null;
      boolean valid=false;
      String sql="insert into request_barang (idrequest, idadmin, idsuplier, tanggal, total_request) "
              + "values(?,?,?,?,?)";
        try {
            connection.setAutoCommit(false);
            statement=connection.prepareStatement(sql);
            statement.setString(1, requestBarang.getIdrequest());
            statement.setInt(2, requestBarang.getAdmin().getIdadmin());
            statement.setString(3, requestBarang.getSuplier().getIdsuplier());
            statement.setDate(4, new Date(requestBarang.getTanggal().getTime()));
            statement.setDouble(5, requestBarang.getTotalrequest());
            statement.executeUpdate();
            
            for(RequestDetil requestDetil : requestBarang.getRequestDetils()){
                requestDetilDAOImpl.insertRequestDetils(connection, requestDetil);
                pilihBarangDAO.getTambahJumlahStokBarang(requestDetil.getJumlah(), 
                        requestDetil.getPilihbarang());
            }
            
            connection.commit();
            valid=true;
            connection.setAutoCommit(true);
            
        } catch (Exception e) {
          try {
              connection.rollback();
              connection.setAutoCommit(true);
              e.printStackTrace();
          } catch (SQLException ex) {
              Logger.getLogger(RequestBarangDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
          }
        }
        return valid;
    }

    @Override
    public List<RequestBarang> getListRequest() {
      PreparedStatement statement=null;
      String sql="select * from request_barang";
      ResultSet rs=null;
      List list=new ArrayList();
        try {
            statement=connection.prepareStatement(sql);
            rs=statement.executeQuery();
            while(rs.next()){
                RequestBarang rb=new RequestBarang();
                rb.setIdrequest(rs.getString("idrequest"));
                int idadmin=rs.getInt("idadmin");
                Admin kodadmin=adminDAO.getAdminById(idadmin);
                rb.setAdmin(kodadmin);
                String idsuplier=rs.getString("idsuplier");
                Suplier kodsuplier=suplierDAO.findOneSuplier(idsuplier);
                rb.setSuplier(kodsuplier);
                rb.setTanggal(rs.getDate("tanggal"));
                rb.setTotalrequest(rs.getDouble("total_request"));
                list.add(rb);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(RequestBarangDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(RequestBarangDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(RequestBarangDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public List<ReportTransaksiPembelian> getCetakRequest(String idrequest) {
      PreparedStatement statement=null;
      List list=new ArrayList();
      ResultSet rs=null;
      String sql="select * from request_barang inner join request_detil on "
              + "(request_barang.idrequest=request_detil.idrequest) where request_barang.idrequest=?";
        try {
            statement=connection.prepareStatement(sql);
            statement.setString(1, idrequest);
            rs=statement.executeQuery();
            while(rs.next()){
                ReportTransaksiPembelian rtp=new ReportTransaksiPembelian();
                RequestBarang rb=new RequestBarang();
                  rb.setIdrequest(rs.getString("idrequest"));
                  int kodeadmin=rs.getInt("idadmin");
                  Admin idadmin=adminDAO.getAdminById(kodeadmin);
                  rb.setAdmin(idadmin);
                  String kodeSuplier=rs.getString("idsuplier");
                  Suplier idsuplier=suplierDAO.findOneSuplier(kodeSuplier);
                  rb.setSuplier(idsuplier);
                  rb.setTanggal(rs.getDate("tanggal"));
                  rb.setTotalrequest(rs.getDouble("total_request"));
                rtp.setRequestBarang(rb);
                  RequestDetil rd=new RequestDetil();
                  String idbarang=rs.getString("idbarang");
                  PilihBarang pb=pilihBarangDAO.findOneBarang(idbarang);
                  rd.setBarang(pb);
                  rd.setNama(rs.getString("nama"));
                  rd.setJumlah(rs.getInt("jumlah"));
                  rd.setHarga(rs.getDouble("harga"));
                rtp.setRequestDetil(rd);
                list.add(rtp);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(RequestBarangDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(RequestBarangDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(RequestBarangDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public List<ReportTransaksiPembelian> getCetakRequestByTanggal(java.util.Date tanggalMulai, java.util.Date tanggalAkhir) {
        PreparedStatement statement=null;
        List list=new ArrayList();
        ResultSet rs=null;
        String sql="select * from request_barang inner join request_detil "
                + "on (request_barang.idrequest=request_detil.idrequest) "
                + "where (request_barang.tanggal>=?) and (request_barang.tanggal<=?)";
        try {
            statement=connection.prepareStatement(sql);
            statement.setDate(1, new Date(tanggalMulai.getTime()));
            statement.setDate(2, new Date(tanggalAkhir.getTime()));
            rs=statement.executeQuery();
            while(rs.next()){
                ReportTransaksiPembelian rtp=new ReportTransaksiPembelian();
                RequestBarang rb=new RequestBarang();
                rb.setIdrequest(rs.getString("request_barang.idrequest"));
                int idadmin=rs.getInt("request_barang.idadmin");
                Admin a=adminDAO.getAdminById(idadmin);
                rb.setAdmin(a);
                String idsuplier=rs.getString("request_barang.idsuplier");
                Suplier s=suplierDAO.findOneSuplier(idsuplier);
                rb.setSuplier(s);
                rb.setTanggal(rs.getDate("request_barang.tanggal"));
                rb.setTotalrequest(rs.getDouble("request_barang.total_request"));
                rtp.setRequestBarang(rb);
                  RequestDetil rd=new RequestDetil();
                  String idbarang=rs.getString("request_detil.idbarang");
                  PilihBarang pb=pilihBarangDAO.findOneBarang(idbarang);
                  rd.setBarang(pb);
                  rd.setNama(rs.getString("request_detil.nama"));
                  rd.setJumlah(rs.getInt("request_detil.jumlah"));
                  rd.setHarga(rs.getDouble("request_detil.harga"));
                rtp.setRequestDetil(rd);
                list.add(rtp);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(RequestBarangDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(RequestBarangDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(RequestBarangDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
}
