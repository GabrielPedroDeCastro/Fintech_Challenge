package br.com.fintech.teste;


import br.com.fintech.bean.Produtos;
import br.com.fintech.dao.ProdutosDAO;
import br.com.fintech.exception.DBException;
import br.com.fintech.factory.DAOFactory;

import java.util.List;

public class TesteProdutosDAO {

	public static void main(String[] args) {
		ProdutosDAO dao = DAOFactory.getProdutosDAO();
		
		//cadastro produtos
		Produtos produtos = new Produtos ( 0,"Fundo Imobiliário", "Moderado", 5000);
		try {
			dao.cadastrar(produtos);
			System.out.println("Produto Cadastrado.");
		} catch (DBException e) {
			e.printStackTrace();
			System.out.println("erro catch");
		}
		
		//buscar um produto e atualizar
		produtos = dao.buscar(1);
		produtos.setdsRisco("Conservador");
		produtos.setvlSaldo(5250);
		try {
			dao.atualizar(produtos);
			System.out.println("Produto atualizado");
		} catch (DBException e){
			e.printStackTrace();
		}
		
		//listar os produtos
		List<Produtos> lista = dao.listar();
		for (Produtos item:lista) {
			System.out.println(item.getIdProdutos() + " " + item.getdsTpProduto() + " " + item.getvlSaldo());
		}
		
		//remover um produto
		try {
			dao.remover(1);
			System.out.println("Produto Removido");
		} catch (DBException e) {
			e.printStackTrace();
		}
	}

	}

