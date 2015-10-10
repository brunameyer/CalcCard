/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.BandeiraDao;
import dao.ClienteDao;
import entity.Bandeira;
import entity.Cliente;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author brunameyer
 */
public class AppServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        
        String acao = req.getParameter("acao");
        if (acao.equals("listar")) {
            List<Bandeira> listaBandeiras;
            BandeiraDao bandeiraDao = new BandeiraDao();
            listaBandeiras = bandeiraDao.listarBandeiras();
            req.setAttribute("listinha", listaBandeiras);
            RequestDispatcher rd = req.getRequestDispatcher("listBandeira.jsp");
            rd.forward(req, resp);
        }
        if (acao.equals("excluir")) {
            BandeiraDao bandeiraDao = new BandeiraDao();
            Integer id = Integer.parseInt(req.getParameter("id"));
            Bandeira bandeiraParaExcluir = bandeiraDao.getBandeiraById(id);
            bandeiraDao.delete(bandeiraParaExcluir);
            
            RequestDispatcher rd = req.getRequestDispatcher("servlet?acao=listar");
            rd.forward(req, resp);                     
        }
        if (acao.equals("editar")) {
            String idAsString = req.getParameter("id");
            Integer id = Integer.parseInt(idAsString);
            BandeiraDao bandeiraDao = new BandeiraDao();
            Bandeira bandeiraParaEditar = bandeiraDao.getBandeiraById(id);
            req.setAttribute("bandeira", bandeiraParaEditar);
            RequestDispatcher rd = req.getRequestDispatcher("servlet?acao=listar");
            rd.forward(req, resp);                       
        }
        if (acao.equals("salvar")) {
            Bandeira bandeira = new Bandeira();
            String idAsString = req.getParameter("id");
            if (!idAsString.equals("null")) {
                Integer id = Integer.parseInt(idAsString);
                bandeira.setId(id);
            }
            String descricao = req.getParameter("descricao");
            bandeira.setDescricao(descricao);
            BandeiraDao bandeiraDao = new BandeiraDao();
            bandeiraDao.salvar(bandeira);
            RequestDispatcher rd = req.getRequestDispatcher("servlet?acao=listar");
            rd.forward(req, resp);                    
        }
        if (acao.equals("novaBandeira")) {
            Bandeira bandeiraNova = new Bandeira();
            req.setAttribute("bandeira", bandeiraNova);
            RequestDispatcher rd = req.getRequestDispatcher("servlet?acao=listar");
            rd.forward(req, resp);
        }
    }
    
    

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }
    
    
    
}
