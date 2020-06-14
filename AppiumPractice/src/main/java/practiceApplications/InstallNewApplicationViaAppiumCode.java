package practiceApplications;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class InstallNewApplicationViaAppiumCode {

	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability("deviceName", "Redmi8Dual");
		dc.setCapability("platformName", "Android");
		
		dc.setCapability("app", "C:\\Users\\vc\\Downloads\\leaforg.apk");

		
		
	AndroidDriver<WebElement> driver= new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
	System.out.println("sucesssfully installed");
	
	}

}
