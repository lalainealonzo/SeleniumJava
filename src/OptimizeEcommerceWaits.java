import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OptimizeEcommerceWaits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "//Users//lalainealonzo//Documents//Drivers//chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS); //Implicit Wait for max of 5 seconds. should apply on each line of code/globally

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		// Search and add multiple items in the cart
		// Have an array with the list of products you want to add to cart

		// Array of Products
		String itemsNeeded[] = { "Cucumber", "Brocolli", "Beetroot", "Carrot" };
		
		//OptimizeEcommerceWaits ec = new OptimizeEcommerceWaits();  //if the method that will be called is static, no need for object declaration
		addItems(driver, itemsNeeded); //send driver, array declared
		
		driver.findElement(By.cssSelector("img[alt='Cart']")).click(); //open cart
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click(); //click checkout
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy"); //input promo code at checkout page
		driver.findElement(By.xpath("//div[@class='promoWrapper']/button[@class='promoBtn']")).click(); //click apply button
		
		//explicit wait
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
		
		//driver.close();
		
	}

	public static void addItems(WebDriver driver, String itemsNeeded[]) { // pass the driver in the method, itemsNeeded array

		// Iterate each index. put products in the list
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

		int j = 0;

		// searching for 1 product name only
		for (int i = 0; i < products.size(); i++) // iterate to all the products
		{

			// get 1 particular value then getText. extracting 0 index for the first time
			String[] product = products.get(i).getText().split("-");
			String formattedProduct = product[0].trim(); // to remove space before the dash

			// check whether the item you extracted is present in the array
			// convert array into ArrayList for easy search
			List<String> itemsNeededList = Arrays.asList(itemsNeeded);

			if (itemsNeededList.contains(formattedProduct)) // if the product(h4.product-name) is in the list, click Add
															// to Cart. then loop
			{
				// click add to cart
				driver.findElements(By.xpath("//div[@class = 'product-action']/button")).get(i).click();
				j++;

				if (j == itemsNeeded.length) 
				{
					break;
				}
			}

		}
	}

}
