package br.com.domoticcenter.restservice.util;
import br.com.domoticcenter.entity.ResidenciaCompleta;


public class ResidenciaCompletaMemory {
	
	
	public static ResidenciaCompleta residenciaCompleta;
	public static String ipDomoticCenter;
	
	public static String getIpDomoticCenter() {
		return ipDomoticCenter;
	}
	
	
	public static void setIpDomoticCenter(String ipDomoticCenter) {
		ResidenciaCompletaMemory.ipDomoticCenter = ipDomoticCenter;
	}

	public static ResidenciaCompleta getResidenciaCompleta() {
		return residenciaCompleta;
	}
	

	public static void setResidenciaCompleta(ResidenciaCompleta residenciaCompleta) {
		ResidenciaCompletaMemory.residenciaCompleta = residenciaCompleta;
	}

}
