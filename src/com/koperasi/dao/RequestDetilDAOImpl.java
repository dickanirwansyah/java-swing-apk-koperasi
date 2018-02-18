/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koperasi.dao;

import com.koperasi.entities.RequestDetil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dickajava
 */
public class RequestDetilDAOImpl {
    
    public RequestDetilDAOImpl(){
        
    }
    
    public boolean insertRequestDetils(Connection connection, RequestDetil requestDetil){
        PreparedStatement statement=null;
        boolean valid=false;
        String sql="insert into request_detil (idrequest, idbarang, nama, jumlah, harga) "
                + "values (?,?,?,?,?)";
        try {
            statement=connection.prepareStatement(sql);
            statement.setString(1, requestDetil.getRequestBarang().getIdrequest());
            statement.setString(2, requestDetil.getPilihbarang().getIdbarang());
            statement.setString(3, requestDetil.getNama());
            statement.setInt(4, requestDetil.getJumlah());
            statement.setDouble(5, requestDetil.getHarga());
            statement.executeUpdate();
            valid=true;
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(RequestDetilDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return valid;
    }
    
}
