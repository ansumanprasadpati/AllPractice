package FIles;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import org.testng.Assert;

public class GetIssue_JIRA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RestAssured.baseURI="http://localhost:8080/";
		SessionFilter session=new SessionFilter();
		//login
		given().header("Content-Type","application/json").log().all()
		.body("{ \r\n"
				+ "    \"username\": \"ansumanprasad.p\", \r\n"
				+ "    \"password\": \"Ansuman@123\" \r\n"
				+ "    }")
		.when().filter(session).post("/rest/auth/1/session")
		.then().statusCode(200);
		String expectMsg="Hello";
		
		//Add comment
		String addcommentResponse=given().header("Content-Type","application/json").log().all().
		pathParam("key", "AP-4").
		body("{\r\n"
				+ "    \"body\": \""+expectMsg+"\",\r\n"
				+ "    \"visibility\": {\r\n"
				+ "        \"type\": \"role\",\r\n"
				+ "        \"value\": \"Administrators\"\r\n"
				+ "    }\r\n"
				+ "}").when().filter(session)
		.post("rest/api/2/issue/{key}/comment").then().extract().asString();
		
		JsonPath js=new JsonPath(addcommentResponse);
		String commentIDIssue=js.getString("id");
		
		
		//get the issue details
		String issueDetails=given().filter(session).pathParam("key", "AP-4")
		.queryParam("fields", "comments").log().all()
		.when().get("/rest/api/2/issue/{key}")
		.then().log().all().extract().response().asString();
		
		JsonPath js1= new JsonPath(issueDetails);
		int commentCount = js1.getInt("fields.comment.comments.size()");
		for(int i=0;i<commentCount;i++)
		{
			String commentID= js1.get("fields.comment.comments["+i+"].id").toString();
			if(commentID.equalsIgnoreCase(commentIDIssue))
			{
				String message=js1.get("fields.comment.comments["+i+"].body").toString();
				Assert.assertEquals(message, expectMsg);
			}
		}

	}

}
