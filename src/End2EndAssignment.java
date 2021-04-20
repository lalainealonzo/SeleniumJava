import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class End2EndAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "//Users//lalainealonzo//Documents//Drivers//chromedriver");
		WebDriver driver = new ChromeDriver();

		// Go to www.cleartrip.com
		driver.get("https://www.cleartrip.com/");

		driver.manage().window().maximize();

		// Select any Adult and Children # in their static dropdowns
		Select selectAdult = new Select(driver.findElement(By.id("Adults")));
		selectAdult.selectByIndex(1);

		Select selectChildren = new Select(driver.findElement(By.id("Adults")));
		selectChildren.selectByValue("3");

		// Select on "Depart On" Calendar (Today's date)
		driver.findElement(By.id("DepartDate")).click();
		driver.findElement(By.cssSelector("a[class*='ui-state-highlight']")).click();

		// Click "> more options..."
		driver.findElement(By.id("MoreOptionsLink")).click();

		// Enter Preferred Airline - autocomplete dropdown
		driver.findElement(By.id("AirlineAutocomplete")).sendKeys("Blue"); // Look for Air Blue (PA)

		List<WebElement> options = driver.findElements(By.cssSelector("li[class='list'] a"));

		for (WebElement option : options) {
			if (option.getText().equalsIgnoreCase("Air Blue (PA)")) {
				option.click();
			}
		}

		// Click Search Flights
		driver.findElement(By.id("SearchBtn")).click();

		// Grab error message and print
		String errorMsg = driver.findElement(By.id("homeErrorMessage")).getText();
		System.out.println(errorMsg); // Sorry, but we can't continue until you fix everything that's marked in RED

	}

}
