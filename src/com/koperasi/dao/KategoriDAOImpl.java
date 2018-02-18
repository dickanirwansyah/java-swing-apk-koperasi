/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koperasi.dao;

import com.koperasi.db.DBConnection;
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
public class KategoriDAOImpl implements KategoriDAO{
    
    private Connection connection;
    public KategoriDAOImpl(){
        connection=DBConnection.getConnection();
    }

    @Override
    public List<Kategori> findAll() {
        PreparedStatement statement=null;
        ResultSet rs=null;
        String sql="select * from kategori";
        List list=new ArrayList();
        try {
            statement=connection.prepareStatement(sql);
            rs=statement.executeQuery();
            while(rs.next()){
                Kategori k=new Kategori();
                k.setIdkategori(rs.getString("idkategori"));
                k.setNama(rs.getString("nama"));
                list.add(k);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(KategoriDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KategoriDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KategoriDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public Kategori findOne(String idkategori) {
       PreparedStatement statement=null;
       Kategori k=null;
       ResultSet rs=null;
       String sql="select * from kategori where idkategori=?";
        try {
            statement=connection.prepareStatement(sql);
            statement.setString(1, idkategori);
            rs=statement.executeQuery();
            while(rs.next()){
                k=new Kategori();
                k.setIdkategori(rs.getString("idkategori"));
                k.setNama(rs.getString("nama"));
            }
            return k;
        } catch (SQLException ex) {
            Logger.getLogger(KategoriDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KategoriDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KategoriDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
       
    }

    @Override
    public boolean SavesKategori(Kategori kategori) {
      PreparedStatement statement=null;
      boolean valid=false;
      String sql="insert into kategori (idkategori, nama) values (?,?)";
        try {
            statement=connection.prepareStatement(sql);
            statement.setString(1, kategori.getIdkategori());
            statement.setString(2, kategori.getNama());
            statement.executeUpdate();
            valid=true;
        } catch (SQLException ex) {
            Logger.getLogger(KategoriDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            valid=false;
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KategoriDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return valid;
    }

    @Override
    public boolean HapusKategori(Kategori kategori) {
      PreparedStatement statement=null;
      boolean valid=false;
      String sql="delete from kategori where idkategori=?";
        try {
            statement=connection.prepareStatement(sql);
            statement.setString(1, kategori.getIdkategori());
            statement.executeUpdate();
            valid=true;
        } catch (SQLException ex) {
            Logger.getLogger(KategoriDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            valid=false;
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KategoriDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return valid;
    }

    @Override
    public String AutoNumber() {
      PreparedStatement statement=null;
      String s, s1;
      String kode="";
      int panjang=3;
      int j=0;
      ResultSet rs=null;
      String sql="select max(right(idkategori, 3)) from kategori";
        try {
            statement=connection.prepareStatement(sql);
            rs=statement.executeQuery();
            if(rs.first()==false){
                kode="KAT001";
            }else{
                rs.last();
                s=Integer.toString(rs.getInt(1)+1);
                s1="";
                for(int i=0; i<panjang-j; i++){
                    s1=s1+"0";
                }
                kode="KAT"+s1+s;
            }
            return kode;
        } catch (SQLException ex) {
            Logger.getLogger(KategoriDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return kode;
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KategoriDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KategoriDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public boolean UpdateKategori(Kategori kategori) {
      PreparedStatement statement=null;
      boolean valid=false;
      String sql="update kategori set nama=? where idkategori=?";
        try {
            statement=connection.prepareStatement(sql);
            statement.setString(1, kategori.getNama());
            statement.setString(2, kategori.getIdkategori());
            statement.executeUpdate();
            valid=true;
        } catch (SQLException ex) {
            Logger.getLogger(KategoriDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            valid=false;
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KategoriDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return valid;
    }
    
}
