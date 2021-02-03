package br.ce.wcaquino.test;

import static br.ce.wcaquino.core.DriverFactory.getDriver;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import br.ce.wcaquino.core.BaseTest;
import br.ce.wcaquino.core.DSL;

public class TesteAjax extends BaseTest {
	
	private DSL dsl = new DSL();

	@Before
	public void inicializa(){
		getDriver().get("https://www.primefaces.org/showcase/ui/ajax/basic.xhtml");
	}

	@Test
	public void testAjax(){
		dsl.escrever("j_idt263:name", "Teste");
		dsl.clicarBotao("j_idt263:j_idt267");
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
//		wait.until(ExpectedConditions.textToBe(By.id("j_idt85:display"), "Teste"));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("j_idt263:display")));
		Assert.assertEquals("Teste", dsl.obterTexto("j_idt263:display"));
	}
}
