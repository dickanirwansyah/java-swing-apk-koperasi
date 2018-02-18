/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koperasi.dao;

import com.koperasi.entities.Admin;

/**
 *
 * @author dickajava
 */
public interface AdminDAO {
    
    public void saveAdmin(Admin admin);
    
    public Admin getLoginAdmin(String username, String password);
    
    public Admin getAdminById(int id);
    
}
