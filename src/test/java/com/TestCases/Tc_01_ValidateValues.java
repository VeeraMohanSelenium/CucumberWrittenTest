package com.TestCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

import com.RunnerClass.CucumberRunner;
import com.ScreenFunctions.ExerciselScreen;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Tc_01_ValidateValues extends CucumberRunner {
	public ExerciselScreen es;

	@Given("^I want to launch the Chrome browser$")
	public void I_want_to_launch_the_Chrome_browser() {
		try {
			System.getProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver = new ChromeDriver();
			test.log(LogStatus.PASS, "Able to launch the chrome browser");
		} catch (Exception e) {
			System.out.println(e);
			test.log(LogStatus.PASS, "Not able to launch the browser : " + e.toString());
		}
	}

	@When("^it maximizes enter the URL$")
	public void it_maximizes_enter_the_URL(DataTable testData) {
		try {
			List<String> details = testData.asList(String.class);
			System.out.println(details.get(0));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(details.get(0));
			test.log(LogStatus.PASS, "Application launch sucessfully");
		} catch (Exception e) {
			System.out.println(e);
			test.log(LogStatus.PASS, "Not able to launch the Application : " + e.toString());
		}
	}

	@Then("^I need to verify the right count of the values appear on the screen$")
	public void I_need_to_verify_the_right_count_of_the_values_appear_on_the_screen() {
		es = new ExerciselScreen();
		es.lblValueCount();

	}

	@Then("^Need to verify the values on the screen are greater then zero$")
	public void Need_to_verify_the_values_on_the_screen_are_greater_then_zero() {
		es.valGreaterthenZero();
	}

	@And("^Need to verify the total balance is correct based values listed on screen$")
	public void Need_to_verify_the_total_balance_is_correct_based_values_listed_on_screen() {
		es.verifyTotalBalanceCorrectValues();
	}

	@Then("^Verify the values are formatted as currencies$")
	public void Verify_the_values_are_formatted_as_currencies() {
		es.verifyFormatCurrencies();
	}

	@Then("^Verify the total balance matches the sum of the values$")
	public void Verify_the_total_balance_matches_the_sum_of_the_values() {
		es.verifyTotalbalance();
	}

}
