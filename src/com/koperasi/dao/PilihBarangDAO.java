/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koperasi.dao;

import com.koperasi.entities.PilihBarang;
import java.util.List;

/**
 *
 * @author dickajava
 */
public interface PilihBarangDAO {
    
    public List<PilihBarang> findAllBarang();
    
    public PilihBarang findOneBarang(String idbarang);
    
    public void getKurangJumlahStokBarang(int jumlah, PilihBarang pilihBarang);
    
    public void getTambahJumlahStokBarang(int jumlah, PilihBarang pilihBarang);
}
