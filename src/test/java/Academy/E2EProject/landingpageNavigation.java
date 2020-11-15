package Academy.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobjects.LandingPage;
import resources.BaseClass;

public class landingpageNavigation extends BaseClass {
	public WebDriver driver;
	
	private static Logger log = LogManager.getLogger(landingpageNavigation.class.getName());
	
	@Test
	public void landingPagenavigation() throws IOException 
	{
		
		
		LandingPage LPage = new LandingPage(driver);
		LPage.getLogin().click();
		
		
	}

	@BeforeTest
	public void beforetesting() throws IOException
	{
		driver = initializedriver();
		driver.get(prop.getProperty("url"));
		log.info("landingpageNavigation-Invoked driver successfully");
	}
	@AfterTest
	public void aftertesting()
	{
		
		driver.close();
	}
	}

