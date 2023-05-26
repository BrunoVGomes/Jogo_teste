package meuJogo.Construtores;

import java.util.ArrayList;

import meuJogo.Modelo.Portas;

public class ClaseArray {
	
	private static ArrayList<Portas> listasPortas = new ArrayList<>();
	
	private static void adicionarNaLista() {
		
		Portas portas = new Portas();
		
		for (int i = 0; i < 3; i++) {
			
			listasPortas.add(portas);
		}		
		
	}
	
	
	/*
	 * public static void main(String[] args) {
	 * 
	 * System.out.println("testando"); adicionarNaLista();
	 * 
	 * }
	 */
	 
}
