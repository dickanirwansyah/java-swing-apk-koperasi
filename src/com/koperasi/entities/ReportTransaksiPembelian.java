/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koperasi.entities;

/**
 *
 * @author dickajava
 */
public class ReportTransaksiPembelian {
    
    private RequestBarang requestBarang;
    private RequestDetil requestDetil;
    
    public RequestBarang getRequestBarang(){
        return requestBarang;
    }
    
    public void setRequestBarang(RequestBarang requestBarang){
        this.requestBarang=requestBarang;
    }
    
    public RequestDetil getRequestDetil(){
        return requestDetil;
    }
    
    public void setRequestDetil(RequestDetil requestDetil){
        this.requestDetil=this.requestDetil;
    }

    @Override
    public String toString() {
        return "ReportTransaksiPembelian{" + "requestBarang=" + requestBarang + ", requestDetil=" + requestDetil + '}';
    }
    
    
}

