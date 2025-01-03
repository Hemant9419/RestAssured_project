package Day3;
import static org.hamcrest.Matchers.equalTo;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;
import static io.restassured.matcher.RestAssuredMatchers.*;


public class CoockiesDemo 
{

	
	//@Test
	void testCookies()
	{
		given()
		.when()
		.get("https://www.google.com/")
		
		.then()
		.cookie("ACE","AakniGOLxRQC9f")
		.log().all()
		;
	}
	
	@Test
	
	void getcookiesInfo() {
		
		Response resp=given()
		
		.when()
		
		   .get("https://www.google.com/");
		
		//get single cookie info
		
		//String Cookie_VALUE=resp.getCookie("ACE");
		//System.out.println(Cookie_VALUE);
		
		// to get all cookies*************
		
	Map<String,String>cookies_Value=	resp.getCookies();
	
	System.out.println(cookies_Value.keySet());
	
	for(String k: cookies_Value.keySet()) {
		
		String cookie=resp.getCookie(k);
		
		System.out.println(k+"   "+cookies_Value);
	}
	
	
	}
}
