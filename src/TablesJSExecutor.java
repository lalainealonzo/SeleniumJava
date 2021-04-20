import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TablesJSExecutor {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "//Users//lalainealonzo//Documents//Drivers//chromedriver");
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//User JavascriptExecutor to find hidden elements
		//use javascript executor to scroll
		JavascriptExecutor js = (JavascriptExecutor)driver; //js object to execute a javascript in the browser
		
		//go to console > window.scrollBy(0,500) - to scroll main window
		//go to console > call dom document > document.querySelector(".tableFixHead") - put which element you want to focus upon scrolling
		//document.querySelector(".tableFixHead").scrollTop=5000 - to scroll to up
		
		//provide Javascript to scroll
		js.executeScript("window.scrollBy(0,500)"); //scroll on window level
		Thread.sleep(3000);
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000"); //scroll on specific element level - table level
		
		//td - 4th column
		List <WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)")); //td - 4th column
		
		int sum = 0; 
		for(int i=0; i<values.size(); i++)
		{
			//sum values in column 4 of the table
			sum = sum + Integer.parseInt(values.get(i).getText());//get 1 each iteration //convert string to int
		}
		System.out.println(sum);
		
		//get total displayed in the window then compare with the values summed up above
		int total = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim()); 
		
		System.out.println(sum);
		
		Assert.assertEquals(sum, total); //pass

	}

}
