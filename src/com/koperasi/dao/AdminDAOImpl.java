/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koperasi.dao;

import com.koperasi.db.DBConnection;
import com.koperasi.entities.Admin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dickajava
 */
public class AdminDAOImpl implements AdminDAO{
    
    private Connection connection;
    public AdminDAOImpl(){
        connection=DBConnection.getConnection();
    }

    @Override
    public void saveAdmin(Admin admin) {
        PreparedStatement statement=null;
        String sql="insert into admin (nama, username, password) values (?,?,?)";
        try {
            statement=connection.prepareStatement(sql);
            statement.setString(1, admin.getNama());
            statement.setString(2, admin.getUsername());
            statement.setString(3, admin.getPassword());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AdminDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AdminDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public Admin getLoginAdmin(String username, String password) {
      PreparedStatement statement=null;
        ResultSet rs=null;
        Admin a=null;
        String sql="select * from admin where username=? and password=?";
        try {
            statement=connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            rs=statement.executeQuery();
            while(rs.next()){
                a=new Admin();
                a.setIdadmin(rs.getInt("idadmin"));
                a.setNama(rs.getString("nama"));
                a.setUsername(rs.getString("username"));
                a.setPassword(rs.getString("password"));
            }
            return a;
        } catch (SQLException ex) {
            Logger.getLogger(AdminDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AdminDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AdminDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public Admin getAdminById(int id) {
       PreparedStatement statement=null;
       ResultSet rs=null;
        Admin a=null;
       String sql="select * from admin where idadmin=?";
        try {
            statement=connection.prepareStatement(sql);
            statement.setInt(1, id);
            rs=statement.executeQuery();
            while(rs.next()){
                a=new Admin();
                a.setIdadmin(rs.getInt("idadmin"));
                a.setNama(rs.getString("nama"));
                a.setUsername(rs.getString("password"));
                a.setPassword(rs.getString("password"));
            }
            return a;
        } catch (SQLException ex) {
            Logger.getLogger(AdminDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AdminDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AdminDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
}
