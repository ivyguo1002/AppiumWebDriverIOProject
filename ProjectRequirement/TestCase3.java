package guru99;

import io.appium.java_client.android.AndroidDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestCase3
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
			
			
			/* Home Page Verification */
			if(driver.findElement(By.id("android:id/home")).isDisplayed())
			{
				System.out.println(" Guru 99 App Home Page is displayed ");
			}
			
			/*  To click on Quiz Button */
			driver.findElement(By.id("com.vector.guru99:id/action_quiz")).click();
			
			/* To click on Quality Center Quiz item
			 */
			driver.findElement(By.name("Quality Center")).click();
			
			/* Questions & Answers Verification  */
			
			//First Question
			String question1 = driver.findElement(By.id("com.vector.guru99:id/question")).getText();
			System.out.println(" First Question :  "+ question1);
			/* Getting Time Remaining */
			String timeForFirstQues = driver.findElement(By.id("com.vector.guru99:id/timer")).getText();
			System.out.println("Time Remaining:  "+ timeForFirstQues);
			/* Clicking on Answer and Next */
			driver.findElement(By.id("com.vector.guru99:id/option2")).click();
			driver.findElement(By.id("com.vector.guru99:id/next")).click();
			
			//Second Question 
			String question2 = driver.findElement(By.id("com.vector.guru99:id/question")).getText();
			System.out.println("Second Question :  "+ question2);
			/* Getting Time Remaining */
			String timeForSecondQues = driver.findElement(By.id("com.vector.guru99:id/timer")).getText();
			System.out.println("Time Remaining:  "+timeForSecondQues);
			/* Clicking on Answer and Finish */
			driver.findElement(By.id("com.vector.guru99:id/option1")).click();
			driver.findElement(By.id("com.vector.guru99:id/finish")).click();
			
			/* Result */
			if(driver.findElement(By.id("com.vector.guru99:id/heading")).isDisplayed())
			{
				System.out.println(" Test Results: ");
				System.out.println(driver.findElement(By.id("com.vector.guru99:id/score")).getText());
			}
			
		}
		catch (Exception E)
		{
			E.printStackTrace();
		}
		driver.quit();
	}
}
