package appiumBasics;

import java.net.MalformedURLException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class AppiumTest5 extends BaseTest{
	
	
	@Test
	public void dragAndDrop() throws MalformedURLException, InterruptedException {
		
	
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		
		driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
		Thread.sleep(2000);
		
		WebElement ele1 = driver.findElement(By.xpath("//android.view.View[@resource-id='io.appium.android.apis:id/drag_dot_1']"));
		
		// Java
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
		    "elementId", ((RemoteWebElement) ele1).getId(),
		    "endX", 833,
		    "endY", 745
		));
		
		String result = driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText();
		Assert.assertEquals(result, "Dropped!");
		
	}

}
