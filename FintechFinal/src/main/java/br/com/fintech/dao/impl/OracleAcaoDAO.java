package br.com.fintech.dao.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fintech.bean.Acao;
import br.com.fintech.bean.Conta;
import br.com.fintech.bean.T_Cat_Acao;
import br.com.fintech.dao.AcaoDAO;
import br.com.fintech.exception.DBException;
import br.com.fintech.singleton.ConnectionManager;

public class OracleAcaoDAO implements AcaoDAO {
	
	private Connection conexao;

	@Override
	public void cadastrar(Acao acao) throws DBException {
		PreparedStatement stmt = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO T_ACAO (ID_ACAO,DS_ACAO,"
					+ "VL_ACAO,NM_TP_ACAO,NM_TP_NECESSIDADE,DT_ACAO,"
					+ "T_CONTA_ID_CONTA,T_CAT_ACAO_ID_CAT_ACAO)"
					+ " VALUES (SQ_T_ACAO.NEXTVAL,?,?,?,?,?,?,?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, acao.getDsAcao());
			stmt.setDouble(2, acao.getVlAcao());
			stmt.setString(3, acao.getNm_tp_acao());
			stmt.setString(4, acao.getNm_tp_necessidade());
			java.sql.Date data =
					new java.sql.Date(
							acao.getDtAcao().getTimeInMillis());
			stmt.setDate(5, data);
			stmt.setInt(6,acao.getCodigoConta().getIdConta());
			stmt.setInt(7,acao.getCodigoCatAcao().getId_Cat_Acao());
						
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
	public void atualizar(Acao acao) throws DBException {
		PreparedStatement stmt = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE T_ACAO SET DS_ACAO=?,"
					+ "VL_ACAO=?,NM_TP_ACAO=?,NM_TP_NECESSIDADE=?,"
					+ "DT_ACAO=?, T_CONTA_ID_CONTA=?, T_CAT_ACAO_ID_CAT_ACAO=?"
					+ "  WHERE ID_ACAO=?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, acao.getDsAcao());
			stmt.setDouble(2, acao.getVlAcao());
			stmt.setString(3, acao.getNm_tp_acao());
			stmt.setString(4, acao.getNm_tp_necessidade());
			java.sql.Date data =
					new java.sql.Date(
							acao.getDtAcao().getTimeInMillis());
			stmt.setDate(5, data);
			stmt.setInt(6, acao.getCodigoConta().getIdConta());
			stmt.setInt(7, acao.getCodigoCatAcao().getId_Cat_Acao());
			stmt.setInt(8, acao.getIdAcao());
			
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
	public void remover(int idAcao) throws DBException {
		PreparedStatement stmt = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "DELETE FROM T_ACAO WHERE ID_ACAO=?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, idAcao);
			
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
	public Acao buscar(int idAcao) {
		Acao acao = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement(""
					+ "SELECT * FROM T_ACAO "
					+ "INNER JOIN T_CONTA "
					+ "ON T_ACAO.T_CONTA_ID_CONTA=T_CONTA.ID_CONTA "
					+ "INNER JOIN T_CAT_ACAO "
					+ "ON T_ACAO.T_CAT_ACAO_ID_CAT_ACAO=T_CAT_ACAO.DI_CAT_ACAO "					
					+ "WHERE T_ACAO.ID_ACAO=?");
			stmt.setInt(1, idAcao);
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				int codigo = rs.getInt("ID_ACAO");
				String descricao = rs.getString("DS_ACAO");
				Double valor = rs.getDouble("VL_ACAO");
				String tpAcao = rs.getString("NM_TP_ACAO");
				String tpNecessidade = rs.getString("NM_TP_NECESSIDADE");
				java.sql.Date data = rs.getDate("DT_ACAO");
				Calendar dataAcao = Calendar.getInstance();
				dataAcao.setTimeInMillis(data.getTime());
				
				String nrAgencia = rs.getString("NR_AGENCIA");
				int codigoConta = rs.getInt("ID_CONTA");				
				String nrConta = rs.getString("NR_CONTA");
				String tpConta = rs.getString("NM_TP_CONTA");
				String banco = rs.getString("NM_BANCO");
				Double saldo = rs.getDouble("VL_SALDO");
				
				int codigoCategoria = rs.getInt("ID_CAT_ACAO");
				String nmcategoria = rs.getString("NM_CATEGORIA");				
				
				acao = new Acao (codigo, descricao, valor, tpAcao,
						tpNecessidade, dataAcao);
				
				Conta conta = new Conta (nrAgencia,codigoConta,nrConta,tpConta,banco,saldo);
				
				T_Cat_Acao categoria = new T_Cat_Acao (codigoCategoria,nmcategoria);
				
				acao.setCodigoConta(conta);
				acao.setCodigoCatAcao(categoria);
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
		return acao;
	}

	@Override
	public List<Acao> listar() {
		List <Acao> lista = new ArrayList <Acao>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_ACAO "
					+ "INNER JOIN T_CONTA "
					+ "ON T_ACAO.T_CONTA_ID_CONTA=T_CONTA.ID_CONTA "
					+ "INNER JOIN T_CAT_ACAO "
					+ "ON T_ACAO.T_CAT_ACAO_ID_CAT_ACAO=T_CAT_ACAO.DI_CAT_ACAO ");
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				int codigo = rs.getInt("ID_ACAO");
				String descricao = rs.getString("DS_ACAO");
				Double valor = rs.getDouble("VL_ACAO");
				String tpAcao = rs.getString("NM_TP_ACAO");
				String tpNecessidade = rs.getString("NM_TP_NECESSIDADE");
				java.sql.Date data = rs.getDate("DT_ACAO");
				Calendar dataAcao = Calendar.getInstance();
				dataAcao.setTimeInMillis(data.getTime());
				
				String nrAgencia = rs.getString("NR_AGENCIA");
				int codigoConta = rs.getInt("ID_CONTA");				
				String nrConta = rs.getString("NR_CONTA");
				String tpConta = rs.getString("NM_TP_CONTA");
				String banco = rs.getString("NM_BANCO");
				Double saldo = rs.getDouble("VL_SALDO");
				
				int codigoCategoria = rs.getInt("ID_CAT_ACAO");
				String nmcategoria = rs.getString("NM_CATEGORIA");				
				
				Acao acao = new Acao (codigo, descricao, valor, tpAcao,
						tpNecessidade, dataAcao);
				
				Conta conta = new Conta (nrAgencia,codigoConta,nrConta,tpConta,banco,saldo);
				
				T_Cat_Acao categoria = new T_Cat_Acao (codigoCategoria,nmcategoria);
				
				acao.setCodigoConta(conta);
				acao.setCodigoCatAcao(categoria);
				lista.add(acao);
				
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
