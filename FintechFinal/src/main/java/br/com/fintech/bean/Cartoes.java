package br.com.fintech.bean;

public class Cartoes {
	
	private int idCartoes;
	private String ds_tp_cartao;
	private String dsBandeira;
	private String ds_ult_digito;
	private String ds_sub_emissora;
	private double vlLimite;
	private Conta codigoConta;
		
	public Cartoes () {
		super();
		}
	
	public Cartoes (int idCartoes, String ds_tp_cartao, String dsBandeira, String ds_ult_digito, String ds_sub_emissora, double vlLimite) {
		super ();
		this.setDs_tp_cartao(ds_tp_cartao);
		this.setDsBandeira(dsBandeira);
		this.setDs_ult_digito(ds_ult_digito);
		this.setDs_sub_emissora(ds_sub_emissora);
		this.setVlLimite(vlLimite);
	}

	public int getIdCartoes() {
		return idCartoes;
	}

	public void setIdCartoes(int idCartoes) {
		this.idCartoes = idCartoes;
	}

	public String getDs_tp_cartao() {
		return ds_tp_cartao;
	}

	public void setDs_tp_cartao(String ds_tp_cartao) {
		this.ds_tp_cartao = ds_tp_cartao;
	}

	public String getDsBandeira() {
		return dsBandeira;
	}

	public void setDsBandeira(String dsBandeira) {
		this.dsBandeira = dsBandeira;
	}

	public String getDs_ult_digito() {
		return ds_ult_digito;
	}

	public void setDs_ult_digito(String ds_ult_digito) {
		this.ds_ult_digito = ds_ult_digito;
	}

	public String getDs_sub_emissora() {
		return ds_sub_emissora;
	}

	public void setDs_sub_emissora(String ds_sub_emissora) {
		this.ds_sub_emissora = ds_sub_emissora;
	}

	public double getVlLimite() {
		return vlLimite;
	}

	public void setVlLimite(double vlLimite) {
		this.vlLimite = vlLimite;
	}

	public Conta getCodigoConta() {
		return codigoConta;
	}

	public void setCodigoConta(Conta codigoConta) {
		this.codigoConta = codigoConta;
	}

	@Override
	public String toString() {
		return "Cartoes [idCartoes=" + idCartoes + ", ds_tp_cartao=" + ds_tp_cartao + ", dsBandeira=" + dsBandeira
				+ ", ds_ult_digito=" + ds_ult_digito + ", ds_sub_emissora=" + ds_sub_emissora + ", vlLimite=" + vlLimite
				+ "]";
	}

	
}
		
		


	

