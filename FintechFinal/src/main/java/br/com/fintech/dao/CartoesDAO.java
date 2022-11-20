package br.com.fintech.dao;

import java.util.List;

import br.com.fintech.bean.Cartoes;
import br.com.fintech.exception.DBException;

public interface CartoesDAO {
	
	void cadastrar (Cartoes cartoes) throws DBException;
	void atualizar (Cartoes cartoes) throws DBException;
	void remover (int idCartoes) throws DBException;
	Cartoes buscar (int idCartoes);
	List <Cartoes> listar();

}
