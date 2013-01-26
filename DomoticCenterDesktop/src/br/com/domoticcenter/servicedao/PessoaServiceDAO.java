package br.com.domoticcenter.servicedao;

import java.io.IOException;
import org.apache.http.client.ClientProtocolException;

import br.com.domoticcenter.entity.ResidenciaCompleta;
import br.com.domoticcenter.restservice.PessoaRestWebService;


public class PessoaServiceDAO {
	public static ResidenciaCompleta autenticaPessoaNoServidor(String login , String senha) throws ClientProtocolException, IOException  {
		PessoaRestWebService pessoaWebService = new PessoaRestWebService();
		return  pessoaWebService.autenticaPessoaComLoginESenhaRetornaResidenciaCompleta(login, senha);
	}
	
}
