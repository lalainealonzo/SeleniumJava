import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestCase3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//create driver object for IE browser. NOT WORKING IN MAC, requires addtl setup
		System.setProperty("webdriver.ie.driver", "//Users//lalainealonzo//Documents//Drivers//geckodriver");
		WebDriver driver = new InternetExplorerDriver();
		
		driver.get("https://www.google.com/"); //visit URL
		System.out.println(driver.getTitle()); //Get page title
		
	}

}
