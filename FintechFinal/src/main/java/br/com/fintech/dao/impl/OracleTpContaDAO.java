package br.com.fintech.dao.impl;

import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fintech.bean.Tp_Conta;
import br.com.fintech.dao.TpContaDAO;
import br.com.fintech.singleton.ConnectionManager;

public class OracleTpContaDAO implements TpContaDAO{
	
	private Connection conexao;

	@Override
	public List<Tp_Conta> listar() {
		List<Tp_Conta> lista = new ArrayList<Tp_Conta>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_TP_CONTA");
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				int codigo = rs.getInt("ID_TP_CONTA");
				String dsTipo = rs.getString("DS_TP_CONTA");
				Tp_Conta tipo = new Tp_Conta (codigo,dsTipo);
				lista.add(tipo);							
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
