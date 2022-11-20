package br.com.fintech.factory;

import br.com.fintech.dao.ContaDAO;
import br.com.fintech.dao.impl.OracleContaDAO;

import br.com.fintech.dao.ProdutosDAO;
import br.com.fintech.dao.impl.OracleProdutosDAO;

import br.com.fintech.dao.CatAcaoDAO;
import br.com.fintech.dao.impl.OracleCatAcaoDAO;

import br.com.fintech.dao.TpContaDAO;
import br.com.fintech.dao.impl.OracleTpContaDAO;

import br.com.fintech.dao.AcaoDAO;
import br.com.fintech.dao.impl.OracleAcaoDAO;

import br.com.fintech.dao.CartoesDAO;
import br.com.fintech.dao.impl.OracleCartoesDAO;

import br.com.fintech.dao.UsuarioDAO;
import br.com.fintech.dao.impl.OracleUsuarioDAO;


public class DAOFactory {
	
	public static ContaDAO getContaDAO() {
		return new OracleContaDAO();
	}
	public static ProdutosDAO getProdutosDAO() {
		return new OracleProdutosDAO();
	}
	
	public static CatAcaoDAO getCatAcaoDAO() {
		return new OracleCatAcaoDAO();
	}
	
	public static TpContaDAO getTpContaDAO() {
		return new OracleTpContaDAO();
	}
	
	public static AcaoDAO getAcaoDAO() {
		return new OracleAcaoDAO();
	}
	
	public static CartoesDAO getCartoesDAO() {
		return new OracleCartoesDAO();
	}
	
	public static UsuarioDAO getUsuarioDAO() {
		return new OracleUsuarioDAO();
	}

}
