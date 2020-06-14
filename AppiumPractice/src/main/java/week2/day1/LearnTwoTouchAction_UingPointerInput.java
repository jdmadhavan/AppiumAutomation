package week2.day1;



import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;

import javax.tools.Diagnostic.Kind;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class LearnTwoTouchAction_UingPointerInput {

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
		
		
		PointerInput finger=new PointerInput(PointerInput.Kind.TOUCH,"finger");
		Sequence drogAndDrop=new Sequence(finger,1);
		
		drogAndDrop.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, startY));
		drogAndDrop.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		
		drogAndDrop.addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), endX, endY));
		drogAndDrop.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		
		

		
		PointerInput finger2=new PointerInput(PointerInput.Kind.TOUCH,"finger2");
		Sequence drogAndDrop2=new Sequence(finger2,2);
		
		drogAndDrop2.addAction(finger2.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX+250, startY));
		drogAndDrop2.addAction(finger2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		
		drogAndDrop2.addAction(finger2.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), endX+200, endY));
		drogAndDrop2.addAction(finger2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		driver.perform(Arrays.asList(drogAndDrop,drogAndDrop2));
		
		
		System.out.println("Pointer Moved successfully");
		

	}

}
