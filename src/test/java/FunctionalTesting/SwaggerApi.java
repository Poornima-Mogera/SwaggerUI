package FunctionalTesting;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;
import io.restassured.response.Response;//package FunctionalTesting;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//import io.restassured.RestAssured;
//import io.restassured.response.Response;
//public class GetRequestAutomation 
//{
//	@Test
//	public void getTest() {
//		Response resp=RestAssured.get("http://rest-api.upskills.in/doc/admin/");
//		int code = resp.getStatusCode();
//		System.out.println("Status code id"+code);
//		Assert.assertEquals(code, 200);
//	}
//
//}


public class SwaggerApi {
	String username="upskills_admin";
	String password="Talent4$$";
	String access_token="";
	
	@Test
	public void getAccessToken() {
		
	Response response=given().when().header("Authorization", "Basic dXBza2lsbHNfcmVzdF9hZG1pbl9vYXV0aF9jbGllbnQ6dXBza2lsbHNfcmVzdF9hZG1pbl9vYXV0aF9zZWNyZXQ=")
	.log().all()
	.post("http://rest-api.upskills.in/api/rest_admin/oauth2/token/client_credentials");
	response.prettyPrint();
	System.out.println("Status Code is " +response.statusCode());
	}
	
	
	@Test
	public void getAdminLogin() {
		 String payload = "{\n" +
		            "    \"username\":\"upskills_admin\",\n" +
		            "    \"password\":\"Talent4$$\"\n" +
		            "}";
		Response response=given().headers("Content-Type", "application/json").body(payload)
		.when().post("http://rest-api.upskills.in/doc/admin/#/2.%20Admin%20User/loginUser");
		response.prettyPrint();
		System.out.println("Status Code is " +response.statusCode());
	
		}
	
	}