package Day3;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.response.Response;


public class HeaderDemo {
	
	@Test
	
	void getHeaderInfo() {
		
		Response res=given()
				
		
		.when()
		   .get("https://www.google.com/");
		
		//Get single header info
		
	String header_value=	res.getHeader("Content-Type");
	System.out.println("the value of content type of header is"+ header_value);
		
	}
	
	

}
