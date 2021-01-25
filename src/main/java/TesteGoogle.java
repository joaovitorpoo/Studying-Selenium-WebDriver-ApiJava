import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.*;

public class TesteGoogle {
	@Test
	public void teste() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\estagio\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.google.com.br/");
		Assert.assertEquals("Google", driver.getTitle());	
	}
}