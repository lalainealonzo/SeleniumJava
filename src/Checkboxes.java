import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Checkboxes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "//Users//lalainealonzo//Documents//Drivers//chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click(); //* any id with SeniorCitizenDiscount
		Boolean selected = driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected();
		System.out.println(selected); //true
		
		//count size of checkboxes
		//find the common locator of the checkboxes
		int checkboxSize = driver.findElements(By.cssSelector("input[type='checkbox']")).size();
		System.out.println(checkboxSize);
		
		
		driver.close();
	}

}
