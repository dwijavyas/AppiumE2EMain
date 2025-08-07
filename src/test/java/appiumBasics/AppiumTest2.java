package appiumBasics;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class AppiumTest2 extends BaseTest{
	
	
	
	@Test
	public void longPressTest() throws MalformedURLException, URISyntaxException, InterruptedException {
		
		
		//xpath, id, accessibilityID, classname, androidUIAutomator, //tagname
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='Expandable Lists']")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
		WebElement menuOption = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
		lpGesture(menuOption);
		Thread.sleep(2000);
		String menu = driver.findElement(By.id("android:id/title")).getText();
		Assert.assertEquals(menu, "Sample menu");
		Assert.assertTrue(driver.findElement(By.id("android:id/title")).isDisplayed());
		

	}

}
