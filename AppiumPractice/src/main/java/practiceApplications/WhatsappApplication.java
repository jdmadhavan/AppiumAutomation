package practiceApplications;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class WhatsappApplication {

	public static void main(String[] args) throws InterruptedException, MalformedURLException {
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
        driver.findElementById("com.whatsapp:id/entry").sendKeys("sending message from Code");
        Thread.sleep(2000);
        driver.findElementByAccessibilityId("Send").click();
        System.out.println("Successfully sent Message");
	}
	

}
