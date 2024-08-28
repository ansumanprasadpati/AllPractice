package stepDefinations;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

import java.io.IOException;

//import java.util.ArrayList;
//import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
//import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResource;
//import pojo_serialization.Location;
//import pojo_serialization.googleResponse;
import resources.TestDataBuild;
import resources.Utils;

public class StepDefination extends Utils{
    RequestSpecification res;
    ResponseSpecification resSpec;
    Response response;
    TestDataBuild td=new TestDataBuild();
    static String  place_id;

    @Given("Add Place payload {string} {string} {string}")
    public void add_place_payload(String name, String language, String address) throws IOException {
        res=given().spec(requestSpecification()).body(td.AddPlacePayload(name, language, address));
    }
    
    @When("user calls {string} with {string} http request")
    public void user_calls_with_http_request(String resource, String method) {
        
        APIResource resourceAPI=APIResource.valueOf(resource);
        resSpec=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
        response=res.when().post("maps/api/place/add/json")
                .then().spec(resSpec).extract().response();

        if (method.equalsIgnoreCase("POST"))
            response=res.when().post(resourceAPI.getResource());
        else if (method.equalsIgnoreCase("GET"))
            response= res.when().get(resourceAPI.getResource());
    }
    
    @Then("API call got success with status {int}")
    public void api_call_got_success_with_status(Integer int1) {
        assertEquals(response.getStatusCode(),200);
        //throw new io.cucumber.java.PendingException();
    }
    @Then("{string} in response body is {string}")
    public void in_response_body_is(String keyValue, String expectedValue) {
        
        
        assertEquals(getJsonPath(response,keyValue),expectedValue);
    }
    @Then("verify place_id created maps to {string} using {string}")
    public void verify_place_id_created_maps_to_using(String expectedName, String resource) throws IOException {
        
        
        place_id=getJsonPath(response, "place_id");
        res=given().spec(requestSpecification()).queryParam("place_id",place_id);
        user_calls_with_http_request(resource, "GET");
        String Actualname=getJsonPath(response, "name");
        assertEquals(Actualname,expectedName);
    }

    @Given("Delete place payload")
    public void delete_place_payload() throws IOException {
        res= given().spec(requestSpecification())
        .body(td.deleteplacePayload(place_id));
        //user_calls_with_http_request("deletePlaceAPI", "POST");
        
    }


}