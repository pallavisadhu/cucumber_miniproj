package config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	
	public final String filePath = "/Users/pallavisadhu/Desktop/cucumber_miniproject/Cucumber_miniproj/src/test/java/config/config.properties";
	Properties prop;
	
	public ReadConfig() throws IOException {
		File f = new File(filePath);
		FileInputStream fin = new FileInputStream(f);
		prop = new Properties();
		prop.load(fin);
		
	}
	
	public String getUrl() {
		return prop.getProperty("url");
	}


}
