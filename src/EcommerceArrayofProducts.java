import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EcommerceArrayofProducts {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "//Users//lalainealonzo//Documents//Drivers//chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		Thread.sleep(3000);
		
		// //button[text()='ADD TO CART'] - 30 elements matching
		//identify complete product block uniquely
		//get CSS based on class name - tag.classname
		//h4.product-name - 30 elements matching
		//take all the product-name then iterate each item in the product-name
		
		/*
		//WebElement is the return type of the products
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		
		//searching for 1 product name only
		for (int i = 0; i<products.size(); i++) //iterate to all the products
		{
			String product = products.get(i).getText(); //will get 1 particular value then getText. extracting 0 index for the first time 
			
			if (product.contains("Cucumber"))
			{
				//click add to cart
				driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click(); //get i = index of cucumber
				break; //if cucumber is already found, stop the loop. do not use break if getting multiple products 
			}
		}
		*/
		
		//Search and add multiple items in the cart
		//Have an array with the list of products you want to add to cart
		
		//Array of Products
		String itemsNeeded[] = {"Cucumber", "Brocolli", "Beetroot", "Carrot"};
		
		//Iterate each index. put products in the list
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		
		int j = 0;
		
		//searching for 1 product name only
		for (int i = 0; i<products.size(); i++) //iterate to all the products
		{
			//get 1 particular value then getText. extracting 0 index for the first time 
			String[] product = products.get(i).getText().split("-"); 
			String formattedProduct = product[0].trim(); //to remove space before the dash
			//product will return whole text (e.g. Cucumber - 1 Kg)
			//use split
			//product[0] = Cucumber - value needed
			//product[1] = 1 Kg
			
			//check whether the item you extracted is present in the array
			//convert array into ArrayList for easy search
			List<String> itemsNeededList = Arrays.asList(itemsNeeded);
			
			if (itemsNeededList.contains(formattedProduct)) //if the product(h4.product-name) is in the list, click Add to Cart. then loop
			{
				//click add to cart
				//text locator is not suggested as sometimes, it changes when clicked (e.g. from 'Add to Cart' to 'Added')
				//driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click(); //get i = index of cucumber
				driver.findElements(By.xpath("//div[@class = 'product-action']/button")).get(i).click();
				j++;
				
				if(j == itemsNeeded.length)
				{
					break;
				}
			}
			
			//Thread.sleep(5000);
		}
		
		System.out.println(itemsNeeded.length);
		System.out.println(j);
		
		driver.close();
		

	}

}
