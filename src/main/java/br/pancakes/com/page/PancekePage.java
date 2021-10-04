package br.pancakes.com.page;

import java.util.Date;

import org.openqa.selenium.By;

public class PancekePage extends BasePage {

	By btnTokenOrigem = By.cssSelector("#pair");
	By btnTokenDestinoLiquidity = By.cssSelector("#pair");
	// $('#pair')
	// .sc-bSFVuW.fljIva.open-currency-select-button
	// By btnTokenOrigem = By.xpath("//button[@class='sc-bSFVuW fljIva
	// open-currency-select-button']/span/img");
	// $('.sc-bSFVuW.fljIva.open-currency-select-button>span>svg')
	// button[@class='sc-bSFVuW fljIva open-currency-select-button']
	By inputPesquisaTokenOrigem = By.xpath("//input[@id='token-search-input']");
	By btnAdd = By.cssSelector(".sc-tYoTV.cHBxSL");
	By btnAddLiquitidy = By.xpath("//button[text()='(Add)']/../../../../..");

	By listaTokenDigitado = By.xpath("//button[@class='sc-tYoTV cHBxSL']/../../..");
	By resultadoPesquisaToken = By.cssSelector(".sc-ctaXAZ.edemjN>.sc-cvJHqN.ksHHfG");

	By inputValorToken1 = By.cssSelector("#swap-currency-input .sc-jifIRw.gUwrWX.token-amount-input");
	By inputValorDestinoLiquidity = By.xpath("//button[text()='MAX']/..//input");
	By inputValorOrigemLiquidity = By.cssSelector("#add-liquidity-input-tokena .sc-eishCr.ktsCfQ.token-amount-input");

	By id = By.id("token-search-input");

	By btnSlippage = By.cssSelector("#open-settings-dialog-button");
	By inputSlippage = By.cssSelector(".sc-jrAGrp.eALlWT");
	By btnFechartSlippage = By.cssSelector(".sc-bdfBwQ.fxYfwL");

	By balance = By.cssSelector(".sc-eishCr.ktsCfQ.token-amount-input");
	By btnMax = By.xpath("//button[text()='MAX']");

	By contratoToken = By.cssSelector("//div[@title='Pepper Finance']");

	By btnTokenSwapDestino = By.xpath("//div[text()='To']/../../../..//button");

	// liquidy
	By btnTokenLiquidyDestino = By.xpath("//div[text()='Select a currency']");
	By inputTokenLiquidyDestino = By.cssSelector("#token-search-input");
	By textoTokenName = By.xpath("//div[@class='sc-cbDGPM jImoym']");

	By inputPesquisaToken2 = By.xpath("//input[@id='token-search-input']");
	By inputValorToken2 = By.xpath("//div[text()='To (estimated)']/../../../..//input");
	By inputValorTeste = By.cssSelector(".sc-eishCr.ktsCfQ.token-amount-input");
	By inputValorOrigem = By.cssSelector(".sc-eishCr.ktsCfQ.token-amount-input");

	By nomeMoeda = By.cssSelector(".sc-gsTCUz.hJWxft");
	By textSeletToken = By.xpath("//div[text()='Select a token']");
	By confirmarLiquidity = By.xpath("//button[text()='Enter an amount']");

	public PancekePage ValoresPancakeSwap(String tokenOrigem, String tokenDestino, String Slippage) {

		tempo();
		// SLIPPAGE
		RealizarSlippage(Slippage);

		// ORIGEM
		clickAcceptButton(btnTokenOrigem);
		escrever(inputPesquisaTokenOrigem, tokenOrigem);
		tempo();
		pressionarEnter(inputPesquisaTokenOrigem);
		tempo();
		clickDuplo(btnMax);
		String valor = obterTexto(inputValorOrigem);

		while (valor.equals("")) {
			clickDuplo(btnMax);
			valor = obterTexto(inputValorOrigem);
		}

		// DENTINO
		clicar(btnTokenSwapDestino);
		tempo();
		escrever(inputPesquisaToken2, tokenDestino);
		tempo();
		pressionarEnter(inputPesquisaToken2);
		EsperarElementoOff(textSeletToken);
		String valorInput = obterTexto(inputValorTeste);

		while (valorInput.equals("")) {
			valorInput = obterTexto(inputValorTeste);
			System.out.println(valor);
		}

		String moeda = obterTextoToken(nomeMoeda);

		// SAÍDA
		System.out.println("------------SWAP------------------------------");
		System.out.println("TOKEN ORIGEM: " + moeda);
		System.out.println(" MAX: " + valor);
		System.out.println("TOKEN DESTINO: " + tokenDestino);
		System.out.println("VALOR: " + valorInput);
		Date date = java.util.Calendar.getInstance().getTime();
		System.out.println(date);
		return this;
	}

	public PancekePage ValoresPancakeLiquidity(String tokenOrigem, String tokenDestino) {

		// ORIGEM
		clickAcceptButton(btnTokenOrigem);
		escrever(id, tokenOrigem);
		pressionarEnter(id);
		tempo();
		tempo();
		tempo();
		String valor = obterTextoToken(balance);
		clickDuplo(btnMax);

		while (valor.equals("")) {
			valor = obterTexto(balance);
		}

		// DENTINO
		clicar(btnTokenLiquidyDestino);
		tempo();
		escrever(inputTokenLiquidyDestino, tokenDestino);
		tempo();
		pressionarEnter(inputTokenLiquidyDestino);
		String valorDestinoLiquidity = obterTexto(inputValorDestinoLiquidity);

		while (valorDestinoLiquidity.equals("")) {

			valorDestinoLiquidity = obterTexto(inputValorDestinoLiquidity);
		}

		System.out.println(confirmarLiquidity);

		// SAÍDA
		String tokenOrigemLiquidity = obterTextoToken(nomeMoeda);
		String valorOrigemLiquidity = obterTexto(inputValorOrigemLiquidity);
		valorDestinoLiquidity = obterTexto(inputValorDestinoLiquidity);

		System.out.println("------------LIQUIDITY------------------------------");
		System.out.println("TOKEN ORIGEM: " + tokenOrigemLiquidity);
		System.out.println("VALOR ORIGEM: " + valorOrigemLiquidity);

		System.out.println("TOKEN DESTINO: " + tokenDestino);
		System.out.println("VALOR DESTINO: " + valorDestinoLiquidity);
		return this;
	}

	public PancekePage RealizarSlippage(String slippage) {
		clicar(btnSlippage);
		escrever(inputSlippage, slippage);
		clicar(btnFechartSlippage);
		return this;
	}

}
