/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.CartaoDao;
import entity.Cartao;
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
        if (acao.equals("listarCartao")) {
            List<Cartao> listaCartoes;
            CartaoDao cartaoDao = new CartaoDao();
            listaCartoes = cartaoDao.listarCartoes();
            req.setAttribute("lista", listaCartoes);
            RequestDispatcher rd = req.getRequestDispatcher("listCartao.jsp");
            rd.forward(req, resp);
        }
        if (acao.equals("excluirCartao")) {
            CartaoDao cartaoDao = new CartaoDao();
            Integer idCartao = Integer.parseInt(req.getParameter("id"));
            Cartao cartaoParaExcluir = cartaoDao.getCartaoById(idCartao);
            cartaoDao.delete(cartaoParaExcluir);
            
            RequestDispatcher rd = req.getRequestDispatcher("servlet?acao=listarCartao");
            rd.forward(req, resp);                     
        }
        if (acao.equals("editarCartao")) {
            String idAsString = req.getParameter("id");
            Integer idCartao = Integer.parseInt(idAsString);
            CartaoDao cartaoDao = new CartaoDao();            
            Cartao cartaoParaEditar = cartaoDao.getCartaoById(idCartao);
            req.setAttribute("cartao", cartaoParaEditar);
            RequestDispatcher rd = req.getRequestDispatcher("editCartao.jsp");
            rd.forward(req, resp);                       
        }
        if (acao.equals("salvarCartao")) {
            CartaoDao dao = new CartaoDao();
            Cartao cartao = new Cartao();
            String idAsString = req.getParameter("id");
            if (!idAsString.isEmpty()) {
                Integer idCartao = Integer.parseInt(idAsString);
                cartao = dao.getCartaoById(idCartao);
            }
            Float taxaCredito = Float.parseFloat(req.getParameter("txtTaxaCredito"));
            Float taxaDebito = Float.parseFloat(req.getParameter("txtTaxaDebito"));
            cartao.setTaxaCredito(taxaCredito);
            cartao.setTaxaDebito(taxaDebito);
            CartaoDao cartaoDao = new CartaoDao();
            cartaoDao.salvar(cartao);
            RequestDispatcher rd = req.getRequestDispatcher("servlet?acao=listarCartao");
            rd.forward(req, resp);                    
        }
        if (acao.equals("novoCartao")) {
            Cartao cartaoNovo = new Cartao();
            req.setAttribute("cartao", cartaoNovo);
            RequestDispatcher rd = req.getRequestDispatcher("editCartao.jsp");
            rd.forward(req, resp);
        }
    }
    
    

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
    
    
    
}
