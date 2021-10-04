package br.pancakes.com.page;

import static java.util.concurrent.TimeUnit.SECONDS;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	static WebDriver driver;
	// static String navegador = "CHROME-HEADLESS";
	static String navegador = "CHROME-METAMASK";
	// static String navegador = "CHROME";
	static String urlPagina = "https://exchange.pancakeswap.finance/#/swap";
	// https://www.canalcliente.com.br/portal/canal_cliente/index.htm

	static WebDriverWait espera;

	@SuppressWarnings("deprecation")
	public static void abrirPaginaInicial() {

		if (navegador.equals("CHROME")) {
			File file = new File("src\\test\\resources\\drives\\chromedriver94_4_96.exe");
			System.setProperty("webdriver.chrome.driver", file.getPath());
			driver = new ChromeDriver();
			espera = new WebDriverWait(driver, 100);
			driver.navigate().to(urlPagina);
			driver.manage().window().maximize();

		}

		else if (navegador.equals("CHROME-HEADLESS")) {
			File file = new File("src\\test\\resources\\drives\\chromedriver94_4_96.exe");
			System.setProperty("webdriver.chrome.driver", file.getPath());
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("profile.default_content_settings.popups", 0);
			chromePrefs.put("download.default_directory", "c:\\arquivos");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.setExperimentalOption("prefs", chromePrefs);
			DesiredCapabilities cap = DesiredCapabilities.chrome();
			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			cap.setCapability(ChromeOptions.CAPABILITY, options);
			driver = new ChromeDriver(cap);
			espera = new WebDriverWait(driver, 100);
			driver.navigate().to(urlPagina);
			driver.manage().window().maximize();

		} else if (navegador.equals("CHROME-METAMASK")) {
			String url = "https://exchange.pancakeswap.finance/#/swap";
			//local do driver
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\BrowserDriver\\chromedriver94_4_96.exe");
	

			ChromeOptions options = new ChromeOptions();
			//colocar o caminho do seu navegador aqui
			options.addArguments("user-data-dir=C:/Users/sergio.rodrigues/AppData/Local/Google/Chrome/User Data");
			
			options.addArguments("start-maximized");

			driver = new ChromeDriver(options);
			espera = new WebDriverWait(driver, 100);
			driver.get(url);
			driver.get("chrome-extension://nkbihfbeogaeaoehlefnkodbefgpgknn/home.html#initialize/welcome");
		}

	}

	public static void FecharNavegador() {
		driver.quit();
	}
	
	public static void FecharNavegadorAtual() {
		driver.close();
	}

	public String verificarBotaoSwap(By by) {
		espera.until(ExpectedConditions.visibilityOfElementLocated(by));
		WebElement element = driver.findElement(by);

		try {
			element.getText();
			return "Swap";
		} catch (Exception e) {
			System.out.println(e);
			return "Aprovar";
		}

	}

	public String verificarBotaoDismiss(By by) {

		try {
			WebElement element = driver.findElement(by);
			element.getText();
			return "Dismiss";
		} catch (Exception e) {
			System.out.println(e);
			return "NoDismiss";
		}

	}

	public void IrParaModal() {
		String janelaAtual = driver.getWindowHandle();
		System.out.println(janelaAtual);

	}

	public String verificarMsgErro(By by) {
		// espera.until(ExpectedConditions.visibilityOfElementLocated(by));
	

		try {
			WebElement element = driver.findElement(by);
			tempo();
			return element.getText();
		} catch (Exception e) {
			System.out.println(e);
			return "gasOK";
		}

	}

	public static void IrParaPagina(String texto) {
		driver.get(texto);
	}

	public void tempo() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<WebElement> listaElemetos(By by) {

		List<WebElement> results = driver.findElements(by);

		return results;

	}

	public void esperarElemento(By by) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void escrever(By by, String texto) {
		espera.until(ExpectedConditions.visibilityOfElementLocated(by));
		driver.findElement(by).clear();
		driver.findElement(by).sendKeys(texto);
	}

	public void entrarFrame(String frame) {
		espera.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
	}

	public void sairFrame() {
		driver.switchTo().defaultContent();
	}

	public void EsperarElementoOff(By locator) {
		espera.until(ExpectedConditions.invisibilityOfElementLocated(locator));

	}

	public void irParaMenu(By by) {
		espera.until(ExpectedConditions.visibilityOfElementLocated(by));
		WebElement element = driver.findElement(by);
		Actions actionProvider = new Actions(driver);
		actionProvider.clickAndHold(element).build().perform();
	}

	public void clicar(By by) {
		espera.until(ExpectedConditions.visibilityOfElementLocated(by));
		driver.findElement(by).click();
	}

	public void clickAcceptButton(By by) {
		WebElement element = driver.findElement(by);

		try {
			waitForSeconds(3);
			waitForElementToBeVisible(driver, element);
			// element.click();
			element.click();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void waitForSeconds(int timeoutInSeconds) {
		try {
			Thread.sleep(timeoutInSeconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static <T> void waitForElementToBeVisible(WebDriver driver, WebElement element) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(120, SECONDS).pollingEvery(5, SECONDS)
				.ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
		wait.until((Function<? super WebDriver, T>) ExpectedConditions.visibilityOf(element));
	}

	public void pressionarEnter(By by) {
		espera.until(ExpectedConditions.visibilityOfElementLocated(by));
		WebElement textbox = driver.findElement(by);
		textbox.sendKeys(Keys.ENTER);
	}

	public void fecharNavegador() {
		driver.quit();

	}

	public void clickDuplo(By by) {
		// espera.until(ExpectedConditions.visibilityOfElementLocated(by));
		WebElement element = driver.findElement(by);
		Actions act = new Actions(driver);
		act.moveToElement(element).click().build().perform();

	}

	public void rolarParaBaixo() {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scrollBy(0,500)", "");
	}

	public String obterTexto(By by) {
		espera.until(ExpectedConditions.visibilityOfElementLocated(by));
		String texto = driver.findElement(by).getAttribute("value");
		return texto;
	}

	public String obterTextoToken(By by) {
		espera.until(ExpectedConditions.visibilityOfElementLocated(by));
		String texto = driver.findElement(by).getText();
		return texto;
	}

	public String ListElementsInputValores(By by) {
		String valor = "";
		int i = 0;
		List<WebElement> elementsList = driver.findElements(by);
		for (WebElement checkBox : elementsList) {
			i++;
			// checkBox = elementsList.get(i);
			if (i == 2) {
				valor = checkBox.getText();
			}

		}
		return valor;
	}

	public String javaScript() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById(\"buyprice\").disabled = false");
		js.executeScript("document.getElementById(\"buyprice\").removeAttribute(\"data-base\");");
		js.executeScript("document.getElementById(\"buyprice\").removeAttribute(\"data-ref\")");
		js.executeScript("document.getElementById(\"buyprice\").removeAttribute(\"class\")");
		js.executeScript("document.getElementById(\"buyprice\").removeAttribute(\"disabled\")");

		String texto = (String) js.executeScript("document.getElementById(\"buyprice\").value ");
		return texto;
	}

	public void rolagemParaBaixo() {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scrollBy(0,250)", "");

	}

	public void rolagemParaCima() {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scrollBy(0,-250)", "");

	}

	public void javaScriptBuytotal() {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("document.getElementById(\"buytotal\").removeAttribute(\"data-base\");");

	}

	public void voltar() {
		tempo();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("history.go(-1);");

	}

	public void selectCombo(By by, String texto) {
		Select drpCountry = new Select((driver.findElement(by)));
		drpCountry.selectByVisibleText(texto);

	}

	public int listaTable(By by) {
		int qtd = driver.findElements(by).size();
		return qtd;
	}

	public WebElement retornaElemento(By by) {
		WebElement element = driver.findElement(by);
		return element;
	}

}
