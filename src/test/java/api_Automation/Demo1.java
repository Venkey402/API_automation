package api_Automation;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.json.JSONObject;
import org.testng.annotations.Test;
public class Demo1 {

	@Test(priority=1)
	public void getUsers()
	{		
		given()
		.when().get("http://localhost:3000/users")
		.then().statusCode(200).log().all();				
	}
	
	@Test(priority=2)
	public void createUserWithHashMap()
	{	
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("Fname", "Shyamala");
		data.put("Lname", "Mamidi");
		System.out.println(data);
		given()
			.contentType("application/json")
			.body(data)
		.when()
			.post("http://localhost:3000/users")
		.then()
			.statusCode(201)
			.log().all();			
	}
	
	@Test(priority=3)
	public void createUserWithJSONLibrary()
	{	
		JSONObject data = new JSONObject();
		data.put("Fname", "Ramu");
		data.put("Lname", "Mamidi");
		System.out.println(data);
		given()
			.contentType("application/json")
			.body(data.toString())
		.when()
			.post("http://localhost:3000/users")
		.then()
			.statusCode(201)
			.log().all();			
	}
	
	@Test
	public void deleteUser()
	{
		given()
			
		
		.when()
			.delete("http://localhost:3000/users/16")
		
		.then()
			.statusCode(200);
		
	}
	
}
