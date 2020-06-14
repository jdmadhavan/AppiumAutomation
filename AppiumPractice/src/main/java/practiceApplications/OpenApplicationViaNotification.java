package practiceApplications;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class OpenApplicationViaNotification {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability("appPackage", "com.miui.home");
		dc.setCapability("appActivity", "com.miui.home.launcher.Launcher");
		dc.setCapability("deviceName", "Redmi8Dual");
		dc.setCapability("platformName", "Android");
		dc.setCapability("automationName", "UiAutomator2");
		dc.setCapability("noReset", true);
		
	
		AndroidDriver<WebElement> driver=new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.openNotifications();
		
		Thread.sleep(2000);
	     String text=driver.findElementByXPath("//*[@text='MM']").getText();
		
System.out.println(text);
driver.findElementByXPath("//*[@text='MM']").click();
System.out.println("Intracted successfull");

	}

}
