/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koperasi.tabelmodel;

import com.koperasi.entities.RequestDetil;
import com.stripbandunk.jwidget.model.DynamicTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dickajava
 */
public class TabelModelRequestDetil extends DynamicTableModel<RequestDetil>{
    
    private List<RequestDetil> list=new ArrayList<>();
    public TabelModelRequestDetil(List<RequestDetil> list, Class<RequestDetil> class1) {
        super(list, class1);
        this.list=list;
    }
    
    public void insertRequestDetils(RequestDetil requestDetil){
        this.list.add(requestDetil);
        fireTableDataChanged();
    }
    
    public void updateRequestDetils(int index, RequestDetil requestDetil){
        this.list.set(index, requestDetil);
        fireTableDataChanged();
    }
    
    public void deleteRequestDetils(int index){
        this.list.remove(index);
        fireTableDataChanged();
    }
    
    public void clearRequest(){
       this.list.clear();
       fireTableDataChanged();
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
      return true;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
       switch(columnIndex){
           case 2 : return Integer.class;
           default:return Object.class;
       }
    }

    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
      if(aValue!=null && aValue instanceof Integer && columnIndex==2){
          int jumlah=(int) aValue;
          list.get(rowIndex).setJumlah(jumlah);
      }
    }
    
    
    
}
