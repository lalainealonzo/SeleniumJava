import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarSpecDate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "//Users//lalainealonzo//Documents//Drivers//chromedriver");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.path2usa.com/travel-companions");
		driver.getTitle();

		// Select a day from the calendar
		driver.findElement(By.id("travel_date")).click();



		WebElement monthYear = driver
				.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")); // month year
																										// picker

		while (!monthYear.getText().contains("August")) // get text check if it contains August. while(false)
		// ! negation to change true to false, vice versa
		{
			driver.findElement(By.cssSelector("[class='datepicker-days'] th[class='next']")).click(); // click next(>>) while text
																								// does not contain
																								// August
		}

		// List<WebElement> dates = driver.findElements(By.className("day")); //day is
		// the common attribute of the days

		int count = driver.findElements(By.className("day")).size(); // day is the common attribute of the days
		
		for (int i = 0; i < count; i++) {
			String day = driver.findElements(By.className("day")).get(i).getText(); // get 23

			if (day.equalsIgnoreCase("23")) // sample day 23
			{
				driver.findElements(By.className("day")).get(i).click(); // if 23, click the date
				break;
			}
		}

		// When working on calendar:
		// Grab common attribute
		// Put in a list
		// Iterate

	}

}
