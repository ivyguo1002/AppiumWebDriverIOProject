package guru99;
import io.appium.java_client.android.*;

import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestCase2
{
	public static AndroidDriver driver;
	public static void main(String args[])
	{
		try
		{
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setJavascriptEnabled(true);
			caps.setCapability("app",System.getProperty("user.dir")+"\\Resources\\com.vector.guru99.apk"); //Provide apk file path as in your local drive 
			caps.setCapability("deviceName","Galaxy S");
			caps.setCapability("deviceVesrsion", "4.3");
			driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),caps);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			Set<String> allElementsText = new HashSet<String>();
			
			/* Home Page Verification */
			if(driver.findElement(By.id("android:id/home")).isDisplayed())
			{
				System.out.println(" Guru 99 App Home Page is displayed ");
			}
			
			/* Click on SAP Course in Course Category */
			driver.findElement(By.name("Course Category")).click();
			List<WebElement> courseList = driver.findElements(By.id("com.vector.guru99:id/lblListHeader"));
			courseList.get(0).click();
			
			/* Child Elements count Verification */
			List<WebElement>sapChildElements = driver.findElements(By.id("com.vector.guru99:id/lblListItem"));
			for(WebElement element: sapChildElements)
			{
				String text = element.getText();
				allElementsText.add(text);
			}
			driver.scrollTo("SAP BI");
			List<WebElement>sapChildElements2 = driver.findElements(By.id("com.vector.guru99:id/lblListItem"));
			for(WebElement element: sapChildElements2)
			{
				String text = element.getText();
				allElementsText.add(text);
			}
			
			for(String s : allElementsText)
			{
				System.out.println(s);
			}
			
			int childElementsCount = allElementsText.size();
			if(childElementsCount == 11)
			{
				System.out.println("Sap course Sub Contents are equal ");
			}
			
		}
		catch (Exception E)
		{
			E.printStackTrace();
		}
		driver.quit();
	}
	
}
