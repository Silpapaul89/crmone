package vtigerCrm.generic.fileUtility;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class jsonUtility {
	
	public String getCommonDataFromJsonFile(String key) throws IOException, ParseException
	{
		FileReader file = new FileReader("./configAppData/jsonCommonData.json");
		JSONParser parser = new JSONParser();
		Object jobj = parser.parse(file);
		JSONObject jsonObj = (JSONObject) jobj;
		String data = (String) jsonObj.get(key);
		return data;
	}

}


