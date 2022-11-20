package br.com.fintech.bean;

public class Tp_Conta {
	
	private int id_Tp_Conta;
	private String ds_Tp_Conta;

	public Tp_Conta () {
		super();
		}
	
	public Tp_Conta (int id_Tp_Conta, String ds_Tp_Conta) {
		super ();
		this.setId_Tp_Conta(id_Tp_Conta);
		this.setDs_Tp_Conta(ds_Tp_Conta);
			}

	public int getId_Tp_Conta() {
		return id_Tp_Conta;
	}

	public void setId_Tp_Conta(int id_Tp_Conta) {
		this.id_Tp_Conta = id_Tp_Conta;
	}

	public String getDs_Tp_Conta() {
		return ds_Tp_Conta;
	}

	public void setDs_Tp_Conta(String ds_Tp_Conta) {
		this.ds_Tp_Conta = ds_Tp_Conta;
	}
}