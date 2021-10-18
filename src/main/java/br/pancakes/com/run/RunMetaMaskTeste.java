package br.pancakes.com.run;

import org.junit.Test;

import br.pancakes.com.teste.MetaMaskTeste;

public class RunMetaMaskTeste {


	
	@Test
	public void ExecucaoValores() {
		MetaMaskTeste meMaskTeste = new MetaMaskTeste();
		
			meMaskTeste.RealizarTransacoes("BNB", "CAKE", "10");
			meMaskTeste.RealizarTransacoes("0xbbb46be231de4dd12f594ccd6ddf0565c1a1d270", "CAKE", "10");
		    meMaskTeste.RealizarTransacoes("HERO", "CAKE", "10");


		
	}

}
