package pagina;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DSL {
	
	private WebDriver driver;
	
	
	public DSL(WebDriver driver) {
		super();
		this.driver = driver;
	}


	public void escreve(String id_campo, String texto ) {
		driver.findElement(By.id(id_campo)).sendKeys(texto);
	}
	public String obterValorCampo(String id_campo) {
		return driver.findElement(By.id(id_campo)).getAttribute("value");
	}
	public void clicarRadio(String id) {
		driver.findElement(By.id(id)).click();
	}
	public boolean isVoidMarcado(String id) {
		return driver.findElement(By.id(id)).isSelected();
	}
	
	public void selecionarCombo(String id, String valor) {
		WebElement element = driver.findElement(By.id(id));
		Select combo = new Select(element);
		combo.selectByVisibleText(valor);
	}
	public String obterValorCombo(String id) {
		WebElement element = driver.findElement(By.id(id));
		Select combo = new Select(element);
		return combo.getFirstSelectedOption().getText();
	}
	
	public void clicarLink(String link) {
		driver.findElement(By.linkText(link)).click();
	}
	public String obterTexto(String id) {
		return driver.findElement(By.id(id)).getText();
	}
	public void clicarBotao(String id) {
		driver.findElement(By.id(id)).click();
	}
	public void botaoCadastrar(String id) {
		driver.findElement(By.id(id)).click();
	}	
}
