/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koperasi.dialog;

import com.koperasi.dao.PilihBarangDAO;
import com.koperasi.dao.PilihBarangDAOImpl;
import com.koperasi.entities.PilihBarang;
import com.koperasi.tabelmodel.TabelModelPilihBarang;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author dickajava
 */
public class PilihBarangDialog extends javax.swing.JDialog {

    private PilihBarangDAO pilihBarangDAO;
    public TabelModelPilihBarang tabelModelPilihBarang;
    private PilihBarang pb;
    public PilihBarangDialog() {
        setModal(true);
        initComponents();
        pilihBarangDAO=new PilihBarangDAOImpl();
        setLocationRelativeTo(null);
        loadPilihBarang();
       
    }

    
    
    public PilihBarang AmbilPilihBarang(){
        setLocationRelativeTo(getParent());
        setVisible(true);
        setTitle("Item barang");
        return pb;
    }
    
    private void loadPilihBarang(){
        List<PilihBarang> list=pilihBarangDAO.findAllBarang();
        tabelModelPilihBarang=new TabelModelPilihBarang(list, PilihBarang.class);
        tabel_barang.setModel(tabelModelPilihBarang);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_barang = new com.stripbandunk.jwidget.JDynamicTable();
        jPanel2 = new javax.swing.JPanel();
        btnAmbil = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("Item Barang");
        jPanel1.add(jLabel1);

        jScrollPane1.setViewportView(tabel_barang);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnAmbil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/koperasi/gambar/1490375343_Upload.png"))); // NOI18N
        btnAmbil.setText("Ambil");
        btnAmbil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAmbilActionPerformed(evt);
            }
        });
        jPanel2.add(btnAmbil);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 781, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAmbilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAmbilActionPerformed
        // ambil barang
        try {
            int index=tabel_barang.getSelectedRow();
            if(index!=-1){
                pb=tabelModelPilihBarang.get(tabel_barang.convertRowIndexToModel(index));
                dispose();
            }else{
                JOptionPane.showMessageDialog(null, "Barang yang anda inginkan belum dipilih !");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnAmbilActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAmbil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private com.stripbandunk.jwidget.JDynamicTable tabel_barang;
    // End of variables declaration//GEN-END:variables
}
