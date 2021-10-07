package com.ers.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertiesParser {

static Map<String,String> dbDetails = new HashMap<>();
	
	public static void getProperties(){
		
		try {
			FileReader reader = new FileReader("src/main/resources/db.properties");
			Properties dbProperties = new Properties();
			
			dbProperties.load(reader);

			dbDetails.put("url", dbProperties.getProperty("url"));
			dbDetails.put("username", dbProperties.getProperty("username"));
			dbDetails.put("password", dbProperties.getProperty("password"));
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
