package FIles;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;

import static io.restassured.RestAssured.*;

import java.io.File;

public class JIRA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestAssured.baseURI="http://localhost:8080/";
		
		SessionFilter session=new SessionFilter();
		
		
		//login session
		given().header("Content-Type","application/json").log().all().
		body("{ \r\n"
				+ "    \"username\": \"ansumanprasad.p\", \r\n"
				+ "    \"password\": \"Ansuman@123\" \r\n"
				+ "    }").when().filter(session)
		.post("/rest/auth/1/session").then().extract().response().asString();
		
		
		//adding comment
		given().header("Content-Type","application/json").log().all().
		pathParam("key", "AP-4").
		body("{\r\n"
				+ "    \"body\": \"This is the comment from coding.\",\r\n"
				+ "    \"visibility\": {\r\n"
				+ "        \"type\": \"role\",\r\n"
				+ "        \"value\": \"Administrators\"\r\n"
				+ "    }\r\n"
				+ "}").when().filter(session)
		.post("rest/api/2/issue/{key}/comment");
		
		//add attachment
		given().header("X-Atlassian-Token","no-check")
		.header("Content-Type","multipart/form-data").filter(session)
		.pathParam("key","AP-4").
		log().all().multiPart("file", new File("C:\\Users\\ansuman.pati\\Desktop\\MyDemo.txt"))
		.when()
		.post("/rest/api/2/issue/{key}/attachments").then().log().all().assertThat().statusCode(200);
		

	}

}
