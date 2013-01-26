package br.com.domoticcenter.entity;



import java.io.Serializable;



public class Residencia implements Serializable {
	
	private static final long serialVersionUID = 5121263954115489073L;


	private Integer residenciaID;
	private String ipDomoticCenter;

	
	
	public Integer getResidenciaID() {
		return residenciaID;
	}




	public void setResidenciaID(Integer residenciaID) {
		this.residenciaID = residenciaID;
	}




	public String getipDomoticCenter() {
		return ipDomoticCenter;
	}




	public void setipDomoticCenter(String ipDomoticCenter) {
		this.ipDomoticCenter = ipDomoticCenter;
	} 

}
