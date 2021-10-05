package br.pancakes.com.teste;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import br.pancakes.com.page.BasePage;
import br.pancakes.com.page.MetaMaskPage;
import br.pancakes.com.page.PancekePage;

public class MetaMaskTeste {

	MetaMaskPage metaMaskPage = new MetaMaskPage();

	BasePage base = new BasePage();
	String token = "";
	String qtd = "";

	
	public void RealizarTransacoes(String tokenOrigem, String tokenDestino, String inputSlippage) {
		BasePage.abrirPaginaInicial();
	  //  metaMaskPage.AdicionarToken(token);
    	metaMaskPage.RealizarSwap(tokenOrigem, tokenDestino, inputSlippage);
	//	metaMaskPage.RealizarLiquidity(tokenOrigem, tokenDestino);
	//	metaMaskPage.RealizarColheita();
	//	metaMaskPage.ValidarGás();
		BasePage.FecharNavegador();

	}
}
