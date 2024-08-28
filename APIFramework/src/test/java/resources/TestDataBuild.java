package resources;

import java.util.ArrayList;
import java.util.List;

import pojo_serialization.Location;
import pojo_serialization.googleResponse;

public class TestDataBuild {
	
	public googleResponse AddPlacePayload(String name, String language, String address)
	{
		googleResponse g=new googleResponse();
		g.setAccuracy(50);
		g.setAddress(address);
		g.setLanguage(language);
		Location l = new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		g.setLocation(l);
		g.setName(name);
		g.setPhoneNumber("238478273947");
		g.setWebsite("www.google.com");
		List<String> myList=new ArrayList<String>();
		myList.add("Shoepark");
		myList.add("shop");
		g.setTypes(myList);
		return g;
	}
	
	public String deleteplacePayload(String place_id)
	{
		return "{\r\n    \"place_id\":\""+place_id+"\"\r\n}";
	}
	

}
