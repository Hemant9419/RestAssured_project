package Day3;


import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class AllLogs_Demo {
	
	@Test
	void testAllLogs() {
		
		given()
		.when()
		  .get("https://reqres.in/api/users?page=2")
		.then()
		.log().body()
		  
		;
		
	}

}
