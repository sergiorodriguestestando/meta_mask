package br.pancakes.com.page;

import java.util.Date;

import org.openqa.selenium.By;

public class PancekePage extends BasePage {

	// origem
	By btnTokenOrigem = By.xpath("//div[text()='From']/../../..//button");
	
	By ValorTokenOrigem = By.id("pair");

	
	By inputPesquisaTokenOrigem = By.xpath("//input[@id='token-search-input']");

	// destino

	By btnTokenDestino = By.xpath("//div[text()='To']/../../..//button");
	By inputPesquisaTokDestino = By.id("token-search-input");
	By inputValorDestino = By.xpath("//div[text()='To (estimated)']/../../..//input");

	By btnTokenDestinoLiquidity = By.cssSelector("#pair");
	// $('#pair')
	// .sc-bSFVuW.fljIva.open-currency-select-button
	// By btnTokenOrigem = By.xpath("//button[@class='sc-bSFVuW fljIva
	// open-currency-select-button']/span/img");
	// $('.sc-bSFVuW.fljIva.open-currency-select-button>span>svg')
	// button[@class='sc-bSFVuW fljIva open-currency-select-button']

	By btnAdd = By.cssSelector(".sc-tYoTV.cHBxSL");
	By btnAddLiquitidy = By.xpath("//button[text()='(Add)']/../../../../..");

	By listaTokenDigitado = By.xpath("//button[@class='sc-tYoTV cHBxSL']/../../..");
	By resultadoPesquisaToken = By.cssSelector(".sc-ctaXAZ.edemjN>.sc-cvJHqN.ksHHfG");

	By inputValorToken1 = By.xpath("//input[@class='sc-iMCRTP iOdHiq token-amount-input']");
	By inputValorDestinoLiquidity = By.xpath("//button[text()='MAX']/..//input");
	By inputValorOrigemLiquidity = By.cssSelector("#add-liquidity-input-tokena .sc-eishCr.ktsCfQ.token-amount-input");

	By id = By.id("token-search-input");

	By btnSlippage = By.cssSelector("#open-settings-dialog-button");
	By btnValorSlippage = By.xpath("//button[text()='0.5%']");
	By inputSlippage = By.cssSelector(".sc-jrAGrp.eALlWT");
	By btnFechartSlippage = By.cssSelector("button.sc-hKFxyN.YaON.sc-eCApnc.fAYopv");

	By balance = By.cssSelector(".sc-eishCr.ktsCfQ.token-amount-input");
	By btnMax = By.xpath("//button[text()='MAX']");

	By contratoToken = By.cssSelector("//div[@title='Pepper Finance']");

	// liquidy
	By btnTokenLiquidyDestino = By.xpath("//div[text()='Select a currency']");
	By inputTokenLiquidyDestino = By.cssSelector("#token-search-input");
	By textoTokenName = By.xpath("//div[@class='sc-cbDGPM jImoym']");

	// By btnImport = By.cssSelector(".sc-jSFjdj.igCRCE button");

	By btnImportSimples = By.cssSelector(".sc-hKFxyN.kotmuB");
	By btnImportHero = By.cssSelector(".sc-fvNhHS.jWpfOZ button");
	By btnImportFinal = By.cssSelector(".sc-hKFxyN dKApOB.token-dismiss-button");

	By textNoResults = By.cssSelector(".sc-gtsrHT.cuPiSY");
	By btnFechar = By.cssSelector(".sc-hKFxyN.YaON.sc-eCApnc.fAYopv");

	By btnImportInterno = By.xpath("//button[@class='sc-hKFxyN dKApOB .token-dismiss-button']");
	By btnManageToken = By.xpath("//button[text()='Manage Tokens']");

	By checkConfirmed = By.xpath("//input[@name='confirmed']");

	By inputValorToken2 = By.xpath("//div[text()='To (estimated)']/../../../..//input");

	By inputValorOrigem = By.cssSelector("input.sc-iMCRTP.iOdHiq.token-amount-input");

	By nomeMoeda = By.cssSelector(".sc-gsTCUz.hJWxft");
	By textSeletToken = By.xpath("//div[text()='Select a token']");
	By confirmarLiquidity = By.xpath("//button[text()='Enter an amount']");

