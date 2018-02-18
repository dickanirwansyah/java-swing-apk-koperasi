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
public class Kategori {
    
    @TableColumn(name = "idkategori", number = 1, size = 30)
    private String idkategori;
    @TableColumn(name = "nama", number = 2, size = 30)
    private String nama;
    
    public String getIdkategori(){
        return idkategori;
    }
    
    public void setIdkategori(String idkategori){
        this.idkategori=idkategori;
    }
    
    public String getNama(){
        return nama;
    }
    
    public void setNama(String nama){
        this.nama=nama;
    }

    @Override
    public String toString() {
       return nama;
    }
    
    
}
