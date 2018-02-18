/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koperasi.dao;

import com.koperasi.db.DBConnection;
import com.koperasi.entities.Barang;
import com.koperasi.entities.Kategori;
import java.sql.Connection;
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
public class BarangDAOImpl implements BarangDAO{
    
    private Connection connection;
    private KategoriDAO kategoriDAO;
    public BarangDAOImpl(){
        connection=DBConnection.getConnection();
        kategoriDAO=new KategoriDAOImpl();
    }

    @Override
    public String autonumber() {
        PreparedStatement statement=null;
        ResultSet rs=null;
        String s,s1;
        String kode=null;
        int panjang = 4;
        int j=0;
        String sql="select max(right(idbarang, 4)) from barang";
        try {
            statement=connection.prepareStatement(sql);
            rs=statement.executeQuery();
            if(rs.first()==false){
                kode="BAR001";
            }else{
                rs.last();
                s=Integer.toString(rs.getInt(1)+1);
                j=s.length();
                s1="";
                for(int i=0; i<panjang - j; i++){
                    s1=s1+"0";
                }
                kode="BAR"+s1+s;
            }
            return kode;
        } catch (SQLException ex) {
            Logger.getLogger(BarangDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return kode;
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BarangDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BarangDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void saveBarang(Barang barang) {
      PreparedStatement statement=null;
      String sql="insert into barang (idbarang, nama, idkategori, jumlah, harga) values (?,?,?,?,?)";
        try {
            statement=connection.prepareStatement(sql);
            statement.setString(1, barang.getIdbarang());
            statement.setString(2, barang.getNama());
            statement.setString(3, barang.getKategori().getIdkategori());
            statement.setInt(4, barang.getJumlah());
            statement.setDouble(5, barang.getHarga());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BarangDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BarangDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void updateBarang(Barang barang) {
      PreparedStatement statement=null;
      String sql="update barang set nama=?, idkategori=?, jumlah=?, harga=? where idbarang=?";
        try {
            statement=connection.prepareStatement(sql);
            statement.setString(1, barang.getNama());
            statement.setString(2, barang.getKategori().getIdkategori());
            statement.setInt(3, barang.getJumlah());
            statement.setDouble(4, barang.getHarga());
            statement.setString(5, barang.getIdbarang());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BarangDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BarangDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void deleteBarang(Barang barang) {
     PreparedStatement statement=null;
     String sql="delete from barang where idbarang=?";
        try {
            statement=connection.prepareStatement(sql);
            statement.setString(1, barang.getIdbarang());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BarangDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BarangDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public List<Barang> findAllBarang() {
      PreparedStatement statement=null;
      List list=new ArrayList();
      ResultSet rs=null;
      String sql="select * from barang";
        try {
            statement=connection.prepareStatement(sql);
            rs=statement.executeQuery();
            while(rs.next()){
                Barang b=new Barang();
                b.setIdbarang(rs.getString("idbarang"));
                b.setNama(rs.getString("nama"));
                String kodekategori=rs.getString("idkategori");
                Kategori k=kategoriDAO.findOne(kodekategori);
                b.setKategori(k);
                b.setJumlah(rs.getInt("jumlah"));
                b.setHarga(rs.getDouble("harga"));
                list.add(b);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(BarangDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BarangDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BarangDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public Barang findOneBarang(String idbarang) {
      PreparedStatement statement=null;
      ResultSet rs=null;
      Barang b=null;
      String sql="select * from barang where idbarang=?";
        try {
            statement=connection.prepareStatement(sql);
            statement.setString(1, idbarang);
            rs=statement.executeQuery();
            while(rs.next()){
                b=new Barang();
                b.setIdbarang(rs.getString("idbarang"));
                b.setNama(rs.getString("nama"));
                String kodekategori=rs.getString("idkategori");
                Kategori k=kategoriDAO.findOne(kodekategori);
                b.setKategori(k);
                b.setJumlah(rs.getInt("jumlah"));
                b.setHarga(rs.getDouble("harga"));
            }
            return b;
        } catch (SQLException ex) {
            Logger.getLogger(BarangDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BarangDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BarangDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
}
