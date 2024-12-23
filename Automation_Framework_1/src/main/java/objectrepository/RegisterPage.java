package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	public RegisterPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="gender-male")
	private WebElement maleOption;
	@FindBy(id="FirstName")
	private WebElement firstNameTextField;
	@FindBy(id="LastName")
	private WebElement lastNameTextField;
	@FindBy(id="Email")
	private WebElement emailTextField;
	@FindBy(id="Password")
	private WebElement passwordTextField;
	@FindBy(id="ConfirmPassword")
	private WebElement confirmPassTextField;
	public WebElement getMaleOption() {
		return maleOption;
	}
	public WebElement getFirstNameTextField() {
		return firstNameTextField;
	}
	public WebElement getLastNameTextField() {
		return lastNameTextField;
	}
	public WebElement getEmailTextField() {
		return emailTextField;
	}
	public WebElement getPasswordTextField() {
		return passwordTextField;
	}
	public WebElement getConfirmPassTextField() {
		return confirmPassTextField;
	}
}
