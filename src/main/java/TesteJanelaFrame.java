import static br.ce.wcaquino.core.DriverFactory.getDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.ce.wcaquino.core.DSL;
import br.ce.wcaquino.core.DriverFactory;

public class TesteJanelaFrame {
	
	private DSL dsl = new DSL();
	
	@Before
	public void inicializa(){
		getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	}
	
	@After
	public void finaliza(){
		DriverFactory.killDriver(); 
	}
	
	@Test
	public void testeFrames(){
		// Entra no frame
		getDriver().switchTo().frame("frame1");
		getDriver().findElement(By.id("frameButton")).click();
		Alert alert = getDriver().switchTo().alert();
		String msg = alert.getText();
		Assert.assertEquals("Frame OK!", msg);
		alert.accept();
		
		// Sai do frame
		getDriver().switchTo().defaultContent();
		
		getDriver().findElement(By.id("elementosForm:nome")).sendKeys(msg);
	}
	
	@Test
	public void deveInteragirComFrameEscondido(){
		WebElement frame = getDriver().findElement(By.id("frame2"));
		dsl.executarJS("window.scrollBy(0, arguments[0])", frame.getLocation().y);
		dsl.entrarFrame("frame2");
		dsl.clicarBotao("frameButton");
		String msg = dsl.alertaObterTextoEAceita();
		Assert.assertEquals("Frame OK!", msg);
	}
	
	@Test
	public void testeJanelas(){
		getDriver().findElement(By.id("buttonPopUpEasy")).click();
		
		// Entra na Janela
		getDriver().switchTo().window("Popup");
		getDriver().findElement(By.tagName("textarea")).sendKeys("Deu certo?");
		
		// Sai da Janela
		getDriver().switchTo().window("");
		getDriver().findElement(By.tagName("textarea")).sendKeys("e agora?");
	}
	
	@Test
	public void testeJanelasSemTitulo(){
		getDriver().findElement(By.id("buttonPopUpHard")).click();
		System.out.println(getDriver().getWindowHandle());
		System.out.println(getDriver().getWindowHandles());
		getDriver().switchTo().window((String) getDriver().getWindowHandles().toArray()[1]);
		getDriver().findElement(By.tagName("textarea")).sendKeys("Deu certo?");
		getDriver().switchTo().window((String) getDriver().getWindowHandles().toArray()[0]);
		getDriver().findElement(By.tagName("textarea")).sendKeys("E agora?");
	}
}