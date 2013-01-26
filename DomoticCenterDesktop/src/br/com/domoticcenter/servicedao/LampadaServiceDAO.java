package br.com.domoticcenter.servicedao;

import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;

import br.com.domoticcenter.entity.Lampada;
import br.com.domoticcenter.restservice.LampadaRestWebService;

public abstract class LampadaServiceDAO {
	public static List<Lampada> listaTodasAsLampadasComIpDomoticCenter(String ipDomoticCenter){		
		LampadaRestWebService lamapadaRestService = new LampadaRestWebService();
		 List<Lampada> returnListaLampadas = null;
		try {
			returnListaLampadas = lamapadaRestService.listaTodasAsLampadasComIpDomoticCenter(ipDomoticCenter);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnListaLampadas;
	}
	
	public static boolean cadastraLampada(Lampada amb){		
		LampadaRestWebService lamapadaRestService = new LampadaRestWebService();
		boolean cadastrouCorretamente = false;
		try {
			cadastrouCorretamente = lamapadaRestService.cadastraLampada(amb);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cadastrouCorretamente;
	}
	
	
	public static boolean updateLampada(Lampada amb){		
		LampadaRestWebService lamapadaRestService = new LampadaRestWebService();
		boolean updateLampadaOk = false;
		try {
			updateLampadaOk = lamapadaRestService.updateLampada(amb);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return updateLampadaOk;
	}
	
	public static boolean deletaLampada(Lampada amb){		
		LampadaRestWebService lamapadaRestService = new LampadaRestWebService();
		boolean deleteLampadaOK = false;
		try {
			deleteLampadaOK = lamapadaRestService.deletaLampada(amb);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return deleteLampadaOK;
	}
	
	public static Lampada buscaLampadaComID(String ID){		
		LampadaRestWebService lamapadaRestService = new LampadaRestWebService();
		 Lampada returnLampada = null;
		try {
			returnLampada = lamapadaRestService.buscaLampadaComID(ID);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnLampada;
	}
	

	public static List<Lampada> listaTodasAsLampadasComIpDomoticCenterEAmbienteID(String ipDomoticCenter, Integer ambienteID){		
		LampadaRestWebService lamapadaRestService = new LampadaRestWebService();
		 List<Lampada> returnListaLampadas = null;
		try {
			returnListaLampadas = lamapadaRestService.listaTodasAsLampadasComIpDomoticCenterEAmbienteID(ipDomoticCenter, ambienteID);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnListaLampadas;
	}
	
	

}
