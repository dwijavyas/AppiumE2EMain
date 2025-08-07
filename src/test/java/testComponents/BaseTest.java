package testComponents;

import java.io.File;
import java.time.Duration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import pages.FormPage;

public class BaseTest {

	
	public AppiumDriverLocalService service;
	public UiAutomator2Options options;
	public AndroidDriver driver;
	public FormPage fp;
	
	
	@BeforeClass()
	public void config() {
		
	service = new AppiumServiceBuilder()
			.withAppiumJS(new File("C://Users//dwija//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
			.withIPAddress("127.0.0.1").usingPort(4723).build();
	
	service.start();
			
			
	options = new UiAutomator2Options();
	options.setPlatformName("Android");
	options.setDeviceName("DwijaEmulator");
	options.setApp("C:\\Users\\dwija\\eclipse-workspace\\AppiumE2EMain\\src\\test\\java\\resources\\General-Store.apk");
	options.setChromedriverExecutable("C:\\Users\\dwija\\Documents\\Selenium\\chromedriver 113\\chromedriver.exe");
		
	driver = new AndroidDriver(options);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
	fp = new FormPage(driver);
		
	}
	
		
	
	
	@AfterClass()
	public void tearDown() {
		
	driver.quit();
	service.stop();
		
		
		
	}
	
	
	
	
}
