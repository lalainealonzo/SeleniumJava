import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicDropdowns {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "//Users//lalainealonzo//Documents//Drivers//chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//Dynamic dropdowns - options are loaded only after typing in the dropdown
		
		
		//FROM / Departure City
		
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click(); //click Departure dropdown
		driver.findElement(By.xpath("//a[@value='BLR']")).click(); //click BLR
		
		Thread.sleep(2000);
		
		//TO / Arrival City
		
		//Arrival City opens by default - no need to click the second dropdown
		driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click(); //click BLR
		
		//Problem with dynamics: 
		//a[@value='MAA'] - will return 2 nodes because this value is also present in FROM dropdown.
		//To select 'MAA' in the TO dropdown (second dropdown), add index
		//Syntax: (//a[@value='MAA'])[2]
		
		//pull a request to merge your code in the main branch

	}

}
