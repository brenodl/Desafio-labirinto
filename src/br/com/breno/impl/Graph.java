package br.com.breno.impl;

import java.util.*;

public class Graph {

	// número de vertices
	private final int verticesQtd;
	private HashMap<Integer, ArrayDeque<Integer>> adj;
	private List<StringBuilder> caminhos = new ArrayList<>();
	int indexList = 0;
	String menor;
	
	public Graph(int verticesQtd) { // Construtor incia a quantidade de vertices

		if (verticesQtd < 0) {

			throw new IllegalArgumentException("O número de vértices deve ser maior que zero!");
		}
		this.verticesQtd = verticesQtd;
		this.adj = new HashMap<>();
		for (int i = 0; i < verticesQtd; i++) { // inicializa todos as posições do HashMap
			adj.put(i, new ArrayDeque<Integer>());
		}
	}

	private boolean verificaVertice(int u) {

		return (u > 0) || (u <= verticesQtd);
	}

	public void addAresta(int u, int v) {

		if (!verificaVertice(u)) {

			throw new IndexOutOfBoundsException("Vértice de origem fora da faixa");
		}

		if (!verificaVertice(v)) {

			throw new IndexOutOfBoundsException("Vértice de origem fora da faixa");
		}

		if (!adj.get(u).contains(v)) {
			adj.get(u).add(v);
		}
		if (!adj.get(v).contains(u)) {
			adj.get(v).add(u);
		}
	}

	public void MostrarGrafo() {

		for (int i = 0; i < adj.size(); i++) {

			System.out.println("[" + i + "]" + "->" + adj.get(i));
		}
		System.out.println();
	}

	public void printAllPaths(int s, int d) {
		
		boolean visited[] = new boolean[verticesQtd];
		Integer[] path = new Integer[verticesQtd];
		int pathIndex = 0;

		for (int i = 0; i < verticesQtd; i++)
			visited[i] = false;

		printAllPathsUtil(s, d, visited, path, pathIndex);
	}

	private void printAllPathsUtil(int u, int d, boolean visited[], Integer path[], int pathIndex) {

		visited[u] = true;
		
		path[pathIndex] = u;
		pathIndex++;
		if (u == d) {
			caminhos.add(new StringBuilder());
			for (int i = 0; i < pathIndex; i++) {

				System.out.print(path[i] + " ");
				caminhos.get(indexList).append(path[i]);
			}
			System.out.println();
			indexList++;
		} else {

			Iterator<Integer> i = adj.get(u).iterator();

			while (i.hasNext()) {
				int n = i.next();
				if (!visited[n])
					printAllPathsUtil(n, d, visited, path, pathIndex);
			}
		}
			pathIndex--;
			visited[u] = false;
	}
	
	public int getQuantidade() {
		
	return caminhos.size();
		
	}
	
	public String getMenorCaminho() {
		
		Integer tamMenor = caminhos.get(0).length();
		menor = caminhos.get(0).toString();
		for(StringBuilder x: caminhos) {
			
			if(tamMenor> x.length()) {
				
				menor = x.toString();
				tamMenor = x.length();
			}
		}
		
		return menor.replace("", ",").replaceFirst(",", "");
		}

	public Integer getPeso() {
		
		return menor.length()-1;
	}
}
