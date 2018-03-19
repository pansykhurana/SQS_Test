package com.theinternettests.tests;


	

	import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

	public class GitHubAccess {
		
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

	
		@Test(priority=3)
		//Check Git Hub Access
		public static void check_ForkLink() {
			/*System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
	        driver = new ChromeDriver();
	        System.out.println("APP_URL");
	        driver.get(pro.getProperty("APP_URL"));*/
			driver.get(pro.getProperty("APP_URL"));
			if (driver.getTitle().contains("The Internet")) {
				System.out.println("Application is launched successfully");

			}else {
				System.out.println("Application is not launched successful");
			}
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			System.out.println("Test");
			//System.out.println(VerifyApplicationLaunch.Link_ForkmeonGitHub);
			try {

				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", driver.findElement(By.xpath(Link_ForkmeonGitHub)));


			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			//ChallengingDomPage.link_ForkmeOnGitHub(driver).click(); 
			if (driver.getTitle().contains("GitHub")) {
				System.out.println("GitHub is launched successfully");

			}else {
				System.out.println("Github not launched successful");
			}
			
		}

		@AfterTest
		
		public void tearDown() throws Exception {
			driver.quit();

			driver.close();



		}

	}


