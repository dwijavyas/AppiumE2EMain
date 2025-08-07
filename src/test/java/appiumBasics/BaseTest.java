package appiumBasics;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {

	public AppiumDriverLocalService service;
	public AndroidDriver driver;
	public UiAutomator2Options options;
	
	@BeforeClass()
	public void config() throws MalformedURLException, URISyntaxException {
		
		service = new AppiumServiceBuilder()
			.withAppiumJS(new File("C://Users//dwija//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
			.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();
				
		options = new UiAutomator2Options();
		options.setDeviceName("DwijaEmulator");
		options.setPlatformName("Android");
		options.setApp("C://Users//dwija//eclipse-workspace//AppiumE2EMain//src//test//java//resources//ApiDemos-debug.apk");
				
		driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	
	public void lpGesture(WebElement menuOption) {
		
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", 
				ImmutableMap.of("elementId",((RemoteWebElement)menuOption).getId(),
				"duration", 2000));
		
		
	}
	
	
	public void scrollAnywhereGesture() {
	
		// Java
		boolean canScrollMore ;
		do{
			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
		
		    "left", 100, "top", 100, "width", 200, "height", 200,
		    "direction", "down",
		    "percent", 3.0
		));
	}while(canScrollMore);
		
	}
	
	public void swipeGesture(WebElement ele, String direction) {
		
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement)ele).getId(),
			    "direction", direction,
			    "percent", 0.25
			));
	}
	
	
	
	
	@AfterClass()
	public void tearDown() {
		
		
		driver.quit();
		service.stop();
		
	}
	
	
}
