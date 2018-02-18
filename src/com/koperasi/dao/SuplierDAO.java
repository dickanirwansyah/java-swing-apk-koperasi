/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koperasi.dao;

import com.koperasi.entities.Suplier;
import java.util.List;

/**
 *
 * @author dickajava
 */
public interface SuplierDAO {
    
    public boolean saveSuplier(Suplier suplier);
    
    public boolean updateSuplier(Suplier suplier);
    
    public boolean deleteSuplier(Suplier suplier);
    
    public Suplier findOneSuplier(String idsuplier);
    
    public List<Suplier> findAllSuplier();
    
    public String autoKodeSuplier();
}
