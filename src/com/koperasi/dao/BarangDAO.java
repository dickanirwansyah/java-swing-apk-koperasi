/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koperasi.dao;

import com.koperasi.entities.Barang;
import java.util.List;

/**
 *
 * @author dickajava
 */
public interface BarangDAO {
    
    public String autonumber();
    
    public void saveBarang(Barang barang);
    
    public void updateBarang(Barang barang);
    
    public void deleteBarang(Barang barang);
    
    public List<Barang> findAllBarang();
    
    public Barang findOneBarang(String idbarang);
}
