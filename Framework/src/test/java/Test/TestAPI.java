package Test;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Project.BaseTest;
import Project.RestCalls;
import Project.ValAssertion;
import Utility.TestUtil;
import Utility.URL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TestAPI {
	
	public String accesstoken;
	public String id;
	Response response;
	@BeforeTest
	public void setup() throws IOException
	{
		accesstoken = BaseTest.Login();
	}
   @Test
   public void getalluser()
   {
	  String endpointurl =URL.getEndpoint("/user");
	  
	  response = RestCalls.getmethodwithheader(endpointurl, accesstoken);
	  
	  //what was next step
	  String res =TestUtil.getresponsestring(response);
	  JsonPath jsonres =TestUtil.jsonparser(res);
	  
	  id = jsonres.getString("users[2]._id");
	  System.out.println(id);
	  ValAssertion.verifystatuscode(response,200);
	  
   }
   @Test(dependsOnMethods="getalluser")
   public void deleteuser()
   {
	   String endpointurl=URL.getEndpoint("/user/" + id);
	   response = RestCalls.deletemethodwithheader(endpointurl, accesstoken);
	   System.out.println(response);
		  
		  //what was next step
		  String res =TestUtil.getresponsestring(response);
		  JsonPath jsonres =TestUtil.jsonparser(res);
		  System.out.println(res);
		 // id = jsonres.getString("users[2]._id");
		  //System.out.println(id);
		  ValAssertion.verifystatuscode(response,200);
   }
}

