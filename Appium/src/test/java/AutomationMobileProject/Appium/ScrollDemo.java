package AutomationMobileProject.Appium;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;

public class ScrollDemo extends BaseTest{
	
	@Test
	
	public void Scroll() {
	
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		ScrollAction("WebView");
		
		
		
	}
}
