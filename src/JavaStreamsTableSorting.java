import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class JavaStreamsTableSorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "//Users//lalainealonzo//Documents//Drivers//chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		//Click the column header to sort 
		driver.findElement(By.xpath("//tr/th[1]")).click(); //Veg/fruit name column - click to sort the column
		
		//capture all webelements into list
		List<WebElement> list = driver.findElements(By.xpath("//tr/td[1]"));
		
		//capture text of all webelements into new (original) list
		List<String> originalList = list.stream()
			.map(s -> s.getText()).collect(Collectors.toList());
		
		//Sort the original list -> sorted list
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
		
		//Compare original list vs sorted list
		Assert.assertTrue(originalList.equals(sortedList)); //true
		
		//Scan the veggie column with getText -> Beans -> print the price of the veggie
		List<String> price = list.stream()					//list = //tr/td[1]
			.filter(s -> s.getText().contains("Beans"))
			.map(s -> getPriceVeggie(s))	//priceValue	//map will help in modifying stream filter results
			.collect(Collectors.toList());
		
		price.forEach(a -> System.out.println(a));
		

	}

	private static String getPriceVeggie(WebElement s) {
		
		// //tr/td[1]/following-sibling::td[1] - Price
		String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return priceValue;
	}

}
