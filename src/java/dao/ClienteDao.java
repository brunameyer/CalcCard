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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author brunameyer
 */
public class ClienteDao {
    
  @Deprecated
public boolean insert(Cliente cliente) {
        Connection c = this.getConnection();
        try {
            PreparedStatement ps
                    = c.prepareStatement("INSERT INTO Cliente "
                            + "( razaoSocial, cnpj )  "
                            + "VALUES ( ?, ? )");
            ps.setString(1, cliente.getRazaoSocial());
            ps.setInt(2, cliente.getCnpj());

            ps.execute();
            ps.close();
            return true;

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                c.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }

    //  Use o #salvar para update e insert
    @Deprecated
    public boolean update(Cliente cliente) {
        Connection c = this.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement("UPDATE Cliente "
                    + "SET razaoSocial = ? "
                    + "SET  cnpj = ? "
                    + " WHERE idcliente = ?");
            ps.setString(1, cliente.getRazaoSocial());
            ps.setInt(2, cliente.getIdCliente());
            ps.setInt(3, cliente.getCnpj());
            ps.execute();

            ps.close();
            return true;

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                c.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }

    public boolean delete(Cliente cliente) {
        Connection c = this.getConnection();
        try {
            PreparedStatement ps
                    = c.prepareStatement("DELETE FROM Cliente "
                            + "WHERE idcliente = ?");
            ps.setInt(1, cliente.getIdCliente());

            ps.execute();

            ps.close();
            return true;

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                c.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }

    public Cliente getClienteById(int id) {
        Connection c = this.getConnection();
        Cliente cliente = null;
        try {
            PreparedStatement ps = c.prepareStatement("SELECT idCliente, "
                    + "idCliente, razaoSocial, cnpj "
                    + "FROM cliente WHERE idCliente = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("idCliente"));
                cliente.setRazaoSocial(rs.getString("razaoSocial"));
                cliente.setCnpj(rs.getInt("cnpj"));

            }
            rs.close();
            ps.close();
            return cliente;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                c.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }
    
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
    
    public void salvar(Cliente cliente) {
        if (cliente.getIdCliente() == null) {
            insert(cliente);
        } else {
            update(cliente);
        }
}

    private Connection getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
