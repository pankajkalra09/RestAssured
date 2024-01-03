import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateProspect {

	@Test
	public void createProsect(){
		
		RestAssured.baseURI = "https://admitpm.unifyed.com/";
		
		String Response = given().header("Content-Type","application/json")
		.header("Authorization", "ZTZkMTQzYWEtMWY3MC0xMWViLWFkYzEtMDI0MmFjMTIwMDAyOmY3ZGRmMTJhLTFmNzAtMTFlYi1hZGMxLTAyNDJhYzEyMDAwMg==")
		.body(" {\r\n"
				+ "     \"row\": {\r\n"
				+ "        \"person.lastName\": \"Wunsdsch\",\r\n"
				+ "        \"person.emailAddress__1__type\": \"Personal\",\r\n"
				+ "        \"person.emailAddress__1__email\": \"prospspsdhdrsogAPI@maili.com\",\r\n"
				+ "        \"person.emailAddress__1__startDate\": \"01/09/2020\",\r\n"
				+ "        \"person.emailAddress__1__endDate\": \"\",\r\n"
				+ "        \"person.emailAddress__1__isPrimary\": \"\",\r\n"
				+ "        \"calendarType.termApplyingFor\": \"Fall 2022 ON\",\r\n"
				+ "        \"person.firstName\": \"Myrisdam\",\r\n"
				+ "        \"calendarType\": \"Graduate Student\",\r\n"
				+ "        \"person.contactNumber__1__type\":\"Office\",\r\n"
				+ "        \"person.contactNumber__1__country\":\"United States\",\r\n"
				+ "        \"person.contactNumber__1__phone\":\"8988989998\",\r\n"
				+ "        \"person.contactNumber__1__extn\":\"+1\",\r\n"
				+ "        \"person.contactNumber__1__beginDate\":\"02-02-2020\",\r\n"
				+ "        \"person.contactNumber__1__endDate\":\"03-03-2020\",\r\n"
				+ "        \"person.contactNumber__1__isPrimary\":\"Yes\",\r\n"
				+ "        \"academics.program\": \"Graduate Student Program\",\r\n"
				+ "        \"academics.primaryMajor__1__\": \"Accounting\",\r\n"
				+ "        \"academics.degree\":\"Graduate Student Award\",\r\n"
				+ "        \"academics.minor__1__\": \"Biology\",\r\n"
				+ "        \"academics.concentration__1__\": \"Book Keeping\",\r\n"
				+ "        \"academics.certificate__1__\": \"Java Programming\",\r\n"
				+ "        \"in_StateRes\": \"Yes\"\r\n"
				+ "    }\r\n"
				+ " }").when().post("v1/webhook/postprospectinfo").then().extract().response().asString();
		
		System.out.println("Full Response is: "+Response);
		
		JsonPath js = new JsonPath(Response);
		String Message = js.get("message");
		
		System.out.println("Message is: "+Message);
		
		String expectedmessage = "Record created successfully!";
		 Assert.assertEquals(Message, expectedmessage);	
	}
}
