package FIles;

import io.restassured.path.json.JsonPath;

public class ReUsableMethods {
	
	public static JsonPath RawtoJson(String getPlace)
	{
		JsonPath js1=new JsonPath(getPlace);
		return js1;
		
	}

}
