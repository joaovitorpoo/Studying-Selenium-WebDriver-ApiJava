import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteCampoTreinamento {
	
	@Test
	public void teste () {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/src/main/resources/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///"+System.getProperty("user.dir")+"/src/main/resources/componentes.html");
		
		
		driver.quit();
	}
	
}
