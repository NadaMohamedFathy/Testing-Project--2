package Services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import Contracts.IHTTP;

public class HTTP implements IHTTP{
	
	/*public HTTP(IHTTP http) {
		
    }*/


	HttpResponse<String> response1;
	@Override
	public String Http(String uri)
	{
		HttpClient client = HttpClient.newHttpClient();
    	HttpRequest request = HttpRequest.newBuilder().uri(URI.create(uri)).build();
		try {
			response1= client.send(request, BodyHandlers.ofString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(response1);
		return response1.body();
	}
	

}
