import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;

public class TakeScreenshots {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "//Users//lalainealonzo//Documents//Drivers//chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//cast the driver to take screenshot
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);//get the output as a file format
		//copy file from src object to a path
		FileUtils.copyFile(src, new File("//Users//lalainealonzo//Documents//TakeScreenshots//screenshot.png")); //should have access on the path
		//import package: import org.apache.commons.io.FileUtils;
	}

}
