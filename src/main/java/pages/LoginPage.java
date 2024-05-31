package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	@FindBy(id = "input-email")
	private WebElement emailInput;

	@FindBy(id = "input-password")
	private WebElement passwordInput;

	@FindBy(xpath = "//input[@value='Login']")
	private WebElement loginButton;

	@FindBy(xpath = "//a[text()='Edit your account information']")
	private WebElement editAccountLink;

	@FindBy(xpath = "//div[text()='Warning: No match for E-Mail Address and/or Password.']")
	private WebElement warningMessage;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void enterEmail(String email) {
		emailInput.sendKeys(email);
	}

	public void enterPassword(String password) {
		passwordInput.sendKeys(password);
	}

	public void clickLoginButton() {
		loginButton.click();
	}

	public String getEditAccountLinkText() {
		return editAccountLink.getText();
	}

	public String getWarningMessageText() {
		return warningMessage.getText();
	}
}