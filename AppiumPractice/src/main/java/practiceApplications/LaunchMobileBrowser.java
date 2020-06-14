package practiceApplications;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class LaunchMobileBrowser {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("browserName", "chrome");
		dc.setCapability("deviceName", "Redmi8Dual");
		dc.setCapability("platformName", "Android");
		
		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), dc);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://m.facebook.com/");
        Thread.sleep(2000);
        driver.findElementByXPath("//*[@id=\"m_login_email\"]").sendKeys("madhavanramlingam@gmail.com");
        Thread.sleep(2000);
        driver.findElementByXPath("//*[@id=\"m_login_password\"]").sendKeys("abcdefmjmj");
        Thread.sleep(2000);
        driver.findElementByXPath("//*[@id=\"u_0_5\"]/button").click();
        
	}

}
