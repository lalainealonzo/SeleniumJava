import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scroll {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "//Users//lalainealonzo//Documents//Drivers//chromedriver");
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//use javascript executor to scroll
		JavascriptExecutor js = (JavascriptExecutor)driver; //js object
		
		//go to console > window.scrollBy(0,500) - to scroll main window
		//go to console > call dom document > document.querySelector(".tableFixHead") - put which element you want to focus upon scrolling
		//document.querySelector(".tableFixHead").scrollTop=5000 - to scroll to up
		
		//provide Javascript to scroll
		js.executeScript("window.scrollBy(0,500)"); //scroll on window level
		Thread.sleep(3000);
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000"); //scroll on specific element level - table level
	
	}

}
