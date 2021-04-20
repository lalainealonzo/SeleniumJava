import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TablesAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Print # of Rows
		//Print # of Cols
		//Print Row 2 content
		
		System.setProperty("webdriver.chrome.driver", "//Users//lalainealonzo//Documents//Drivers//chromedriver");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scroll(0,600)");
		
		//table[name='courses'] tr - rows
		//table[name='courses'] th - cols
		
		int rowsCount = driver.findElements(By.cssSelector("table[name='courses'] tr")).size();
		int colsCount = driver.findElements(By.cssSelector("table[name='courses'] th")).size();
		
		System.out.println("No. of rows: " + rowsCount);
		System.out.println("No. of rows: " + colsCount);
		
		//table[name='courses'] tr:nth-child(3) - row to be printed
		String printRow = driver.findElement(By.cssSelector("table[name='courses'] tr:nth-child(3)")).getText();
		System.out.println(printRow);
		
		//another solution to print row 2
		WebElement table=driver.findElement(By.id("product"));
		List<WebElement> secondrow=table.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"));

		System.out.println(secondrow.get(0).getText());
		System.out.println(secondrow.get(1).getText());
		System.out.println(secondrow.get(2).getText());



	}

}
