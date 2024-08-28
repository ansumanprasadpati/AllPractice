//import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo_serialization.Location;
import pojo_serialization.googleResponse;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

public class SpecbuilderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		googleResponse g=new googleResponse();
		g.setAccuracy(50);
		g.setAddress("Bangalore");
		g.setLanguage("English");
		Location l = new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		g.setLocation(l);
		g.setName("Ansuman");
		g.setPhoneNumber("238478273947");
		g.setWebsite("www.google.com");
		List<String> myList=new ArrayList<String>();
		myList.add("Shoepark");
		myList.add("shop");
		g.setTypes(myList);
		
		RequestSpecification reqSpec=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key", "qaclick123")
		.setContentType(ContentType.JSON).build();
		
		ResponseSpecification resSpec=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
		RequestSpecification res=given().spec(reqSpec)
		.body(g);
		
		Response response=res.when().post("maps/api/place/add/json")
		.then().spec(resSpec).extract().response();
		
		String responseString=response.asString();
		System.out.println(responseString);

	}

}
