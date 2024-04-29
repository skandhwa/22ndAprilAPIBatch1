package POJOMapper;

import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;

public class CreateSerializeUser {
	
	public static String createUser() throws JsonProcessingException
	{
	
	
	CreateUserPOJO obj=new CreateUserPOJO();
	obj.setCity("kolkata");
	obj.setName("Mohan");
	obj.setState("WB");
	obj.setPincode(713304);
	
	ObjectMapper objmapper=new ObjectMapper();
	String JsonPayload=	objmapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
	return JsonPayload;
	
	
	
	
	
	
	
	}
	
	

}
