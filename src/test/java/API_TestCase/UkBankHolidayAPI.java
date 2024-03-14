package API_TestCase;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import java.util.HashMap;

import  org.testng.annotations.Test;

import io.restassured.http.ContentType;


public class UkBankHolidayAPI {
		
		String text;
		
		@Test(priority=1)
		void getListOfHoloiday()
		{
			given()
			
			.when()
				.get("https://www.gov.uk/bank-holidays.json")
				.then()
				.statusCode(200)
				.log().all();
			
		}
	
		
		@Test(priority=2)
		void createHoliday()
		{	
			HashMap data=new HashMap();
			data.put("title","Holi");
			data.put("date", "2024-03-24");
			
			given()
			
				.contentType("application/json")
				.body(data)
			
			.when()
			.post("https://www.gov.uk/bank-holidays.json")
			
		
			.then()		
			.statusCode(201)
			.log().all();
		}

		


}
