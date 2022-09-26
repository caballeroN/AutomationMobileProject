package AutomationMobileProject.Appium;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class AppiumBasics extends BaseTest{
	
	@Test
	
	public void WiFiSettingsName() throws MalformedURLException {
	
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		driver.findElement(By.xpath("(//android.widget.RelativeLayout) [2]")).click();
		
		String alertTittle = driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(alertTittle,"WiFi settings");
	
		driver.findElement(By.id("android:id/edit")).sendKeys("NoeliaWifi");
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
	}
}
