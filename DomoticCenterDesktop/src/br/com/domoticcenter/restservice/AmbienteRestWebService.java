package br.com.domoticcenter.restservice;

import br.com.domoticcenter.restservice.util.HttpAction;
import br.com.domoticcenter.restservice.util.RestUtils;
import java.io.IOException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.util.EntityUtils;


import br.com.domoticcenter.entity.Ambiente;
import br.com.domoticcenter.restservice.interfaces.IHTTPServiceAmbiente;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class AmbienteRestWebService extends HttpAction implements IHTTPServiceAmbiente  {
	private static final String  LISTA_TODOS_AMBIENTES_POR_IPDOMOTICCENTER = RestUtils.SERVERURL+"/rest/ambiente/lista/por/ipdomotic/";
	private static final String CADASTRA_AMBIENTE= RestUtils.SERVERURL+"/rest/ambiente/cadastra";
	private static final String UPDATE_NOME_AMBIENTE=  RestUtils.SERVERURL+"/rest/ambiente/update";
	private static final String DELETA_AMBIENTE=  RestUtils.SERVERURL+"/rest/ambiente/deleta";
	private static final String BUSCA_AMBIENTE_POR_ID=  RestUtils.SERVERURL+"/rest/ambiente/procura/por/id/";
	
    private Gson gson;
    private HttpEntity entity;


	public List<Ambiente> listaTodosOsAmbientesComIpDomoticCenter(String ipDomoticCenter) throws ClientProtocolException, IOException {
		entity = GET(LISTA_TODOS_AMBIENTES_POR_IPDOMOTICCENTER+ipDomoticCenter);
    	gson = new Gson();
     	List<Ambiente> ambientes = null;
        if (entity != null) {
           	 ambientes = gson.fromJson(EntityUtils.toString(entity), new TypeToken<List<Ambiente>>(){}.getType());
        }
		return ambientes;
	}
	
	
	public Ambiente buscaAmbienteComID(String idAmbiente)
			throws ClientProtocolException, IOException {
    	entity =  GET(BUSCA_AMBIENTE_POR_ID+idAmbiente); 
    	gson = new Gson();
     	Ambiente ambiente = null;
        if (entity != null) {
           	ambiente = gson.fromJson(EntityUtils.toString(entity), Ambiente.class);
        }
		return ambiente;
	}
	
	public boolean updateAmbiente(Ambiente ambiente)
			throws ClientProtocolException, IOException {
		return POST(UPDATE_NOME_AMBIENTE,ambiente);
	
	}
	public boolean deletaAmbiente(Ambiente ambiente)
			throws ClientProtocolException, IOException {
		return POST(DELETA_AMBIENTE,ambiente);
	}

	public boolean cadastraAmbiente(Ambiente ambiente)
			throws ClientProtocolException, IOException {
		return POST(CADASTRA_AMBIENTE,ambiente);
		
	}


}
