/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koperasi.dao;

import com.koperasi.entities.ReportTransaksiPenjualan;
import com.koperasi.entities.Transaksi;
import java.util.Date;
import java.util.List;

/**
 *
 * @author dickajava
 */
public interface TransaksiDAO {
    
    public String autonumber();
    
    public boolean insertTransaksi(Transaksi transaksi);
    
    public List<Transaksi> getListTransaksi();
    
    public List<ReportTransaksiPenjualan> getReportTransaksi(String idtransaksi);
    
    public List<ReportTransaksiPenjualan> getReportTransaksiByTanggal(Date tanggalMulai, Date tanggalAkhir);
}
