package eCommerce;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class TC3 extends BaseTest{
	@Test
	public void fillForm() throws InterruptedException {
		
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("dwija");
		driver.hideKeyboard();
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title"))
				, "text", "Cart"));
		
		double totalSum = 0;
		List<WebElement> prodPrices = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
		
		for(int i=0;i<prodPrices.size();i++){
			
			
			String price = prodPrices.get(i).getText();
			double amount = Double.parseDouble(price.substring(1));
			
			totalSum = totalSum + amount;
			
		}
			
		String purchaseAmount = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		double totalPurchaseAmt = Double.parseDouble(purchaseAmount.substring(1));
		
		
			System.out.println("total sum of prices:" +totalSum);
			
			Assert.assertEquals(totalSum, totalPurchaseAmt);
	
		WebElement ele = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		lpGesture(ele);
		
		driver.findElement(By.id("android:id/button1")).click();
		driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		Thread.sleep(2000);
		//web browser open google page
		
			
			
			
			
			
	
	}
	
	
	
}
