/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koperasi.dao;

import com.koperasi.entities.TransaksiDetil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dickajava
 */
public class TransaksiDetilDAOImpl {
    
    public TransaksiDetilDAOImpl(){
        
    }
    
    public boolean insertTransaksiDetil(Connection connection, TransaksiDetil detil){
        PreparedStatement statement=null;
        boolean valid=false;
        String sql2 = "insert into transaksi_detil(idtransaksi, idbarang, nama, jumlah, harga) "
                + "values (?,?,?,?,?)";
        try {
            statement=connection.prepareStatement(sql2);
            statement.setString(1, detil.getTransaksi().getIdtransaksi());
            statement.setString(2, detil.getPilihBarang().getIdbarang());
            statement.setString(3, detil.getNama());
            statement.setInt(4, detil.getJumlah());
            statement.setDouble(5, detil.getHarga());
            statement.executeUpdate();
            valid=true;
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiDetilDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TransaksiDetilDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
       return valid;
    }
}
