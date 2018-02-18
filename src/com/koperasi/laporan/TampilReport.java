/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koperasi.laporan;

import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author dickajava
 */
public class TampilReport extends JDialog{
    
    private final String title;
    private final JRViewer jrv;
    public TampilReport(String title, JRViewer jrv){
        this.title=title;
        this.jrv=jrv;
        tampil();
    }
    
    private void tampil(){
        setSize(900, 700);
        setLocationRelativeTo(null);
        setTitle(title);
        getContentPane().add(jrv);
        setVisible(true);
    }
}