	public PancekePage ValoresPancakeSwap(String tokenOrigem, String tokenDestino, String qtd) {

		// SLIPPAGE
		// RealizarSlippage(Slippage);

		// ORIGEM
		String valorInput;
		clicar(btnTokenOrigem);
		tempo();
		escrever(inputPesquisaTokenOrigem, tokenOrigem);
		tempo();
		pressionarEnter(inputPesquisaTokenOrigem);
		tempo();

		// while (valor.equals("")) {
		// clickDuplo(btnMax);
		// valor = obterTexto(inputValorOrigem);
		// }

		// DENTINO
		clicar(btnTokenDestino);
		tempo();
		escrever(inputPesquisaTokDestino, tokenDestino);
		tempo();
		pressionarEnter(inputPesquisaTokDestino);
		// EsperarElementoOff(textSeletToken);
		escrever(inputValorToken1, qtd);
		valorInput = obterTexto(inputValorDestino);

		// while (valorInput.equals("")) {
		// valorInput = obterTexto(inputValorDestino);
		//
		// }
		//

		// String moeda = obterTextoToken(nomeMoeda);

		// SAÍDA
		System.out.println("------------SWAP------------------------------");
		// System.out.println("TOKEN ORIGEM: " + moeda);
		String valor = obterTexto(inputValorToken1);
		System.out.println(" MAX: " + valor);
		System.out.println("TOKEN DESTINO: " + tokenDestino);
		System.out.println("VALOR: " + valorInput);
		Date date = java.util.Calendar.getInstance().getTime();
		System.out.println(date);
		return this;
	}

	public PancekePage BuscarValoresPancakes(String tokenOrigem, String tokenDestino, String qtd) {
		String elemento = null;
		Boolean resultadoElemento = null;

		// ORIGEM
		String valor = "";
		String valorInput;
		clicar(btnTokenOrigem);
		tempo();
		escrever(inputPesquisaTokenOrigem, tokenOrigem);
		tempo();
		pressionarEnter(inputPesquisaTokenOrigem);
		tempo();

		int tamanho = tokenOrigem.length();

		if (tamanho > 6 || tokenOrigem.equals("HERO")) {

			elemento = verificarElementoPagina(btnImportSimples);
			resultadoElemento = ValidarElementonNaPagina(textNoResults);
			if (elemento.equals("Import")) {

				if (tokenOrigem.equals("HERO")) {
					clicarPrimeiro(btnImportHero);
				} else {
					clicar(btnImportSimples);
				}

				tempo();
				clicar(checkConfirmed);
				tempo();
				clicar(btnImportInterno);
				tempo();
				clicar(btnTokenDestino);
				tempo();
				escrever(inputPesquisaTokDestino, tokenDestino);
				tempo();
				pressionarEnter(inputPesquisaTokDestino);
				escrever(inputValorToken1, qtd);

			} else if (!resultadoElemento) {
				clicar(btnFechar);
				System.out.println("Sem dados");

			} else {
				tempo();
				clicar(btnTokenDestino);
				tempo();
				escrever(inputPesquisaTokDestino, tokenDestino);
				tempo();
				pressionarEnter(inputPesquisaTokDestino);
				tempo();
				escrever(inputValorToken1, qtd);
				tempo();

				while (valor.equals("")) {
					valor = obterTexto(inputValorOrigem);
				}

			}

			System.out.println("---------------------------------------------------------------------");
			valorInput = obterTexto(inputValorDestino);
			System.out.println("TOKEN ORIGEM: " + obterTextoToken(ValorTokenOrigem));
			valor = obterTexto(inputValorToken1);
			System.out.println(" MAX: " + valor);
			System.out.println("TOKEN DESTINO: " + tokenDestino);
			System.out.println("VALOR: " + valorInput);
			Date date = java.util.Calendar.getInstance().getTime();
			System.out.println(date);
			IrParaPagina("https://pancakeswap.finance/swap");

		} else {

			tempo();
			clicar(btnTokenDestino);
			tempo();
			escrever(inputPesquisaTokDestino, tokenDestino);
			tempo();
			pressionarEnter(inputPesquisaTokDestino);
			tempo();
			escrever(inputValorToken1, qtd);
			tempo();

			// SAÍDA
			System.out.println("---------------------------------------------------------------------");
			valorInput = obterTexto(inputValorDestino);
			System.out.println("TOKEN ORIGEM: " + obterTextoToken(ValorTokenOrigem));
			valor = obterTexto(inputValorToken1);
			System.out.println(" MAX: " + valor);
			System.out.println("TOKEN DESTINO: " + tokenDestino);
			System.out.println("VALOR: " + valorInput);
			Date date = java.util.Calendar.getInstance().getTime();
			System.out.println(date);
			IrParaPagina("https://pancakeswap.finance/swap");
			return this;

		}
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
		// escrever(inputSlippage, slippage);
		clicar(btnValorSlippage);
		clicar(btnFechartSlippage);
		return this;
	}

}
