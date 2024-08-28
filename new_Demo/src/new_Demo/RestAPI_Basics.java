package new_Demo;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import FIles.ReUsableMethods;
import FIles.payloadBody;

public class RestAPI_Basics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hello!");
		// to Add place.
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String response=given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(payloadBody.AddPlace())
		.when().post("/maps/api/place/add/json")
		.then().assertThat().statusCode(200).body("scope", equalTo("APP"))
		.header("Server","Apache/2.4.52 (Ubuntu)").extract().response().asString();
		System.out.println(response);
		
		//Created the JsonPath object to capture the response
		JsonPath js= new JsonPath(response);
		//from the response we captured the place_id and stored it into one String
		//variable.
		String getPlace_ID=js.getString("place_id");
		System.out.println(getPlace_ID);
		
		//update place
		
		String newAddress="Bangalore";
		given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
		.body("{\r\n"
				+ "\"place_id\":\""+getPlace_ID+"\",\r\n"
				+ "\"address\":\""+newAddress+"\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}")
		.when().put("/maps/api/place/update/json")
		.then().assertThat().log().all().statusCode(200).body("msg", equalTo("Address successfully updated"));
		
		//get Place
		String get_Place=given().log().all().queryParam("key", "qaclick123")
				.queryParam("place_id", getPlace_ID)
		.when().get("/maps/api/place/get/json")
		.then().assertThat().log().all().statusCode(200)
		.extract().response().asString();
		System.out.println(get_Place);
		
		JsonPath js1=ReUsableMethods.RawtoJson(get_Place);
		String new_Add=js1.get("address");
		System.out.println(new_Add);
		Assert.assertEquals(new_Add,newAddress);
		}
}
