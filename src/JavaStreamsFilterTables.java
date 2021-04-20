import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class JavaStreamsFilterTables {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Goal is to see if search results returns correct results with the string entered in the Searchbox
		
		System.setProperty("webdriver.chrome.driver", "//Users//lalainealonzo//Documents//Drivers//chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		String item = "Che";
		
		//Enter the string
		driver.findElement(By.id("search-field")).sendKeys(item);
		
		//create a list for the column 1 containing veggies
		List<WebElement> searchResults = driver.findElements(By.xpath("//tr/td[1]"));
		
		List<WebElement> filteredList = searchResults.stream()
			.filter(veggie -> veggie.getText().contains(item)) //check if search results contains the searched Text. filter by the search criteria
			.collect(Collectors.toList()); //convert match items into list
		
		//print the filteredList
		filteredList.stream().map(list -> list.getText()).forEach(list -> System.out.println(list));
		
		Assert.assertEquals(searchResults.size(), filteredList.size());

	}

}
