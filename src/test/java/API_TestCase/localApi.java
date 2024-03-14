package API_TestCase;

 import java.util.HashMap;
 import static io.restassured.RestAssured.given;
 import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.Test;
import java.util.HashMap;

import  org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
public class localApi {
	ValidatableResponse id;
	
	@Test(priority=1)
	public void createNewUser()

	{
		HashMap has=new HashMap();
		has.put("name", "John");
		has.put("age", "30");
		has.put("phone", "+1 (890) 643-2508");
		
		String courseArray[]= {"Java","Selenium"};
		has.put("courses", courseArray);
		
		
		id=given()
		.contentType("application/json")
		.body(has)
		.when()
			.post("http://localhost:3000/clients")
		.then()
			.statusCode(201)
			.body("name",equalTo("John"))
				.body("age",equalTo("30"))
					.body("phone",equalTo("+1 (890) 643-2508"))
					.body("courses[0]",equalTo("Java"))
					.body("courses[1]",equalTo("Selenium"))
					.log().all();
				
	}
	@Test(priority=2)
	public void deleteRecord()
	{
		given()
		.when()
			.delete("http://localhost:3000/clients/"+id)
		.then()
			.statusCode(404);	
	}
}


