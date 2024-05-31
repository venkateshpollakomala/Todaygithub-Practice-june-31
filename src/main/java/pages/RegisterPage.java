package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
    
    WebDriver driver;

    @FindBy(xpath = "//input[@id='input-firstname']")
    private WebElement firstNameInput;

    @FindBy(xpath = "//input[@id='input-lastname']")   
    private WebElement lastNameInput;

    @FindBy(xpath = "//input[@id='input-email']")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@id='input-telephone']")
    private WebElement telephoneInput;

    @FindBy(xpath = "//input[@id='input-password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@id='input-confirm']")
    private WebElement confirmPasswordInput;

    @FindBy(xpath = "//*[text()='Yes']")
    private WebElement yesButton;

    @FindBy(xpath = "//input[@name='agree']")
    private WebElement agreeCheckbox;

    @FindBy(xpath = "//input[@value='Continue']")
    private WebElement continueButton;
    
    @FindBy(xpath = "//h1[text()='Your Account Has Been Created!']")
    private WebElement accountCreatedMessage;

    @FindBy(xpath = "//div[text()='First Name must be between 1 and 32 characters!']")
    private WebElement firstNameErrorMessage;

    @FindBy(xpath = "//div[text()='Last Name must be between 1 and 32 characters!']")
    private WebElement lastNameErrorMessage;

    @FindBy(xpath = "//div[text()='E-Mail Address does not appear to be valid!']")
    private WebElement emailAddressErrorMessage;

    @FindBy(xpath = "//div[text()='Telephone must be between 3 and 32 characters!']")
    private WebElement telephoneErrorMessage;

    @FindBy(xpath = "//div[text()='Password must be between 4 and 20 characters!']")
    private WebElement passwordErrorMessage;
    
    @FindBy(xpath = "//body/div[@id='account-register']/div[1]")
    private WebElement accountRegisterDiv;
    
    
    @FindBy(xpath = "//*[text()='Warning: E-Mail Address is already registered!']")
    private WebElement emailAlreadyRegisteredWarningMessage;
    

    
    

    // Corrected the constructor name
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public boolean isEmailAlreadyRegisteredWarningMessageDisplayed() {
        return emailAlreadyRegisteredWarningMessage.isDisplayed();
    }

    public void enterFirstName(String firstNameText) {
        firstNameInput.sendKeys(firstNameText);
    }

    public void enterLastName(String lastNameText) {
        lastNameInput.sendKeys(lastNameText);
    }

    public void enterEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void enterTelephone(String telephone) {
        telephoneInput.sendKeys(telephone);
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        confirmPasswordInput.sendKeys(confirmPassword);
    }
    public void clickYesButton() {
        yesButton.click();
    }

    public void clickAgreeCheckbox() {
        agreeCheckbox.click();
    }

    public void clickContinueButton() {
        continueButton.click();
    }
    public boolean isAccountCreatedMessageDisplayed() {
        return accountCreatedMessage.isDisplayed();
    }

    public boolean isFirstNameErrorMessageDisplayed() {
        return firstNameErrorMessage.isDisplayed();
    }

    public boolean isLastNameErrorMessageDisplayed() {
        return lastNameErrorMessage.isDisplayed();
    }

    public boolean isEmailAddressErrorMessageDisplayed() {
        return emailAddressErrorMessage.isDisplayed();
    }

    public boolean isTelephoneErrorMessageDisplayed() {
        return telephoneErrorMessage.isDisplayed();
    }

    public boolean isPasswordErrorMessageDisplayed() {
        return passwordErrorMessage.isDisplayed();
    }
    public boolean isAccountRegisterDivDisplayed() {
        return accountRegisterDiv.isDisplayed();
    }
}
