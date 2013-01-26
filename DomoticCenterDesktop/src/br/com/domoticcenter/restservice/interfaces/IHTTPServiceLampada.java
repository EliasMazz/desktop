package br.com.domoticcenter.restservice.interfaces;
import java.io.IOException;
import java.util.List;
import org.apache.http.client.ClientProtocolException;
import br.com.domoticcenter.entity.Lampada;






public  interface IHTTPServiceLampada {

	public List<Lampada> listaTodasAsLampadasComIpDomoticCenter(String ipDomoticCenter) throws ClientProtocolException, IOException;
	public Lampada buscaLampadaComID(String idLampada) throws ClientProtocolException, IOException;
	public boolean updateLampada(Lampada lampada) throws ClientProtocolException, IOException;
	public boolean deletaLampada(Lampada lampada) throws ClientProtocolException, IOException;
	public boolean cadastraLampada(Lampada lampada) throws ClientProtocolException, IOException;
	public List<Lampada> listaTodasAsLampadasComIpDomoticCenterEAmbienteID(String ipDomoticCenter, Integer ambienteID) throws ClientProtocolException, IOException;
	
	
	
}
