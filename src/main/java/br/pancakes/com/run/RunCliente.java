package br.pancakes.com.run;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.pancakes.com.page.BasePage;



@RunWith(Suite.class)
@SuiteClasses({ 
	
	RunMetaMaskTeste.class

	
	})
public class RunCliente {
	
	static BasePage base = new BasePage();

	@BeforeClass
	public static void abrirNavegador() {
		BasePage.abrirPaginaInicial();

	}
	
	@AfterClass
	public static void fecharNavegador() {
		base.fecharNavegador();
	}

}
