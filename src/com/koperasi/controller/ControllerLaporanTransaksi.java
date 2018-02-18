/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koperasi.controller;

import com.koperasi.dao.TransaksiDAO;
import com.koperasi.dao.TransaksiDAOImpl;
import com.koperasi.entities.PilihBarang;
import com.koperasi.entities.ReportTransaksiPenjualan;
import com.koperasi.entities.Transaksi;
import com.koperasi.internal.InternalPembelianTanggal;
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
public class ControllerLaporanTransaksi {
    
    private TransaksiDAO transaksiDAO;
    private Transaksi transaksi;
    private PilihBarang pb;
    public ControllerLaporanTransaksi(){
        transaksiDAO=new TransaksiDAOImpl();
        transaksi=new Transaksi();
        pb=new PilihBarang();
    }
    
    public void getCetakLaporanTanggal(InternalPembelianTanggal ipt){
        try {
            List<ReportTransaksiPenjualan> transaksiPenjualan=transaksiDAO.
                    getReportTransaksiByTanggal
            (ipt.getTextTanggalMulai().getDate(), ipt.getTextTanggalBerakhir().getDate());
            JasperPrint jp=JasperFillManager.fillReport(this.getClass().getClassLoader()
                    .getResourceAsStream("com/koperasi/laporan/CetakPenjualan.jasper"), null,
                    new JRBeanCollectionDataSource(transaksiPenjualan));
            JRViewer jrv=new JRViewer(jp);
            TampilReport tampilReport=new TampilReport("Laporan berdasarkan tanggal", jrv);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void getCetakLaporanTanggal1(InternalPembelianTanggal ipt){
        try {
            if(ipt.getTextTanggalMulai().getDate()==null){
                JOptionPane.showMessageDialog(null, "maaf tanggal mulai belum ditentukan");
            }else if(ipt.getTextTanggalBerakhir().getDate()==null){
                JOptionPane.showMessageDialog(null, "maaf tanggal akhir belum ditentukan");
            }else{
                List<ReportTransaksiPenjualan> transaksiPenjualan=transaksiDAO
                        .getReportTransaksiByTanggal(ipt.getTextTanggalMulai().getDate(), 
                                ipt.getTextTanggalBerakhir().getDate());
                JasperPrint jp=JasperFillManager.fillReport(this.getClass().getClassLoader()
                        .getResourceAsStream("com/koperasi/laporan/CetakPenjualan.jasper"), null, 
                        new JRBeanCollectionDataSource(transaksiPenjualan));
                JRViewer jrv=new JRViewer(jp);
                TampilReport tampilReport=new TampilReport("Laporan Berdasarkan tanggal", jrv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
