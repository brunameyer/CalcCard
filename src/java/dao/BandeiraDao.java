/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Bandeira;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author VDISOO0219
 */
public class BandeiraDao {

    public boolean delete(Bandeira bandeira) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.delete(bandeira);
        session.getTransaction().commit();
        session.close();
        return true;

    }

    public Bandeira getBandeiraById(Integer id) {
        Bandeira bandeira = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        bandeira = (Bandeira) session.get(Bandeira.class, id);
        session.getTransaction().commit();
        session.close();
        return bandeira;
    }

    public List<Bandeira> listarBandeiras() {
        List<Bandeira> lista = new ArrayList<Bandeira>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query= session.createQuery("from entity.Bandeira");
        lista = query.list();
        return lista;
        
    }

    public void salvar(Bandeira bandeira) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.saveOrUpdate(bandeira);
        session.getTransaction().commit();
        session.close();
    }

    

}
