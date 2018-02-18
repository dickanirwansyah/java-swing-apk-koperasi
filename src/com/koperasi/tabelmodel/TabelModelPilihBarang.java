/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koperasi.tabelmodel;

import com.koperasi.entities.PilihBarang;
import com.stripbandunk.jwidget.model.DynamicTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dickajava
 */
public class TabelModelPilihBarang extends DynamicTableModel<PilihBarang>{
    
    private List<PilihBarang> list=new ArrayList<>();
    public TabelModelPilihBarang(List<PilihBarang> list, Class<PilihBarang> class1) {
        super(list, class1);
        this.list=list;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
      return true;
    }
    
    public void setData(List<PilihBarang> pilihbarang){
        this.list=list;
        fireTableDataChanged();
    }
    
     public List<PilihBarang> getCekBarang(){
        List lst=new ArrayList();
        for(PilihBarang pb : list){
            if(pb.getCentang()){
                lst.add(pb);
            }
        }
        return lst;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if(columnIndex==0){
            return Boolean.class;
        }else{
            return super.getColumnClass(columnIndex);
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
       if(aValue!=null && aValue instanceof Boolean && columnIndex==0){
           Boolean pilih=(Boolean) aValue;
           list.get(rowIndex).setCentang(pilih);
       }
    }
    
    
}
