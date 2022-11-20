package br.com.fintech.teste;

import java.util.List;

import br.com.fintech.bean.Tp_Conta;
import br.com.fintech.dao.TpContaDAO;
import br.com.fintech.factory.DAOFactory;

public class TesteTpContaDAO {
	public static void main(String[] args) {
	
			TpContaDAO dao = DAOFactory.getTpContaDAO();
			
			List<Tp_Conta> lista = dao.listar();
			for (Tp_Conta tipo:lista) {
				System.out.println(tipo.getId_Tp_Conta() + " " + tipo.getDs_Tp_Conta());
			}
		}
}
