import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestCase2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//create driver object for firefox browser
		System.setProperty("webdriver.gecko.driver", "//Users//lalainealonzo//Documents//Drivers//geckodriver");
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.google.com/"); //visit URL
		System.out.println(driver.getTitle()); //Get page title
		
	}

}
