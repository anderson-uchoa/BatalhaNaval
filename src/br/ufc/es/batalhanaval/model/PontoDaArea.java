package br.ufc.es.batalhanaval.model;

import java.awt.Color;

public class PontoDaArea {

	private boolean acertado;
	private Navio navio;
	private Color cor;
	private int linha;
	private int coluna;
	
	public PontoDaArea(int linha, int coluna){
		this(linha, coluna ,null);
	}
	
	public PontoDaArea(int linha, int coluna, Navio navio){
		this.linha = linha;
		this.coluna = coluna;
		this.acertado = false;
		this.navio = navio;
		this.cor =  (navio != null) ? navio.getCor(): new Color(127, 255, 212);
	}
	
	public int getLinha() {
		return linha;
	}

	public int getColuna() {
		return coluna;
	}

	//retorno verdadeiro se o ponto ainda nao foi acertado. indica se o tiro foi "aceito" ou nao
	public boolean acertar(){
		
		if(this.acertado)
			return false;
		
		this.acertado = true;
		if( this.navio != null){
			this.navio.atingido();
			this.cor = Color.RED;
		}else{
			this.cor = Color.BLUE;
			System.out.println("agua");
		}
		return true;
	}
	
	protected void setNavio(Navio navio){
		this.navio = navio;
		this.cor =  (navio != null) ? navio.getCor(): this.cor;
	}
	
	public boolean isAcertado() {
		return this.acertado;
	}

	public Color getCor() {
		return cor;
	}

	public boolean contemNavio() {
		return this.navio != null;
	}

	public boolean isAfundado() {
		if(navio!=null)
			return navio.foiAfundado();
		else
			return false;
	}

	public Navio getNavio() {
		return navio;
	}

}
