package br.com.domoticcenter.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Pessoa implements Serializable {


	private Integer pessoaID;
	private String ipDomoticCenter;
	private String nome;
	private String login;
	private String senha;
	private boolean Ativo;
	
	
	public Integer getPessoaID() {
		return pessoaID;
	}
	public void setPessoaID(Integer pessoaID) {
		this.pessoaID = pessoaID;
	}
	public String getipDomoticCenter() {
		return ipDomoticCenter;
	}
	public void setipDomoticCenter(String ipDomoticCenter) {
		this.ipDomoticCenter = ipDomoticCenter;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public boolean isAtivo() {
		return Ativo;
	}
	public void setAtivo(boolean ativo) {
		Ativo = ativo;
	}
	

}
