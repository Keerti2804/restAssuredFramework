package Project;

import java.io.IOException;

import org.testng.annotations.Test;

import Utility.Payloadconvertor;
import Utility.URL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class BaseTest {
	
	static Response response;
	
	@Test
	public static String Login() throws IOException
	{
		//i am trying to do login
		//what is my first step//URL//body
		
		String endpointurl =  URL.getEndpoint("/user/login");
		
		String Loginpayload = Payloadconvertor.generatepayloadString("login.json");
		
		//i have to call the method which i want run and fetch the response
		
	    response = RestCalls.postmethod(endpointurl, Loginpayload);
	    System.out.println("response" + response);
	    //this is to fetch the response body
	    
	    String res =  response.getBody().asString();
	    
	    System.out.println("Resp" + res);
	    
	    //i want to convert this in to Json
	    JsonPath jsonres = new JsonPath(res);
	   String accessToken =  jsonres.getString("accessToken");
	   
	   return accessToken;
	}
	
}