package stepDefinations;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {

	@Before("@DeletePlace")
	public void beforeScenario() throws IOException {
		
		StepDefination sd= new StepDefination();
		if(StepDefination.place_id==null) {
		
		sd.add_place_payload("White house","English UK", "London");
		sd.user_calls_with_http_request("AddPlaceAPI", "POST");
		sd.verify_place_id_created_maps_to_using("White house", "getPlaceAPI");
		}
	}

}
