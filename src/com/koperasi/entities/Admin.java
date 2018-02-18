/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koperasi.entities;

/**
 *
 * @author dickajava
 */
public class Admin {
    
    private int idadmin;
    private String nama;
    private String username;
    private String password;
    
    public int getIdadmin(){
        return idadmin;
    }
    
    public void setIdadmin(int idadmin){
        this.idadmin=idadmin;
    }
    
    public String getNama(){
        return nama;
    }
    
    public void setNama(String nama){
        this.nama=nama;
    }
    
    public String getUsername(){
        return username;
    }
    
    public void setUsername(String username){
        this.username=username;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setPassword(String password){
        this.password=password;
    }

    @Override
    public String toString() {
        return nama;
    }
    
    
}
