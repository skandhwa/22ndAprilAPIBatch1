package stepDefinition;

import Utilities.FetchValueFromExcel;
import Utilities.ReUsabaleMethods;
import Utilities.ReadDataFromProperty;
import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.util.Map;

import org.testng.Assert;

import POJOMapper.CreateSerializeUser;
import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;


public class StepDefinition {
	
	RequestSpecification req;
	RequestSpecification res;
	ResponseSpecification respec;
	String strResponse;
	Response response;
	
	String PropertyFileData=ReadDataFromProperty.readDatafromProperty().getProperty("baseURI");
	String PropertyFileDatanew=ReadDataFromProperty.readDatafromProperty().getProperty("baseURInew");
	String Token=ReadDataFromProperty.readDatafromProperty().getProperty("AuthToken");
	
	@Given("User hits into the application url")
	public void user_hits_into_the_application_url() {
		req=new RequestSpecBuilder().setBaseUri(PropertyFileData)
				.setContentType(ContentType.JSON).build();
	}
		
	

	@Given("User will pass the payload")
	public void user_will_pass_the_payload() throws JsonProcessingException {
		
		res=given().relaxedHTTPSValidation().
				spec(req).body(CreateSerializeUser.createUser());
	    
	}

	@When("User will submit the post request with {string}")
	public void user_will_submit_the_post_request_with(String endpoint) {
		
		respec=new ResponseSpecBuilder().expectStatusCode(200).build();
		response=res.when().post(endpoint).then().spec(respec).extract().response();
		
		
	   
	}


	@Then("validate the status code with {string}")
	public void validate_the_status_code_with(String status_code) {
		
		
		String s=status_code;  
		//Converting String into int using Integer.parseInt()  
		int i=Integer.parseInt(s);  
		
		int statuscode=response.getStatusCode();
		System.out.println("The Status Code is "+statuscode);
		Assert.assertEquals(statuscode, i);
		
		
		
		strResponse= response.asString();
		System.out.println(strResponse);
		JsonPath js=ReUsabaleMethods.rawtoJson(strResponse);
		
	   
	}
	
	
	@Given("User logins into the application with corresponding baseUri")
	public void user_logins_into_the_application_with_corresponding_base_uri() {
		
		req=new RequestSpecBuilder().setBaseUri(PropertyFileDatanew)
				.setContentType(ContentType.JSON).build();
		
	    
	}

	@Given("User will pass the payload with authentication token")
	public void user_will_pass_the_payload_with_authentication_token() throws IOException {
		
		res=given().headers("Authorization",Token).
				spec(req).body(FetchValueFromExcel.createUser());
		
		
	  
	}

	@When("User will submit the post request with the  {string}")
	public void user_will_submit_the_post_request_with_the(String endpoint) {
		
		respec=new ResponseSpecBuilder().expectStatusCode(201).build();
		response=res.when().post(endpoint).then().spec(respec).extract().response();
	    
	}
	
	
	@Then("validate the status code with  new status code as {string}")
	public void validate_the_status_code_with_new_status_code_as(String status_code) {
		
		
		String s=status_code;  
		//Converting String into int using Integer.parseInt()  
		int i=Integer.parseInt(s);  
		
		int statuscode=response.getStatusCode();
		System.out.println("The Status Code is "+statuscode);
		Assert.assertEquals(statuscode, i);
		
		
		
		strResponse= response.asString();
		System.out.println(strResponse);
		JsonPath js=ReUsabaleMethods.rawtoJson(strResponse);
		
	    
	}
	
	

	@Then("User will validate the responsebody")
	public void user_will_validate_the_responsebody() throws IOException {
		
		strResponse= response.asString();
		System.out.println(strResponse);
		JsonPath js=ReUsabaleMethods.rawtoJson(strResponse);
		String Name=js.getString("name");
		System.out.println("The Expected name is "+Name);
		
		
		Map<String,String> mpnew=FetchValueFromExcel.createUser();
		System.out.println(mpnew);
	String ActualName=mpnew.get(0);
	
	System.out.println("The Actual Name is "+ActualName);
	
		
		
		
	   
	}

	
	
	

}
