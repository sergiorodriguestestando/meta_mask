package br.pancakes.com;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Ultil {
	static String digitado;

	public static String DigitarToken() {
		InputStream is = System.in;
		System.out.print("Digite o TOKEN ");
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);

		try {
			digitado = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (digitado.equals("")) {
			System.out.print("Digite o TOKEN ");
			try {
				digitado = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return digitado;

	}

	public static String DigitarValor() {
		InputStream is = System.in;
		System.out.print("Digite o valor ");
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);

		try {
			digitado = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (digitado.equals("")) {
			System.out.print("Digite o valor ");
			try {
				digitado = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return digitado;

	}

	public static HashMap<String, String> valoresTeste(String token, String qtd) {
		HashMap<String, String> map = new HashMap<>();
		map.put(token, qtd);
		map.put(token, qtd);
		map.put(token, qtd);

		return map;
	}

}
