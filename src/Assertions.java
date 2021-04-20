import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assertions {
	
	//TestNG is one of the testing framework which will be used when building selenium

	public static void main(String[] args) throws InterruptedException {
		
		//Assertion to compare expected with actual results
		//No need to check in console using print
		
		System.setProperty("webdriver.chrome.driver", "//Users//lalainealonzo//Documents//Drivers//chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.manage().window().maximize();
		
		//Assert - checkbox is false
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		Assert.assertFalse(false);
		
		//Click checkbox
		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click(); //* any id with SeniorCitizenDiscount
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		Assert.assertTrue(true);

		
		//count size of checkboxes
		//find the common locator of the checkboxes
		int checkboxSize = driver.findElements(By.cssSelector("input[type='checkbox']")).size();
		System.out.println(checkboxSize);
		
		//Currency - tagname is Select
		WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")); //dropdown element
				
		Select selectObj = new Select(staticDropdown); //create object of the Select Class. using object you will be able to use methods of the Select class.

		selectObj.selectByIndex(2); //AED Select by Index
		String selectedOption = selectObj.getFirstSelectedOption().getText(); //returns the webelement of the selected option
		System.out.println(selectedOption);
				
		selectObj.selectByValue("USD"); //USD Select by Value
		String selectedOption2 = selectObj.getFirstSelectedOption().getText(); //returns the webelement of the selected option
		System.out.println(selectedOption2);
				
		selectObj.selectByVisibleText("INR"); //INR Select by Visible Text
		String selectedOption3 = selectObj.getFirstSelectedOption().getText(); //returns the webelement of the selected option
		System.out.println(selectedOption3);
				
		//Passengers - tagname is div
		driver.findElement(By.id("divpaxinfo")).click(); //Passenger dropdown
		Thread.sleep(2000L);
				
		int cnt = 0;
		while(cnt<3) //while true
		{
			driver.findElement(By.id("hrefIncAdt")).click(); //Click plus icon in Adult 3 times. Outcome should be 4.
			cnt++;
		}
				
		driver.findElement(By.id("btnclosepaxoption")).click(); //Click Done
		
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		
		//Assert.assertEquals(actual, expected);
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "4 Adult");
				
		
		
		
		//driver.close();

	}

}
