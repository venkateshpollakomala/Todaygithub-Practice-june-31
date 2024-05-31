package abcdefg.aprilpractiveframewrok;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BasePackage.Base;
import pages.LoginPage;

public class Login extends Base {
	WebDriver driver;
	LoginPage loginpage;

	@BeforeMethod
	public void setUp() {
		driver = InitializeBrowserAndOpenApplication("chrome");

		driver.findElement(By.xpath("//span[text()='My Account']")).click();

		driver.findElement(By.xpath("//a[text()='Login'][1]")).click();
		loginpage = new LoginPage(driver);
	}

	@Test(priority = 1)
	public void LoginWithValidCredentials() {
		loginpage.enterEmail("pvenky.mba9@gmail.com");
		loginpage.enterPassword("Venky!23");
		loginpage.clickLoginButton();
		Assert.assertEquals(loginpage.getEditAccountLinkText(), "Edit your account information",
				"Incorrect text displayed");
	}

	@Test(priority = 2)
	public void LoginwithInValidCredentials() {

		loginpage.enterEmail("pvenky.mba91@gmail.com");
		loginpage.enterPassword("Venky!234");
		loginpage.clickLoginButton();

		Assert.assertEquals(loginpage.getWarningMessageText(), "Warning: No match for E-Mail Address and/or Password.");
	}

	@Test(priority = 3)
	public void loginWithValidPasswordInValidEmail() {

		loginpage.enterEmail("pvenky.mba99@gmail.com");
		loginpage.enterPassword("Venky!23");
		loginpage.clickLoginButton();
		Assert.assertEquals(loginpage.getWarningMessageText(), "Warning: No match for E-Mail Address and/or Password.",
				"ProperWarning messegae is not displayed");
	}

	@Test(priority = 4)
	public void loginWithvalidEmailandInValidpassword() {

		loginpage.enterEmail("pvenky.mba9@gmail.com");
		loginpage.enterPassword("Venky!2356");
		loginpage.clickLoginButton();
		Assert.assertEquals(loginpage.getWarningMessageText(), "Warning: No match for E-Mail Address and/or Password.",
				"ProperWarning messegae is not displayed");
	}

	@Test(priority = 5)
	public void TrytoLoginWithoutCredentials() {

		loginpage.enterEmail("");
		loginpage.enterPassword("");
		loginpage.clickLoginButton();
		Assert.assertEquals(loginpage.getWarningMessageText(), "Warning: No match for E-Mail Address and/or Password.",
				"ProperWarning messegae is not displayed");
	}

	@Test(priority = 6)
	public void VerifyForgotPassword() {
		driver.findElement(By.linkText("Forgotten Password")).click();

	}

	@AfterMethod

	public void tearDown() {

		driver.quit();

	}
}
