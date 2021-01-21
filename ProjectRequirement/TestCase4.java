package guru99;

import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestCase4 {
	
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
					
			//step2 - click the Interview button and questions are displayed
				driver.findElement(By.name("Interview")).click();
			
				
			//Step 3 - Click java and followed with structs
				driver.findElement(By.name("JAVA")).click();
				driver.findElement(By.name("Top 50 Struts Interview Questions")).click();
				
			//Step 4 - Click on show answer button and press next
				driver.findElement(By.id("com.vector.guru99:id/show_answer")).click();
				driver.findElement(By.name("Next")).click();
		
			
			driver.quit();
		}

}
