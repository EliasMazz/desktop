package br.com.domoticcenter.restservice;

import br.com.domoticcenter.restservice.util.HttpAction;
import br.com.domoticcenter.restservice.util.RestUtils;
import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.util.EntityUtils;

import br.com.domoticcenter.entity.ResidenciaCompleta;
import br.com.domoticcenter.restservice.interfaces.IHTTPServicePessoa;
import com.google.gson.Gson;


public class PessoaRestWebService extends HttpAction implements IHTTPServicePessoa {
		private static final String  AUTENTICA_PESSOA_COM_LOGIN_SENHA =  RestUtils.SERVERURL+"/rest/pessoa/autentica/por/login/";
	    private HttpEntity entity;
	    private Gson gson;
	
    public ResidenciaCompleta autenticaPessoaComLoginESenhaRetornaResidenciaCompleta(String login, String senha)
			throws ClientProtocolException, IOException {
    		entity = GET(AUTENTICA_PESSOA_COM_LOGIN_SENHA+login+"/senha/"+senha);
    		gson = new Gson();
         	ResidenciaCompleta residenciaCompleta = null;
            if (entity == null) 
            	return null;
            residenciaCompleta = gson.fromJson(EntityUtils.toString(entity), ResidenciaCompleta.class);
            
    		return residenciaCompleta;
    
	}

}
