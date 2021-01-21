package guru99;

import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestCase5 {
	public static void main(String args[])
	{
	AndroidDriver driver=null;
	DesiredCapabilities cap = new DesiredCapabilities();
	String udid = "077c35ee0ade546b";
	File app = new File(System.getProperty("user.dir")+"\\Resources\\com.vector.guru99.apk");
	
		cap.setJavascriptEnabled(true);
		cap.setCapability("deviceName", "Nexus 5");
		cap.setCapability("udid", udid);
		cap.setCapability("app", app);
		try {
			driver=new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), cap);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
		} catch (MalformedURLException e) {
	 		e.printStackTrace();
		}
		
		//Step1  - Verify home page
				if(driver.findElement(By.name("Guru99")).isDisplayed())
					System.out.println("Home page is displayed");
				else
					System.out.println("home page is not displayed");
				
		//step2 - click on Course List tab
			driver.findElement(By.name("Course List")).click();
		
			
		//Step 3 - darg until PHP course found and click on it
			driver.scrollToExact("PHP");
			driver.findElement(By.name("PHP")).click();
			
		//Step 4 - Click on Lesson 1 and verify the lesson1
			driver.findElement(By.name("Lesson #1")).click();

			if(driver.findElement(By.name("What is PHP? Write your first PHP Program")).isDisplayed())
			System.out.println("First Lesson is opened");
			else
				System.out.println("First lesson not opened");
			
			//Go to next lesson
			driver.findElement(By.name("Next")).click();
			
			//verify 2nd lesson title
			
			if(driver.findElement(By.name("Step by step instruction on XAMPP & Netbeans installation")).isDisplayed())
				System.out.println("second Lesson is opened");
				else
				System.out.println("second lesson is not opened");
	
		
		driver.quit();
	}

}
