/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koperasi.dao;

import com.koperasi.db.DBConnection;
import com.koperasi.entities.Admin;
import com.koperasi.entities.PilihBarang;
import com.koperasi.entities.ReportTransaksiPenjualan;
import com.koperasi.entities.Transaksi;
import com.koperasi.entities.TransaksiDetil;
import com.koperasi.internal.InteranalTransaksi;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author dickajava
 */
public class TransaksiDAOImpl implements TransaksiDAO{
    
    private Connection connection;
    private PilihBarangDAO pilihBarangDAO;
    private InteranalTransaksi it;
    private AdminDAO adminDAO;
    private TransaksiDetilDAOImpl transaksiDetilDAOImpl;
    public TransaksiDAOImpl(){
        connection=DBConnection.getConnection();
        adminDAO=new AdminDAOImpl();
        pilihBarangDAO=new PilihBarangDAOImpl();
        transaksiDetilDAOImpl=new TransaksiDetilDAOImpl();
    }

    @Override
    public String autonumber() {
        PreparedStatement statement=null;
        ResultSet rs=null;
        String s,s1;
        String kode=null;
        Integer j=0;
        Integer panjang =4;
        String sql="select max(right(idtransaksi, 4)) from transaksi";
        try {
            statement=connection.prepareStatement(sql);
            rs=statement.executeQuery();
            if(rs.first()==false){
                kode="KT-0001";
            }else{
                 rs.last();
                 s=Integer.toString(rs.getInt(1)+1);
                 s1="";
                 j=s.length();
                 for(int i=0; i<panjang - j; i++){
                     s1=s1+"0";
                 }
                 kode="KT"+s1+s;
            }
            return  kode;
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return kode;
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TransaksiDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TransaksiDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

   
    
    @Override
    public boolean insertTransaksi(Transaksi transaksi) {
      PreparedStatement statement=null;
      boolean valid=false;
      String sql="insert into transaksi(idtransaksi, idadmin, tanggal, total_transaksi) "
              + "values (?,?,?,?)";
        try {
            connection.setAutoCommit(false);
            statement=connection.prepareStatement(sql);
            statement.setString(1, transaksi.getIdtransaksi());
            statement.setInt(2, transaksi.getAdmin().getIdadmin());
            statement.setDate(3, new Date(transaksi.getTanggal().getTime()));
            statement.setDouble(4, transaksi.getTotaltransaksi());
            statement.executeUpdate();
            
            
            int validJumlah=0;
            for(TransaksiDetil transaksiDetil : transaksi.getTransaksiDetils()){
              transaksiDetilDAOImpl.insertTransaksiDetil(connection, transaksiDetil);
              if(transaksiDetil.getPilihBarang().getJumlah() < transaksiDetil.getJumlah()){
                  JOptionPane.showMessageDialog(null, "kapasitas transaksi melebihi"
                          + " kapasitas jumlah barang dirak!");
                  validJumlah = transaksiDetil.getPilihBarang().getJumlah() - transaksiDetil.getJumlah();
                  valid=false;
              }else{
                  pilihBarangDAO.getKurangJumlahStokBarang(transaksiDetil.getJumlah(), transaksiDetil.getPilihBarang());
              }
            }
            
           if(validJumlah<0){
               connection.rollback();
               connection.setAutoCommit(true);
           }else{
               connection.commit();
               connection.setAutoCommit(true);
               valid=true;
           }
            
            
        } catch (SQLException ex) {
          try {
              connection.rollback();
              connection.setAutoCommit(true);
              Logger.getLogger(TransaksiDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
          } catch (SQLException ex1) {
              Logger.getLogger(TransaksiDAOImpl.class.getName()).log(Level.SEVERE, null, ex1);
          }finally{
              if(statement!=null){
                  try {
                      statement.close();
                  } catch (SQLException ex1) {
                      Logger.getLogger(TransaksiDAOImpl.class.getName()).log(Level.SEVERE, null, ex1);
                  }
              }
          }
            
        }
        return valid;
        
    }

    @Override
    public List<Transaksi> getListTransaksi() {
      PreparedStatement statement=null;
      List list=new ArrayList();
      ResultSet rs=null;
      String sql="select * from transaksi";
        try {
            statement=connection.prepareStatement(sql);
            rs=statement.executeQuery();
            while(rs.next()){
                Transaksi t=new Transaksi();
                t.setIdtransaksi(rs.getString("idtransaksi"));
                int idadmin=rs.getInt("idadmin");
                Admin kodadmin=adminDAO.getAdminById(idadmin);
                t.setAdmin(kodadmin);
                t.setTanggal(rs.getDate("tanggal"));
                t.setTotalTransaksi(rs.getDouble("total_transaksi"));
                list.add(t);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
             return null;
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TransaksiDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TransaksiDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public List<ReportTransaksiPenjualan> getReportTransaksi(String idtransaksi) {
      PreparedStatement statement=null;
      List list=new ArrayList();
      ResultSet rs=null;
      String sql="select * from transaksi inner join transaksi_detil on "
              + "(transaksi.idtransaksi=transaksi_detil.idtransaksi) where transaksi.idtransaksi=?";
        try {
            statement=connection.prepareStatement(sql);
            statement.setString(1, idtransaksi);
            rs=statement.executeQuery();
            while(rs.next()){
                ReportTransaksiPenjualan rtp=new ReportTransaksiPenjualan();
                Transaksi t=new Transaksi();
                t.setIdtransaksi(rs.getString("idtransaksi"));
                int idadmin=rs.getInt("idadmin");
                Admin kodeadmin=adminDAO.getAdminById(idadmin);
                t.setAdmin(kodeadmin);
                t.setTanggal(rs.getDate("tanggal"));
                t.setTotalTransaksi(rs.getDouble("total_transaksi"));
                rtp.setTransaksi(t);
                  TransaksiDetil td=new TransaksiDetil();
                  String pilihbarang=rs.getString("idbarang");
                  PilihBarang idbarang=pilihBarangDAO.findOneBarang(pilihbarang);
                  td.setPilihBarang(idbarang);
                  td.setNama(rs.getString("nama"));
                  td.setJumlah(rs.getInt("jumlah"));
                  td.setHarga(rs.getDouble("harga"));
                 rtp.setTransaksiDetil(td);
                 list.add(rtp);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TransaksiDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TransaksiDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public List<ReportTransaksiPenjualan> getReportTransaksiByTanggal(java.util.Date tanggalMulai, java.util.Date tanggalAkhir) {
     PreparedStatement statement=null;
     List list=new ArrayList();
     ResultSet rs=null;
     String sql="select * from transaksi inner join transaksi_detil "
             + "on (transaksi.idtransaksi=transaksi_detil.idtransaksi) "
             + "where (transaksi.tanggal>=?) and (transaksi.tanggal<=?)";
        try {
            statement=connection.prepareStatement(sql);
            statement.setDate(1, new Date(tanggalMulai.getTime()));
            statement.setDate(2, new Date(tanggalAkhir.getTime()));
            rs=statement.executeQuery();
            while(rs.next()){
                ReportTransaksiPenjualan rtp=new ReportTransaksiPenjualan();
                Transaksi t=new Transaksi();
                t.setIdtransaksi(rs.getString("transaksi.idtransaksi"));
                int idadmin=rs.getInt("transaksi.idadmin");
                Admin a=adminDAO.getAdminById(idadmin);
                t.setAdmin(a);
                t.setTanggal(rs.getDate("transaksi.tanggal"));
                t.setTotalTransaksi(rs.getDouble("transaksi.total_transaksi"));
                rtp.setTransaksi(t);
                  TransaksiDetil detil=new TransaksiDetil();
                String pilbar=rs.getString("transaksi_detil.idbarang");
                PilihBarang pb=pilihBarangDAO.findOneBarang(pilbar);
                detil.setPilihBarang(pb);
                detil.setNama(rs.getString("transaksi_detil.nama"));
                detil.setJumlah(rs.getInt("transaksi_detil.jumlah"));
                detil.setHarga(rs.getDouble("transaksi_detil.harga"));
                rtp.setTransaksiDetil(detil);
                list.add(rtp);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TransaksiDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TransaksiDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

}
