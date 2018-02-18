/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koperasi.controller;

import com.koperasi.dao.RequestBarangDAO;
import com.koperasi.dao.RequestBarangDAOImpl;
import com.koperasi.dialog.PilihBarangDialog;
import com.koperasi.entities.PilihBarang;
import com.koperasi.entities.ReportTransaksiPembelian;
import com.koperasi.entities.RequestBarang;
import com.koperasi.entities.RequestDetil;
import com.koperasi.internal.InternalRequest;
import com.koperasi.laporan.TampilReport;
import java.util.ArrayList;
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
public class ControllerRequest {
    
    private RequestBarang rb;
    private RequestDetil rd;
    private PilihBarang pb;
    private RequestBarangDAO requestBarangDAO;
    public ControllerRequest(){
        requestBarangDAO=new RequestBarangDAOImpl();
        rb=new RequestBarang();
        pb=new PilihBarang();
        rd=new RequestDetil();
    }
    
    public void getCetakLaporanRequest(InternalRequest ir){
        try {
            String kodeRequest=ir.getTextKodeRequest().getText();
            List<ReportTransaksiPembelian> cetakrequest=requestBarangDAO.getCetakRequest(kodeRequest);
            JasperPrint jp=JasperFillManager.fillReport(getClass()
                    .getClassLoader().getResourceAsStream("com/koperasi/laporan/CetakPembelian.jasper"), 
                    null, new JRBeanCollectionDataSource(cetakrequest));
            JRViewer jrv=new JRViewer(jp);
            TampilReport tampilReport=new TampilReport("Laporan Request", jrv);
            JOptionPane.showMessageDialog(null, "data berhasil dicetak !");
            ir.getTextKodeRequest().setText("");
            //ir.getBtnCetak().setEnabled(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void getAutoNumber(InternalRequest ir){
       String kode=requestBarangDAO.getAutoKode();
       ir.getTextKodeRequest().setText(kode);
       ir.getBtnCari().setEnabled(true);
       ir.getBtnCariBarang().setEnabled(true);
       ir.getBtnSave().setEnabled(true);
       ir.getBtnDelete().setEnabled(true);
    }       
    
    private int getValidasiHitung(InternalRequest ir){
        int jumlah=0;
        for(int i=0; i<ir.getTabelModelRequest().getRowCount(); i++){
           jumlah = (int) ir.getTabelModelRequest().getValueAt(i, 2);
        }
        return jumlah;
    }
    
    public void getHitungTotalPembelian(InternalRequest ir){
        int jumlahBaris=ir.getTabelModelRequest().getRowCount();
        double totalHarga=0;
        double totalJumlah, totalSatuan;
        TableModel tableModel;
        tableModel=ir.getTabelRequestDetil().getModel();
        if(getValidasiHitung(ir)==0){
            JOptionPane.showMessageDialog(null, "total tidak bisa dihitung karena masih ada nilai yang 0");
        }else{
            for(int i=0; i<jumlahBaris; i++){
               totalJumlah=Double.parseDouble(ir.getTabelModelRequest().getValueAt(i, 2).toString());
               totalSatuan=Double.parseDouble(ir.getTabelModelRequest().getValueAt(i, 3).toString());
               totalHarga=totalHarga+(totalJumlah*totalSatuan);
            }
            ir.getTextTotal().setText(String.valueOf(totalHarga));
        }
    }
    
    public void getHapusRequest(InternalRequest ir){
        try {
            int index=ir.getTabelRequestDetil().getSelectedRow();
            if(index!=-1){
                rd=ir.getTabelModelRequest().get(ir.getTabelRequestDetil().convertRowIndexToModel(index));
                if(JOptionPane.showConfirmDialog(null, "apakah anda yakin ingin membatalkan pembelian ini?", 
                        null, JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
                    ir.getTabelModelRequest().deleteRequestDetils(index);
                }
            }else{
                JOptionPane.showMessageDialog(null, "seleksi salah satu baris");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void getCariBarang(InternalRequest ir){
        try {
            boolean valid=false;
            PilihBarangDialog barangDialog=new PilihBarangDialog();
            pb=barangDialog.AmbilPilihBarang();
            if(pb!=null){
                List<PilihBarang> listpilbar=barangDialog.tabelModelPilihBarang.getCekBarang();
                for(PilihBarang pilbar : listpilbar){
                    RequestDetil rd=new RequestDetil();
                    rd.setBarang(pilbar);
                    rd.setNama(pilbar.getNama());
                    rd.setJumlah(0);
                    rd.setHarga(pilbar.getHarga());
                    
                    for(int i=0; i<ir.getTabelRequestDetil().getRowCount(); i++){
                        RequestDetil detil=ir.getTabelModelRequest().get(i);
                        if(detil.getPilihbarang().getIdbarang().equals(rd.getPilihbarang().getIdbarang())){
                            valid=true;
                        }
                    }
                    if(valid==false){
                        ir.getTabelModelRequest().insertRequestDetils(rd);
                    }else{
                        JOptionPane.showMessageDialog(null, "maaf nama barang sudah ada dalam tabel !");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
