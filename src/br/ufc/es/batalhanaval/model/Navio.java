package br.ufc.es.batalhanaval.model;

import java.awt.Color;

public abstract class Navio {

	private int tamanho;
	private int bombasAtingidas;
	private boolean horizontal;
	private String nome;
	private Color cor;
	
	public Navio(int tamanho, String nome, Color cor) {
		this(tamanho, false, nome, cor);
	}
	
	public Navio(int tamanho, boolean horizontal, String nome, Color cor) {
		this.tamanho = tamanho;
		this.horizontal = horizontal;
		this.nome = nome;
		this.cor = cor;
	}

	public int getTamanho() {
		return tamanho;
	}
	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}
	public int getBombasAtingidas() {
		return bombasAtingidas;
	}
	public void setBombasAtingidas(int bombasAtingidas) {
		this.bombasAtingidas = bombasAtingidas;
	}
	public boolean isHorizontal() {
		return horizontal;
	}
	public void setHorizontal(boolean horizontal) {
		this.horizontal = horizontal;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void atingido() {
		System.out.println("bomba");
		this.bombasAtingidas++;
		if(foiAfundado()){
			System.out.println("afundado"+this.getNome());
		}
	}

	public boolean foiAfundado() {
//		System.out.println("Afundado");
		return (tamanho <= bombasAtingidas);
	}

	public Color getCor() {
		return this.cor;
	}
}
