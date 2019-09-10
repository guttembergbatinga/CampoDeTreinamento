package pagina;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class CampoDeTreinamento {
	
	private WebDriver driver;
	
	@Before
	public void inicializa() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Guto\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.a.testaddressbook.com/");
	}
	
	@After
	public void finaliza() {
		driver.quit();
	}
	
	@Test
	public void FabricaTeste() throws InterruptedException {
		
		WebElement clickSignIn = driver.findElement(By.xpath("//*[@id=\"sign-in\"]"));
		clickSignIn.click();

		Thread.sleep(2000);
		WebElement clickSignIn2 = driver.findElement(By.xpath("//input[@name='commit']"));
		clickSignIn2.click();
		WebElement validarMensagem = driver.findElement(By.xpath("/html/body/div/div[1]"));
		Assert.assertEquals("Bad email or password.", validarMensagem.getText());
		
		WebElement campoSenha = driver.findElement(By.id("session_password"));
		campoSenha.sendKeys("123456");
		WebElement clickSignIn3 = driver.findElement(By.xpath("//*[@id=\"clearance\"]/div/div/form/div[3]/input"));
		clickSignIn3.click();
		WebElement validarCampoSenha = driver.findElement(By.xpath("/html/body/div/div[1]"));
		Assert.assertEquals("Bad email or password.", validarCampoSenha.getText());
		
		WebElement campoLogin = driver.findElement(By.id("session_email"));
		campoLogin.sendKeys("gutobatinga@gmail.com");
		WebElement clickSignIn4 = driver.findElement(By.xpath("//*[@id=\"clearance\"]/div/div/form/div[3]/input"));
		clickSignIn4.click();
		WebElement validarCampoLogin = driver.findElement(By.xpath("/html/body/div/div[1]"));
		Assert.assertEquals("Bad email or password.", validarCampoLogin.getText());
		
		WebElement campoLoginDefinitivo = driver.findElement(By.id("session_email"));
		campoLoginDefinitivo.sendKeys("gutobatinga@gmail.com");
		WebElement campoSenhaDefinitivo = driver.findElement(By.id("session_password"));
		campoSenhaDefinitivo.sendKeys("123456");
		WebElement clickSignIn5 = driver.findElement(By.xpath("//*[@id=\"clearance\"]/div/div/form/div[3]/input"));
		clickSignIn5.click();
		WebElement validarEmail = driver.findElement(By.xpath("//*[@id=\"navbar\"]/div[2]/span"));
		Assert.assertEquals("gutobatinga@gmail.com", validarEmail.getText());
		
		WebElement validarMensagemBemVindo = driver.findElement(By.xpath("/html/body/div/div/h1"));
		Assert.assertEquals("Welcome to Address Book", validarMensagemBemVindo.getText());
		
		WebElement signOut = driver.findElement(By.xpath("//*[@id=\"navbar\"]/div[1]/a[3]"));
		signOut.click();
		WebElement signUp = driver.findElement(By.xpath("//*[@id=\"clearance\"]/div/div/form/div[4]/a"));
		signUp.click();
		Thread.sleep(2000);
		WebElement signUp2 = driver.findElement(By.xpath("//*[@id=\"new_user\"]/div[3]/input"));
		signUp2.click();

	}
}