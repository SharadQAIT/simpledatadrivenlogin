package com.Testdatadriven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.excel.utility.Xls_Reader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataDrivenTest {

	public static WebDriver driver;

	@Test
	public void Launchsite() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		// options.addArguments("--disable notifications");
		DesiredCapabilities cp = new DesiredCapabilities();
		cp.setCapability(ChromeOptions.CAPABILITY, options);
		options.merge(cp);
		System.setProperty("Webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		System.out.println("Chrome Browser Successfully launch..");
		// logger.info("Starting your Selenium test...");
		driver.get("https://omnistage.solutionanalysts.us/");
		System.out.println("Omni site Successfully launched..");

		Xls_Reader reader = new Xls_Reader(
				"D:\\Eclipse Workspace\\Selenium_Tutorials\\com.datadrivenselenium\\src\\test\\java\\com\\ExcelTestData\\LoginTestData.xlsx");

		String emailid = reader.getCellData("login", "email id", 2);
		System.out.println(emailid);
	}

	public static void main(String[] args)

	{
		// TODO Auto-generated method stub

		DataDrivenTest DD = new DataDrivenTest();
		DD.Launchsite();
	}

}
