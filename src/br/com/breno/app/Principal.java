package br.com.breno.app;

import br.com.breno.impl.Graph;
import br.com.breno.service.ArquivoService;

public class Principal {
	
	public static void main(String[] args){
		
		ArquivoService readTxt = new ArquivoService();
		Graph grafo = new Graph(Character.getNumericValue(readTxt.getArquivoTexto().charAt(0)));

		for(int i = 3; i<readTxt.getArquivoTexto().length()-1;i=i+2) {
			
			grafo.addAresta(Character.getNumericValue(readTxt.getArquivoTexto().charAt(i)), Character.getNumericValue(readTxt.getArquivoTexto().charAt(i+1)));
		}
		
grafo.MostrarGrafo();
		System.out.println();
		grafo.printAllPaths(Character.getNumericValue(readTxt.getArquivoTexto().charAt(1)),Character.getNumericValue(readTxt.getArquivoTexto().charAt(2)));
		System.out.println();
		
		System.out.println("Qtd. de caminhos possíveis: "+grafo.getQuantidade());
		System.out.println("Melhor caminho: " +grafo.getMenorCaminho());
		System.out.println("Peso: "+ grafo.getPeso());
	}
}