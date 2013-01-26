package br.com.domoticcenter.servicedao;

import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;

import br.com.domoticcenter.entity.Agendamento;
import br.com.domoticcenter.restservice.AgendamentoRestWebService;

public abstract class AgendamentoServiceDAO {
	public static List<Agendamento> listaTodosAgendamentosPorIPDomotic(String ipDomoticCenter){		
		AgendamentoRestWebService agendamentoRestService = new AgendamentoRestWebService();
		 List<Agendamento> returnListaAgendamentos = null;
		try {
			returnListaAgendamentos = agendamentoRestService.listaTodosAgendamentosPorIPDomotic(ipDomoticCenter);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnListaAgendamentos;
	}
	
	public static List<Agendamento> listaTodosAgendamentosPorIPDomoticEtipoObjeto(String ipDomoticCenter, Integer tipoObjeto){		
		AgendamentoRestWebService agendamentoRestService = new AgendamentoRestWebService();
		 List<Agendamento> returnListaAgendamentos = null;
		try {
			returnListaAgendamentos = agendamentoRestService.listaTodosOsAgendamentosPorIPDomoticEtipoObjeto(ipDomoticCenter, tipoObjeto);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnListaAgendamentos;
	}
	
	public static boolean cadastraAgendamento(Agendamento agend){		
		AgendamentoRestWebService agendamentoRestService = new AgendamentoRestWebService();
		boolean cadastrouCorretamente = false;
		try {
			cadastrouCorretamente = agendamentoRestService.cadastraAgendamento(agend);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cadastrouCorretamente;
	}
	
	
	public static boolean updateAgendamento(Agendamento agend){		
		AgendamentoRestWebService agendamentoRestService = new AgendamentoRestWebService();
		boolean updateAgendamentoOk = false;
		try {
			updateAgendamentoOk = agendamentoRestService.updateAgendamento(agend);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return updateAgendamentoOk;
	}
	
	public static boolean updateNomeAgendamento(Agendamento agend){		
		AgendamentoRestWebService agendamentoRestService = new AgendamentoRestWebService();
		boolean updateAgendamentoOk = false;
		try {
			updateAgendamentoOk = agendamentoRestService.updateNomeAgendamento(agend);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return updateAgendamentoOk;
	}
	
	public static boolean updateAtivoDesativoAgendamento(Agendamento agend){		
		AgendamentoRestWebService agendamentoRestService = new AgendamentoRestWebService();
		boolean updateAgendamentoOk = false;
		try {
			updateAgendamentoOk = agendamentoRestService.updateAtivaDesativaAgendamento(agend);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return updateAgendamentoOk;
	}
	
	public static boolean deletaAgendamento(Agendamento agend){		
		AgendamentoRestWebService agendamentoRestService = new AgendamentoRestWebService();
		boolean deleteAgendamentoOK = false;
		try {
			deleteAgendamentoOK = agendamentoRestService.deletaAgendamento(agend);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return deleteAgendamentoOK;
	}
	
	public static Agendamento buscaAgendamentoComID(String ID){		
		AgendamentoRestWebService agendamentoRestService = new AgendamentoRestWebService();
		 Agendamento returnAgendamento = null;
		try {
			returnAgendamento = agendamentoRestService.buscaAgendamentoPorID(ID);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnAgendamento;
	}

}
