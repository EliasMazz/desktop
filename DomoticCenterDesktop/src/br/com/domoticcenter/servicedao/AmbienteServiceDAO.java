package br.com.domoticcenter.servicedao;

import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;

import br.com.domoticcenter.entity.Ambiente;
import br.com.domoticcenter.restservice.AmbienteRestWebService;

public abstract class AmbienteServiceDAO {
	public static List<Ambiente> listaTodosOsAmbientesPorIpDomoticCenter(String ipDomoticCenter){		
		AmbienteRestWebService ambienteRestService = new AmbienteRestWebService();
		 List<Ambiente> returnListaAmbientes = null;
		try {
			returnListaAmbientes = ambienteRestService.listaTodosOsAmbientesComIpDomoticCenter(ipDomoticCenter);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnListaAmbientes;
	}
	
	public static boolean cadastraAmbiente(Ambiente amb){		
		AmbienteRestWebService ambienteRestService = new AmbienteRestWebService();
		boolean cadastrouCorretamente = false;
		try {
			cadastrouCorretamente = ambienteRestService.cadastraAmbiente(amb);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cadastrouCorretamente;
	}
	
	
	public static boolean updateAmbiente(Ambiente amb){		
		AmbienteRestWebService ambienteRestService = new AmbienteRestWebService();
		boolean updateAmbienteOk = false;
		try {
			updateAmbienteOk = ambienteRestService.updateAmbiente(amb);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return updateAmbienteOk;
	}
	
	public static boolean deletaAmbiente(Ambiente amb){		
		AmbienteRestWebService ambienteRestService = new AmbienteRestWebService();
		boolean deleteAmbienteOK = false;
		try {
			deleteAmbienteOK = ambienteRestService.deletaAmbiente(amb);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return deleteAmbienteOK;
	}
	
	public static Ambiente buscaAmbienteComID(String ID){		
		AmbienteRestWebService ambienteRestService = new AmbienteRestWebService();
		 Ambiente returnAmbiente = null;
		try {
			returnAmbiente = ambienteRestService.buscaAmbienteComID(ID);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnAmbiente;
	}

}
