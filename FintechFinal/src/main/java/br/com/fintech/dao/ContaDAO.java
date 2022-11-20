package br.com.fintech.dao;

import java.util.List;

import br.com.fintech.bean.Conta;
import br.com.fintech.exception.DBException;

public interface ContaDAO {
	
	void cadastrar (Conta conta) throws DBException;
	void atualizar (Conta conta) throws DBException;
	void remover (int idConta) throws DBException;
	Conta buscar (int idConta);
	List <Conta> listar();
	

}