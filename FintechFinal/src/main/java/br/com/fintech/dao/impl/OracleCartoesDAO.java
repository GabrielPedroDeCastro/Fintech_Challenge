package br.com.fintech.dao.impl;

import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fintech.bean.Cartoes;
import br.com.fintech.bean.Conta;
import br.com.fintech.dao.CartoesDAO;
import br.com.fintech.exception.DBException;
import br.com.fintech.singleton.ConnectionManager;

public class OracleCartoesDAO implements CartoesDAO {
	
	private Connection conexao;

	@Override
	public void cadastrar(Cartoes cartoes) throws DBException {
		PreparedStatement stmt = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO T_CARTOES (ID_CARTOES,DS_TP_CARTAO,"
					+ "DS_BANDEIRA,DS_ULT_DIGITO,DS_SUB_EMISSORA,VL_LIMITE,ID_CONTA "
					+ " VALUES (SQ_T_CARTOES.NEXTVAL,?,?,?,?,?,?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, cartoes.getDs_tp_cartao());
			stmt.setString(2, cartoes.getDsBandeira());
			stmt.setString(3, cartoes.getDs_ult_digito());
			stmt.setString(4, cartoes.getDs_sub_emissora());
			stmt.setDouble(5, cartoes.getVlLimite());
			stmt.setInt(6, cartoes.getCodigoConta().getIdConta());
								
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException ("Erro ao cadastrar.");
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void atualizar(Cartoes cartoes) throws DBException {
		PreparedStatement stmt = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE T_CARTOES SET DS_TP_CARTAO=?,"
					+ "DS_BANDEIRA=?,DS_ULT_DIGITO=?,DS_SUB_EMISSORA=?,"
					+ "VL_LIMITE=?,ID_CONTA=? WHERE ID_CARTOES=?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, cartoes.getDs_tp_cartao());
			stmt.setString(2, cartoes.getDsBandeira());
			stmt.setString(3, cartoes.getDs_ult_digito());
			stmt.setString(4, cartoes.getDs_sub_emissora());
			stmt.setDouble(5, cartoes.getVlLimite());
			stmt.setInt(6, cartoes.getCodigoConta().getIdConta());
			stmt.setInt(7, cartoes.getIdCartoes());
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException ("Erro ao atualizar.");
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		
	}

	@Override
	public void remover(int idCartoes) throws DBException {
		PreparedStatement stmt = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "DELETE FROM T_CARTOES WHERE ID_CARTOES=?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, idCartoes);
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException ("Erro ao deletar.");
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
	}

	@Override
	public Cartoes buscar(int idCartoes) {
		Cartoes cartoes = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement(""
					+ "SELECT * FROM T_CARTOES "
					+ "INNER JOIN T_CONTA "
					+ "ON T_CARTOES.ID_CONTA = T_CONTA.ID_CONTA"
					+ "WHERE T_CARTOES.ID_CARTOES=?");
			stmt.setInt(1, idCartoes);
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				int codigo = rs.getInt("ID_CARTOES");	
				String tpCartao = rs.getString("DS_TP_CARTAO");
				String bandeira = rs.getString("DS_BANDEIRA");
				String digito = rs.getString("DS_ULT_DIGITO");
				String emissora = rs.getString("DS_SUB_EMISSORA");
				Double limite = rs.getDouble("VL_LIMITE");
				
				int codigoconta = rs.getInt("ID_CONTA");
				String nrAgencia = rs.getString("NR_AGENCIA");				
				String nrConta = rs.getString("NR_CONTA");
				String tpConta = rs.getString("NM_TP_CONTA");
				String banco = rs.getString("NM_BANCO");
				Double saldoconta = rs.getDouble("VL_SALDO");
				
				cartoes = new Cartoes (codigo, tpCartao, bandeira, digito, emissora, limite);
				Conta conta = new Conta (nrAgencia,codigoconta ,nrConta, tpConta, banco, saldoconta);
				
				cartoes.setCodigoConta(conta);
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
		return cartoes;
	}
		
		
		
		
	@Override
	public List<Cartoes> listar() {
		List <Cartoes> lista = new ArrayList <Cartoes>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_CARTOES "
					+ "INNER JOIN T_CONTA "
					+ "ON T_CARTOES.ID_CONTA = T_CONTA.ID_CONTA");
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				int codigo = rs.getInt("ID_CARTOES");	
				String tpCartao = rs.getString("DS_TP_CARTAO");
				String bandeira = rs.getString("DS_BANDEIRA");
				String digito = rs.getString("DS_ULT_DIGITO");
				String emissora = rs.getString("DS_SUB_EMISSORA");
				Double limite = rs.getDouble("VL_LIMITE");
				
				int codigoconta = rs.getInt("ID_CONTA");
				String nrAgencia = rs.getString("NR_AGENCIA");				
				String nrConta = rs.getString("NR_CONTA");
				String tpConta = rs.getString("NM_TP_CONTA");
				String banco = rs.getString("NM_BANCO");
				Double saldoconta = rs.getDouble("VL_SALDO");
								
				Cartoes cartoes = new Cartoes (codigo, tpCartao, bandeira, digito, emissora, limite);
				Conta conta = new Conta (nrAgencia,codigoconta ,nrConta, tpConta, banco, saldoconta);
				cartoes.setCodigoConta(conta);
				lista.add(cartoes);
				
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
		} return lista;
	}
}

	