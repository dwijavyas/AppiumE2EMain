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

public class AppiumTest3 extends BaseTest{
	
	
	@Test
	public void Scrolling() throws MalformedURLException, InterruptedException {
		
		//AppiumBy - ClassName, accesibilitID, androidUIautomator
		//By - xpath, id
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		//where we have idea of where to scroll
		//to scroll in android  mobile - need to inspect elements in google engine - so use androidUiautomator - create class(argument(method(text);));
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
		Thread.sleep(2000);
		
		//no idea of where to scroll
		//scrollAnywhereGesture();
		

	}

}
