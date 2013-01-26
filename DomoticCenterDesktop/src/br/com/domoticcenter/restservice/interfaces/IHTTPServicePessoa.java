package br.com.domoticcenter.restservice.interfaces;
import br.com.domoticcenter.entity.ResidenciaCompleta;
import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;







public  interface IHTTPServicePessoa {

	public ResidenciaCompleta autenticaPessoaComLoginESenhaRetornaResidenciaCompleta(String login, String senha) throws ClientProtocolException, IOException;

}
