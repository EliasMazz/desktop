package br.com.domoticcenter.restservice;

import java.io.IOException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import br.com.domoticcenter.entity.ResidenciaCompleta;
import br.com.domoticcenter.restservice.interfaces.IHTTPServiceResidencia;
import br.com.domoticcenter.restservice.util.HttpAction;
import br.com.domoticcenter.restservice.util.RestUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ResidenciaRestWebService extends HttpAction implements IHTTPServiceResidencia {
	private static final String  PROCURA_RESIDENCIA_POR_IPDOMOTICCENTER =  RestUtils.SERVERURL+"/rest/residencia/procura/por/ipdomotic/";
	private static final String  BUSCA_TODOS_OBJETOS_DA_RESIDENCIA_COM_IPDOMOTIC =  RestUtils.SERVERURL+"/rest/residencia/lista/";
	
	
	private DefaultHttpClient httpClient;
	private HttpResponse httpResponse;
	private HttpGet httpGet;
    private HttpEntity entity;
    private Gson gson;
	

	public boolean verificaSeExisteNoServidorResidenciaComIpDomoticCenter(String ipDomoticCenter) throws ClientProtocolException, IOException  {
		          System.out.println( "Procurando residencia com IP DomoticCenter "+ipDomoticCenter );
		httpClient = new DefaultHttpClient();
		httpGet = new HttpGet(PROCURA_RESIDENCIA_POR_IPDOMOTICCENTER+ipDomoticCenter);
	    httpResponse = httpClient.execute(httpGet);
	    Integer  responseCode = httpResponse.getStatusLine().getStatusCode();
		          System.out.println("Resposta "+responseCode);
		return responseCode.equals(RestUtils.httpCodeOk);
     
	}

	public List<ResidenciaCompleta> buscaTodosOsObjetosDaResidencia(
		String ipDomoticCenter) throws ClientProtocolException, IOException {
    	entity =  GET(BUSCA_TODOS_OBJETOS_DA_RESIDENCIA_COM_IPDOMOTIC+ipDomoticCenter);
    	gson = new Gson();
     	List<ResidenciaCompleta> residenciaComTodosObjetos = null;
        if (entity != null) {
           	residenciaComTodosObjetos = gson.fromJson(EntityUtils.toString(entity), new TypeToken<List<ResidenciaCompleta>>(){}.getType());
        }
		return residenciaComTodosObjetos;
	}

}
