package Academy.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resources.BaseClass;

public class LoginPageNavigation extends BaseClass {
	
	public WebDriver driver;
	
	private static Logger log = LogManager.getLogger(LoginPageNavigation.class.getName());
	@Test(dataProvider="getdata")
	public void LoginPagenavigation(String Username, String Password) throws IOException
	{
		
		driver = initializedriver();
		driver.get(prop.getProperty("url"));
		log.info(" LoginPageNavignarion-Invoked browser successfully");
		LandingPage LPage = new LandingPage(driver);
		LPage.getLogin().click();
		log.info(" LoginPageNavignarion-Clicked successfully");
		LoginPage LogPage = new LoginPage(driver);
		LogPage.getLogin().sendKeys(Username);
		log.info(" LoginPageNavignarion-sent username successfully");
		LogPage.getPassword().sendKeys(Password);
		log.info(" LoginPageNavignarion-sent password successfully");
		LogPage.getLoginBtn().click();
		
		
	}

	@DataProvider
	public Object[][] getdata()
	{
		Object[][] data = new Object[2][2];
		data[0][0] = "abc1";
		data[0][1] = "pwd1";
		data[1][0] = "abc2";
		data[1][1] = "pwd2";
		
		return data;
		
	}
	
	@AfterTest
	public void aftertesting()
	{
		
		driver.close();
	}
	
	@BeforeTest
	public void beforetesting() throws IOException
	{
		
		driver = initializedriver();
		driver.get(prop.getProperty("url"));
	}
}
