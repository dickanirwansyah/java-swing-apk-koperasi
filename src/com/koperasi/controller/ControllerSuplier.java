/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koperasi.controller;

import com.koperasi.dao.SuplierDAO;
import com.koperasi.dao.SuplierDAOImpl;
import com.koperasi.entities.Suplier;
import com.koperasi.panel.PanelSuplier;
import javax.swing.JOptionPane;

/**
 *
 * @author dickajava
 */
public class ControllerSuplier {
    
    
    private Suplier s;
    private SuplierDAO suplierDAO;
    public ControllerSuplier(){
        s=new Suplier();
        suplierDAO=new SuplierDAOImpl();
    }
    
    
    private boolean doValidasi(PanelSuplier ps){
        boolean valid=false;
        if(ps.getTextKodeSuplier().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "kode suplier masih kosong");
        }else if(ps.getTextNamaSuplier().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "nama suplier masih kosong");
        }else if(ps.getTextTeleponSuplier().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "telepon masih kosong");
        }else if(ps.getTextAlamat().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "alamat masih kosong");
        }else{
            valid=true;
        }
        return valid;
    }
    
    public void doHapusSuplier(PanelSuplier ps){
        try {
            int index=ps.getTabelSuplier().getSelectedRow();
            if(index!=-1){
                s=ps.getTabelModelSuplier().get(ps.getTabelSuplier().convertRowIndexToModel(index));
                if(JOptionPane.showConfirmDialog(null, "yakin ingin hapus data ini?", "konfirmasi", 
                        JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
                    suplierDAO.deleteSuplier(s);
                    doReset(ps);
                    JOptionPane.showMessageDialog(null, "data berhasil dihapus");
                    ps.getBtnDeleteSuplier().setEnabled(false);
                    ps.getBtnUpdateSuplier().setEnabled(false);
                }
            }else{
                JOptionPane.showMessageDialog(null, "seleksi salah satu baris !");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void doUpdateSuplier(PanelSuplier ps){
        try {
            int index=ps.getTabelSuplier().getSelectedRow();
            if(index!=-1){
                s=ps.getTabelModelSuplier().get(ps.getTabelSuplier().convertRowIndexToModel(index));
                if(doValidasi(ps)==true){
                    String kode=ps.getTextKodeSuplier().getText();
                    String nama=ps.getTextNamaSuplier().getText();
                    String telepon=ps.getTextTeleponSuplier().getText();
                    String alamat=ps.getTextAlamat().getText();
                    
                    s.setIdsuplier(kode);
                    s.setAlamat(alamat);
                    s.setNama(nama);
                    s.setAlamat(alamat);
                    
                    suplierDAO.updateSuplier(s);
                    doReset(ps);
                    JOptionPane.showMessageDialog(null, "data berhasil diupdate!");
                    ps.getBtnUpdateSuplier().setEnabled(false);
                    ps.getBtnDeleteSuplier().setEnabled(false);
                }
            }else{
                JOptionPane.showMessageDialog(null, "seleksi salah satu baris");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    public void doAmbilSuplier(PanelSuplier ps){
        try {
            int index=ps.getTabelSuplier().getSelectedRow();
            if(index!=-1){
                s=ps.getTabelModelSuplier().get(ps.getTabelSuplier().convertRowIndexToModel(index));
                ps.getTextAlamat().setText(s.getAlamat());
                ps.getTextKodeSuplier().setText(s.getIdsuplier());
                ps.getTextNamaSuplier().setText(s.getNama());
                ps.getTextTeleponSuplier().setText(s.getNotelp());
                
                JOptionPane.showMessageDialog(null, "data berhasil terseleksi");
                ps.getBtnDeleteSuplier().setEnabled(true);
                ps.getBtnUpdateSuplier().setEnabled(true);
            }else{
                JOptionPane.showMessageDialog(null, "seleksi salah satu baris !");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void doSaveSuplier(PanelSuplier ps){
        try {
            if(doValidasi(ps)==true){
                String kode=ps.getTextKodeSuplier().getText();
                String nama=ps.getTextNamaSuplier().getText();
                String alamat=ps.getTextAlamat().getText();
                String telepon=ps.getTextTeleponSuplier().getText();
                
                s.setAlamat(alamat);
                s.setIdsuplier(kode);
                s.setNama(nama);
                s.setNotelp(telepon);
                
                suplierDAO.saveSuplier(s);
                doReset(ps);
                JOptionPane.showMessageDialog(null, "data berhasil disimpan !");
                ps.getBtnSaveSuplier().setEnabled(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void doAutoKode(PanelSuplier ps){
        try {
            String kodeauto=suplierDAO.autoKodeSuplier();
            ps.getTextKodeSuplier().setText(kodeauto);
            ps.getBtnSaveSuplier().setEnabled(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    private void doReset(PanelSuplier ps){
        ps.getTextAlamat().setText("");
        ps.getTextKodeSuplier().setText("");
        ps.getTextNamaSuplier().setText("");
        ps.getTextTeleponSuplier().setText("");
    }
    
    
    
}
