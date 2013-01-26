package br.com.domoticcenter.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Ambiente implements Serializable {


	private Integer ambienteID;
	private String nome;
	private String ipDomoticCenter;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	@Override
	public String toString() {
		return nome;
	}

	public Integer getAmbienteID() {
		return ambienteID;
	}

	public void setAmbienteID(Integer ambienteID) {
		this.ambienteID = ambienteID;
	}

	public String getIpDomoticCenter() {
		return ipDomoticCenter;
	}

	public void setIpDomoticCenter(String ipDomoticCenter) {
		this.ipDomoticCenter = ipDomoticCenter;
	}
}
