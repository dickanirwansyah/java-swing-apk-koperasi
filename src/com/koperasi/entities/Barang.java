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
public class Barang {
    
    @TableColumn(name = "idbarang", size = 30, number = 1)
    private String idbarang;
    @TableColumn(name = "nama",size = 30, number = 2)
    private String nama;
    @TableColumn(name = "kategori", size = 30, number = 3)
    private Kategori kategori;
    @TableColumn(name = "jumlah", size = 30, number = 4)
    private int jumlah;
    @TableColumn(name = "harga", size = 30, number = 5)
    private double harga;
    
    public String getIdbarang(){
        return idbarang;
    }
    
    public void setIdbarang(String idbarang){
        this.idbarang=idbarang;
    }
    
    public String getNama(){
        return nama;
    }
    
    public void setNama(String nama){
        this.nama=nama;
    }
    
    public Kategori getKategori(){
        return kategori;
    }
    
    public void setKategori(Kategori kategori){
        this.kategori=kategori;
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

    @Override
    public String toString() {
        return nama;
    }
    
    
}
