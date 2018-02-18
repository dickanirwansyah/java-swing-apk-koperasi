/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koperasi.tabelmodel;

import com.koperasi.entities.Kategori;
import com.stripbandunk.jwidget.model.DynamicTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dickajava
 */
public class TabelModelKategori extends DynamicTableModel<Kategori>{
    
    private List<Kategori> list=new ArrayList<>();
    public TabelModelKategori(List<Kategori> list, Class<Kategori> class1) {
        super(list, class1);
        this.list=list;
    }
    
}
