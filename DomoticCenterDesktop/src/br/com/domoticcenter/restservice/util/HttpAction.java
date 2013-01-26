package br.com.domoticcenter.restservice.util;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import com.google.gson.Gson;

public class HttpAction {
	//private DefaultHttpClient httpClient;
	private HttpResponse httpResponse;
	private HttpGet httpGet;
    private Gson gson;
    private HttpPost postRequest;
    private StringEntity input; 
    private HttpResponse response;
    
	public boolean POST(String url,Object objeto) throws ClientProtocolException, IOException{
		DefaultHttpClient httpClient = new DefaultHttpClient();
		postRequest = new HttpPost(url);
		gson = new Gson();
	    input = new StringEntity(gson.toJson(objeto));
		input.setContentType("application/json");
		postRequest.setEntity(input);
		response = httpClient.execute(postRequest);
		Integer responseCode = response.getStatusLine().getStatusCode();
		return responseCode.equals(RestUtils.httpCodeOk);
       
	}
	
	public HttpEntity GET(String url) throws ClientProtocolException, IOException{
		 DefaultHttpClient  httpClient = new DefaultHttpClient();
		httpGet = new HttpGet(url);
		httpResponse = httpClient.execute(httpGet);
     	return httpResponse.getEntity();
       
	}
}
