/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koperasi.controller;

import com.koperasi.dao.RequestBarangDAO;
import com.koperasi.dao.RequestBarangDAOImpl;
import com.koperasi.entities.ReportTransaksiPembelian;
import com.koperasi.entities.RequestBarang;
import com.koperasi.internal.InternalRequestTanggal;
import com.koperasi.laporan.TampilReport;
import java.util.List;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author dickajava
 */


public class ControllerLaporanRequest {
    
    private RequestBarangDAO requestBarangDAO;
    private RequestBarang rb;
    public ControllerLaporanRequest(){
        requestBarangDAO=new RequestBarangDAOImpl();
        rb=new RequestBarang();
    }
    
    
    public void getCetakRequestBarang(InternalRequestTanggal irt){
        try {
            if(irt.getTextTanggalMulai().getDate()==null){
                JOptionPane.showMessageDialog(null, "tanggal mulai belum dipilih");
            }else if(irt.getTextTanggalAkhir().getDate()==null){
                JOptionPane.showMessageDialog(null, "tanggal akhir belum dipilih");
            }else{
                List<ReportTransaksiPembelian> pembelianRequest=requestBarangDAO
                        .getCetakRequestByTanggal(irt.getTextTanggalMulai().getDate(), 
                                irt.getTextTanggalAkhir().getDate());
                JasperPrint jp=JasperFillManager.fillReport(getClass().getClassLoader()
                        .getResourceAsStream("com/koperasi/laporan/CetakRequest.jasper"), null, 
                        new JRBeanCollectionDataSource(pembelianRequest));
                JRViewer jrv=new JRViewer(jp);
                TampilReport tampilReport=new TampilReport("Laporan berdasarkan tanggal", jrv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
