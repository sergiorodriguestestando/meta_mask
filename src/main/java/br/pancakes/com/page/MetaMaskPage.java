package br.pancakes.com.page;

import org.openqa.selenium.By;

public class MetaMaskPage extends BasePage {

	PancekePage pancekePage = new PancekePage();

	By inputSenha = By.xpath("//input[@id='password']");
	By btnDesbloqeurar = By.xpath("//span[@class='MuiButton-label']");
	By cota = By.xpath("//div[@id='HM_Menu_120_I1']");
	By cotaMes = By.xpath("//div[@id='HM_Menu_126_SUB_I1']");
	By aviso = By.xpath("//div[text()='X']");
	String url = "https://exchange.pancakeswap.finance/#/swap";
	By btnAdicionarToken = By.xpath("//button[@class='button btn-secondary btn--rounded add-token-button__button']");
	By btnAdicionarTokenPersonal = By.xpath("//button[text()='Token Personalizado']");
	By inputEndContratraToken = By.xpath("//input[@id='custom-address']");
	By inputSimboloToken = By.xpath("//input[@id='custom-symbol']");
	By inputDecimaisPrecisao = By.xpath("//input[@id='custom-decimals']");
	By btnProxima = By.xpath("//button[@class='button btn-secondary page-container__footer-button']");
	By btnAdicionarTokens = By
			.xpath("//button[@class='button btn-secondary btn--large page-container__footer-button']");

	By btnAprove = By.id("//*[contains(span,'Aprove')]");

	By btnDismiss = By.xpath("//button[contains(text(),'DISMISS')]");

	By btnSwap = By.cssSelector("#swap-button");
	By btnConfirmarSwap = By.cssSelector("#confirm-swap-or-send");
	By btnAcceptSwap = By.xpath("//button[text()='Accept']");

	// LIQUIDITY

	By btnLiquidity = By.cssSelector("#pool-nav-link");
	By btnHarvest = By.cssSelector("#harvest-all");

	By btnQtdColheitasMetaMask = By.xpath("//div[@class='page-container__footer-secondary']/a");
	By inputGas = By.xpath("//input[@class='advanced-gas-inputs__gas-edit-row__input']");
	// input[@class='advanced-gas-inputs__gas-edit-row__input']

	By msgGasZero = By.cssSelector(".advanced-gas-inputs__gas-edit-row__error-text");

	By divConfirmar = By.cssSelector(".page-container__footer");

	By btnConfirmar = By.xpath("//button[text()='Confirmar']");
	// button[text()='Confirmar']
	By addLiquidity = By.cssSelector("#join-pool-button");

	public MetaMaskPage AdicionarToken(String token) {

		escrever(inputSenha, "12345678");
		clicar(btnDesbloqeurar);
		IrParaPagina("https://exchange.pancakeswap.finance/#/swap");
		IrParaPagina("chrome-extension://nkbihfbeogaeaoehlefnkodbefgpgknn/home.html#");
		clicar(btnAdicionarToken);
		clicar(btnAdicionarTokenPersonal);
		escrever(inputEndContratraToken, token);
		clicar(btnProxima);
		clicar(btnAdicionarTokens);
		return this;
	}

	public void RealizarSwap(String tokenOrigem, String tokenDestito, String inputSlippage) {
		
		//autenticação
		escrever(inputSenha, "12345678");
		clicar(btnDesbloqeurar);
		IrParaPagina("https://exchange.pancakeswap.finance/#/swap");
		
		
		
		pancekePage.ValoresPancakeSwap(tokenOrigem, tokenDestito, inputSlippage);

		rolagemParaCima();

		String msg = verificarBotaoDismiss(btnDismiss);

		if (msg.equals("Dismiss")) {
			clicar(btnDismiss);
			String texto = verificarBotaoSwap(btnSwap);
			tempo();
			if (texto.equals("Swap")) {
				irParaMenu(btnSwap);
				clicar(btnSwap);
				System.out.println(obterTextoToken(btnConfirmarSwap));

			} else {

				irParaMenu(btnAprove);
				clicar(btnAprove);
			}

		} else {

			String texto = verificarBotaoSwap(btnSwap);
			tempo();
			if (texto.equals("Swap")) {
				irParaMenu(btnSwap);
				clicar(btnSwap);
				System.out.println(obterTextoToken(btnConfirmarSwap));

			} else {
				irParaMenu(btnAprove);
				clicar(btnAprove);
			}

		}

	}

	public void RealizarLiquidity(String tokenOrigem, String tokenDestito) {
		// escrever(inputSenha, "12345678");
		// clicar(btnDesbloqeurar);
		IrParaPagina("https://exchange.pancakeswap.finance/#/swap");
		clicar(btnLiquidity);
		clicar(addLiquidity);
		pancekePage.ValoresPancakeLiquidity(tokenOrigem, tokenDestito);

	}

	public void RealizarColheita() {
		// escrever(inputSenha, "12345678");
		// clicar(btnDesbloqeurar);
		IrParaPagina("https://exchange.pancakeswap.finance/#/swap");
		IrParaPagina("https://app.zcore.network/");

		rolagemParaBaixo();

		clicar(btnHarvest);
		tempo();
		IrParaPagina("chrome-extension://nkbihfbeogaeaoehlefnkodbefgpgknn/home.html#");

		String msg = verificarMsgErro(msgGasZero);

		if (msg.equals("Gas limit must be at least 21000")) {
			System.out.println(obterTextoToken(msgGasZero));

		} else {
			System.out.println("siga");
			String valor = obterTextoToken(btnQtdColheitasMetaMask);
			String qtd = valor.substring(23, 24);
			int n = Integer.parseInt(qtd);

			for (int i = 0; i < n; i++) {
				tempo();
				tempo();

				System.out.println(obterTextoToken(btnConfirmar));
				tempo();
				// clicar(btnConfirmar);

			}
		}

	}

	public void ValidarGás() {
		escrever(inputSenha, "12345678");
		clicar(btnDesbloqeurar);
		IrParaPagina("https://exchange.pancakeswap.finance/#/swap");
		IrParaPagina("https://app.zcore.network/");

		rolagemParaBaixo();

		clicar(btnHarvest);
		tempo();

		IrParaPagina("chrome-extension://nkbihfbeogaeaoehlefnkodbefgpgknn/home.html#");
		tempo();
		// String valor = obterTextoToken(inputGas);
		// System.out.println(valor);

		String msg = verificarMsgErro(msgGasZero);

		if (msg.equals("erroMsg")) {
			System.out.println(obterTextoToken(msgGasZero));

		} else {
			System.out.println("siga");
			String valor = obterTextoToken(btnQtdColheitasMetaMask);
			String qtd = valor.substring(23, 24);
			int n = Integer.parseInt(qtd);

			for (int i = 0; i < n; i++) {
				tempo();
				tempo();

				System.out.println(obterTextoToken(btnConfirmar));
				tempo();
				// clicar(btnConfirmar);

			}

		}

	}

}
