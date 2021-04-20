import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "//Users//lalainealonzo//Documents//Drivers//chromedriver");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://www.amazon.com/");

		WebElement accountAndList = driver
				.findElement(By.xpath("//div[@id='nav-tools']/a[@id='nav-link-accountList']"));
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));

		Actions action = new Actions(driver); // interactions Action Class

		action.moveToElement(searchBox) // move to search box
				.click().keyDown(Keys.SHIFT) // action method, SHIFT key
				.sendKeys("product") // type the product you're looking for
				.doubleClick() // double click to select the text entered
				.build().perform();

		action.moveToElement(accountAndList) // move to accounts & list then mouse hover
				.contextClick() // right click
				.build().perform();// builds the step then perform this build
		

	}

}
