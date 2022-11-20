package br.com.fintech.bean;

import br.com.fintech.util.CriptografiaUtils;

public class Usuario {
	
	private int id_User;
	private String nm_User;
	private String email;
	private String senha;
	
	public Usuario() {
		super();
	}

	public Usuario(int id_User, String nm_User, String email, String senha) {
		super();
		this.id_User = id_User;
		this.nm_User = nm_User;
		this.email = email;
		setSenha(senha);
	}

	public int getId_User() {
		return id_User;
	}

	public void setId_User(int id_User) {
		this.id_User = id_User;
	}

	public String getNm_User() {
		return nm_User;
	}

	public void setNm_User(String nm_User) {
		this.nm_User = nm_User;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		try{
			this.senha =
					CriptografiaUtils.criptografar(senha);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
