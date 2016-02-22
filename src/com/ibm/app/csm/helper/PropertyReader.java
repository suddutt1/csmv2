package com.ibm.app.csm.helper;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
	
public static String propertyReader(String fileName,String key){
	Properties props=new Properties();
	try {
		props.load(new FileInputStream("src/properties/"+fileName));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return props.getProperty(key);
}
}
