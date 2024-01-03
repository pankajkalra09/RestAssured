import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class CreatePro {

	
	@Test	
	public void prospect() {
		
		System.out.println("Before RESTASSURED");
		
		RestAssured.baseURI = "https:unifyedadmitqa.unifyed.com/v1/webhook/postprospectinfo";
		
		System.out.println("After RestAssured");
		
		given().auth().oauth2("Mjg1ZGMzYjMtODA1YS00ZjBjLTk4ZjgtMzgyOWNkY2QwOTc2OmJhNDVhZmIzLTQ3NzEtNDI3Yy05NDFjLWNiMjc2NzJhMWQ1MQ==").log().all()
		.header("Content-Type","application/json")
		.body(" {\r\n"
				+ "     \"row\": {\r\n"
				+ "        \"person.lastName\": \"Wunsschds\",\r\n"
				+ "        \"person.emailAddress__1__type\": \"Personal\",\r\n"
				+ "        \"person.emailAddress__1__email\": \"zdxsds@mailinator.com\",\r\n"
				+ "        \"person.emailAddress__1__startDate\": \"01/09/2020\",\r\n"
				+ "        \"person.emailAddress__1__endDate\": \"\",\r\n"
				+ "        \"person.emailAddress__1__isPrimary\": \"\",\r\n"
				+ "        \"calendarType.termApplyingFor\": \"Graduate Spring 2022\",\r\n"
				+ "        \"person.firstName\": \"Myrsdsiam\",\r\n"
				+ "        \"calendarType\": \"Graduate Student\",\r\n"
				+ "        \"person.contactNumber__1__type\":\"Cell\",\r\n"
				+ "        \"person.contactNumber__1__country\":\"United States\",\r\n"
				+ "        \"person.contactNumber__1__phone\":\"8988989998\",\r\n"
				+ "        \"person.contactNumber__1__extn\":\"+1\",\r\n"
				+ "        \"person.contactNumber__1__beginDate\":\"02-02-2020\",\r\n"
				+ "        \"person.contactNumber__1__endDate\":\"03-03-2023\",\r\n"
				+ "        \"person.contactNumber__1__isPrimary\":\"Yes\",\r\n"
				+ "        \"academics.program\": \"Concentration\",\r\n"
				+ "        \"academics.concentration__1__\": \"Finance\",\r\n"
				+ "        \"in_StateRes\": \"Yes\"\r\n"
				+ "    }\r\n"
				+ " }").when().post().then().statusCode(200);
	}
}
