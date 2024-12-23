package genericutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * @author Debashish
 */

public class FileUtility {
	
	/**
	 * This method will return value from the property file
	 * This method takes key as an argument
	 * @param key
	 * @return key
	 * @return value
	 * @throws IOException
	 */
	
	public String getDataFromProperty(String key) throws IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/Testdata/commondata.properties");
		Properties prop = new Properties();
		prop.load(fis);
		return prop.getProperty(key);
	}
}
