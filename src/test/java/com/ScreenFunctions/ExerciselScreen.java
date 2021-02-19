package com.ScreenFunctions;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.RunnerClass.CucumberRunner;
import com.relevantcodes.extentreports.LogStatus;

public class ExerciselScreen extends CucumberRunner {

	// label values x-path
	@FindBy(how = How.XPATH, using = "//*[starts-with(@id,'lbl_val_')]")
	public static List<WebElement> lbl_values;

	// text values x-path
	@FindBy(how = How.XPATH, using = "//*[starts-with(@id,'txt_val_')]")
	public static List<WebElement> txt_values;

	// text total balance value
	@FindBy(how = How.ID, using = "txt_ttl_val")
	public static WebElement txt_Balance;

	public ExerciselScreen() {
		PageFactory.initElements(driver, this);
	}

	public void lblValueCount() {
		int valCount = lbl_values.size();
		System.out.println("value count is : " + valCount);
		test.log(LogStatus.PASS, "value count is : " + valCount);
	}

	public void valGreaterthenZero() {
		try {
			for (WebElement ele : txt_values) {
				String data = ele.getText().trim().substring(1).replaceAll(",", "");
				float value = Float.parseFloat(data);
				if (value > 0) {
					System.out.println(value + " greater then 0");
					test.log(LogStatus.PASS, value + " greater then 0");
				} else {
					System.out.println(value + " lessthen then 0");
					test.log(LogStatus.FAIL, value + " lessthen then 0");
				}
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			test.log(LogStatus.FAIL, e.toString());
		}
	}

	public void verifyTotalBalanceCorrectValues() {
		try {
			float sumData = 0;
			for (WebElement ele : txt_values) {
				String data = ele.getText().trim().substring(1).replaceAll(",", "");
				float a = Float.parseFloat(data);
				sumData = sumData + a;
			}
			System.out.println("Total values sum is : " + sumData);
			test.log(LogStatus.PASS, "Total values sum is : " + sumData);
			String ttl_Value = txt_Balance.getText().trim().substring(1).replaceAll(",", "");
			float balance = Float.parseFloat(ttl_Value);
			System.out.println("Total balance is in form of float is : " + balance);
			test.log(LogStatus.PASS, "Total balance is in form of float is : " + balance);
			if (sumData == balance) {
				System.out.println("Total balance is correct based on values");
				test.log(LogStatus.PASS, "Total balance is correct based on values");
			} else {
				System.out.println("Total balance is not correct based on values ");
				test.log(LogStatus.FAIL, "Total balance is not correct based on values ");
			}

		} catch (Exception e) {
			System.out.println(e.toString());
			test.log(LogStatus.FAIL, e.toString());
		}

	}

	public void verifyFormatCurrencies() {
		try {
			for (WebElement ele : txt_values) {
				String data = ele.getText().trim().substring(1).replaceAll(",", "");
				float price = Float.parseFloat(data);
				// Get current locale information
				Locale currentLocale = Locale.US;

				// Get currency instance from locale; This will have all currency related
				// information
				Currency currentCurrency = Currency.getInstance(currentLocale);

				// Currency Formatter specific to locale
				NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(currentLocale);

				// Test the output
				System.out.println(currentLocale.getDisplayName());
				test.log(LogStatus.PASS, "Currency Local name is : " + currentLocale.getDisplayName());

				System.out.println(currentCurrency.getDisplayName());
				test.log(LogStatus.PASS, "Currency Currency is : " + currentCurrency.getDisplayName());

				System.out.println(currencyFormatter.format(price));
				test.log(LogStatus.PASS, "Currency formate is : " + currencyFormatter.format(price));

			}

		} catch (Exception e) {
			System.out.println(e.toString());
			test.log(LogStatus.FAIL, e.toString());
		}

	}

	public void verifyTotalbalance() {
		try {
			float sumData = 0;
			for (WebElement ele : txt_values) {
				String data = ele.getText().trim().substring(1).replaceAll(",", "");
				float a = Float.parseFloat(data);
				sumData = sumData + a;
			}
			System.out.println("Total values sum is : " + sumData);
			test.log(LogStatus.PASS, "Total values sum is : " + sumData);
			String ttl_Value = txt_Balance.getText().trim().substring(1).replaceAll(",", "");
			float balance = Float.parseFloat(ttl_Value);
			System.out.println("Total balance is in form of float is : " + balance);
			test.log(LogStatus.PASS, "Total balance is in form of float is : " + balance);
			if (sumData == balance) {
				System.out.println("Total balance matches to sum of values");
				test.log(LogStatus.PASS, "Total balance matches to sum of values");
			} else {
				System.out.println("Total balance not matches to sum of values");
				test.log(LogStatus.FAIL, "Total balance not matches to sum of values");
			}

		} catch (Exception e) {
			System.out.println(e.toString());
			test.log(LogStatus.FAIL, e.toString());
		}
	}
}
