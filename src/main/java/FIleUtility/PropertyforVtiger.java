package FIleUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyforVtiger
{
	public String getInputData(String key) throws IOException
	{
		FileInputStream fis = new FileInputStream("src\\test\\resources\\Loginvtiger.properties");
		Properties p = new Properties();
		p.load(fis);
		return p.getProperty(key); 
	}
}
