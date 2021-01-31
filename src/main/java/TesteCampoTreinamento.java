import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

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
	
	@Test 
	public void testeCombo() {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/src/main/resources/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///"+System.getProperty("user.dir")+"/src/main/resources/componentes.html");
		
		// Criando objeto do combo 
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
		
		// Selecionando opção
		// combo.selectByIndex(2);
		// combo.selectByValue("2graucomp");
		combo.selectByVisibleText("2o grau completo");
		
		Assert.assertEquals("2o grau completo", combo.getFirstSelectedOption().getText());
		
		driver.quit();
	}
	
	@Test 
	public void testeComboVerificarOptions() {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/src/main/resources/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///"+System.getProperty("user.dir")+"/src/main/resources/componentes.html");
		
		// Criando objeto do combo 
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
		Assert.assertEquals(8, options.size());
		
		boolean encontrou = false;
		for (WebElement option: options) {
			if (option.getText().equals("2o grau completo")) {
				encontrou = true;
				break;
			}
		}
		Assert.assertTrue(encontrou);
		
		driver.quit();
	}
	
	@Test 
	public void testeComboMultiplo() {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/src/main/resources/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///"+System.getProperty("user.dir")+"/src/main/resources/componentes.html");
		
		// Criando objeto do combo e selecionando opções
		WebElement element = driver.findElement(By.id("elementosForm:esportes"));
		Select combo = new Select(element);
		combo.selectByVisibleText("Natacao");
		combo.selectByVisibleText("Corrida");
		combo.selectByVisibleText("O que eh esporte?");
		
		// Criando Lista com todas opções selecionadas e verificando tamanho 
		List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
		Assert.assertEquals(3, allSelectedOptions.size());
		
		// Deselecionando uma opção do combo 
		combo.deselectByVisibleText("Corrida");
		
		// Criando Lista com todas opções selecionadas e verificando tamanho
		allSelectedOptions = combo.getAllSelectedOptions();
		Assert.assertEquals(2, allSelectedOptions.size());
		
		driver.quit();
	}
	
	@Test 
	public void testeBotao() {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/src/main/resources/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///"+System.getProperty("user.dir")+"/src/main/resources/componentes.html");
		
		// Criando objeto do Botao
		WebElement botao = driver.findElement(By.id("buttonSimple"));
		botao.click();
		
		Assert.assertEquals("Obrigado!", botao.getAttribute("value"));
		driver.quit();
	}
	
	@Test
	public void testeLink() {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/src/main/resources/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///"+System.getProperty("user.dir")+"/src/main/resources/componentes.html");
	
		driver.findElement(By.linkText("Voltar")).click();
		
		Assert.assertEquals("Voltou!", driver.findElement(By.id("resultado")).getText());
		driver.quit();
	}
	
	@Test
	public void testeTextoPagina() {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/src/main/resources/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///"+System.getProperty("user.dir")+"/src/main/resources/componentes.html");
		
		// Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Campo de Treinamento"));
		Assert.assertEquals("Campo de Treinamento", driver.findElement(By.tagName("h3")).getText());
		Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", driver.findElement(By.className("facilAchar")).getText());
		
		driver.quit();
	}
	
	@Test
	public void testJavascript(){
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/src/main/resources/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("alert('Testando js via selenium')");
		js.executeScript("document.getElementById('elementosForm:nome').value = 'Escrito via js'");
		js.executeScript("document.getElementById('elementosForm:sobrenome').type = 'radio'");
		
		WebElement element = driver.findElement(By.id("elementosForm:nome"));
		js.executeScript("arguments[0].style.border = arguments[1]", element, "solid 4px red");
	}
}
