package practiceApplications;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class ChangeScreenOrientation {

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
		
		String orientation = driver.getOrientation().toString();
		System.out.println(orientation);
		driver.rotate(ScreenOrientation.LANDSCAPE);
      
		String orentation1=driver.getOrientation().toString();
		driver.rotate(ScreenOrientation.PORTRAIT);
		System.out.println(orentation1);

	}

}
