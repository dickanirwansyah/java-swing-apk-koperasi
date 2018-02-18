/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koperasi.dialog;

import com.koperasi.dao.KategoriDAO;
import com.koperasi.dao.KategoriDAOImpl;
import com.koperasi.entities.Kategori;
import com.koperasi.tabelmodel.TabelModelKategori;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author dickajava
 */
public class KategoriDialog extends javax.swing.JDialog {

    private Kategori k;
    private KategoriDAO kategoriDAO;
    private TabelModelKategori tabelmodelkategori;
    public KategoriDialog() {
        setModal(true);
        initComponents();
        setLocationRelativeTo(null);
        kategoriDAO=new KategoriDAOImpl();
        loadDataKategori();
        k=new Kategori();
    }

    private void loadDataKategori(){
        List<Kategori> list=kategoriDAO.findAll();
        tabelmodelkategori=new TabelModelKategori(list, Kategori.class);
        tabelKategori.setModel(tabelmodelkategori);
    }
    
    public Kategori ambilKategoris(){
        setVisible(true);
        setLocationRelativeTo(getParent());
        setTitle("Pilih Kategori");
        return k;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelKategori = new com.stripbandunk.jwidget.JDynamicTable();
        jPanel2 = new javax.swing.JPanel();
        btnPilih = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("Pilih Kategori");
        jPanel1.add(jLabel1);

        jScrollPane1.setViewportView(tabelKategori);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnPilih.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/koperasi/gambar/1490375343_Upload.png"))); // NOI18N
        btnPilih.setText("Pilih");
        btnPilih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPilihActionPerformed(evt);
            }
        });
        jPanel2.add(btnPilih);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPilihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPilihActionPerformed
        // proses pilih
        try {
            int index=tabelKategori.getSelectedRow();
            if(index!=-1){
                k=tabelmodelkategori.get(tabelKategori.convertRowIndexToModel(index));
                dispose();
            }else{
                JOptionPane.showMessageDialog(null, "selesksi salah satu baris !");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnPilihActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPilih;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private com.stripbandunk.jwidget.JDynamicTable tabelKategori;
    // End of variables declaration//GEN-END:variables
}
