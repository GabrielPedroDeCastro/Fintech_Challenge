package br.com.fintech.dao.impl;

import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fintech.bean.Conta;
import br.com.fintech.bean.Usuario;
import br.com.fintech.dao.ContaDAO;
import br.com.fintech.exception.DBException;
import br.com.fintech.singleton.ConnectionManager;

public class OracleContaDAO implements ContaDAO {
	
	private Connection conexao;

	@Override
	public void cadastrar(Conta conta) throws DBException {
		PreparedStatement stmt = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO T_CONTA (NR_AGENCIA,"
					+ "ID_CONTA,NR_CONTA,NM_TP_CONTA,NM_BANCO,"
					+ "VL_SALDO,T_USER_ID_USER) VALUES (?,SQ_T_CONTA.NEXTVAL,"
					+ "?,?,?,?,?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, conta.getNrAgencia());
			stmt.setString(2, conta.getNrConta());
			stmt.setString(3, conta.getNm_tp_conta());
			stmt.setString(4, conta.getnmBanco());
			stmt.setDouble(5, conta.getVlSaldo());
			stmt.setInt(6, conta.getCodigoUsuario().getId_User());
			
			
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
	public void atualizar(Conta conta) throws DBException {
		PreparedStatement stmt = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE T_CONTA SET NR_AGENCIA=?,"
					+ "NR_CONTA=?,NM_TP_CONTA=?,NM_BANCO=?,VL_SALDO=?,T_USER_ID_USER=? WHERE ID_CONTA=?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, conta.getNrAgencia());
			stmt.setString(2, conta.getNrConta());
			stmt.setString(3, conta.getNm_tp_conta());
			stmt.setString(4, conta.getnmBanco());
			stmt.setDouble(5, conta.getVlSaldo());
			stmt.setInt(6, conta.getCodigoUsuario().getId_User());
			stmt.setInt(7, conta.getIdConta());
			
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
	public void remover(int idConta) throws DBException {
		PreparedStatement stmt = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "DELETE FROM T_CONTA WHERE ID_CONTA=?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, idConta);
			
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
	public Conta buscar(int idConta) {
		Conta conta = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement(""
					+ "SELECT * FROM T_CONTA"
					+ "INNER JOIN T_USER"
					+ "ON T_CONTA.T_USER_ID_USER = T_USER.ID_USER"
					+ "WHERE T_CONTA.ID_CONTA=?");
			stmt.setInt(1, idConta);
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				String nrAgencia = rs.getString("NR_AGENCIA");
				int codigo = rs.getInt("ID_CONTA");				
				String nrConta = rs.getString("NR_CONTA");
				String tpConta = rs.getString("NM_TP_CONTA");
				String banco = rs.getString("NM_BANCO");
				Double saldo = rs.getDouble("VL_SALDO");
				
				int codigouser = rs.getInt("ID_USER");
				String nome = rs.getString("NM_USER");
				String email = rs.getString("DS_EMAIL");
				String senha = rs.getString("DS_SENHA");				
				
				conta = new Conta (nrAgencia,codigo,nrConta,tpConta,banco,saldo);
				Usuario usuario = new Usuario (codigouser, nome, email, senha);
				
				conta.setCodigoUsuario(usuario);
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
		return conta;
	}

	@Override
	public List<Conta> listar() {
		List <Conta> lista = new ArrayList <Conta>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_CONTA "
					+ "INNER JOIN T_USER"
					+ "ON T_CONTA.T_USER_ID_USER = T_USER.ID_USER");
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				int codigo = rs.getInt("ID_CONTA");
				String nrAgencia = rs.getString("NR_AGENCIA");
				String nrConta = rs.getString("NR_CONTA");
				String tpConta = rs.getString("NM_TP_CONTA");
				String banco = rs.getString("NM_BANCO");
				Double saldo = rs.getDouble("VL_SALDO");
				
				int codigouser = rs.getInt("ID_USER");
				String nome = rs.getString("NM_USER");
				String email = rs.getString("DS_EMAIL");
				String senha = rs.getString("DS_SENHA");				
				
				Conta conta = new Conta (nrAgencia,codigo,nrConta,tpConta,banco,saldo);
				Usuario usuario = new Usuario (codigouser, nome, email, senha);
				
				conta.setCodigoUsuario(usuario);

				lista.add(conta);
				
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
