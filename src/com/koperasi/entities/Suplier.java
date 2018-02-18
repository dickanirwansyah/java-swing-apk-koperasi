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
public class Suplier {
    
    @TableColumn(name = "idsuplier", number = 1, size = 30)
    private String idsuplier;
    @TableColumn(name = "nama", number = 2, size = 30)
    private String nama;
    @TableColumn(name = "notelp", number = 3, size = 30)
    private String notelp;
    @TableColumn(name = "alamat", number = 4, size = 30)
    private String alamat;
    
    public String getIdsuplier(){
        return idsuplier;
    }
    
    public void setIdsuplier(String idsuplier){
        this.idsuplier=idsuplier;
    }
    
    public String getNama(){
        return nama;
    }
    
    public void setNama(String nama){
        this.nama=nama;
    }
    
    
    public String getNotelp(){
        return notelp;
    }
    
    public void setNotelp(String notelp){
        this.notelp=notelp;
    }
    
    public String getAlamat(){
        return alamat;
    }
    
    public void setAlamat(String alamat){
        this.alamat=alamat;
    }

    @Override
    public String toString() {
        return nama;
    }
    
    
}
