package br.com.domoticcenter.restservice.interfaces;
import java.io.IOException;
import java.util.List;
import org.apache.http.client.ClientProtocolException;
import br.com.domoticcenter.entity.Agendamento;






public  interface IHTTPServiceAgendamento {

	public List<Agendamento> listaTodosAgendamentosPorIPDomotic(String ipDomoticCenter) throws ClientProtocolException, IOException;
	
	public  List<Agendamento> listaTodosOsAgendamentosPorIPDomoticEtipoObjeto(String ipDomoticCenter, Integer tipoObjeto) throws ClientProtocolException, IOException;
	
	public Agendamento buscaAgendamentoPorID(String agendamentoID) throws ClientProtocolException, IOException;
	
	public boolean updateAgendamento(Agendamento agendamento) throws ClientProtocolException, IOException;
	
	public boolean updateNomeAgendamento(Agendamento agendamento) throws ClientProtocolException, IOException;
	
	public boolean updateAtivaDesativaAgendamento(Agendamento agendamento) throws ClientProtocolException, IOException;
	
	public boolean deletaAgendamento(Agendamento agendamento) throws ClientProtocolException, IOException;
	
	public boolean cadastraAgendamento(Agendamento agendamento) throws ClientProtocolException, IOException;
	
	
	
	
}
