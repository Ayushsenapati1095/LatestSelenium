package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {

	 public WebDriver driver;
	 public Properties prop;

	public WebDriver initializedriver() throws IOException {

		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\Ayush Senapati\\eclipse-workspace\\E2EProject\\src\\main\\java\\resources\\Data.properties");
		prop.load(fis);
		
		
		String browsername = prop.getProperty("browser");

		if (browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Ayush Senapati\\Documents\\Chrome\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	public void getScreenshotPath(String testcasename, WebDriver driver) throws IOException
	{
		
		TakesScreenshot tsc = (TakesScreenshot)driver;
		File Source = tsc.getScreenshotAs(OutputType.FILE);
		String Destination = System.getProperty("user.dir")+"//reports//"+testcasename+".png";
		FileUtils.copyFile(Source, new File(Destination));
	}
}
