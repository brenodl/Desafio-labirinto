package br.com.breno.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ArquivoService {

	private static final String PATH = "C:\\Users\\Breno\\Stefanini\\ApiText\\Rest.txt";
	private File arq;

	public ArquivoService() {
		arq = new File(PATH);
		if (!arq.exists()) {
			try {
				arq.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public String getArquivoTexto() {
		String linha = null;
		StringBuilder bld = new StringBuilder();

		try {
			FileReader fr = new FileReader(arq);
			BufferedReader br = new BufferedReader(fr);
			linha = br.readLine();
			bld.append(linha);

			while (linha != null) {

				linha = br.readLine();
				bld.append(linha);
			}

			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bld.toString().replaceAll(",", "").replaceAll(" ", "").replaceAll("[a-z]", "");
	}
}
