package week2.day2;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class SwitchBetWeenApp {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability("appPackage", "com.whatsapp");
		dc.setCapability("appActivity", "com.whatsapp.HomeActivity");
		dc.setCapability("deviceName", "Redmi8Dual");
		dc.setCapability("platformName", "Android");
		dc.setCapability("automationName", "UiAutomator2");
		dc.setCapability("noReset", true);
		
		AndroidDriver<WebElement> driver=new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		Thread.sleep(2000);
		driver.findElementByAccessibilityId("Search").click();
		Thread.sleep(2000);
		driver.findElementById("com.whatsapp:id/search_src_text").sendKeys("MM");
		Thread.sleep(2000);
		driver.findElementById("com.whatsapp:id/conversations_row_contact_name").click();
		Thread.sleep(2000);
		
		//switch whatsapp to MMS Application
	    driver.startActivity(new Activity("com.android.mms","com.android.mms.ui.MmsTabActivity")); 
	    	    
	    Thread.sleep(2000);
	    
	  //Switch MMS to whatsapp Application
	    driver.startActivity(new Activity("com.whatsapp","com.whatsapp.HomeActivity")); 
		System.out.println("successfully switched between two Application");
		

	}

}
