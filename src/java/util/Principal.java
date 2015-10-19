/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import dao.HibernateUtil;
import entity.Cartao;
import org.hibernate.Session;

/**
 *
 * @author VDISOO0219
 */
public class Principal {
    
    public static void main (String[] args) {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();        
        
        Cartao c;
        c = (Cartao)session.get(Cartao.class, 1);
        
        session.delete(c);
        
        session.getTransaction().commit();
        session.close();
    }
    
}
