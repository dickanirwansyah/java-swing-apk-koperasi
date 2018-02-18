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
public class TransaksiDetil {
    
    
    private Transaksi transaksi;
    @TableColumn(name = "idbarang", size = 30, number = 1)
    private PilihBarang pilihBarang;
    @TableColumn(name = "nama", size = 30, number = 2)
    private String nama;
    @TableColumn(name = "jumlah", size = 30, number = 3)
    private int jumlah;
    @TableColumn(name = "harga", size = 30, number = 4)
    private double harga;
    
    public Transaksi getTransaksi(){
        return transaksi;
    }
    
    public void setTransaksi(Transaksi transaksi){
        this.transaksi=transaksi;
    }
    
    public PilihBarang getPilihBarang(){
        return pilihBarang;
    }
    
    public void setPilihBarang(PilihBarang pilihbarang){
        this.pilihBarang=pilihbarang;
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

    @Override
    public String toString() {
        return "TransaksiDetil{" + "transaksi=" + transaksi + ", pilihBarang=" + pilihBarang + ", nama=" + nama + ", jumlah=" + jumlah + ", harga=" + harga + '}';
    }

   
    
}
