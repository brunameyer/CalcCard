/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Cliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author brunameyer
 */
public class ClienteDao {
    
    public List<Cliente> getAll() {
        List<Cliente> lista = new ArrayList();
        Connection conn = null;
        PreparedStatement sttm = null;
        ResultSet rs = null;
        
        try {
        Class.forName("orj.gjt.mm.mysql.Driver");
        conn = DriverManager.getConnection("", "root", "");
        
        sttm = conn.prepareStatement("select * from Cliente");
        rs = sttm.executeQuery();
        while (rs.next()) {
            Cliente cliente = new Cliente();
            cliente.setIdCliente(rs.getInt(""));
            cliente.setRazaoSocial(rs.getString("razaoSocial"));
            cliente.setCnpj(rs.getInt("cnpj"));
            lista.add(cliente);
        }
        conn.close();
        
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lista;
    }
}
