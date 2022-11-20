package br.com.fintech.bean;

public class Conta {
	
	private String nrAgencia;
	private int idConta;
	private String nrConta;
	private String nm_tp_conta;
	private String nmBanco;
	private double vlSaldo;
	private Usuario codigoUsuario;
	
	public Conta () {
		super();
		}
	
	public Conta (String nrAgencia, int idConta,String nrConta, String nm_tp_conta, String nmBanco, double vlSaldo) {
		super ();
		this.setIdConta(idConta);
		this.setNrAgencia(nrAgencia);
		this.setNrConta(nrConta);
		this.setNm_tp_conta(nm_tp_conta);
		this.setnmBanco(nmBanco);		
		this.setVlSaldo(vlSaldo);
			}

	public int getIdConta() {
		return idConta;
	}

	public void setIdConta(int idConta) {
		this.idConta = idConta;
	}

	public String getNrAgencia() {
		return nrAgencia;
	}

	public void setNrAgencia(String nrAgencia) {
		this.nrAgencia = nrAgencia;
	}

	public String getNrConta() {
		return nrConta;
	}

	public void setNrConta(String nrConta) {
		this.nrConta = nrConta;
	}

	public String getNm_tp_conta() {
		return nm_tp_conta;
	}

	public void setNm_tp_conta(String nm_tp_conta) {
		this.nm_tp_conta = nm_tp_conta;
	}

	public String getnmBanco() {
		return nmBanco;
	}

	public void setnmBanco(String nmBanco) {
		this.nmBanco = nmBanco;
	}

	public double getVlSaldo() {
		return vlSaldo;
	}

	public void setVlSaldo(double vlSaldo) {
		this.vlSaldo = vlSaldo;
	}

	public Usuario getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(Usuario codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	@Override
	public String toString() {
		return "Conta [nrAgencia=" + nrAgencia + ", idConta=" + idConta + ", nrConta=" + nrConta + ", nm_tp_conta="
				+ nm_tp_conta + ", nmBanco=" + nmBanco + ", vlSaldo=" + vlSaldo + "]";
	}
	

}
