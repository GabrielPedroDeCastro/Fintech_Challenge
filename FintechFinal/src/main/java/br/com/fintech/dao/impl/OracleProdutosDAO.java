package br.com.fintech.dao.impl;

import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fintech.bean.Conta;
import br.com.fintech.bean.Produtos;
import br.com.fintech.dao.ProdutosDAO;
import br.com.fintech.exception.DBException;
import br.com.fintech.singleton.ConnectionManager;

public class OracleProdutosDAO implements ProdutosDAO{
	
	private Connection conexao;

	@Override
	public void cadastrar(Produtos produtos) throws DBException {
		PreparedStatement stmt = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO T_PRODUTOS (ID_PRODUTOS, DS_TP_PRODUTO,"
					+ "DS_RISCO,VL_SALDO,ID_CONTA) VALUES (SQ_T_PRODUTOS.NEXTVAL,"
					+ "?,?,?,?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, produtos.getdsTpProduto());
			stmt.setString(2, produtos.getdsRisco());
			stmt.setDouble(3, produtos.getvlSaldo());
			stmt.setInt(4, produtos.getidConta().getIdConta());
			
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
	public void atualizar(Produtos produtos) throws DBException {
		PreparedStatement stmt = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE PRODUTOS SET DS_TP_PRODUTO=?"
					+ "DS_RISCO=?, VL_SALDO=?, ID_CONTA=? WHERE ID_PRODUTOS=?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, produtos.getdsTpProduto());
			stmt.setString(2, produtos.getdsRisco());
			stmt.setDouble(3, produtos.getvlSaldo());
			stmt.setInt(4, produtos.getidConta().getIdConta());
			stmt.setInt(5, produtos.getIdProdutos());
			
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
	public void remover(int idProdutos) throws DBException {
		PreparedStatement stmt = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "DELETE FROM T_PRODUTOS WHERE ID_PRODUTOS=?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, idProdutos);
			
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
	public Produtos buscar(int idProdutos) {
		Produtos produtos = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement(""
					+ "SELECT * FROM T_PRODUTOS "
					+ "INNER JOIN T_CONTA "
					+ "ON T_PRODUTO.ID_CONTA = T_CONTA.ID_CONTA "
					+ "WHERE T_PRODUTOS.ID_PRODUTOS=?");
			stmt.setInt(1, idProdutos);
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				int codigo = rs.getInt("ID_PRODUTOS");				
				String tpProdutos = rs.getString("DS_TP_PRODUTOS");
				String dsRisco = rs.getString("DS_RISCO");
				Double saldo = rs.getDouble("VL_SALDO");
				
				int codigoconta = rs.getInt("ID_CONTA");
				String nrAgencia = rs.getString("NR_AGENCIA");				
				String nrConta = rs.getString("NR_CONTA");
				String tpConta = rs.getString("NM_TP_CONTA");
				String banco = rs.getString("NM_BANCO");
				Double saldoconta = rs.getDouble("VL_SALDO");
								
				produtos = new Produtos (codigo, tpProdutos, dsRisco, saldo);
				Conta conta = new Conta (nrAgencia,codigoconta ,nrConta, tpConta, banco, saldoconta);
				
				produtos.setidConta(conta);				
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
		return produtos;
	}

	@Override
	public List<Produtos> listar() {
		List <Produtos> lista = new ArrayList <Produtos>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_PRODUTOS "
					+ "INNER JOIN T_CONTA "
					+ "ON T_PRODUTOS.ID_CONTA=T_CONTA.ID_CONTA");
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				int codigo = rs.getInt("ID_PRODUTOS");				
				String tpProdutos = rs.getString("DS_TP_PRODUTOS");
				String dsRisco = rs.getString("DS_RISCO");
				Double saldo = rs.getDouble("VL_SALDO");
				
				int codigoconta = rs.getInt("ID_CONTA");
				String nrAgencia = rs.getString("NR_AGENCIA");				
				String nrConta = rs.getString("NR_CONTA");
				String tpConta = rs.getString("NM_TP_CONTA");
				String banco = rs.getString("NM_BANCO");
				Double saldoconta = rs.getDouble("VL_SALDO");
				
				Produtos produtos = new Produtos (codigo, tpProdutos, dsRisco, saldo);
				Conta conta = new Conta (nrAgencia, codigoconta, nrConta, tpConta, banco, saldoconta);
				
				produtos.setidConta(conta);		

				lista.add(produtos);
				
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
