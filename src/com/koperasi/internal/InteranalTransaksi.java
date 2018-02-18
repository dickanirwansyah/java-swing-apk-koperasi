/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koperasi.internal;

import com.koperasi.controller.ControllerTransaksi;
import com.koperasi.dao.TransaksiDAO;
import com.koperasi.dao.TransaksiDAOImpl;
import com.koperasi.dialog.PilihBarangDialog;
import com.koperasi.entities.Admin;
import com.koperasi.entities.PilihBarang;
import com.koperasi.entities.Transaksi;
import com.koperasi.entities.TransaksiDetil;
import com.koperasi.tabelmodel.TabelModelTransaksiDetil;
import com.stripbandunk.jwidget.JDynamicTable;
import com.toedter.calendar.JDateChooser;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author dickajava
 */
public class InteranalTransaksi extends javax.swing.JInternalFrame {

    
    List<TransaksiDetil> list=new ArrayList<>();
    private TabelModelTransaksiDetil tabelModelTransaksiDetil;
    private Date tanggalSekarang;
    private TransaksiDAO transaksiDAO;
    private Admin admin;
    private PilihBarang pb;
    private Transaksi t;
    private ControllerTransaksi controllerTransaksi;
    public InteranalTransaksi() {
        initComponents();
        tanggalSekarang=new Date();
        txtTanggal.setDate(tanggalSekarang);
        txtTanggal.setEnabled(false);
        transaksiDAO=new TransaksiDAOImpl();
        btnCariBarang.setEnabled(false);
        btnHapus.setEnabled(false);
        pb=new PilihBarang();
        t=new Transaksi();
        btnSimpan.setEnabled(false);
        btnCetak.setEnabled(false);
        controllerTransaksi=new ControllerTransaksi();
        txtTotalTransaksi.setEnabled(false);
        setLocation(200, 40);
        txtKodeTransaksi.setEnabled(false);
        sessionTransaksi();
    }

    private void resetForm(){
        txtTotalTransaksi.setText("");
        tabelModelTransaksiDetil.clear();
    }
    
