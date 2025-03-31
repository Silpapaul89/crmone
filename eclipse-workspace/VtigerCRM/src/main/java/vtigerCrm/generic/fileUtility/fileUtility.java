package vtigerCrm.generic.fileUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class fileUtility {
	
	public String getCommonDataFromPropertiesFile(String key) throws IOException
	{
		FileInputStream fisp = new FileInputStream("./configAppData/commonData.properties");
		Properties PObj = new Properties();
		PObj.load(fisp);
		String data = PObj.getProperty(key);
		return data;
	}

}


