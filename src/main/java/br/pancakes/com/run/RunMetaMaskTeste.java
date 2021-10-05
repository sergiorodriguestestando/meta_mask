package br.pancakes.com.run;

import br.pancakes.com.teste.MetaMaskTeste;

public class RunMetaMaskTeste {

	public static void main(String[] args) {
		

		MetaMaskTeste meMaskTeste = new MetaMaskTeste();
		meMaskTeste.RealizarTransacoes("CAKE", "BUSD", "1");
		//meMaskTeste.RealizarTransacoes("ZEFI", "BUSD", "2");
		//meMaskTeste.RealizarTransacoes("ZEFI", "BUSD", "3");
	}

}
