/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Cartao;
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
    
    public Cartao getCartaoById (Integer idCartao) {        
        Cartao cartao = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        
        //Criteria criteria = session.createCriteria(Produto.class);
        //criteria.add(Restrictions.like("nome", nome));
        //lista = criteria.list();
        
        cartao = (Cartao) session.get(Cartao.class, idCartao);          
        
        session.getTransaction().commit();
        session.close();
        return cartao;
    }
    
    public List<Cartao> listarCartoes() {
        List<Cartao> lista = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        
        Query query  = session.createQuery("from entity.Cartao");
        
        lista = query.list();
        
        session.getTransaction().commit();
        session.close();
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
