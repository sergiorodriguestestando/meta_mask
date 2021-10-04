package br.pancakes.com.teste;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import br.pancakes.com.page.BasePage;
import br.pancakes.com.page.PancekePage;

public class PancakeTeste {

	PancekePage pancekePage = new PancekePage();
	BasePage base = new BasePage();
	String token = "";
	String qtd = "";


	@Test
	public void PancakeValores(String tokenOrigem, String valor, String tokenDestino) {
		BasePage.abrirPaginaInicial();
		pancekePage.ValoresPancakeLiquidity(tokenOrigem,tokenDestino);
		BasePage.FecharNavegador();

	}
}
