/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koperasi.dao;

import com.koperasi.entities.ReportTransaksiPembelian;
import com.koperasi.entities.RequestBarang;
import java.util.Date;
import java.util.List;

/**
 *
 * @author dickajava
 */
public interface RequestBarangDAO {
    
    public String getAutoKode();
    
    public boolean insertRequestBarangFromSuplier(RequestBarang requestBarang);
    
    public List<RequestBarang> getListRequest();
    
    public List<ReportTransaksiPembelian> getCetakRequest(String idrequest);
    
    public List<ReportTransaksiPembelian> getCetakRequestByTanggal(Date tanggalMulai, Date tanggalAkhir);
}
