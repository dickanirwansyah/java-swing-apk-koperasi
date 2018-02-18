/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koperasi.controller;

import com.koperasi.dao.KategoriDAO;
import com.koperasi.dao.KategoriDAOImpl;
import com.koperasi.entities.Kategori;
import com.koperasi.panel.PanelKategori;
import javax.swing.JOptionPane;

/**
 *
 * @author dickajava
 */
public class ControllerKategori {
    
    private Kategori k;
    private KategoriDAO kategoriDAO;
    public ControllerKategori(){
        k=new Kategori();
        kategoriDAO=new KategoriDAOImpl();
    }
    
    
    private void doReset(PanelKategori panelkategori){
        panelkategori.getTextKodeKategori().setText("");
        panelkategori.getTextNamaKategori().setText("");
    }
    
    private boolean doValid(PanelKategori panelKategori){
        boolean valid=false;
        if(panelKategori.getTextKodeKategori().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "kode kategori masih kosong");
        }else if(panelKategori.getTextNamaKategori().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "nama kategori masih kosong");
        }else{
            valid=true;
        }
        return valid;
    }
    
    public void doAutoKode(PanelKategori panelKategori){
        try {
            String kodeKategori = kategoriDAO.AutoNumber();
            panelKategori.getTextKodeKategori().setText(kodeKategori);
            panelKategori.getBtnSimpan().setEnabled(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void doUpdateKategori(PanelKategori panelKategori){
        try {
            int index=panelKategori.getTabelKategori().getSelectedRow();
            if(index!=-1){
                k=panelKategori.getTabelModelKategori().get(panelKategori
                        .getTabelKategori().convertRowIndexToModel(index));
                if(doValid(panelKategori)==true){
                    String kode=panelKategori.getTextKodeKategori().getText();
                    String nama=panelKategori.getTextNamaKategori().getText();
                    k.setIdkategori(kode);
                    k.setNama(nama);
                    kategoriDAO.UpdateKategori(k);
                    doReset(panelKategori);
                    JOptionPane.showMessageDialog(null, "sukses !");
                    panelKategori.getBtnHapus().setEnabled(false);
                    panelKategori.getBtnUpdate().setEnabled(false);
                    panelKategori.getBtnSimpan().setEnabled(false);
                }
            }else{
                JOptionPane.showMessageDialog(null, "seleksi salah satu baris !");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void doAmbilKategori(PanelKategori panelKategori){
        try {
            int index=panelKategori.getTabelKategori().getSelectedRow();
            if(index!=-1){
                k=panelKategori.getTabelModelKategori().get(panelKategori
                        .getTabelKategori().convertRowIndexToModel(index));
               
                    panelKategori.getTextKodeKategori().setText(k.getIdkategori());
                    panelKategori.getTextNamaKategori().setText(k.getNama());
                    JOptionPane.showMessageDialog(null, "data terseleksi !");
                    panelKategori.getBtnHapus().setEnabled(true);
                    panelKategori.getBtnUpdate().setEnabled(true);
                    panelKategori.getBtnSimpan().setEnabled(false);
            }else{
                JOptionPane.showMessageDialog(null, "seleksi salah satu baris !");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void doDeleteKategori(PanelKategori panelKategori){
        try {
            int index=panelKategori.getTabelKategori().getSelectedRow();
            if(index!=-1){
                k=panelKategori.getTabelModelKategori()
                        .get(panelKategori.getTabelKategori().convertRowIndexToModel(index));
                if(JOptionPane.showConfirmDialog(null, "apakah anda yakin ingin hapus data ini ?", 
                        "konfirmasi", JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
                    kategoriDAO.HapusKategori(k);
                    JOptionPane.showMessageDialog(null, "sukses !");
                    panelKategori.getBtnHapus().setEnabled(false);
                    panelKategori.getBtnUpdate().setEnabled(false);
                    panelKategori.getBtnSimpan().setEnabled(false);
                    doReset(panelKategori);
                }
            }else{
                JOptionPane.showMessageDialog(null, "seleksi salah satu baris !");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void doSaveKategori(PanelKategori panelKategori){
        if(doValid(panelKategori)==true){
            String kode=panelKategori.getTextKodeKategori().getText();
            String nama=panelKategori.getTextNamaKategori().getText();
            Kategori k=new Kategori();
            k.setIdkategori(kode);
            k.setNama(nama);
            kategoriDAO.SavesKategori(k);
            doReset(panelKategori);
            JOptionPane.showMessageDialog(null, "sukses !");
            panelKategori.getBtnHapus().setEnabled(false);
            panelKategori.getBtnUpdate().setEnabled(false);
            panelKategori.getBtnSimpan().setEnabled(false);
        }
    }
    
}
