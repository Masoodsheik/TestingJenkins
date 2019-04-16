package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver rdriver) {

		this.driver = rdriver;
		PageFactory.initElements(rdriver, this);

	}

	@FindBy(id = "txtUsername")
	private WebElement txtuserid;

	@FindBy(id = "txtPassword")
	private WebElement txtPassword;

	@FindBy(id = "btnLogin")
	private WebElement btSign;

	public void SetUserName(String uName) {
		if (txtuserid.isDisplayed()) {
			txtuserid.sendKeys(uName);
		}
	}

	public void SetPassword(String Pass) {

		txtPassword.sendKeys(Pass);
	}

	public void ClickSubmit() {
		btSign.click();

	}

	public String getUserName() // method to validate field
	{
		return txtuserid.getAttribute("text");
		// return txtuserid.getText();

	}

}
