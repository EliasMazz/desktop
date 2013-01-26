package br.com.domoticcenter.restservice.interfaces;
import br.com.domoticcenter.entity.ResidenciaCompleta;
import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;






public  interface IHTTPServiceResidencia {

	public boolean verificaSeExisteNoServidorResidenciaComIpDomoticCenter(String ipDomoticCenter) throws ClientProtocolException, IOException;
	public List<ResidenciaCompleta> buscaTodosOsObjetosDaResidencia(String ipDomoticCenter) throws ClientProtocolException, IOException;
	
}
