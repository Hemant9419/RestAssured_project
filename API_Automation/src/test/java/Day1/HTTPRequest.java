package Day1;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;

import java.util.HashMap;

import static io.restassured.matcher.RestAssuredMatchers.*;
/*
given()
content type, set cookies , add auth, add param, set headers info sends in given section

when()
get, post, put, delete.

then();
validate status code, extract response, extract headers cookies and response body

*/
public class HTTPRequest {

	int id;
	@Test(priority=1)
	void getuser() {
		
		given()
		
		.when()
		   
		.get("https://reqres.in/api/users?page=2")
		
		    
		    .then()
		    
		    .statusCode(200)
		    
		    .log().all();// print all log into the consol
		
	}
	
	@Test(priority=2)
	void createuser()
	{
		HashMap<String, String> map= new HashMap<String, String>();
		
		map.put("Name", "Hemant");
		map.put("Job", "QA engineer");
		
		
		id=given()
		.contentType("application/json")
		.body(map)
		
		.when()
		   .post("https://reqres.in/api/users")
		   
		   .jsonPath().getInt("id")
		   ;
		   
		/*.then()
		.statusCode(201)
		
		.log().all();
		
		;*/
		
	}
	@Test(priority=3, dependsOnMethods = "createuser")
	void updateuser()
	
	{
		
HashMap<String, String> map= new HashMap<String, String>();
		
		map.put("Name", "Rahul");
		map.put("Job", "Team lead");
		
		
		given()
		.contentType("application/json")
		.body(map)
		
		.when()
		   .put("https://reqres.in/api/users/"+id)
		   
		  
		   
		   
		   .then()
		   .statusCode(200)
		     .log().all();
		   
	}
	
	
	
}
