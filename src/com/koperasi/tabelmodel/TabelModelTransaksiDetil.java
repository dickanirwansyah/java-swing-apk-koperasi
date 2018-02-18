/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koperasi.tabelmodel;

import com.koperasi.entities.TransaksiDetil;
import com.stripbandunk.jwidget.model.DynamicTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dickajava
 */
public class TabelModelTransaksiDetil extends DynamicTableModel<TransaksiDetil>{
    
    private List<TransaksiDetil> list=new ArrayList<>();
    public TabelModelTransaksiDetil(List<TransaksiDetil> list, Class<TransaksiDetil> class1) {
        super(list, class1);
        this.list=list;
    }
    
    public void insertTransaksiDetils(TransaksiDetil transaksiDetil){
        this.list.add(transaksiDetil);
        fireTableDataChanged();
    }
    
    public void updateTransaksiDetils(int index, TransaksiDetil transaksiDetil){
        this.list.set(index, transaksiDetil);
        fireTableDataChanged();
    }
    
    public void deleteTransaksiDetils(int index){
        this.list.remove(index);
        fireTableDataChanged();
        
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
      return true;
    }
    
    public void clearTransaksiDetils(){
       this.list.clear();
       fireTableDataChanged();
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
      if(aValue!=null && aValue instanceof Integer && columnIndex == 2){
          int jumlah = (int) aValue;
          list.get(rowIndex).setJumlah(jumlah);
      }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch(columnIndex){
            case 2 : return Integer.class;
            default:return Object.class;
        }
    }
    
    
    
}
