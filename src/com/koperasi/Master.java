/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koperasi;

import com.koperasi.dao.BarangDAO;
import com.koperasi.dao.BarangDAOImpl;
import com.koperasi.dao.RequestBarangDAO;
import com.koperasi.dao.RequestBarangDAOImpl;
import com.koperasi.dao.TransaksiDAO;
import com.koperasi.dao.TransaksiDAOImpl;
import com.koperasi.entities.Admin;
import com.koperasi.entities.Barang;
import com.koperasi.entities.RequestBarang;
import com.koperasi.entities.Transaksi;
import com.koperasi.internal.InteranalTransaksi;
import com.koperasi.internal.InternalBarang;
import com.koperasi.internal.InternalKategori;
import com.koperasi.internal.InternalPembelianTanggal;
import com.koperasi.internal.InternalRequest;
import com.koperasi.internal.InternalRequestTanggal;
import com.koperasi.internal.InternalSuplier;
import com.koperasi.laporan.TampilReport;
import com.koperasi.panel.PanelBarang;
import java.util.List;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;
import net.sf.jasperreports.view.JRDesignViewer;

/**
 *
 * @author dickajava
 */
public class Master extends javax.swing.JFrame {

   private Admin a;
   private BarangDAO barangDAO;
   private TransaksiDAO transaksiDAO;
   private RequestBarangDAO requestBarangDAO;
   private PanelBarang panelBarang;
    public Master() {
        initComponents();
        barangDAO=new BarangDAOImpl();
        transaksiDAO=new TransaksiDAOImpl();
        requestBarangDAO=new RequestBarangDAOImpl();
        setSize(1350, 1000);
        panelBarang=new PanelBarang();
    }

    
    
    public void setAdmin(Admin admin){
        a=new Admin();
        a=admin;
        if(admin!=null){
            labelAdmin.setText(a.getNama());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        labelAdmin = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Staff Koperasi"));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Selamat Datang :");

        labelAdmin.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        labelAdmin.setText("Admin");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelAdmin)
                .addContainerGap(135, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(labelAdmin))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jDesktopPane1.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(163, Short.MAX_VALUE))
        );

        getContentPane().add(jDesktopPane1, java.awt.BorderLayout.CENTER);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/koperasi/gambar/1490374831_Key.png"))); // NOI18N
        jMenu1.setText("Logout");

        jMenuItem11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/koperasi/gambar/1490375304_Delete.png"))); // NOI18N
        jMenuItem11.setText("Keluar");
        jMenu1.add(jMenuItem11);

        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/koperasi/gambar/1490374806_Database.png"))); // NOI18N
        jMenu2.setText("Master");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/koperasi/gambar/1490374806_Database.png"))); // NOI18N
        jMenuItem1.setText("Data Kategori");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/koperasi/gambar/1490374806_Database.png"))); // NOI18N
        jMenuItem2.setText("Data Barang");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/koperasi/gambar/1490374806_Database.png"))); // NOI18N
        jMenuItem3.setText("Data Suplier");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/koperasi/gambar/1490374806_Database.png"))); // NOI18N
        jMenu3.setText("Transaksi");

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/koperasi/gambar/1490374806_Database.png"))); // NOI18N
        jMenuItem4.setText("Penjualan");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/koperasi/gambar/1490374806_Database.png"))); // NOI18N
        jMenuItem5.setText("Pembelian");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem5);

        jMenuBar1.add(jMenu3);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/koperasi/gambar/1490374778_Report.png"))); // NOI18N
        jMenu4.setText("Laporan");

        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/koperasi/gambar/1490374778_Report.png"))); // NOI18N
        jMenuItem6.setText("Laporan Semua Barang");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem6);

        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/koperasi/gambar/1490374778_Report.png"))); // NOI18N
        jMenuItem7.setText("Laporan Semua Penjualan");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem7);

        jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/koperasi/gambar/1490374778_Report.png"))); // NOI18N
        jMenuItem8.setText("Laporan Semua Pembelian");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem8);

        jMenuItem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/koperasi/gambar/1490374778_Report.png"))); // NOI18N
        jMenuItem9.setText("Laporan Pembelian Pertanggal");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem9);

        jMenuItem10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/koperasi/gambar/1490374778_Report.png"))); // NOI18N
        jMenuItem10.setText("Laporan Penjualan Pertanggal");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem10);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // kategori data
        InternalKategori ik=new InternalKategori();
        jDesktopPane1.add(ik);
        ik.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // barang data
        InternalBarang ib=new InternalBarang();
        jDesktopPane1.add(ib);
        ib.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // suplier data
        InternalSuplier is=new InternalSuplier();
        jDesktopPane1.add(is);
        is.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // transaksi penjualan ke pelanggan
        InteranalTransaksi transaksi=new InteranalTransaksi();
        jDesktopPane1.add(transaksi);
        transaksi.setAdmin(a);
        transaksi.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // transaksi pembelian ke suplier
        InternalRequest ir=new InternalRequest();
        jDesktopPane1.add(ir);
        ir.setAmbilDataAdmin(a);
        ir.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // Laporan Semua Barang
        try {
            List<Barang> listbarang=barangDAO.findAllBarang();
            JasperPrint jp=JasperFillManager.fillReport(this.getClass()
                    .getClassLoader().getResourceAsStream("com/koperasi/laporan/LaporanBarang.jasper"),null, 
                    new JRBeanCollectionDataSource(listbarang));
            JRViewer jrv=new JRViewer(jp);
            TampilReport tampilReport=new TampilReport("Laporan Semua Barang", jrv);
            JOptionPane.showMessageDialog(null, "data berhasil di extract ke pdf !");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // Laporan Semua Penjualan
        try {
            List<Transaksi> listTransaksi=transaksiDAO.getListTransaksi();
            JasperPrint jp=JasperFillManager.fillReport(this.getClass().getClassLoader()
                    .getResourceAsStream("com/koperasi/laporan/LaporanTransaksi.jasper"), null, 
                    new JRBeanCollectionDataSource(listTransaksi));
            JRViewer jrv=new JRViewer(jp);
            TampilReport tampilReport=new TampilReport("Laporan Semua Pembelian", jrv);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // Laporan Semua Pembelian
        try {
            List<RequestBarang>listRequest=requestBarangDAO.getListRequest();
            JasperPrint jp=JasperFillManager.fillReport(this.getClass().getClassLoader()
                    .getResourceAsStream("com/koperasi/laporan/LaporanRequest.jasper"), null,  
                    new JRBeanCollectionDataSource(listRequest));
            JRViewer jrv=new JRViewer(jp);
            TampilReport tampilReport=new TampilReport("Laporan Pembelian Barang", jrv);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        // Laporan transaksi penjualan berdasarkan tanggal
        InternalPembelianTanggal ipt=new InternalPembelianTanggal();
        jDesktopPane1.add(ipt);
        ipt.setVisible(true);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        // Laporan request pembelian berdasarkan tanggal
        InternalRequestTanggal irt=new InternalRequestTanggal();
        jDesktopPane1.add(irt);
        irt.setVisible(true);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Master.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Master.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Master.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Master.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Master().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelAdmin;
    // End of variables declaration//GEN-END:variables
}
