package com.theinternettests.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DriverScript {

	public static WebDriver driver;	
	public static FileInputStream fileobj;
	public static Properties pro;
	public static String ChallengingDomHeader;
	public static String Link_ForkmeonGitHub;
	public static String button_theinternetpage;
	public static String alertbutton_theinternetpage;
	public static String successbutton_theinternetpage;
	public static String WebTable_Header;

	public static void main(String[] args) throws FileNotFoundException,IOException {

		pro = new Properties();
		fileobj = new FileInputStream("./ApplicationDetails.Properties");
		pro.load(fileobj);
		ChallengingDomHeader = pro.getProperty("ChallengingDOM.headertxt_challengingdom.xpath");
		Link_ForkmeonGitHub = pro.getProperty("ChallengingDOM.Link_ForkmeonGithub.xpath");
		button_theinternetpage = pro.getProperty("ChallengingDOM.button");
		alertbutton_theinternetpage = pro.getProperty("ChallengingDOM.button_alert.css");
		successbutton_theinternetpage = pro.getProperty("ChallengingDOM.button_success.css");
		WebTable_Header = pro.getProperty("ChallengingDOM.allheaders_xpath");
		appLaunch(pro.getProperty("APP_URL"));
		check_ForkLink(pro.getProperty("APP_URL"));
		checkButtonColor();
		checkAlertButtonColor();
		checkSuccessButtonColor();
		retrieveWebTableContent();
		checkCanvasPresence();
		checkHeaderCountAndValuesAsExpected();
		checkEditLink();	
		checkDeleteLink();
	}

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

		driver.get(pro.getProperty("APP_URL"));


	}

	@Test
	//Check Application Launch Successful
	public static void appLaunch(String URL)
	{

		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("APP_URL");
		driver.get(pro.getProperty("APP_URL"));



		if (driver.getTitle().contains("The Internet")) {
			System.out.println("Application is launched successfully");

		}else {
			System.out.println("Application is not launched successful");
		}
		driver.close();
	}

	@Test
	//Check Git Hub Access
	public static void check_ForkLink(String URL) {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("APP_URL");
		driver.get(pro.getProperty("APP_URL"));

		if (driver.getTitle().contains("The Internet")) {
			System.out.println("Application is launched successfully");

		}else {
			System.out.println("Application is not launched successful");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


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
		driver.close();
	}

	@Test
	public static void checkButtonColor() {
		try{
			System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");

			driver = new ChromeDriver();

			driver.get(pro.getProperty("APP_URL"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

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
			AssertJUnit.assertTrue( "BackGround Color is not matching as expected",hex.equals("#2ba6cb"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		driver.close();
	}

	@Test
	public static void checkAlertButtonColor() {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();

		driver.get(pro.getProperty("APP_URL"));

		if (driver.getTitle().contains("The Internet")) {
			System.out.println("Application is launched successfully");

		}else {
			System.out.println("Application is not launched successful");
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {

			WebElement element2 = driver.findElement(By.cssSelector(alertbutton_theinternetpage));

			String color1 = element2.getCssValue("background-color");
			System.out.println(color1);
			String hex1 = Color.fromString(color1).asHex();
			System.out.println(hex1);

			// System.out.println(Color.fromString(element2.getCssValue("color")).asHex());
			AssertJUnit.assertTrue("BackGround Color is not matching as expected",hex1.equals("#c60f13") );
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		driver.close();
	}

	@Test
	public static void checkSuccessButtonColor() {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();

		driver.get(pro.getProperty("APP_URL"));

		if (driver.getTitle().contains("The Internet")) {
			System.out.println("Application is launched successfully");

		}else {
			System.out.println("Application is not launched successful");
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {

			WebElement element1 = driver.findElement(By.cssSelector(successbutton_theinternetpage));

			String color2 = element1.getCssValue("background-color");
			System.out.println(color2);
			String hex2 = Color.fromString(color2).asHex();
			System.out.println(hex2);

			//System.out.println(Color.fromString(element1.getCssValue("color")).asHex());
			AssertJUnit.assertTrue("BackGround Color is not matching as expected",hex2.equals("#5da423") );
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		driver.close();
	}

	@Test
	public static void checkHeaderCountAndValuesAsExpected() {


		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();

		driver.get(pro.getProperty("APP_URL"));

		//ArrayList of column names
		ArrayList<String> colnames=new ArrayList<String>(); 
		colnames.add("Lorem"); 
		colnames.add("Ipsum");  
		colnames.add("Dolor");  
		colnames.add("Sit");  
		colnames.add("Amet");
		colnames.add("Diceret");
		colnames.add("Action");


		if (driver.getTitle().contains("The Internet")) {
			System.out.println("Application is launched successfully");

		}else {
			System.out.println("Application is not launched successful");
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {

			ArrayList<WebElement> Headers = (ArrayList<WebElement>) driver.findElements(By.xpath(WebTable_Header));
			System.out.println();
			if (Headers.size() == colnames.size()) {
				System.out.println("Total number of columns are matching");
				for(int i=0;i<colnames.size();i++){
					if(Headers.get(i).getText().equals(colnames.get(i))){
						System.out.println("Column value is matching : "+"Expected: "+colnames.get(i)+", Actual: "+Headers.get(i).getText());
					}else{
						System.err.println("Column value is not matching : "+"Expected: "+colnames.get(i)+", Actual: "+Headers.get(i).getText());
					}
				}
			}


			//System.out.println(Color.fromString(element1.getCssValue("color")).asHex());

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		driver.close();
	}


	@Test
	public static void retrieveWebTableContent() {
		int rows_count,col_count;
		String cellText = null;
		//Navigate to the Web page
		System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/challenging_dom");
		driver.manage().window().maximize();
		//Identify the table
		WebElement Table = driver.findElement(By.xpath("//table"));
		//Read specific cell value
		//WebElement cell = driver.findElement(By.xpath("//table/tbody/tr[2]/td[3]"));

		//System.out.println("Data for Row 2 and Column 3 is "+cell.getText()+".");
		//Fetch # of rows in a table
		List<WebElement> rows = Table.findElements(By.tagName("tr"));

		rows_count = rows.size();
		//Iterate through the rows
		for(int i= 0; i<rows_count; i++){
			//Fetch # of columns in a row
			List<WebElement> columns = rows.get(i).findElements(By.tagName("td"));
			col_count = columns.size();
			//Iterate through the columns within particular row
			for(int j=0; j<col_count; j++){
				cellText =  columns.get(j).getText();
				System.out.print(cellText+"  ");
			}
			System.out.println("");
		}
		driver.close();
	}

	
	@Test
	public static void checkCanvasPresence() {
	
		//Navigate to the Web page
		System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.get("https://the-internet.herokuapp.com/challenging_dom");
		driver.manage().window().maximize();
		//Identify the table
		 
		WebElement element = driver.findElement(By.xpath("//canvas"));
		if (element.isDisplayed()) {
			System.out.println("Answer: field is present");
		}
		driver.close();
		
	}
	
	@Test
	public static void checkEditLink() {
		
		
		//Navigate to the Web page
		System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/challenging_dom");
		driver.manage().window().maximize();
		//Identify the table
		 
		List<WebElement> elements = driver.findElements(By.xpath("//table/tbody/tr/td[7]/a[1]"));
		for (WebElement webElement : elements) {
			if (webElement.getText().contains("edit")) {
				System.out.println("Edit link is available");
				webElement.click();
				System.out.println(driver.getCurrentUrl());
			}else
			{
				System.out.println("No Edit link");
			}
		}
		driver.close();
		
	}
	
	@Test
	public static void checkDeleteLink() {

		//Navigate to the Web page
		System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/challenging_dom");
		driver.manage().window().maximize();
		//Identify the table
		 
		List<WebElement> elements = driver.findElements(By.xpath("//table/tbody/tr/td[7]/a[2]"));
		for (WebElement webElement : elements) {
			if (webElement.getText().contains("delete")) {
				System.out.println("Delete link is available");
				webElement.click();
				System.out.println(driver.getCurrentUrl());
			}else
			{
				System.out.println("No Delete link");
			}
		}
		driver.close();
		
	}
	
	@AfterTest
	public void tearDown() throws Exception {
		driver.close();



	}

}
