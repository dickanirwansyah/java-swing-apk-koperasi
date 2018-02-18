/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koperasi.controller;

import com.koperasi.dao.BarangDAO;
import com.koperasi.dao.BarangDAOImpl;
import com.koperasi.dao.KategoriDAO;
import com.koperasi.dao.KategoriDAOImpl;
import com.koperasi.entities.Barang;
import com.koperasi.entities.Kategori;
import com.koperasi.panel.PanelBarang;
import javax.swing.JOptionPane;

/**
 *
 * @author dickajava
 */
public class ControllerBarang {
    
    private Barang b;
    private BarangDAO barangDAO;
    private KategoriDAO kategoriDAO;
    public ControllerBarang(){
        barangDAO=new BarangDAOImpl();
        b=new Barang();
        kategoriDAO=new KategoriDAOImpl();
    }
    
    public int getValidasiJumlahStok(PanelBarang panelBarang){
        int jumlah=0;
        String nama="";
        for(int i=0; i<panelBarang.getTabelBarang().getRowCount(); i++){
            nama=(String) panelBarang.getTabelBarang().getValueAt(i, 1);
            jumlah=(int) panelBarang.getTabelBarang().getValueAt(i, 3);
        }
        if(jumlah<12){
            JOptionPane.showMessageDialog(null, "jumlah stok "+nama+ " kurang dari 20 harap hubungi suplier !");
        }
        return jumlah;
    }
    
    private boolean doValid(PanelBarang panelBarang){
        boolean valid=false;
        if(panelBarang.getTextKodeBarang().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "kode barang masih kosong");
        }else if(panelBarang.getTextNamaBarang().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "nama barang masih kosong");
        }else if(panelBarang.getTextKodeKategori().getText().trim().isEmpty() && panelBarang.getTextNamaKategori().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "kategori masih belum dipilih !");
        }else if(panelBarang.getTextJumlah().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "jumlah barang masih kosong");
        }else if(panelBarang.getTextHarga().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "harga barang masih kosong ");
        }else{
            valid=true;
        }
        return valid;
    }
    
    
    public void doAmbilBarang(PanelBarang panelBarang){
        int index=panelBarang.getTabelBarang().getSelectedRow();
        if(index!=-1){
            b=panelBarang.getTabelModelBarang()
                    .get(panelBarang.getTabelBarang().convertRowIndexToModel(index));
            panelBarang.getTextHarga().setText(String.valueOf(b.getHarga()));
            panelBarang.getTextJumlah().setText(String.valueOf(b.getJumlah()));
            panelBarang.getTextKodeKategori().setText(String.valueOf(b.getKategori().getIdkategori()));
            panelBarang.getTextNamaKategori().setText(String.valueOf(b.getKategori().getNama()));
            panelBarang.getTextKodeBarang().setText(String.valueOf(b.getIdbarang()));
            panelBarang.getTextNamaBarang().setText(String.valueOf(b.getNama()));
            JOptionPane.showMessageDialog(null, "data berhasil terseleksi !");
            panelBarang.getBtnSimpan().setEnabled(false);
            panelBarang.getBtnCari().setEnabled(true);
            panelBarang.getBtnHapus().setEnabled(true);
            panelBarang.getBtnUpdate().setEnabled(true);
        }else{
            JOptionPane.showMessageDialog(null, "seleksi salah satu baris !");
        }
    }
    
    private void doResetBarang(PanelBarang panelBarang){
        panelBarang.getTexKategori().setText("");
        panelBarang.getTextHarga().setText("");
        panelBarang.getTextKodeBarang().setText("");
        panelBarang.getTextKodeKategori().setText("");
        panelBarang.getTextNamaBarang().setText("");
        panelBarang.getTextJumlah().setText("");
        panelBarang.getTextNamaKategori().setText("");
    }
    
    
    public void doAutoKode(PanelBarang panelBarang){
        try {
            String kodebarang=barangDAO.autonumber();
            panelBarang.getTextKodeBarang().setText(kodebarang);
            panelBarang.getBtnSimpan().setEnabled(true);
            panelBarang.getBtnCari().setEnabled(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void doUpdateBarang(PanelBarang panelBarang){
        try {
            int index=panelBarang.getTabelBarang().getSelectedRow();
            if(index!=-1){
                b=panelBarang.getTabelModelBarang()
                        .get(panelBarang.getTabelBarang().convertRowIndexToModel(index));
                if(doValid(panelBarang)==true){
                    String kode=panelBarang.getTextKodeBarang().getText();
                    String nama=panelBarang.getTextNamaBarang().getText();
                    String idkategori=panelBarang.getTextKodeKategori().getText();
                    int jumlah=Integer.valueOf(panelBarang.getTextJumlah().getText());
                    double harga=Double.valueOf(panelBarang.getTextHarga().getText());
                    
                    b.setIdbarang(kode);
                    b.setNama(nama);
                    Kategori kodekategori=kategoriDAO.findOne(idkategori);
                    b.setKategori(kodekategori);
                    b.setJumlah(jumlah);
                    b.setHarga(harga);
                    
                    barangDAO.updateBarang(b);
                    doResetBarang(panelBarang);
                    JOptionPane.showMessageDialog(null, "data berhasil diupdate");
                }
            }else{
                JOptionPane.showMessageDialog(null, "seleski salah satu baris !");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void doHapusBarang(PanelBarang panelBarang){
        try {
            int index=panelBarang.getTabelBarang().getSelectedRow();
            if(index!=-1){
                b=panelBarang.getTabelModelBarang()
                        .get(panelBarang.getTabelBarang().convertRowIndexToModel(index));
                if(JOptionPane.showConfirmDialog(null, "apakah anda yakin ingin hapus data ini?", 
                        "konfirmasi", JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
                    barangDAO.deleteBarang(b);
                    doResetBarang(panelBarang);
                    JOptionPane.showMessageDialog(null, "data berhasil dihapus !");
                }
            }else{
                JOptionPane.showMessageDialog(null, "seleksi salah satu baris !");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void doSaveBarang(PanelBarang panelBarang){
        try {
            if(doValid(panelBarang)==true){
            String kode=panelBarang.getTextKodeBarang().getText();
            String nama=panelBarang.getTextNamaBarang().getText();
            String idkategori=panelBarang.getTextKodeKategori().getText();
            int jumlah=Integer.valueOf(panelBarang.getTextJumlah().getText());
            double harga=Double.valueOf(panelBarang.getTextHarga().getText());
            
            b.setIdbarang(kode);
            b.setNama(nama);
            b.setJumlah(jumlah);
            b.setHarga(harga);
            Kategori kodekategori=kategoriDAO.findOne(idkategori);
            b.setKategori(kodekategori);
            barangDAO.saveBarang(b);
            doResetBarang(panelBarang);
            JOptionPane.showMessageDialog(null, "sukses !");
            panelBarang.getBtnSimpan().setEnabled(false);
            panelBarang.getBtnCari().setEnabled(false);
          }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
