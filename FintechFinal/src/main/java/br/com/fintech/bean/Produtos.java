package br.com.fintech.bean;

public class Produtos {
	
	private int idProdutos;
	private String dsTpProduto;
	private String dsRisco;
	private double vlSaldo;
	private Conta idConta;
		
	public Produtos () {
		super();
		}


	public Produtos (int idProdutos, String dsTpProduto, String dsRisco, double vlSaldo) {
	super ();
	this.idProdutos = idProdutos;
	this.dsTpProduto = dsTpProduto;
	this.dsRisco = dsRisco;
	this.vlSaldo = vlSaldo;
		}
		
	public int getIdProdutos() {
		return idProdutos;
		}
		
	public void setIdProdutos (int idProdutos) {
		this.idProdutos = idProdutos;
		}
		
	public String getdsTpProduto() {
		return dsTpProduto;
		}
		
	public void setdsTpProduto (String dsTpProduto) {
		this.dsTpProduto = dsTpProduto;
		}
		
	public String getdsRisco() {
		return dsRisco;
		}
		
	public void setdsRisco (String dsRisco) {
		this.dsRisco = dsRisco;
		}
		
	public double getvlSaldo() {
		return vlSaldo;
		}
		
	public void setvlSaldo (double vlSaldo) {
		this.vlSaldo = vlSaldo;
		}
		
	public Conta getidConta() {
		return idConta;
		}
		
	public void setidConta (Conta idConta) {
		this.idConta = idConta;
		}


	@Override
	public String toString() {
		return "Produtos [idProdutos=" + idProdutos + ", dsTpProduto=" + dsTpProduto + ", dsRisco=" + dsRisco
				+ ", vlSaldo=" + vlSaldo + "]";
	}
		


}

