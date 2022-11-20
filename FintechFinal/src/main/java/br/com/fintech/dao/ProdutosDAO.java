package br.com.fintech.dao;

import java.util.List;

import br.com.fintech.bean.Produtos;
import br.com.fintech.exception.DBException;

public interface ProdutosDAO {
	void cadastrar (Produtos produtos) throws DBException;
	void atualizar (Produtos produtos) throws DBException;
	void remover (int idProdutos) throws DBException;
	Produtos buscar (int idProdutos);
	List <Produtos> listar();

}
