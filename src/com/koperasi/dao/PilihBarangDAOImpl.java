/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koperasi.dao;

import com.koperasi.db.DBConnection;
import com.koperasi.entities.Kategori;
import com.koperasi.entities.PilihBarang;
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
public class PilihBarangDAOImpl implements PilihBarangDAO{

    private Connection connection;
    private KategoriDAO kategoriDAO;
    public PilihBarangDAOImpl(){
        connection=DBConnection.getConnection();
        kategoriDAO=new KategoriDAOImpl();
    }
    
    @Override
    public List<PilihBarang> findAllBarang() {
        PreparedStatement statement=null;
        List list=new ArrayList();
        ResultSet rs=null;
        String sql="select * from barang";
        try {
            statement=connection.prepareStatement(sql);
            rs=statement.executeQuery();
            while(rs.next()){
                PilihBarang pb=new PilihBarang();
                pb.setIdbarang(rs.getString("idbarang"));
                pb.setNama(rs.getString("nama"));
                String idkategori=rs.getString("idkategori");
                Kategori kategoris=kategoriDAO.findOne(idkategori);
                pb.setKategori(kategoris);
                pb.setJumlah(rs.getInt("jumlah"));
                pb.setHarga(rs.getDouble("harga"));
                list.add(pb);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(PilihBarangDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PilihBarangDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PilihBarangDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public PilihBarang findOneBarang(String idbarang) {
       PreparedStatement statement=null;
        ResultSet rs=null;
        String sql="select * from barang where idbarang=?";
        PilihBarang pb=null;
        try {
            statement=connection.prepareStatement(sql);
            statement.setString(1, idbarang);
            rs=statement.executeQuery();
            while(rs.next()){
                pb=new PilihBarang();
                pb.setIdbarang(rs.getString("idbarang"));
                pb.setNama(rs.getString("nama"));
                String idkategori=rs.getString("idkategori");
                Kategori kategoris=kategoriDAO.findOne(idkategori);
                pb.setKategori(kategoris);
                pb.setJumlah(rs.getInt("jumlah"));
                pb.setHarga(rs.getDouble("harga"));
            }
            return pb;
        } catch (SQLException ex) {
            Logger.getLogger(PilihBarangDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PilihBarangDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PilihBarangDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void getKurangJumlahStokBarang(int jumlah, PilihBarang pilihBarang) {
      PreparedStatement statement=null;
      String sql="update barang set jumlah=jumlah-? where idbarang=?";
        try {
            statement=connection.prepareStatement(sql);
            statement.setInt(1, jumlah);
            statement.setString(2, pilihBarang.getIdbarang());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PilihBarangDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PilihBarangDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void getTambahJumlahStokBarang(int jumlah, PilihBarang pilihBarang) {
      PreparedStatement statement=null;
      String sql="update barang set jumlah=jumlah+? where idbarang=?";
        try {
            statement=connection.prepareStatement(sql);
            statement.setInt(1, jumlah);
            statement.setString(2, pilihBarang.getIdbarang());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PilihBarangDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PilihBarangDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
}
