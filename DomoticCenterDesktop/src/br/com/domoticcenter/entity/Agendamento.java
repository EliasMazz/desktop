package br.com.domoticcenter.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Agendamento implements Serializable {

	private Integer agendamentoID;
	
	private Integer ambienteID;
	
	private String ipDomoticCenter;
	
	private Integer hora;
	
	private Integer minuto;
	
	private String nome;
	
	private String diasNaSemana;
	
	private Integer tipoObjeto;
	
	private boolean ativo;
	
	private boolean estadoObjeto;
	
        private Integer posicaoObjAmbiente;
        
        private Integer posicaoAmbiente;

        
        
    public Integer getPosicaoObjAmbiente() {
        return posicaoObjAmbiente;
    }

    public void setPosicaoObjAmbiente(Integer posicaoObjAmbiente) {
        this.posicaoObjAmbiente = posicaoObjAmbiente;
    }

    public Integer getPosicaoAmbiente() {
        return posicaoAmbiente;
    }

    public void setPosicaoAmbiente(Integer posicaoAmbiente) {
        this.posicaoAmbiente = posicaoAmbiente;
    }
        

 

    public void setPosicaoObjAmbiente(int posicaoObjAmbiente) {
        this.posicaoObjAmbiente = posicaoObjAmbiente;
    }

  
        
	public Integer getAgendamentoID() {
		return agendamentoID;
	}

	public void setAgendamentoID(Integer agendamentoID) {
		this.agendamentoID = agendamentoID;
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

	public Integer getHora() {
		return hora;
	}

	public void setHora(Integer hora) {
		this.hora = hora;
	}

	public Integer getMinuto() {
		return minuto;
	}

	public void setMinuto(Integer minuto) {
		this.minuto = minuto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDiasNaSemana() {
		return diasNaSemana;
	}

	public void setDiasNaSemana(String diasNaSemana) {
		this.diasNaSemana = diasNaSemana;
	}

	public Integer getTipoObjeto() {
		return tipoObjeto;
	}

	public void setTipoObjeto(Integer tipoObjeto) {
		this.tipoObjeto = tipoObjeto;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public boolean isEstadoObjeto() {
		return estadoObjeto;
	}

	public void setEstadoObjeto(boolean estadoObjeto) {
		this.estadoObjeto = estadoObjeto;
	}


}
