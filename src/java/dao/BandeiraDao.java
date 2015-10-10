/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import entity.Bandeira;
import entity.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author VDISOO0219
 */
public class BandeiraDao {
    
        
    @Deprecated
public boolean insert(Bandeira bandeira) {
        Connection c = this.getConnection();
        try {
            PreparedStatement ps
                    = c.prepareStatement("INSERT INTO Bandeira "
                            + "( descricao )  "
                            + "VALUES ( ? )");
            ps.setString(1, bandeira.getDescricao());
            
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
    public boolean update(Bandeira bandeira) {
        Connection c = this.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement("UPDATE Bandeira "
                    + "SET descricao = ? "
                    + " WHERE id = ?");
            ps.setString(1, bandeira.getDescricao());
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
    
    public boolean delete(Bandeira bandeira) {
        Connection c = this.getConnection();
        try {
            PreparedStatement ps
                    = c.prepareStatement("DELETE FROM Bandeira "
                            + "WHERE id = ?");
            ps.setInt(1, bandeira.getId());

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
    
    public Bandeira getBandeiraById(int id) {
        Connection c = this.getConnection();
        Bandeira bandeira = null;
        try {
            PreparedStatement ps = c.prepareStatement("SELECT id, "
                    + "id, descricao "
                    + "FROM Bandeira WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                bandeira = new Bandeira();
                bandeira.setId(rs.getInt("id"));
                bandeira.setDescricao(rs.getString("descricao"));
                

            }
            rs.close();
            ps.close();
            return bandeira;
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
    
    public List<Bandeira> listarBandeiras() {
        List<Bandeira> lista = new ArrayList<Bandeira>();
        Connection I = this.getConnection();
        try {
            PreparedStatement ps
                    = I.prepareStatement("SELECT id, descricao "
                            + "FROM bandeira");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Bandeira objBandeira = new Bandeira();
                objBandeira.setId(rs.getInt("id"));
                objBandeira.setDescricao(rs.getString("descricao"));

                lista.add(objBandeira);
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                I.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return lista;
    }
    
    public void salvar(Bandeira bandeira) {
        if (bandeira.getId() == null) {
            insert(bandeira);
        } else {
            update(bandeira);
        }

    }

    private Connection getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
