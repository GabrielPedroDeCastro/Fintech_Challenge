package br.com.fintech.bean;

public class T_Cat_Acao {
	
	private int id_Cat_Acao;
	private String nmCategoria;
	
	public T_Cat_Acao () {
		super();
		}
	
	public T_Cat_Acao (int id_Cat_Acao, String nmCategoria) {
		super ();
		this.setId_Cat_Acao(id_Cat_Acao);
		this.setNmCategoria(nmCategoria);
			}

	public int getId_Cat_Acao() {
		return id_Cat_Acao;
	}

	public void setId_Cat_Acao(int id_Cat_Acao) {
		this.id_Cat_Acao = id_Cat_Acao;
	}

	public String getNmCategoria() {
		return nmCategoria;
	}

	public void setNmCategoria(String nmCategoria) {
		this.nmCategoria = nmCategoria;
	}

	@Override
	public String toString() {
		return "T_Cat_Acao [id_Cat_Acao=" + id_Cat_Acao + ", nmCategoria=" + nmCategoria + "]";
	}
	
}
