/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koperasi.dao;

import com.koperasi.entities.Kategori;
import java.util.List;

/**
 *
 * @author dickajava
 */
public interface KategoriDAO {
    
    
    public List<Kategori> findAll();
    
    public Kategori findOne(String idkategori);
    
    public boolean SavesKategori(Kategori kategori);
    
    public boolean HapusKategori(Kategori kategori);
    
    public boolean UpdateKategori(Kategori kategori);
    
    public String AutoNumber();
}
