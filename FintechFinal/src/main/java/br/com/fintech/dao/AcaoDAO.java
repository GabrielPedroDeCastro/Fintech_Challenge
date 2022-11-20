package br.com.fintech.dao;

import java.util.List;

import br.com.fintech.bean.Acao;
import br.com.fintech.exception.DBException;

public interface AcaoDAO {
	
	void cadastrar (Acao acao) throws DBException;
	void atualizar (Acao acao) throws DBException;
	void remover (int idAcao) throws DBException;
	Acao buscar (int idAcao);
	List <Acao> listar();

}
