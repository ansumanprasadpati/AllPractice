import static io.restassured.RestAssured.*;

import java.util.List;

import Pojo.api;
import Pojo.getCourse;
import Pojo.webAutomation;
import io.restassured.path.json.JsonPath;
public class oAuth {

	public static void main(String[] args) throws InterruptedException
	{
		try {
				String Response= given().formParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
				.formParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
				.formParam("grant_type", "client_credentials")
				.formParam("scope", "trust")
				.when().log().all()
				.post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token")
				.then().extract().asString();
				System.out.println(Response);
				
				//get access
				JsonPath js = new JsonPath(Response);
				String token=js.get("access_token");
				
				getCourse gc= given()
				.queryParam("access_token", token)
				.when().log().all()
				.get("https://rahulshettyacademy.com/oauthapi/getCourseDetails").as(getCourse.class);
				
				
				System.out.println(gc.getInstructor());
				System.out.println(gc.getUrl());
				List<api> courseDetails=gc.getCourses().getApi();
				
				for(int i=0;i<courseDetails.size();i++) {
					if(courseDetails.get(i).getCourseTitle().equalsIgnoreCase("SoapUI Webservices testing"))
					{
						System.out.println(courseDetails.get(i).getPrice());
					}
				}
				List<webAutomation> course_Title=gc.getCourses().getWebAutomation();
				for(int j=0;j<course_Title.size();j++) {
					System.out.println(course_Title.get(j).getCourseTitle());
				}

	}catch(Exception e) {
		e.printStackTrace();
		}
		
	}

}
