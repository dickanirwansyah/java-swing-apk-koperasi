/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koperasi.controller;

import com.koperasi.dao.TransaksiDAO;
import com.koperasi.dao.TransaksiDAOImpl;
import com.koperasi.dialog.PilihBarangDialog;
import com.koperasi.entities.PilihBarang;
import com.koperasi.entities.ReportTransaksiPenjualan;
import com.koperasi.entities.Transaksi;
import com.koperasi.entities.TransaksiDetil;
import com.koperasi.internal.InteranalTransaksi;
import com.koperasi.laporan.TampilReport;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author dickajava
 */
public class ControllerTransaksi {
    
    
    private TransaksiDAO transaksiDAO;
    private Transaksi transaksi;
    private PilihBarang pb;
    public ControllerTransaksi(){
        transaksiDAO=new TransaksiDAOImpl();
        transaksi=new Transaksi();
        pb=new PilihBarang();
    }
    
   public void getCetakTransaksiBerdasrkanKode(InteranalTransaksi it){
       try {
           String kodeTransaksi=it.getTextKodeTransaksi().getText();
           List<ReportTransaksiPenjualan> listkodepenjualan=transaksiDAO.getReportTransaksi(kodeTransaksi);
           JasperPrint jp=JasperFillManager.fillReport(this.getClass().getClassLoader()
                   .getResourceAsStream("com/koperasi/laporan/CetakPenjualan.jasper"), null, 
                   new JRBeanCollectionDataSource(listkodepenjualan));
           JRViewer jrv=new JRViewer(jp);
           JOptionPane.showMessageDialog(null, "data berhasil dicetak !");
           it.getBtnCetak().setEnabled(false);
           it.getTextKodeTransaksi().setText("");
           TampilReport tampilReport=new TampilReport("Laporan Berdasarkan kode", jrv);
       } catch (Exception e) {
           e.printStackTrace();
       }
   } 
    
   public void getHapusBarang(InteranalTransaksi it){
       try {
           int index=it.getTabelDetilTransaksi().getSelectedRow();
           if(index!=-1){
               it.getTabelModelTransaksi()
                       .get(it.getTabelDetilTransaksi().convertRowIndexToModel(index));
               if(JOptionPane.showConfirmDialog(null, "yakin ingin haspu data ini?", "konfirmasi", 
                       JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
                   it.getTabelModelTransaksi().deleteTransaksiDetils(index);
                   JOptionPane.showMessageDialog(null, "data berhasil dihapus");
               }
           }else{
               JOptionPane.showMessageDialog(null, "seleksi salah satu baris !");
           }
       } catch (Exception e) {
           e.printStackTrace();
       }
   } 
    
   public void getNewTransaksi(InteranalTransaksi it){
       try {
           String kodeTransaksi=transaksiDAO.autonumber();
           it.getTextKodeTransaksi().setText(kodeTransaksi);
           it.getBtnCariBarang().setEnabled(true);
           it.btnHapus().setEnabled(true);
       } catch (Exception e) {
           e.printStackTrace();
       }
   }
   
   private int getValidasiHitung(InteranalTransaksi it){
       int jumlah=0;
       for(int i=0; i<it.getTabelModelTransaksi().getRowCount(); i++){
           jumlah=(int) it.getTabelModelTransaksi().getValueAt(i, 2);
       }
       return jumlah;
   }
   
   
   public void getHitungTotal(InteranalTransaksi it){
       int jumlahBaris=it.getTabelModelTransaksi().getRowCount();
        double totalHarga=0;
        double totalJumlah, totalSatuan;
        TableModel tableModel;
        tableModel=it.getTabelDetilTransaksi().getModel();
        if(getValidasiHitung(it)==0){
            JOptionPane.showMessageDialog(null, "total tidak bisa dihitung karena masih ada nilai yang 0");
        }else{
            for(int i=0; i<jumlahBaris; i++){
               totalJumlah=Double.parseDouble(it.getTabelModelTransaksi().getValueAt(i, 2).toString());
               totalSatuan=Double.parseDouble(it.getTabelModelTransaksi().getValueAt(i, 3).toString());
               totalHarga=totalHarga+(totalJumlah*totalSatuan);
            }
            it.getTextTotal().setText(String.valueOf(totalHarga));
        }
   }
   
   public void getAmbilBarang(InteranalTransaksi it){
       boolean valid=false;
       PilihBarangDialog pbd=new PilihBarangDialog();
       pb=pbd.AmbilPilihBarang();
       if(pb!=null){
           List<PilihBarang> pilihBarangCek=pbd.tabelModelPilihBarang.getCekBarang();
           for(PilihBarang pilbar : pilihBarangCek){
               TransaksiDetil td =new TransaksiDetil();
               td.setPilihBarang(pilbar);
               td.setNama(pilbar.getNama());
               td.setJumlah(0);
               td.setHarga(pilbar.getHarga());
               
               it.getBtnSaveBarang().setEnabled(true);
               
               //proses validasi
               for(int i=0; i<it.getTabelDetilTransaksi().getRowCount(); i++){
                   TransaksiDetil detils = it.getTabelModelTransaksi().get(i);
                   if(detils.getPilihBarang().getNama().equals(td.getPilihBarang().getNama())){
                       valid=true;
                   }
               }
               if(valid==false){
                   it.getTabelModelTransaksi().insertTransaksiDetils(td);
               }else{
                   JOptionPane.showMessageDialog(null, "Maaf nama barang sudah ada dalam tabel !");
               }
           }
       }
   } 
   
}
