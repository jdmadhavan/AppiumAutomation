package week2.day2;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class InteractionWithNotification {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability("appPackage", "com.miui.home");
		dc.setCapability("appActivity", "com.miui.home.launcher.Launcher");
		dc.setCapability("deviceName", "Redmi8Dual");
		dc.setCapability("platformName", "Android");
		dc.setCapability("automationName", "UiAutomator2");
		dc.setCapability("noReset", true);
		
		AndroidDriver<WebElement> driver=new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
		
		driver.openNotifications();
		
		Thread.sleep(4000);
		String text = driver.findElementByXPath("//*[@text='USB debugging connected']").getText();
		System.out.println("text"+text);
		
		Thread.sleep(2000);
		driver.findElementByXPath("//*[@text='USB debugging connected']").click();		
		Dimension screenSize=driver.manage().window().getSize();
		int width= screenSize.getWidth();
		int hight=screenSize.getHeight();
		
		int startX=(int) (width*0.5);
		int startY=(int) (hight*0.8);
		
		int endX=(int) (width*0.5);
		int endY=(int) (hight*0.2);
		Thread.sleep(5000);
	
		if(!driver.findElementByXPath("//android.widget.TextView[@text='Feature flags']").isDisplayed())
		{
		PointerInput finger=new PointerInput(PointerInput.Kind.TOUCH,"finger");
		Sequence drogAndDrop=new Sequence(finger,1);
		
		drogAndDrop.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, startY));
		drogAndDrop.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		
		drogAndDrop.addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), endX, endY));
		drogAndDrop.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		driver.perform(Arrays.asList(drogAndDrop))	;
		
		
	}
		System.out.println("Intracted successfull");
	}

}
