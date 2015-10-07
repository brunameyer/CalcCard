/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.ClienteDao;
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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String acao = req.getParameter("acao");
        if (acao.equals("listar")) {
            ClienteDao clienteDao = new ClienteDao();
            List<Cliente> lista = clienteDao.getAll();
            req.setAttribute("lista", lista);
            RequestDispatcher rd = req.getRequestDispatcher("listaCliente.jsp");
            rd.forward(req, resp);
        }
        if (acao.equals("excluir")) {
            ClienteDao clienteDao = new ClienteDao();
            Integer id = Integer.parseInt(req.getParameter("id"));
            Cliente clienteExcluido = clienteDao.getClienteById(id);
            clienteDao.delete(clienteExcluido);
            
            RequestDispatcher rd = req.getRequestDispatcher("servlet?acao=listar");
            rd.forward(req, resp);
        }
        if (acao.equals ("editar")) {
            String idAsString = req.getParameter("id");
            Integer id = Integer.parseInt(idAsString);
            ClienteDao clienteDao = new ClienteDao();
            Cliente clienteParaEditar = clienteDao.getClienteById(id);
            req.setAttribute("Cliente", clienteParaEditar);
            RequestDispatcher rd = req.getRequestDispatcher("editCliente.jsp");
            rd.forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }
    
    
    
}
