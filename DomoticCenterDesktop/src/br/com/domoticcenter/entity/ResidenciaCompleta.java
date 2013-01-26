package br.com.domoticcenter.entity;
import java.util.List;



public class ResidenciaCompleta {
	
	private String ipDomoticCenter;
	private List<Ambiente> ambientes;
	private List<Lampada> lampadas;
	private List<Agendamento> agendamentos;
	
	
	public String getIpDomoticCenter() {
		return ipDomoticCenter;
	}
	public void setIpDomoticCenter(String ipDomoticCenter) {
		this.ipDomoticCenter = ipDomoticCenter;
	}
	public List<Ambiente> getAmbientes() {
		return ambientes;
	}
	public void setAmbientes(List<Ambiente> ambientes) {
		this.ambientes = ambientes;
	}
	public List<Lampada> getLampadas() {
		return lampadas;
	}
	public void setLampadas(List<Lampada> lampadas) {
		this.lampadas = lampadas;
	}
	public List<Agendamento> getAgendamentos() {
		return agendamentos;
	}
	public void setAgendamentos(List<Agendamento> agendamentos) {
		this.agendamentos = agendamentos;
	} 

}
