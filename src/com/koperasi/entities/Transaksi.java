/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koperasi.entities;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dickajava
 */
public class Transaksi {
    private String idtransaksi;
    private Admin admin;
    private Date tanggal;
    private double total_transaksi;
    private List<TransaksiDetil> transaksiDetils=new ArrayList<>();
    
    public String getIdtransaksi(){
        return idtransaksi;
    }
    
    public void setIdtransaksi(String idtransaksi){
        this.idtransaksi=idtransaksi;
    }
    
    public Admin getAdmin(){
        return admin;
    }
    
    public void setAdmin(Admin admin){
        this.admin=admin;
    }
    
    public Date getTanggal(){
        return tanggal;
    }
    
    public void setTanggal(Date tanggal){
        this.tanggal=tanggal;
    }
    
    public double getTotaltransaksi(){
       return total_transaksi;
    }
    
    public void setTotalTransaksi(double total_transaksi){
        this.total_transaksi=total_transaksi;
    }
    
    public List<TransaksiDetil> getTransaksiDetils(){
        return transaksiDetils;
    }
    
    public void setTransaksiDetils(List<TransaksiDetil> transaksiDetils){
        this.transaksiDetils=transaksiDetils;
    }
}
