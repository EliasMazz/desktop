package br.com.domoticcenter.restservice;

import br.com.domoticcenter.restservice.util.HttpAction;
import br.com.domoticcenter.restservice.util.RestUtils;
import java.io.IOException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.util.EntityUtils;

import br.com.domoticcenter.entity.Lampada;
import br.com.domoticcenter.restservice.interfaces.IHTTPServiceLampada;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class LampadaRestWebService extends HttpAction implements IHTTPServiceLampada {
	private static final String  LISTA_TODAS_LAMPADAS_POR_IPDOMOTICCENTER =  RestUtils.SERVERURL+"/rest/lampada/lista/por/ipdomotic/";
	private static final String CADASTRA_LAMPADA=  RestUtils.SERVERURL+"/rest/lampada/cadastra";
	private static final String UPDATE_NOME_LAMPADA=  RestUtils.SERVERURL+"/rest/lampada/update";
	private static final String DELETA_LAMPADA=  RestUtils.SERVERURL+"/rest/lampada/deleta";
	private static final String BUSCA_LAMPADA_POR_ID=  RestUtils.SERVERURL+"/rest/lampada/procura/por/id/";
	private static final String BUSCA_LAMPADA_POR_IPDOMOTICCENTER_E_AMBIENTEID=  RestUtils.SERVERURL+"/rest/lampada/lista/por/ipdomotic/";
	
    private Gson gson;
    private HttpEntity entity;
 
    
	public List<Lampada> listaTodasAsLampadasComIpDomoticCenter(String ipDomoticCenter) throws ClientProtocolException, IOException {
    	entity = GET(LISTA_TODAS_LAMPADAS_POR_IPDOMOTICCENTER+ipDomoticCenter);
    	gson = new Gson();
     	List<Lampada> lampadas = null;
        if (entity != null) {
           	 lampadas = gson.fromJson(EntityUtils.toString(entity), new TypeToken<List<Lampada>>(){}.getType());
        }
		return lampadas;
	}
	
	public Lampada buscaLampadaComID(String idLampada)
			throws ClientProtocolException, IOException {
    	entity = GET(BUSCA_LAMPADA_POR_ID+idLampada);
    	gson = new Gson();
     	Lampada lampada = null;
        if (entity != null) {
           	lampada = gson.fromJson(EntityUtils.toString(entity), Lampada.class);
        }
		return lampada;
	}
	
	public boolean updateLampada(Lampada lampada)
			throws ClientProtocolException, IOException {
		return POST(UPDATE_NOME_LAMPADA, lampada);
		
	}
	
	public boolean deletaLampada(Lampada lampada)
			throws ClientProtocolException, IOException {
		return POST(DELETA_LAMPADA, lampada);
	}

	public boolean cadastraLampada(Lampada lampada)
			throws ClientProtocolException, IOException {
		return POST(CADASTRA_LAMPADA, lampada);
		
	}

	public List<Lampada>listaTodasAsLampadasComIpDomoticCenterEAmbienteID(
			String ipDomoticCenter, Integer ambienteID)
			throws ClientProtocolException, IOException {
    	entity = GET(BUSCA_LAMPADA_POR_IPDOMOTICCENTER_E_AMBIENTEID+ipDomoticCenter+"/idambiente/"+ambienteID);
    	gson = new Gson();
    	List<Lampada> lampadas = null;
        if (entity != null) {
           	 lampadas = gson.fromJson(EntityUtils.toString(entity), new TypeToken<List<Lampada>>(){}.getType());
        }
		return lampadas;

	}

}
