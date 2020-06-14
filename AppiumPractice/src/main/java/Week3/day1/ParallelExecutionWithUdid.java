package Week3.day1;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class ParallelExecutionWithUdid {
	
@Test
public void launchApplication() throws MalformedURLException {
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability("appPackage", "com.android.contacts");
		dc.setCapability("appActivity", "com.android.contacts.activities.TwelveKeyDialer");
		dc.setCapability("deviceName", "Redmi8Dual");
		dc.setCapability("platformName", "Android");
		dc.setCapability("udid", "43d888db0906");
		
		
		AndroidDriver<WebElement> driver=new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
		
		System.out.println("system launched successfully");

	}

}
