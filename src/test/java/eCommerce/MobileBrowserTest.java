package eCommerce;

import java.net.MalformedURLException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class MobileBrowserTest extends MobileBrowserBaseTest{
	
	
	@Test
	public void mobileChrome() throws MalformedURLException, InterruptedException {
		
	driver.get("http://google.com");
	System.out.println(driver.getTitle());
	driver.findElement(By.name("q")).sendKeys("rahul shetty");
	driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		
		
		
	}

}
