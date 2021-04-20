import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Pagination {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "//Users//lalainealonzo//Documents//Drivers//chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		//Click the column header to sort 
		driver.findElement(By.xpath("//tr/th[1]")).click(); //Veg/fruit name column - click to sort the column
		
		
		
		List<String> price;
		String veggie = "GGG";
		
		do {
			//capture all webelements of Veggies column into list
			List<WebElement> list = driver.findElements(By.xpath("//tr/td[1]"));
			
			//Scan the veggie column with getText -> Potato -> print the price of the veggie
			price = list.stream()	//list = //tr/td[1]
					.filter(s -> s.getText().contains(veggie)) //check for Potato's Price only
					.map(s -> getPriceVeggie(s))	//priceValue	//map will help in modifying stream filter results
					.collect(Collectors.toList());
		
			price.forEach(a -> System.out.println(a)); //print the price of the veggie
		
			//to search on the next page, if Filter not on the current page
			if(price.size()<1) //if Potato is not in the current page, size is 0
			{
				if (driver.findElement(By.cssSelector("[aria-label='Next']")).getAttribute("aria-disabled").contains("true"))
				{
					System.out.println("No such veggie item \"" 
							+ veggie + "\" in the table"); //if Next button is now disabled/user is in the last page
					break;
				}
				else
				{
				driver.findElement(By.cssSelector("[aria-label='Next']")).click(); //click next button to search Potato in next page
				}
			}
		
		} while (price.size()<1); //do while true (while potato is not found)

	}
	
	private static String getPriceVeggie(WebElement s) {
		
		// //tr/td[1]  /following-sibling::td[1] - Price
		String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return priceValue;
	}

}
