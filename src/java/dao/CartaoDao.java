/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Cartao;
import entity.Cartao;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author brunameyer
 */
public class CartaoDao {
    
    @Deprecated
    public boolean insert (Cartao cartao) {
        Connection c = this.getConnection();
        try { 
            PreparedStatement ps
                    = c.prepareStatement("INSERT INTO Cartao"
                    + "(taxaDebito, taxaCredito)"
                    + "Values (?) (?)");
            ps.setFloat(1, cartao.getTaxaCredito());
            ps.setFloat(2, cartao.getTaxaDebito());
            
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
    
    @Deprecated
    public boolean update (Cartao cartao) {
        Connection c = this.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement("UPDATE Cartao"
            + "SET descricao = ?"
            + "WHERE id = ?");
            
            ps.setFloat(1, cartao.getTaxaCredito());
            ps.setFloat(2, cartao.getTaxaDebito());
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
    
    @Deprecated
    public boolean delete (Cartao cartao) {
        Connection c = this.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement("DELETE FROM Cartao"
            + "WHERE id=?");
            
            ps.setFloat(1,cartao.getTaxaCredito());
            ps.setFloat(2,cartao.getTaxaDebito());
            
            ps.execute();
            ps.close();
            return true;
        } catch (SQLException ex)  {
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
    
    public Cartao getCartaoById (Integer idCartao) {
        Connection c = this.getConnection();
        Cartao cartao = null;
        
        try {
            PreparedStatement ps = c.prepareStatement("SELECT id,"
            + "id, taxaDebito, taxaCredito"
            + "FROM Cartao WHERE id = ?");
            
            ps.setInt(1, cartao.getIdCartao());
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                
                cartao = new Cartao();
                cartao.setIdCartao(rs.getInt("idCartao"));
                cartao.setTaxaCredito(rs.getFloat("taxaCredito"));
                cartao.setTaxaDebito(rs.getFloat("taxaDebito"));
                
                }
            
            rs.close();
            ps.close();
            return cartao;
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
    
    public List<Cartao> listarCartaos() {
        List<Cartao> lista = new ArrayList<Cartao>();
        Connection c = this.getConnection();
        try {
            PreparedStatement ps
                    = c.prepareStatement("SELECT idCartao, taxaDebito, taxaCredito "
                            + "FROM Cartao");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Cartao objCartao = new Cartao();
                objCartao.setIdCartao(rs.getInt("id"));
                objCartao.setTaxaCredito(rs.getFloat("taxaCredito"));
                objCartao.setTaxaDebito(rs.getFloat("taxaDebito"));

                lista.add(objCartao);
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                c.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return lista;
    }
    
    public void salvar (Cartao cartao) {
        if (cartao.getIdCartao() == null) {
            insert(cartao);
        } else {
            update(cartao);
        }
    }
 
    private Connection getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
