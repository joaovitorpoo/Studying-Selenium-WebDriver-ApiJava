package br.ce.wcaquino.test;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.*;

public class TesteGoogle {
	
	@Test
	public void teste() {
		// ----------------- DEFININDO DRIVER DO NAVEGADOR ------------------------------------------------------
		
		// FIREFOX 
		//System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/src/main/resources/geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();
		
		// GOOGLE CHROME
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com.br/");
		Assert.assertEquals("Google", driver.getTitle());
		
		// POSICAO DA JANELA
		// driver.manage().window().setPosition(new Point(500, 200));
		
		// TAMANHO DA JANELA
		 driver.manage().window().setSize(new Dimension(400, 300));
		
		// FECHA SO A ABA
		// driver.close();
		
		// FECHA O DRIVE 
		//driver.quit();
	}
	
}