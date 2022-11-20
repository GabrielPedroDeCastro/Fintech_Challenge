package br.com.fintech.dao.impl;

import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fintech.bean.T_Cat_Acao;
import br.com.fintech.dao.CatAcaoDAO;
import br.com.fintech.singleton.ConnectionManager;

public class OracleCatAcaoDAO implements CatAcaoDAO{
	
	private Connection conexao;
	
	@Override
	public List<T_Cat_Acao> listar() {
		List<T_Cat_Acao> lista = new ArrayList<T_Cat_Acao>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_CAT_ACAO");
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				int codigo = rs.getInt("ID_CAT_ACAO");
				String nmcategoria = rs.getString("NM_CATEGORIA");
				T_Cat_Acao categoria = new T_Cat_Acao (codigo,nmcategoria);
				lista.add(categoria);							
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				rs.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return lista;
	}
}
