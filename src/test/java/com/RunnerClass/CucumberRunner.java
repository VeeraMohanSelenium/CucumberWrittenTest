package com.RunnerClass;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(strict = true, monochrome = true, 
				features = "Features", glue = "com.TestCases", 
				plugin = { "pretty","html:target/cucumber-html-report" })

public class CucumberRunner extends AbstractTestNGCucumberTests {

	public static WebDriver driver;

	public static ExtentReports extent;

	public static ExtentTest test;

	@BeforeSuite
	public static void intializeReport() {
		extent = new ExtentReports("AutomationResults.html");

	}

	@BeforeTest
	public static void startTest(ITestContext iTestContext) {
		String curentClassName = iTestContext.getCurrentXmlTest().getClasses().stream().findFirst().get().getName();
		test = extent.startTest(curentClassName);
	}

	@AfterTest
	public static void endTest() {
		extent.endTest(test);
		driver.quit();
	}

	@AfterSuite
	public static void flushreport() {
		extent.flush();
		extent.close();

	}

	public static String takescreenshot() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TakesScreenshot sht = (TakesScreenshot) driver;

		String print = sht.getScreenshotAs(OutputType.BASE64);

		return "data:image/jpg;base64, " + print;

	}

}
