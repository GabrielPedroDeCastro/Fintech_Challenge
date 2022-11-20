package br.com.fintech.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/produto")
public class CadastroServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private ProdutoDAO dao;
	private CategoriaDAO categoriaDao;

	@Override
	public void init() throws ServletException {
		super.init();
		dao = DAOFactory.getProdutoDAO();
		categoriaDao = DAOFactory.getCategoriaDAO();
	}
     
   //... Mais códigos..
}