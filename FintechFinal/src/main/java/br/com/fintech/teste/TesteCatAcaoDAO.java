package br.com.fintech.teste;

import java.util.List;

import br.com.fintech.bean.T_Cat_Acao;
import br.com.fintech.dao.CatAcaoDAO;
import br.com.fintech.factory.DAOFactory;

public class TesteCatAcaoDAO {

	public static void main(String[] args) {
		CatAcaoDAO dao = DAOFactory.getCatAcaoDAO();
		
		List<T_Cat_Acao> lista = dao.listar();
		for (T_Cat_Acao categoria:lista) {
			System.out.println(categoria.getId_Cat_Acao() + " " + categoria.getNmCategoria());
		}
	}
}
