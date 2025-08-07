package appiumBasics;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class AppiumTest1 extends BaseTest{
	
	
	
	@Test
	public void wifiTest() throws MalformedURLException, URISyntaxException {
		
		
		//xpath, id, accessibilityID, classname, androidUIAutomator, //tagname
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\'3. Preference dependencies']")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		DeviceRotation landscape = new DeviceRotation(0,0,90);
		driver.rotate(landscape);
		driver.findElement(AppiumBy.xpath("(//android.widget.RelativeLayout)[2]")).click();
		String wifiBox = driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals("WiFi settings", wifiBox);
		driver.setClipboardText("dv");
		driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
	

	}

}
