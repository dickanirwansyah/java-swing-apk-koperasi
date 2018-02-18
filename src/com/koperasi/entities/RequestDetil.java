/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koperasi.entities;

import com.stripbandunk.jwidget.annotation.TableColumn;

/**
 *
 * @author dickajava
 */
public class RequestDetil {
    
    private RequestBarang requestBarang;
    @TableColumn(name = "idbarang", number = 1, size = 30)
    private PilihBarang pilihBarang;
    @TableColumn(name = "nama", number = 2, size = 30)
    private String nama;
    @TableColumn(name = "jumlah", number = 3, size = 30)
    private int jumlah;
    @TableColumn(name = "harga", number = 4, size = 30)
    private double harga;
    
    public RequestBarang getRequestBarang(){
        return requestBarang;
    }
    
    public void setRequestBarang(RequestBarang requestBarang){
        this.requestBarang=requestBarang;
    }
    
    public PilihBarang getPilihbarang(){
        return pilihBarang;
    }
    
    public void setBarang(PilihBarang pilihBarang){
        this.pilihBarang=pilihBarang;
    }
    
    public String getNama(){
        return nama;
    }
    
    public void setNama(String nama){
        this.nama=nama;
    }
    
    public int getJumlah(){
        return jumlah;
    }
    
    public void setJumlah(int jumlah){
        this.jumlah=jumlah;
    }
    
    public double getHarga(){
        return harga;
    }
    
    public void setHarga(double harga){
        this.harga=harga;
    }
}
