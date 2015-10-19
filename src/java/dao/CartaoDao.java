/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Cartao;
import entity.Cartao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author brunameyer
 */
public class CartaoDao {
    
    
     public void delete (Cartao cartao) {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        
        session.delete(cartao);
        
        session.getTransaction().commit();
        session.close();
                    
    }
    
    public void getCartaoById (Integer idCartao) {
        
        Cartao cartao = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        
        cartao = (Cartao) session.get(Cartao.class, idCartao);
        
        session.delete(idCartao);
        
        session.getTransaction().commit();
        session.close();
    }
    
    public List<Cartao> getAll () {
        List<Cartao> lista = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        
        Query query  = session.createQuery("from entity.Cartao");
        
        lista = query.list();
        
        return lista;
    }
    
    public void salvar (Cartao cartao) {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        
        session.saveOrUpdate(cartao);
        
        session.getTransaction().commit();
        session.close();
    }
 
    
}
