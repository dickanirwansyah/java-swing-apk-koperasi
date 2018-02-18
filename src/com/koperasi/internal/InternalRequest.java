/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koperasi.internal;

import com.koperasi.controller.ControllerRequest;
import com.koperasi.dao.RequestBarangDAO;
import com.koperasi.dao.RequestBarangDAOImpl;
import com.koperasi.dao.RequestDetilDAOImpl;
import com.koperasi.dao.SuplierDAO;
import com.koperasi.dao.SuplierDAOImpl;
import com.koperasi.dialog.PilihBarangDialog;
import com.koperasi.dialog.SuplierDialog;
import com.koperasi.entities.Admin;
import com.koperasi.entities.PilihBarang;
import com.koperasi.entities.RequestBarang;
import com.koperasi.entities.RequestDetil;
import com.koperasi.entities.Suplier;
import com.koperasi.tabelmodel.TabelModelRequestDetil;
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
public class InternalRequest extends javax.swing.JInternalFrame {

    private RequestBarang rb;
    private RequestBarangDAO requestBarangDAO;
    private List<RequestDetil> list=new ArrayList<>();
    private Admin admin;
    private Date tanggalSekarang;
    private Suplier s;
    private PilihBarang pb;
    private SuplierDAO suplierDAO;
    private ControllerRequest cr;
    private TabelModelRequestDetil tabelModelRequestDetil;
    public InternalRequest() {
        initComponents();
        rb=new RequestBarang();
        tanggalSekarang=new Date();
        suplierDAO=new SuplierDAOImpl();
        txtTanggal.setDate(tanggalSekarang);
        txtTanggal.setEnabled(false);
        txtNamaSuplier.setEnabled(false);
        txtKodeSuplier.setEnabled(false);
        btnSimpan.setEnabled(false);
        btnCariBarang.setEnabled(false);
        btnHapus.setEnabled(false);
        txtKodeRequest.setEnabled(false);
        txtTotalRequest.setEnabled(false);
        cr=new ControllerRequest();
        requestBarangDAO=new RequestBarangDAOImpl();
        setLocation(200, 40);
        loadRequest();
    }

    private void isiSuplier(Suplier s){
        txtKodeSuplier.setText(String.valueOf(s.getIdsuplier()));
        txtNamaSuplier.setText(String.valueOf(s.getNama()));
    }
    
    private void resetAfterSaved(){
        txtKodeSuplier.setText("");
        txtNamaSuplier.setText("");
        txtTotalRequest.setText("");
        tabelModelRequestDetil.clearRequest();
    }
    