    private boolean validasiInput(){
        boolean valid=false;
        if(txtKodeTransaksi.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "kode transaksi masih kosong");
        }else if(txtTanggal.getDate()==null){
            JOptionPane.showMessageDialog(null, "tanggal masih kosong");
        }else if(txtTotalTransaksi.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "total keseluruhan masih kosong !");
        }else if(tabel_transaksiDetil.getRowCount()==0){
            JOptionPane.showMessageDialog(null, "pilih barang salah satu !");
        }else{
            valid=true;
        }
        return valid;
    }
    
    public void setAdmin(Admin admin){
        this.admin=admin;
    }
    
    public JTextField getTextKodeTransaksi(){
        return txtKodeTransaksi;
    }
    
    public JDateChooser getTextTanggalTransaksi(){
        return txtTanggal;
    }
    
    public JDynamicTable getTabelDetilTransaksi(){
        return tabel_transaksiDetil;
    }
    
    public TabelModelTransaksiDetil getTabelModelTransaksi(){
        return tabelModelTransaksiDetil;
    }
            
    public JButton getBtnSaveBarang(){
        return btnSimpan;
    }
    
    public JButton btnHapus(){
        return btnHapus;
    }
    
    public JButton getBtnCetak(){
        return btnCetak;
    }
    
    public JButton getBtnCariBarang(){
        return btnCariBarang;
    }
    
    public JTextField getTextTotal(){
        return txtTotalTransaksi;
    }
    
    private void sessionTransaksi(){
        tabelModelTransaksiDetil=new TabelModelTransaksiDetil(list, TransaksiDetil.class);
        tabel_transaksiDetil.setModel(tabelModelTransaksiDetil);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtKodeTransaksi = new javax.swing.JTextField();
        txtTotalTransaksi = new javax.swing.JTextField();
        txtTanggal = new com.toedter.calendar.JDateChooser();
        jButton6 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_transaksiDetil = new com.stripbandunk.jwidget.JDynamicTable();
        jPanel3 = new javax.swing.JPanel();
        btnNew = new javax.swing.JButton();
        btnCariBarang = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        btnCetak = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("Transaksi View");
        jPanel1.add(jLabel1);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("form transaksi"));

        jLabel2.setText("idtransaksi :");

        jLabel3.setText("Tanggal :");

        jLabel5.setText("Total belanja :");

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/koperasi/gambar/1490375343_Upload.png"))); // NOI18N
        jButton6.setText("Hitung");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(157, 157, 157)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtKodeTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtTotalTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton6))
                    .addComponent(txtTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(224, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtKodeTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(txtTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTotalTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(tabel_transaksiDetil);

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/koperasi/gambar/1490374731_Create.png"))); // NOI18N
        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });
        jPanel3.add(btnNew);

        btnCariBarang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/koperasi/gambar/1490374744_Search.png"))); // NOI18N
        btnCariBarang.setText("Cari Barang");
        btnCariBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariBarangActionPerformed(evt);
            }
        });
        jPanel3.add(btnCariBarang);

        btnHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/koperasi/gambar/1490375304_Delete.png"))); // NOI18N
        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });
        jPanel3.add(btnHapus);

        btnSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/koperasi/gambar/1490374759_Save.png"))); // NOI18N
        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });
        jPanel3.add(btnSimpan);

        btnCetak.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/koperasi/gambar/1490374778_Report.png"))); // NOI18N
        btnCetak.setText("Cetak");
        btnCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakActionPerformed(evt);
            }
        });
        jPanel3.add(btnCetak);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCariBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariBarangActionPerformed
        // cari barang dan insert multiple
        controllerTransaksi.getAmbilBarang(this);
    }//GEN-LAST:event_btnCariBarangActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // proses haspus barang
        controllerTransaksi.getHapusBarang(this);
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        // controller new transaksi
        controllerTransaksi.getNewTransaksi(this);
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // controller simpan keseluhan
        try {
            if(validasiInput()==true){
                t=new Transaksi();
                t.setIdtransaksi(txtKodeTransaksi.getText());
                t.setTanggal(txtTanggal.getDate());
                t.setAdmin(admin);
                t.setTotalTransaksi(Double.valueOf(txtTotalTransaksi.getText()));
                
                List<TransaksiDetil> listdetils=new ArrayList();
                for(int i=0; i<tabelModelTransaksiDetil.getRowCount(); i++){
                    TransaksiDetil td=new TransaksiDetil();
                    PilihBarang pb=(PilihBarang) tabelModelTransaksiDetil.getValueAt(i, 0);
                    String nama=(String) tabelModelTransaksiDetil.getValueAt(i, 1);
                    int jumlah=(int) tabelModelTransaksiDetil.getValueAt(i, 2);
                    double harga=(double) tabelModelTransaksiDetil.getValueAt(i, 3);
                    
                    td.setTransaksi(t);
                    td.setPilihBarang(pb);
                    td.setHarga(harga);
                    td.setJumlah(jumlah);
                    td.setNama(nama);
                    listdetils.add(td);
                }
                t.setTransaksiDetils(listdetils);
                if(transaksiDAO.insertTransaksi(t)==true){
                    JOptionPane.showMessageDialog(null, "data berhasil disimpan !");
                    btnCariBarang.setEnabled(false);
                    btnHapus.setEnabled(false);
                    btnSimpan.setEnabled(false);
                    btnCetak.setEnabled(true);
                    resetForm();
                }else{
                    JOptionPane.showMessageDialog(null, "data gagal disimpan !");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // proses hitung
        controllerTransaksi.getHitungTotal(this);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakActionPerformed
        // proses cetak berdasarkan kode
        controllerTransaksi.getCetakTransaksiBerdasrkanKode(this);
    }//GEN-LAST:event_btnCetakActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCariBarang;
    private javax.swing.JButton btnCetak;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private com.stripbandunk.jwidget.JDynamicTable tabel_transaksiDetil;
    private javax.swing.JTextField txtKodeTransaksi;
    private com.toedter.calendar.JDateChooser txtTanggal;
    private javax.swing.JTextField txtTotalTransaksi;
    // End of variables declaration//GEN-END:variables
}
