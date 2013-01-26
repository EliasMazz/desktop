package br.com.domoticcenter.servicedao;

import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;

import br.com.domoticcenter.entity.ResidenciaCompleta;
import br.com.domoticcenter.restservice.ResidenciaRestWebService;

public class ResidenciaServiceDAO {
	public static boolean verificaSeExisteNoServidorResidenciaComIpDomoticCenter(String ipDomoticCenter) throws ClientProtocolException, IOException  {
		ResidenciaRestWebService residenciaWebService = new ResidenciaRestWebService();
		return  residenciaWebService.verificaSeExisteNoServidorResidenciaComIpDomoticCenter(ipDomoticCenter);
		
	}
	
	
	public static List<ResidenciaCompleta> buscaTodosOsObjetosDaResidencia(String ipDomoticCenter) throws ClientProtocolException, IOException {
		ResidenciaRestWebService residenciaWebService = new ResidenciaRestWebService();
		return residenciaWebService.buscaTodosOsObjetosDaResidencia(ipDomoticCenter);
	}
}
