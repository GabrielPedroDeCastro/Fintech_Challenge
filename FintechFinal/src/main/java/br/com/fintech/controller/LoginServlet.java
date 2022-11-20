package br.com.fintech.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import br.com.fintech.bean.Usuario;
import br.com.fintech.bo.EmailBO;
import br.com.fintech.dao.UsuarioDAO;
import br.com.fintech.exception.EmailException;
import br.com.fintech.factory.DAOFactory;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UsuarioDAO dao;
	private EmailBO bo;

    public LoginServlet() {
        dao = DAOFactory.getUsuarioDAO();
        bo = new EmailBO();    
    }


	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		int codigo = request.getParameter("codigo");
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		Usuario usuario = new Usuario (codigo, nome, email, senha);
		
		if (dao.validarUsuario(usuario)) {
			HttpSession session = request.getSession();
			session.setAttribute ("user",email);
				String mensagem = "Um login foi realizado com sucesso!";
			try {
				bo.enviarEmail(email, "Login Realizado", mensagem);
			} catch (EmailException e) {
				e.printStackTrace();
			}
		} else {
			request.setAttribute ("erro", "Usuario e/ou senha inválidos");
		}
		request.getRequestDispatcher("home.jsp").forward(request);
		
		doGet(request, response);
	}

}
