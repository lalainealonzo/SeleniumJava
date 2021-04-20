import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class AutoSuggestDropdownAssignment {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "//Users//lalainealonzo//Documents//Drivers//chromedriver");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

		String country = "India";

		WebElement autoSuggestDropdown = driver.findElement(By.id("autocomplete"));
		autoSuggestDropdown.click();
		autoSuggestDropdown.sendKeys("Ind");
		Thread.sleep(3000);

		List<WebElement> suggestions = driver
				.findElements(By.xpath("//li[@class='ui-menu-item']/div"));
		
		for (int i=0; i<suggestions.size(); i++)
		{
			String suggestion = suggestions.get(i).getText();
			if (suggestion.equalsIgnoreCase(country))
			{
				suggestions.get(i).click();
				break;
			}
			
		}

		//Another option for iteration
		/*
		for (WebElement suggestion : suggestions) {
			if (suggestion.getText().equalsIgnoreCase(country)) {
				suggestion.click();
				break;
			}
		}
		*/
		Assert.assertEquals(autoSuggestDropdown.getAttribute("value"), country);

		//from assignment
		/*
		driver.findElement(By.id("autocomplete")).sendKeys("ind");
		Thread.sleep(2000);
		driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
		driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
		System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value"));
		*/
		
		driver.close();
	}

}
