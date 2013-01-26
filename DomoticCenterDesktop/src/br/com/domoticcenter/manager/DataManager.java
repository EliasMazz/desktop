package br.com.domoticcenter.manager;

import java.util.List;
import java.util.Map;

public interface DataManager {

	public String write(Map<String, String> data) throws Exception;
	
	public List<String> read(String data) throws Exception;
	
}
