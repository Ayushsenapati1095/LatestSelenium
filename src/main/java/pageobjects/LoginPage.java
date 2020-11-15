package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;

	By Login = By.id("user_email");
	By Password = By.id("user_password");
	By LoginBtn = By.xpath("//input[@type='submit']");

	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public WebElement getLogin() {

		return driver.findElement(Login);

	}

	public WebElement getPassword() {

		return driver.findElement(Password);

	}
	
	public WebElement getLoginBtn() {

		return driver.findElement(LoginBtn);

	}
	
}
