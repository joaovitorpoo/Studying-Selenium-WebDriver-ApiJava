import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.*;

public class TesteGoogle {
	
	@Test
	public void teste() {
		// ----------------- DEFININDO DRIVER DO NAVEGADOR ------------------------------------------------------
		
		// FIREFOX 
		// System.setProperty("webdriver.gecko.driver", "../Studying-Selenium-WebDriver-ApiJava/geckodriver.exe");
		// WebDriver driver = new FirefoxDriver();
		
		// GOOGLE CHROME
		System.setProperty("webdriver.chrome.driver", "../Studying-Selenium-WebDriver-ApiJava/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com.br/");
		Assert.assertEquals("Google", driver.getTitle());
		
		// FECHA SO A ABA
		// driver.close();
		
		// FECHA O DRIVE 
		driver.quit();
	}
	
}