package br.com.domoticcenter.entity;

import java.io.Serializable;


@SuppressWarnings("serial")
public class Lampada implements Serializable {


	private Integer lampadaID;
	private String nome;
	private Integer ambienteID;
	private String ipDomoticCenter;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getLampadaID() {
		return lampadaID;
	}

	public void setLampadaID(Integer lampadaID) {
		this.lampadaID = lampadaID;
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
