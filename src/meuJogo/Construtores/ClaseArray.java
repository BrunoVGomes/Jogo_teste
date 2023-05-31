package meuJogo.Construtores;

import java.util.ArrayList;

import meuJogo.Modelo.Portas;

public class ClaseArray extends Portas {
	
	private static ArrayList<Portas> listasPortas = new ArrayList<>();
	
	public static void adicionarNaLista() {
		
		for (int i = 0; i < 3; i++) {
			Portas portas = new Portas();
			
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
