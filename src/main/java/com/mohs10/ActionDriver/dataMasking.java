package com.mohs10.ActionDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.mohs10.base.StartBrowser;

public class dataMasking extends StartBrowser {
	public static String screenShot() {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	}

	public static void maskEmail(By locator, String email, String command) {
		try {

			// Mask the email address
			String[] emailParts = email.split("@");
			String username = emailParts[0];
			String domain = emailParts[1];
			String maskedUsername = "";
			for (int i = 0; i < username.length() - 1; i++) {
				maskedUsername += "*";
			}
			maskedUsername += username.charAt(username.length() - 1);
			String maskedEmail = maskedUsername + "@" + domain;

			// Pass the masked email to the field
			System.out.println(maskedEmail);
			WebElement ele = StartBrowser.driver.findElement(locator);
			ele.sendKeys(maskedEmail);
			StartBrowser.childTest.pass("Successfully performed type action on :" + email + " With test data :" + command);
		} catch (Exception e) {

			StartBrowser.childTest.fail(
					"Unable to performe type action action on :" + email + " With test data :" + command,
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
			StartBrowser.childTest.info(e);
			throw e;
		}
	}

	public static void masktext(By locator, String text, String command) {
		try {
			// Replace characters with asterisks except for the last character
			String maskedFirstName = "";
			int length = text.length();
			for (int j = 0; j < length - 1; j++) {
				maskedFirstName += "*";
			}
			maskedFirstName += text.charAt(length - 1);

			// Pass the masked first name to the field
			System.out.println(maskedFirstName);
			WebElement ele = StartBrowser.driver.findElement(locator);
			ele.sendKeys(maskedFirstName);

			StartBrowser.childTest
					.pass("Successfully performed type action on :" + text + " With test data :" + command);
		} catch (Exception e) {

			StartBrowser.childTest.fail(
					"Unable to performe type action action on :" + text + " With test data :" + command,
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
			StartBrowser.childTest.info(e);
			throw e;
		}
	}

	/*
	 * public static void maskNumbers(By locator, int number) { // Convert the
	 * number to a string String numberString = String.valueOf(number);
	 * 
	 * // Replace digits with asterisks except for the last character String
	 * maskedNumber = ""; int length = numberString.length(); for (int j = 0; j <
	 * length - 1; j++) { maskedNumber += "*"; } maskedNumber +=
	 * numberString.charAt(length - 1);
	 * 
	 * // Pass the masked number to the field System.out.println(maskedNumber);
	 * WebElement ele = StartBrowser.driver.findElement(locator);
	 * ele.sendKeys(maskedNumber); }
	 */

	public static void maskExpectChar(By locator, String text, String command) {
		try {

			// Replace characters with asterisks except for the first and last character
			String maskedFirstName = text.charAt(0) + "";
			int length = text.length();
			for (int j = 1; j < length - 2; j++) {
				maskedFirstName += "*";
			}
			maskedFirstName += text.charAt(length - 2);

			// Pass the masked first name to the field
			System.out.println(maskedFirstName);
			WebElement ele = StartBrowser.driver.findElement(locator);
			ele.sendKeys(maskedFirstName);
			StartBrowser.childTest
					.pass("Successfully performed type action on :" + text + " With test data :" + command);
		} catch (Exception e) {

			StartBrowser.childTest.fail(
					"Unable to performe type action action on :" + text + " With test data :" + command,
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
			StartBrowser.childTest.info(e);
			throw e;
		}
	}

}
