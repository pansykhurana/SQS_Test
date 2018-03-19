package com.theinternettests.tests;


	


	import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

	public class CheckButtonColor {
		
		public static WebDriver driver;	
		public static FileInputStream fileobj;
		public static Properties pro;
		public static String ChallengingDomHeader;
		public static String Link_ForkmeonGitHub;
		public static String button_theinternetpage;
		public static String alertbutton_theinternetpage;
		public static String successbutton_theinternetpage;

		@BeforeTest
		
		public void setUpMethod() throws Exception {
			pro = new Properties();
			fileobj = new FileInputStream("./ApplicationDetails.Properties");
			pro.load(fileobj);
			ChallengingDomHeader = pro.getProperty("ChallengingDOM.headertxt_challengingdom.xpath");
			Link_ForkmeonGitHub = pro.getProperty("ChallengingDOM.Link_ForkmeonGithub.xpath");
			button_theinternetpage = pro.getProperty("ChallengingDOM.button");
			alertbutton_theinternetpage = pro.getProperty("ChallengingDOM.button_alert.css");
			successbutton_theinternetpage = pro.getProperty("ChallengingDOM.button_success.css");
			System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
			driver = new ChromeDriver();
			//System.out.println("APP_URL");
			


		}

		@Test(priority=8)
		public static void checkButtonColor() {
			/*try{
			System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");

			driver = new ChromeDriver();
	    System.out.println("APP_URL");
	    driver.get(pro.getProperty("APP_URL"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}*/
			driver.get(pro.getProperty("APP_URL"));
			if (driver.getTitle().contains("The Internet")) {
				System.out.println("Application is launched successfully");

			}else {
				System.out.println("Application is not launched successful");
			}

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			try {

				WebElement element = driver.findElement(By.cssSelector(button_theinternetpage));

				String color = element.getCssValue("background-color");
				System.out.println(color);
				String hex = Color.fromString(color).asHex();
				System.out.println(hex);

				//System.out.println(Color.fromString(element.getCssValue("color")).asHex());
				//AssertJUnit.assertTrue( "BackGround Color is not matching as expected",hex.equals("#2ba6cb"));
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			driver.close();
		}

		@AfterTest
		
		public void tearDown() throws Exception {
			driver.quit();

			




		}

	}
