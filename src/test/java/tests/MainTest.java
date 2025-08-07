package tests;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import pages.CartPage;
import pages.FormPage;
import pages.ProductsPage;
import testComponents.BaseTest;

public class MainTest extends BaseTest{

	@Test
	public void maintest() throws InterruptedException {
	
		fp.setNameField("dwija");
		fp.setGender("female");
		fp.setCountrySelection("Argentina");
		ProductsPage pp = fp.submitForm();
		pp.addItemToCartByIndex(0);
		pp.addItemToCartByIndex(0);
		CartPage cp = pp.goToCartPage();
		
		//Thread.sleep(2000);
//	WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(5));
//wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")),"text" , "Cart"));
		double totalSum = cp.getProductsSum();
		double displayFormattedSum = cp.getTotalAmountDisplayed();
		Assert.assertEquals(totalSum, displayFormattedSum);
		cp.acceptTermsConditions();
		cp.submitOrder();
	
	
	
	
	}
	
}
