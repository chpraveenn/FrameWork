package reusableComponents;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;



public class PropertiesOperations {
	
	static Properties prop = new Properties();
	public static String getPropertyValueByKey(String key) throws Exception{
		
		String propPath = System.getProperty("user.dir")+"/src/test/resources/config.properties";
		FileInputStream fis = new FileInputStream(propPath);
		
		prop.load(fis);
		String value = prop.get(key).toString();
		if(StringUtils.isEmpty(value)) {
			throw new Exception("Value Not Specified for the key"+key+"in properites file");
		}
		
		return value;
	}

}
