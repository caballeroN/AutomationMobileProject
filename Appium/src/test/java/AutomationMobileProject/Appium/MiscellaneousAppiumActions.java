package AutomationMobileProject.Appium;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class MiscellaneousAppiumActions extends BaseTest{
	
	@Test
	
	public void Miscellaneous() throws MalformedURLException {
		
		//App package & App Activity
		
		//command: adb shell dumpsys | find "mCurrentFocus" (for Windows)
		//format: package/activity
	
		Activity activity = new Activity("io.appium.android.apis", "io.appium.android.apis.preference.PreferenceDependencies");
		driver.startActivity(activity);
		
		/*These steps are no more required: 
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();*/
		driver.findElement(By.id("android:id/checkbox")).click(); 
		
		//Rotate screen
		DeviceRotation landscape = new DeviceRotation(0, 0, 90);
		driver.rotate(landscape);
		
		driver.findElement(By.xpath("(//android.widget.RelativeLayout) [2]")).click();
		
		String alertTittle = driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(alertTittle,"WiFi settings");
		
		//Copy to clipboard - paste to clipboard
	
		driver.setClipboardText("NoeliaWifi");
		driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
		
		driver.pressKey(new KeyEvent(AndroidKey.ENTER)); //Press Enter Key
		
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
		
		driver.pressKey(new KeyEvent(AndroidKey.BACK)); //Press Back Key
		driver.pressKey(new KeyEvent(AndroidKey.HOME)); //Press Home Key
		
		
	}
}