    private boolean validasiSaved(){
        boolean valid=false;
        if(txtKodeRequest.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "kode request masih kosong");
        }else if(txtKodeSuplier.getText().trim().isEmpty() && txtNamaSuplier.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "suplier belum dipilih !");
        }else if(txtTanggal.getDate()==null){
            JOptionPane.showMessageDialog(null, "tanggal masih kosong");
        }else if(txtTotalRequest.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "total request masih  belum dihitung");
        }else if(tabel_requestDetil.getRowCount()==0){
            JOptionPane.showMessageDialog(null, "barang request masih 0 harap cari barang yang mau dibeli");
        }else{
            valid=true;
        }
        return valid;
    }
    
    public void setAmbilDataAdmin(Admin admin){
        this.admin=admin;
    }
    
   
    
    public JButton getBtnCari(){
        return btnCari;
    }
    
    public JButton getBtnCariBarang(){
        return btnCariBarang;
    }
    
    public JButton getBtnDelete(){
        return btnHapus;
    }
    
    public JButton getBtnSave(){
        return btnSimpan;
    }
    
    public TabelModelRequestDetil getTabelModelRequest(){
        return tabelModelRequestDetil;
    }
    
    public JDynamicTable getTabelRequestDetil(){
        return tabel_requestDetil;
    }
    
    public JTextField getTextTotal(){
        return txtTotalRequest;
    }
    
    public JTextField getTextKodeSuplier(){
        return txtKodeSuplier;
    }
    
    public JTextField getTextNamaSuplier(){
        return txtNamaSuplier;
    }
    
    public JDateChooser getTextTanggal(){
        return txtTanggal;
    }
    
    public JTextField getTextKodeRequest(){
        return txtKodeRequest;
    }
    
    private void loadRequest(){
        tabelModelRequestDetil=new TabelModelRequestDetil(list, RequestDetil.class);
        tabel_requestDetil.setModel(tabelModelRequestDetil);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtKodeRequest = new javax.swing.JTextField();
        txtKodeSuplier = new javax.swing.JTextField();
        txtNamaSuplier = new javax.swing.JTextField();
        txtTanggal = new com.toedter.calendar.JDateChooser();
        txtTotalRequest = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_requestDetil = new com.stripbandunk.jwidget.JDynamicTable();
        jPanel3 = new javax.swing.JPanel();
        btnNew = new javax.swing.JButton();
        btnCariBarang = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("Request Barang");
        jPanel1.add(jLabel1);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("form request"));

        jLabel2.setText("idrequest :");

        jLabel3.setText("suplier :");

        jLabel4.setText("tanggal :");

        jLabel5.setText("total request :");

        btnCari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/koperasi/gambar/1490374744_Search.png"))); // NOI18N
        btnCari.setText("Cari");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/koperasi/gambar/1490375343_Upload.png"))); // NOI18N
        jButton1.setText("Total Pembelian");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(152, 152, 152)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtKodeRequest)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtKodeSuplier, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtNamaSuplier, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                    .addComponent(txtTanggal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTotalRequest))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCari))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jButton1)))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtKodeRequest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtKodeSuplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNamaSuplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCari))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTotalRequest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(19, 19, 19))
        );

        jScrollPane1.setViewportView(tabel_requestDetil);

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

        btnSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/koperasi/gambar/1490374759_Save.png"))); // NOI18N
        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });
        jPanel3.add(btnSimpan);

        btnHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/koperasi/gambar/1490375304_Delete.png"))); // NOI18N
        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });
        jPanel3.add(btnHapus);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        // TODO add your handling code here:
        cr.getAutoNumber(this);
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnCariBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariBarangActionPerformed
        // TODO add your handling code here:
        cr.getCariBarang(this);
    }//GEN-LAST:event_btnCariBarangActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        // suplier
        SuplierDialog dialog=new SuplierDialog();
        s=dialog.getAmbilSuplier();
        if(s!=null){
            isiSuplier(s);
        }
    }//GEN-LAST:event_btnCariActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // hapus 
        cr.getHapusRequest(this);
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // proses simpan
        try {
            if(validasiSaved()==true){
                rb=new RequestBarang();
                rb.setIdrequest(txtKodeRequest.getText());
                rb.setTanggal(txtTanggal.getDate());
                rb.setAdmin(admin);
                String kodeSuplier=txtKodeSuplier.getText();
                Suplier idsuplier=suplierDAO.findOneSuplier(kodeSuplier);
                rb.setSuplier(idsuplier);
                rb.setTotalrequest(Double.valueOf(txtTotalRequest.getText()));
                
                List<RequestDetil> listDetils=new ArrayList<>();
                for(int i=0; i<tabel_requestDetil.getRowCount(); i++){
                    RequestDetil detil=new RequestDetil();
                    detil.setRequestBarang(rb);
                    PilihBarang kodeBarang=(PilihBarang) tabelModelRequestDetil.getValueAt(i, 0);
                    String namaBarang=(String) tabelModelRequestDetil.getValueAt(i, 1);
                    int jumlah=(int) tabelModelRequestDetil.getValueAt(i, 2);
                    double harga=(double) tabelModelRequestDetil.getValueAt(i, 3);
                    
                    detil.setBarang(kodeBarang);
                    detil.setNama(namaBarang);
                    detil.setJumlah(jumlah);
                    detil.setHarga(harga);
                    listDetils.add(detil);
                }
                rb.setRequestDetils(listDetils);
                if(requestBarangDAO.insertRequestBarangFromSuplier(rb)==true){
                    JOptionPane.showMessageDialog(null, "data pembelian dari suplier berhasil disimpan !");
                    resetAfterSaved();
                    btnCari.setEnabled(false);
                    btnHapus.setEnabled(false);
                    btnSimpan.setEnabled(false);
                }else{
                    JOptionPane.showMessageDialog(null, "data gagal disimpan !");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // total pembelian
        cr.getHitungTotalPembelian(this);
    }//GEN-LAST:event_jButton1ActionPerformed

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnCariBarang;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private com.stripbandunk.jwidget.JDynamicTable tabel_requestDetil;
    private javax.swing.JTextField txtKodeRequest;
    private javax.swing.JTextField txtKodeSuplier;
    private javax.swing.JTextField txtNamaSuplier;
    private com.toedter.calendar.JDateChooser txtTanggal;
    private javax.swing.JTextField txtTotalRequest;
    // End of variables declaration//GEN-END:variables
}
