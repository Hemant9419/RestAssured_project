package Day2;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;



import static org.hamcrest.Matchers.equalTo;

import static io.restassured.matcher.RestAssuredMatchers.*;





public class DifferentWaysToCreate_PostBody {

	/*
1.	HashMap
2.	Using org.json
3.	Using POJO class(plain old java object)
4.	Using external json file

	 */
	
	
	//Test post request using HashMap********************************
	
	//@Test(priority=1)
	public void testPostUsingHashMap()
	
	{
		
		
		HashMap map= new HashMap();
		
		map.put("Name", "sonu");
		
		map.put("Location","Goa");
		map.put("Mobile no", "8287812735");
		
		String courseArr[]= {"c","java"};
		
		map.put("courses",courseArr);
		
		given()
		.contentType("application/json")
		.when()
		.post("http://localhost:3000/jsondata")
		.then()
		  .statusCode(201)
		  .header("content-Type", "application/json; charset=utf-8")
		  
		  .log().all()
		  
		;
		
	}
	//@Test(priority=2)
	void testDelete()
	{
		given()
		
		.when()
		
		.delete("http://localhost:3000/jsondata/4")
		.then()
		.statusCode(200) 
		
		;
	}
	
	//creat json data using json lainrary org.json****************************
	@Test
	void testpostusingJson() {
		
		JSONObject data= new JSONObject();
		
		data.put("Name", "Hemant");
		data.put("Location", "Mumbai");
		data.put("phone", "98899889988");
		
		String corsesArr[]= {"c","java"};
		
		data.put("courses",corsesArr );
		given()
		.contentType("application/json")
		.body(data.toString())
		.when()
		.post("http://localhost:3000/jsondata")
		.then()
		  .statusCode(201)
		  .header("content-Type", "application/json; charset=utf-8")
		  
		  .log().all()
		  
		;
	}
	//Test using POJO geter and seter class**************************
	
	
	void testPostusingPOJO()
	{
		Pojo_postRequest data= new Pojo_postRequest();
		
		data.setName("Rahul");
		data.setLocation("Delhi");
		data.setPhone("8909878908");
		
		String corsesArry[]= {"java","python"};
		
		data.setCourses(corsesArry);
		
		given()
		.contentType("application/json")
		.body(data)
		
		.when()
		
		.post("http://localhost:3000/jsondata")
		
		
		.then()
		.statusCode(201)
		.body("name", equalTo("Rahul"))
		.body("location", equalTo("Delhi"))
		.body("phone", equalTo("8909878908"))
		.body("course[0]", equalTo("java"))
		.body("courses[1]", equalTo("python"))
		.header("content-Type", "application/json; charset=utf-8")
		.log().all()
		;
	}
	
	// Test POST request using external json file*****************************
	
	@Test
	void TestPostUsingExternalJsonFile() throws FileNotFoundException {
		
		
		File file= new File(".\\body.json");
		FileReader fr= new FileReader(file);
		JSONTokener jt= new JSONTokener(fr);
		
		JSONObject data= new JSONObject(jt);
		
		
		
		given()
		
		.contentType("application/json")
		.body(data.toString())
		.when()
		.post("http://localhost:3000/jsondata")
		.then()
		 .statusCode(201)
		 .body("name",equalTo("Hemant"))
		 .body("Location", equalTo("Mumbai"))
		 .body("phone",equalTo("98899889988"))
		 .body("corses[0]", equalTo("java"))
		 .body("corses[1]", equalTo("python"))
		
		;
	}
	
	
}
