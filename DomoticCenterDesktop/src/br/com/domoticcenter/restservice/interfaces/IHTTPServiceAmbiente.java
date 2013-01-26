package br.com.domoticcenter.restservice.interfaces;
import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;

import br.com.domoticcenter.entity.Ambiente;






public  interface IHTTPServiceAmbiente {

	public List<Ambiente> listaTodosOsAmbientesComIpDomoticCenter(String ipDomoticCenter) throws ClientProtocolException, IOException;
	public Ambiente buscaAmbienteComID(String idAmbiente) throws ClientProtocolException, IOException;
	public boolean updateAmbiente(Ambiente ambiente) throws ClientProtocolException, IOException;
	public boolean deletaAmbiente(Ambiente ambiente) throws ClientProtocolException, IOException;
	public boolean cadastraAmbiente(Ambiente ambiente) throws ClientProtocolException, IOException;
	
	
}
