import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteCampoTreinamento {
	
	@Test
	public void testeTextField () {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/src/main/resources/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///"+System.getProperty("user.dir")+"/src/main/resources/componentes.html");
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Joao Vitor Pinto");
		Assert.assertEquals("Joao Vitor Pinto", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
		driver.quit();
	}
	
	@Test 
	public void testeTextArea() {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/src/main/resources/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///"+System.getProperty("user.dir")+"/src/main/resources/componentes.html");
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("testeeeeeeee\n\n\ntesteeeeeeeee\n\n\ntesteeeeeeeee");
		Assert.assertEquals("testeeeeeeee\n\n\ntesteeeeeeeee\n\n\ntesteeeeeeeee", driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
		driver.quit();
	}
	
	@Test 
	public void testeRadio() {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/src/main/resources/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///"+System.getProperty("user.dir")+"/src/main/resources/componentes.html");
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());
		driver.quit();
	}
	
	@Test 
	public void testeCheckBox() {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/src/main/resources/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///"+System.getProperty("user.dir")+"/src/main/resources/componentes.html");
		driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected());
		driver.quit();
	}
}
