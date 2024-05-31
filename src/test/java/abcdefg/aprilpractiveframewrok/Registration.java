package abcdefg.aprilpractiveframewrok;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BasePackage.Base;
import Utils.utilities;
import pages.RegisterPage;

public class Registration extends Base {
	WebDriver driver;
	RegisterPage registerPage;

	@BeforeMethod
	public void setup() {
		driver = InitializeBrowserAndOpenApplication("chrome");
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.xpath("//a[text()='Register']")).click();
		registerPage = new RegisterPage(driver);

	}

	@AfterMethod
	public void teardoen() {
		driver.quit();
	}

	@Test(priority = 1)
	public void createRegistration() {
		registerPage.enterFirstName("Deepu");
		registerPage.enterLastName("Pollakomala");
		registerPage.enterEmail(utilities.generateEmailTimeStamp());
		registerPage.enterTelephone("9398086762");
		registerPage.enterPassword("Venky!23");
		registerPage.enterConfirmPassword("Venky!23");
		registerPage.clickYesButton();
		registerPage.clickAgreeCheckbox();
		registerPage.clickContinueButton();
		registerPage.isAccountCreatedMessageDisplayed();
	}

	@Test(priority = 2)
	public void registerwithMandatoryFields() {
		registerPage.enterFirstName("Deepu");
		registerPage.enterLastName("Pollakomala");
		registerPage.enterEmail(utilities.generateEmailTimeStamp());
		registerPage.enterTelephone("9398086762");
		registerPage.enterPassword("Venky!23");
		registerPage.enterConfirmPassword("Venky!23");
		registerPage.clickAgreeCheckbox();
		registerPage.clickContinueButton();
		registerPage.isAccountCreatedMessageDisplayed();
	}

	@Test(priority = 3)
	public void registerWithoutinputdata() {
		registerPage.enterFirstName("");
		registerPage.enterLastName("");
		registerPage.enterEmail("");
		registerPage.enterTelephone("");
		registerPage.enterPassword("");
		registerPage.enterConfirmPassword("");
		registerPage.clickAgreeCheckbox();
		registerPage.clickContinueButton();
		Assert.assertTrue(registerPage.isFirstNameErrorMessageDisplayed());
		Assert.assertTrue(registerPage.isLastNameErrorMessageDisplayed());
		Assert.assertTrue(registerPage.isEmailAddressErrorMessageDisplayed());
		Assert.assertTrue(registerPage.isTelephoneErrorMessageDisplayed());
		Assert.assertTrue(registerPage.isPasswordErrorMessageDisplayed());
	}

	@Test(priority = 4)
	public void duplicateEmailid() {
		registerPage.enterFirstName("Deepu");
		registerPage.enterLastName("Pollakomala");
		registerPage.enterEmail("deepu318@gmail.com");
		registerPage.enterTelephone("9398086762");
		registerPage.enterPassword("Venky!23");
		registerPage.enterConfirmPassword("Venky!23");
		registerPage.clickAgreeCheckbox();
		registerPage.clickContinueButton();
		registerPage.isEmailAlreadyRegisteredWarningMessageDisplayed();
	}

	@Test(priority = 5)
	public void registerwithwrongconfirmpassword() {
		registerPage.enterFirstName("Deepu");
		registerPage.enterLastName("Pollakomala");
		registerPage.enterEmail("deepu318@gmail.com");
		registerPage.enterTelephone("9398086762");
		registerPage.enterPassword("Venky!23");
		registerPage.enterConfirmPassword("Ve");
		registerPage.clickAgreeCheckbox();
		registerPage.clickContinueButton();
	}

	@Test(priority = 6)
	public void registerwithInvalidEmailAddress() {
		registerPage.enterFirstName("Deepu");
		registerPage.enterLastName("Pollakomala");
		registerPage.enterEmail("deepu318@com");
		registerPage.enterTelephone("9398086762");
		registerPage.enterPassword("Venky!23");
		registerPage.enterConfirmPassword("Venky!23");
		registerPage.clickAgreeCheckbox();
		registerPage.clickContinueButton();
		registerPage.isEmailAddressErrorMessageDisplayed();
	}

	@Test(priority = 7)
	public void below4passwordcharecters() {
		registerPage.enterFirstName("Deepu");
		registerPage.enterLastName("Pollakomala");
		registerPage.enterEmail("deepu318@gmail.com");
		registerPage.enterTelephone("9398086762");
		registerPage.enterPassword("Ve");
		registerPage.enterConfirmPassword("Ve");
		registerPage.clickAgreeCheckbox();
		registerPage.clickContinueButton();
		registerPage.isPasswordErrorMessageDisplayed();
	}

	@Test(priority = 8)
	public void registerwithoutPrivacypolicy() {
		registerPage.enterFirstName("Deepu");
		registerPage.enterLastName("Pollakomala");
		registerPage.enterEmail("deepu318@gmail.com");
		registerPage.enterTelephone("9398086762");
		registerPage.enterPassword("Venky!23");
		registerPage.enterConfirmPassword("Venky!23");
		registerPage.clickYesButton();
		registerPage.clickContinueButton();
		registerPage.isAccountRegisterDivDisplayed();
	}

}