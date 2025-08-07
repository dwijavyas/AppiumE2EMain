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

public class AppiumTest4 extends BaseTest{
	
	
	@Test
	public void Swipe() throws MalformedURLException, InterruptedException {
		
		//AppiumBy - ClassName, accesibilitID, androidUIautomator
		//By - xpath, id
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		//click on Gallery
		driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
		Thread.sleep(2000);
		
		//click on photos
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"1. Photos\"]")).click();
		Thread.sleep(2000);
		
		WebElement firstImage = driver.findElement(By.xpath("//(android.widget.ImageView)[1]"));
		Assert.assertEquals(firstImage.getAttribute("focusable"),"true");
		
		swipeGesture(firstImage,"left");
		
		//after Swipe
		Assert.assertEquals(firstImage.getAttribute("focusable"),"false");

	}

}
