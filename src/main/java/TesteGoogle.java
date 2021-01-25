import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.*;

public class TesteGoogle {
	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\estagio\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver(); 
		
		driver.get("https://www.google.com.br/");
		System.out.println(driver.getTitle());
	}
}