/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koperasi.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author dickajava
 */
public class RequestBarang {
    private String idrequest;
    private Admin admin;
    private Suplier suplier;
    private Date tanggal;
    private double totalRequest;
    private List<RequestDetil> requestDetils=new ArrayList<>();
    
    
    public List<RequestDetil> getRequestDetils(){
        return requestDetils;
    }
    
    public void setRequestDetils(List<RequestDetil> requestDetils){
        this.requestDetils=requestDetils;
    }
    
    public String getIdrequest(){
        return idrequest;
    }
    
    public void setIdrequest(String idrequest){
        this.idrequest=idrequest;
    }
    
    public Admin getAdmin(){
        return admin;
    }
    
    public void setAdmin(Admin admin){
        this.admin=admin;
    }
    
    public Suplier getSuplier(){
        return suplier;
    }
    
    public void setSuplier(Suplier suplier){
        this.suplier=suplier;
    }
    
    public Date getTanggal(){
        return tanggal;
    }
    
    public void setTanggal(Date tanggal){
        this.tanggal=tanggal;
    }
    
    public double getTotalrequest(){
        return totalRequest;
    }
    
    public void setTotalrequest(double totalRequest){
        this.totalRequest=totalRequest;
    }
}
