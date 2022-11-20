package br.com.fintech.teste;

import br.com.fintech.bean.Conta;
import br.com.fintech.dao.ContaDAO;
import br.com.fintech.exception.DBException;
import br.com.fintech.factory.DAOFactory;

import java.util.List;

public class TesteContaDAO {

	public static void main(String[] args) {
		ContaDAO dao = DAOFactory.getContaDAO();
		
		//cadastro conta
		Conta conta = new Conta ( "1234", 0, "456789", "teste", "Santander", 25874.98);
		try {
			dao.cadastrar(conta);
			System.out.println("Conta Cadastrada.");
		} catch (DBException e) {
			e.printStackTrace();
			System.out.println("erro catch");
		}
		
		//buscar uma conta e atualizar
		conta = dao.buscar(17);
		conta.setnmBanco("Itau");
		conta.setVlSaldo(50000);
		try {
			dao.atualizar(conta);
			System.out.println("Conta atualizada");
		} catch (DBException e){
			e.printStackTrace();
		}
		
		//listar as contas
		List<Conta> lista = dao.listar();
		for (Conta item:lista) {
			System.out.println(item.getIdConta() + " " + item.getNrAgencia() + " " + item.getnmBanco() + " " + item.getVlSaldo());
		}
		
		//remover uma conta
		try {
			dao.remover(13);
			System.out.println("Conta Removida");
		} catch (DBException e) {
			e.printStackTrace();
		}
	}
	
}