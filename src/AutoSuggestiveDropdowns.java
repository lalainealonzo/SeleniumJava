import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestiveDropdowns {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "//Users//lalainealonzo//Documents//Drivers//chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.manage().window().maximize();
		
		//Auto Suggestive Dropdowns - while you input, suggestions are displayed
		
		driver.findElement(By.id("autosuggest")).sendKeys("Ind"); //Select India
		Thread.sleep(3000);
		
		//figure out generic indicator of the suggested texts
		//li[class='ui-menu-item'] - 3 items:
		//British Indian Ocean Territory
		//India
		//Indonesia
		//li[class='ui-menu-item'] a - tagname a
		
		//List of WebElements. put into one variable
		List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));

		//Iterate each option to check if matches the inputted text
		
		for(WebElement option:options) //every iteration, pick 1 option from options variable
		{
			if(option.getText().equalsIgnoreCase("India")) //get text to extract the suggested text one by one then if the text is equal to "India", perform click();
			{
				option.click();
			}
		}
	}

}
