package eCommerceApp;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;


public class eCommerce_ComparePrice extends BaseTestGeneralStoreapk{
	
	@Test
	
	public void FillForm() throws InterruptedException {
		//Fill name
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Noelia Caballero");
				
		//Hide Keyboard
		driver.hideKeyboard();
				
		//Select gender
		driver.findElement(By.xpath("//android.widget.RadioButton[@text = 'Female']")).click();
				
		//Select country element
		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
				
		//Scroll until Argentina and click on this option
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text = 'Argentina']")).click();
				
		//Click on Lets shop button
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
				
		//Select products
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click(); //I select 0 index because when I click on ADD TO CART on the previous step, the text changes to ADDED TO CART		
		
		//Go to the cart
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
				
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart")); //expected: web element, attribute, value of attribute
				
		// Add a list for add all the prices
		List<WebElement> productPrices = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
		int totalOfProducts = productPrices.size();
		double sum = 0;
		
		for(int i=0; i<totalOfProducts; i++) {
			
			String amount = productPrices.get(i).getText();
			Double price = getFormattedAmount(amount);
			sum = sum + price;
		}
		//Compare product
		String displaySum = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		Double displaFormattedSum = getFormattedAmount(displaySum);
		Assert.assertEquals(sum, displaFormattedSum);
				
				
				
	}
	

}