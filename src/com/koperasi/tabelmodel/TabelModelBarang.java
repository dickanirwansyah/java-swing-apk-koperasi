/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koperasi.tabelmodel;

import com.koperasi.entities.Barang;
import com.stripbandunk.jwidget.model.DynamicTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dickajava
 */
public class TabelModelBarang extends DynamicTableModel<Barang>{
    
    private List<Barang> list=new ArrayList<Barang>();
    public TabelModelBarang(List<Barang> data, Class<Barang> clazz) {
        super(data, clazz);
    }
    
}
