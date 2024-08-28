package automation.dataSet;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class dataReader {
	public List<HashMap<String, String>> getJsonDataToMap() throws IOException
	{
		//read external JSON and convert it to String
		String jsonData=FileUtils.readFileToString(new File(System.getProperty("user.dir")+"src//test//java//automation//dataSet//purchaseOrder.json"),
				StandardCharsets.UTF_8);
		//string to HashMap: need jackson databind
		ObjectMapper mapper=new ObjectMapper();
		List<HashMap<String, String>> data=mapper.readValue(jsonData,
				new TypeReference<List<HashMap<String, String>>>() {});
		return data;
		
	}

}
