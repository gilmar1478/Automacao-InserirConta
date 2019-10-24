package br.com.empresa.steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class InserirConta {
	
	private WebDriver driver;
	
	@Dado("^que estou acessando a aplicacao$")
	public void que_estou_acessando_a_aplicacao() throws Throwable {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\gilmar.filho\\Documents\\DRIVER\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://srbarriga.herokuapp.com");	}

	@Quando("^informo o usuario \"(.*?)\"$")
	public void informo_o_usuario(String arg1) throws Throwable {
	//	driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(arg1);
		driver.findElement(By.id("email")).sendKeys(arg1);
	}

	@Quando("^a senha \"(.*?)\"$")
	public void a_senha(String arg1) throws Throwable {
		driver.findElement(By.id("senha")).sendKeys(arg1);
		//driver.findElement(By.xpath("//*[@id=\"senha\"]")).sendKeys(arg1);
	}

	


	@Quando("^seleciono entrar$")
	public void selecionoEntrar() throws Throwable {
		driver.findElement(By.tagName("button")).click();
	}

	@Entao("^visualizo a pagina inicial$")
	public void visualizoAPaginaInicial() throws Throwable {
		String texto = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
		Assert.assertEquals("Bem vindo, gilmar!", texto);
	}
	
	
	
}
