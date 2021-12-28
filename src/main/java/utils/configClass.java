package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class configClass {
	
	Properties config = new Properties();
	
	 public  String readConfigData (String key) throws IOException {
		 
	    InputStream input = new FileInputStream("resources/config.properties");
	    config.load(input);
	    return config.getProperty(key);
	}

}
