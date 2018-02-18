/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koperasi.dialog;

import com.koperasi.dao.SuplierDAO;
import com.koperasi.dao.SuplierDAOImpl;
import com.koperasi.entities.Suplier;
import com.koperasi.tabelmodel.TabelModelSuplier;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author dickajava
 */
public class SuplierDialog extends javax.swing.JDialog {

    
    private TabelModelSuplier tabelModelSuplier;
    private SuplierDAO suplierDAO;
    private Suplier s;
    public SuplierDialog() {
        setModal(true);
        initComponents();
        s=new Suplier();
        suplierDAO=new SuplierDAOImpl();
        setLocationRelativeTo(null);
        loadSuplier();
    }

    private void loadSuplier(){
        List list=suplierDAO.findAllSuplier();
        tabelModelSuplier=new TabelModelSuplier(list, Suplier.class);
        tabel_suplier.setModel(tabelModelSuplier);
    }
    
    public Suplier getAmbilSuplier(){
        setLocationRelativeTo(getParent());
        setVisible(true);
        setTitle("Data Suplier");
        return s;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_suplier = new com.stripbandunk.jwidget.JDynamicTable();
        jPanel2 = new javax.swing.JPanel();
        btnAmbil = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("Data Suplier");
        jPanel1.add(jLabel1);

        jScrollPane1.setViewportView(tabel_suplier);

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
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 681, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAmbilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAmbilActionPerformed
        // proses ambil suplie
        try {
            int index=tabel_suplier.getSelectedRow();
            if(index!=-1){
                s=tabelModelSuplier.get(tabel_suplier.convertRowIndexToModel(index));
                dispose();
            }else{
                JOptionPane.showMessageDialog(null, "seleksi salah satu baris !");
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
    private com.stripbandunk.jwidget.JDynamicTable tabel_suplier;
    // End of variables declaration//GEN-END:variables
}
