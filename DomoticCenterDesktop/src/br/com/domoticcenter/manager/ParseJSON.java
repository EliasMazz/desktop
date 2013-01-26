package br.com.domoticcenter.manager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.json.JSONException;
import org.json.JSONObject;

public class ParseJSON {

	private static final String LOG_TAG = "parse";

	public ParseJSON() {
	}

	public  JSONObject  doRequestToArduino(String url) {

		JSONObject jsonChannels = getHttpJson(url);
		
		System.out.println("Classe Parse JSON" + jsonChannels);
		try {

			String status = jsonChannels.optString("status");
			String out = jsonChannels.optString("out");
		

			if (status.length() > 0) {
				                        System.out.println("Classe Parse JSON status " + status);
				                        System.out.println("Classe Parse JSON out" + out);
				return jsonChannels;
			} 

		} catch (Exception e) {
                    System.out.println("doRequestToArduino ERRO");
	
		}

		
		return null;

	}

	public  JSONObject getHttpJson(String url) {
		JSONObject json = null;
		String result = getHttp(url);
		try {
			json = new JSONObject(result);
		} catch (JSONException e) {
			                 System.out.println("There was a Json parsing based error");
        
			
			return null;
		}
		return json;
	}

	public  String getHttp(String url) {
		System.out.println("Classe Parse JSON"+ url);
		String result = "";
		HttpClient httpclient = new DefaultHttpClient();

		URI u;
		try {
			u = new URI(url);
			HttpGet httpget = new HttpGet(u);

			HttpParams httpParameters = new BasicHttpParams();
			int timeoutConnection = 3000;
			HttpConnectionParams.setConnectionTimeout(httpParameters,
					timeoutConnection);
			int timeoutSocket = 5000;
			HttpConnectionParams.setSoTimeout(httpParameters, timeoutSocket);
			httpclient = new DefaultHttpClient(httpParameters);

			HttpResponse response;
			             //    System.out.println( httpget.toString());

			try {
				response = httpclient.execute(httpget);
				HttpEntity entity = response.getEntity();
				if (entity != null) {
					InputStream instream = entity.getContent();
					result = convertStreamToString(instream);
					// System.out.println(result); 
					instream.close();
				}
			} catch (ClientProtocolException e) {
                            System.out.println("There was a protocol based error");	
				
			} catch (IOException e) {
                             System.out.println("There was an IO Stream related error");
           		}

		} catch (URISyntaxException e) {
			
			e.printStackTrace();
		}
		return result;
	}

	private  String convertStreamToString(InputStream is) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();
		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
		} catch (IOException e) {
		
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
				
			}
		}

		
		return sb.toString();
	}
}
