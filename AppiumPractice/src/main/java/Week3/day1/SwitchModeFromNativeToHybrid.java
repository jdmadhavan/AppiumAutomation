package Week3.day1;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class SwitchModeFromNativeToHybrid {

	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability("appPackage", "com.testleaf.leaforg");
		dc.setCapability("appActivity", "com.testleaf.leaforg.MainActivity");
		dc.setCapability("deviceName", "Redmi8Dual");
		dc.setCapability("platformName", "Android");
		dc.setCapability("automationName", "UiAutomator2");
		dc.setCapability("noReset", true);
		
		AndroidDriver<WebElement> driver=new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
	   driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	   
	   driver.findElementByXPath("(//android.widget.EditText)[1]").sendKeys("rajkumar@testleaf.com");
	   driver.findElementByXPath("(//android.widget.EditText)[2]").sendKeys("Leaf@123");
	   
	   Set<String> contextHandles = driver.getContextHandles();
	   for (String modes:contextHandles)
	   {
		   System.out.println(modes);
	   }
	   
	   driver.context("WEBVIEW_com.testleaf.leaforg");
	   
	   
	   driver.findElementByXPath("//input[@placeholder='Email']").clear();

	}

}
