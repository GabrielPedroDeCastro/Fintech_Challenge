package br.com.fintech.bean;

import java.util.Calendar;

public class Acao {
	
	private int idAcao;
	private String dsAcao;
	private double vlAcao;
	private String nm_tp_acao;
	private String nm_tp_necessidade;
	private Calendar dtAcao;
	private Conta codigoConta;
	private T_Cat_Acao codigoCatAcao;
	
		
	public Acao () {
		super();
			}
		
	public Acao (int idAcao, String dsAcao, double vlAcao, String nm_tp_acao, String nm_tp_necessidade, Calendar dtAcao) {
		super ();
		this.setIdAcao(idAcao);
		this.setDsAcao(dsAcao);
		this.setVlAcao(vlAcao);
		this.setNm_tp_acao(nm_tp_acao);
		this.setNm_tp_necessidade(nm_tp_necessidade);
		this.setDtAcao(dtAcao);
		
		}

	public int getIdAcao() {
		return idAcao;
	}

	public void setIdAcao(int idAcao) {
		this.idAcao = idAcao;
	}

	public String getDsAcao() {
		return dsAcao;
	}

	public void setDsAcao(String dsAcao) {
		this.dsAcao = dsAcao;
	}

	public double getVlAcao() {
		return vlAcao;
	}

	public void setVlAcao(double vlAcao) {
		this.vlAcao = vlAcao;
	}

	public String getNm_tp_acao() {
		return nm_tp_acao;
	}

	public void setNm_tp_acao(String nm_tp_acao) {
		this.nm_tp_acao = nm_tp_acao;
	}

	public String getNm_tp_necessidade() {
		return nm_tp_necessidade;
	}

	public void setNm_tp_necessidade(String nm_tp_necessidade) {
		this.nm_tp_necessidade = nm_tp_necessidade;
	}

	public Calendar getDtAcao() {
		return dtAcao;
	}

	public void setDtAcao(Calendar dtAcao) {
		this.dtAcao = dtAcao;
	}

	public T_Cat_Acao getCodigoCatAcao() {
		return codigoCatAcao;
	}

	public void setCodigoCatAcao(T_Cat_Acao codigoCatAcao) {
		this.codigoCatAcao = codigoCatAcao;
	}

	public Conta getCodigoConta() {
		return codigoConta;
	}

	public void setCodigoConta(Conta codigoConta) {
		this.codigoConta = codigoConta;
	}
	
}
