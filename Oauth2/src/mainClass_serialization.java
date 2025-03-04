import io.restassured.RestAssured;
import pojo_serialization.Location;
import pojo_serialization.googleResponse;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

public class mainClass_serialization {

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
		
		
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String response=given().log().all().queryParam("key", "qaclick123")
		.body(g)
		.when().post("maps/api/place/add/json")
		.then().assertThat().statusCode(200).extract().response().asString();
		System.out.println(response);

	}

}
