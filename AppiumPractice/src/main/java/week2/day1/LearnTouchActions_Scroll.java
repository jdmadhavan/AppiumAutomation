package week2.day1;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class LearnTouchActions_Scroll {

	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability("appPackage", "com.the511plus.MultiTouchTester");
		dc.setCapability("appActivity", "com.the511plus.MultiTouchTester.MultiTouchTester");
		dc.setCapability("deviceName", "Redmi8Dual");
		dc.setCapability("platformName", "Android");
		dc.setCapability("noReset", true);
		
		AndroidDriver<WebElement> driver=new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
		
		
		Dimension screenSize=driver.manage().window().getSize();
		int width= screenSize.getWidth();
		int hight=screenSize.getHeight();
		
		int startX=(int) (width*0.5);
		int startY=(int) (hight*0.7);
		
		int endX=(int) (width*0.5);
		int endY=(int) (hight*0.2);
		
		
		TouchAction<?> action=new TouchAction<>(driver)
				.press(PointOption.point(startX, startY))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(6)))
				.moveTo(PointOption.point(endX, endY))
		        .release()
		        .perform();
		        
		System.out.println("Pointer Moved successfully");
		

	}

}
