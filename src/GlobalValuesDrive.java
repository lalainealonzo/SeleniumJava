import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class GlobalValuesDrive {
	
	public static void main(String[] args) throws IOException {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("//Users//lalainealonzo//eclipse-workspace//SeleniumJavaProject//src//data.properties");
		prop.load(fis); //object has knowledge where properties file is located
		prop.getProperty("browser");
		prop.getProperty("url");
		prop.setProperty("browser", "firefox"); //when setting new property
		
		//to write back new property to the file
		FileOutputStream fos = new FileOutputStream("//Users//lalainealonzo//eclipse-workspace//SeleniumJavaProject//src//data.properties");
		prop.store(fos, null);
		
	}

}
