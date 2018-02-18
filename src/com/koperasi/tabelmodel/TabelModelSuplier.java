/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koperasi.tabelmodel;

import com.koperasi.entities.Suplier;
import com.stripbandunk.jwidget.model.DynamicTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dickajava
 */
public class TabelModelSuplier extends DynamicTableModel<Suplier>{
    
    private List<Suplier> list=new ArrayList<Suplier>();
    public TabelModelSuplier(List<Suplier> list, Class<Suplier> class1) {
        super(list, class1);
        this.list=list;
    }
    
}
