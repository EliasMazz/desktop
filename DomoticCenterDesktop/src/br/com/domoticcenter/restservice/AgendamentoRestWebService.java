package br.com.domoticcenter.restservice;

import br.com.domoticcenter.restservice.util.HttpAction;
import br.com.domoticcenter.restservice.util.RestUtils;
import java.io.IOException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.util.EntityUtils;
import br.com.domoticcenter.entity.Agendamento;
import br.com.domoticcenter.restservice.interfaces.IHTTPServiceAgendamento;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class AgendamentoRestWebService extends HttpAction implements IHTTPServiceAgendamento {
	private static final String  LISTA_TODOS_AGENDAMENTOS_POR_IPDOMOTICCENTER = RestUtils.SERVERURL+"/rest/agendamento/lista/por/ipdomotic/";
	private static final String BUSCA_AGENDAMENTO_POR_ID=  RestUtils.SERVERURL+"/rest/agendamento/procura/por/id/";
	private static final String CADASTRA_AGENDAMENTO= RestUtils.SERVERURL+"/rest/agendamento/cadastra";
	private static final String UPDATE_AGENDAMENTO=  RestUtils.SERVERURL+"/rest/agendamento/update";
	private static final String UPDATE_NOME_AGENDAMENTO=  RestUtils.SERVERURL+"/rest/agendamento/update/nome";
	private static final String UPDATE_ATIVO_AGENDAMENTO=  RestUtils.SERVERURL+"/rest/agendamento/update/ativo";
	private static final String DELETA_AGENDAMENTO=  RestUtils.SERVERURL+"/rest/agendamento/deleta";
	
    private Gson gson;
    private HttpEntity entity;
   
	
    
    public List<Agendamento> listaTodosAgendamentosPorIPDomotic(String ipDomoticCenter)
			throws ClientProtocolException, IOException {
    	entity = GET(LISTA_TODOS_AGENDAMENTOS_POR_IPDOMOTICCENTER+ipDomoticCenter);
    	gson = new Gson();
     	List<Agendamento> agendamento = null;
        if (entity != null) {
           	agendamento = gson.fromJson(EntityUtils.toString(entity), new TypeToken<List<Agendamento>>(){}.getType());
        }
		return agendamento;
	}
	public List<Agendamento> listaTodosOsAgendamentosPorIPDomoticEtipoObjeto(
			String ipDomoticCenter, Integer tipoObjeto)
			throws ClientProtocolException, IOException {
    	entity =GET(LISTA_TODOS_AGENDAMENTOS_POR_IPDOMOTICCENTER+ipDomoticCenter+"/tipoobjeto/"+tipoObjeto);
    	gson = new Gson();
     	List<Agendamento> agendamento = null;
        if (entity != null) {
           	agendamento = gson.fromJson(EntityUtils.toString(entity), new TypeToken<List<Agendamento>>(){}.getType());
        }
		return agendamento;
	}
	public Agendamento buscaAgendamentoPorID(String agendamentoID)
			throws ClientProtocolException, IOException {
    	entity =GET(BUSCA_AGENDAMENTO_POR_ID+agendamentoID);
    	gson = new Gson();
     	Agendamento agendamento = null;
        if (entity != null) {
           	agendamento = gson.fromJson(EntityUtils.toString(entity), Agendamento.class);
        }
		return agendamento;
	}
	public boolean updateAgendamento(Agendamento agendamento)
			throws ClientProtocolException, IOException {
		return POST(UPDATE_AGENDAMENTO,agendamento);
	}
	public boolean updateNomeAgendamento(Agendamento agendamento)
			throws ClientProtocolException, IOException {
		return POST(UPDATE_NOME_AGENDAMENTO,agendamento);
	
	}
	public boolean updateAtivaDesativaAgendamento(Agendamento agendamento)
			throws ClientProtocolException, IOException {
		return POST(UPDATE_ATIVO_AGENDAMENTO,agendamento);
	}
	public boolean deletaAgendamento(Agendamento agendamento)
			throws ClientProtocolException, IOException {
		return POST(DELETA_AGENDAMENTO,agendamento);
	}
	public boolean cadastraAgendamento(Agendamento agendamento)
			throws ClientProtocolException, IOException {
		return POST(CADASTRA_AGENDAMENTO,agendamento);
		
	}
    
	

}
