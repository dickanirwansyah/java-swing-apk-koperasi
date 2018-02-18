/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koperasi.dao;

import com.koperasi.db.DBConnection;
import com.koperasi.entities.Suplier;
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
public class SuplierDAOImpl implements SuplierDAO{
    
    private Connection connection;
    public SuplierDAOImpl(){
        connection=DBConnection.getConnection();
    }

    @Override
    public boolean saveSuplier(Suplier suplier) {
        PreparedStatement statement=null;
        boolean valid=false;
        String sql="insert into suplier(idsuplier, nama, notelp, alamat) values (?,?,?,?)";
        try {
            statement=connection.prepareStatement(sql);
            statement.setString(1, suplier.getIdsuplier());
            statement.setString(2, suplier.getNama());
            statement.setString(3, suplier.getNotelp());
            statement.setString(4, suplier.getAlamat());
            statement.executeUpdate();
            valid=true;
        } catch (SQLException ex) {
            Logger.getLogger(SuplierDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            valid=false;
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SuplierDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return valid;
    }

    @Override
    public boolean updateSuplier(Suplier suplier) {
       PreparedStatement statement=null;
       boolean valid=false;
       String sql="update suplier set nama=?, notelp=?, alamat=? where idsuplier=?";
        try {
            statement=connection.prepareStatement(sql);
            statement.setString(1, suplier.getNama());
            statement.setString(2, suplier.getNotelp());
            statement.setString(3, suplier.getAlamat());
            statement.setString(4, suplier.getIdsuplier());
            statement.executeUpdate();
            valid=true;
        } catch (SQLException ex) {
            Logger.getLogger(SuplierDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            valid=false;
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SuplierDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return valid;
    }

    @Override
    public boolean deleteSuplier(Suplier suplier) {
      PreparedStatement statement=null;
      boolean valid=false;
      String sql="delete from suplier where idsuplier=?";
        try {
            statement=connection.prepareStatement(sql);
            statement.setString(1, suplier.getIdsuplier());
            statement.executeUpdate();
            valid=true;
        } catch (SQLException ex) {
            Logger.getLogger(SuplierDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            valid=false;
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SuplierDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return valid;
    }

    @Override
    public Suplier findOneSuplier(String idsuplier) {
      PreparedStatement statement=null;
        ResultSet rs=null;
        Suplier s=null;
        String sql="select * from suplier where idsuplier=?";
        try {
            statement=connection.prepareStatement(sql);
            statement.setString(1, idsuplier);
            rs=statement.executeQuery();
            while(rs.next()){
                s=new Suplier();
                s.setIdsuplier(rs.getString("idsuplier"));
                s.setNama(rs.getString("nama"));
                s.setNotelp(rs.getString("notelp"));
                s.setAlamat(rs.getString("alamat"));
            }
            return s;
        } catch (SQLException ex) {
            Logger.getLogger(SuplierDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SuplierDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SuplierDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public List<Suplier> findAllSuplier() {
      PreparedStatement statement=null;
      List list=new ArrayList();
      ResultSet rs=null;
      String sql="select * from suplier";
        try {
            statement=connection.prepareStatement(sql);
            rs=statement.executeQuery();
            while(rs.next()){
                Suplier s=new Suplier();
                s.setIdsuplier(rs.getString("idsuplier"));
                s.setNama(rs.getString("nama"));
                s.setNotelp(rs.getString("notelp"));
                s.setAlamat(rs.getString("alamat"));
                list.add(s);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(SuplierDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SuplierDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SuplierDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public String autoKodeSuplier() {
      PreparedStatement statement=null;
      String s,s1;
      ResultSet rs=null;
      String kode="";
      int j=0;
      int panjang=4;
      String sql="select max(right(idsuplier, 4)) from suplier";
        try {
            statement=connection.prepareStatement(sql);
            rs=statement.executeQuery();
            if(rs.first()==false){
                kode="SUP0001";
            }else{
                rs.last();
                s=Integer.toString(rs.getInt(1)+1);
                s1="";
                j=s.length();
                for(int i=0; i<panjang - j; i++){
                    s1=s1+"0";
                }
                kode="SUP"+s1+s;
            }
            return kode;
        } catch (SQLException ex) {
            Logger.getLogger(SuplierDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return kode;
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SuplierDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SuplierDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
}
