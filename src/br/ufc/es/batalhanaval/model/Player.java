package br.ufc.es.batalhanaval.model;

public class Player{
	
	private String nome;
	private AreaBatalha area;
	private int naviosAfundados = 0;
	
	public Player() {
		super();	
		// TODO Auto-generated constructor stub
	}
	public Player(String nome, AreaBatalha area) {
		super();
		this.nome = nome;
		this.area = area;
		naviosAfundados = 0;
	}
	

	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public AreaBatalha getArea() {
		return area;
	}
	public void setArea(AreaBatalha area) {
		this.area = area;
	}
	public int getNaviosAfundados() {
		return naviosAfundados;
	}
	
	public void maisUmNavioAfundado() {
		naviosAfundados++;
	}
	
	
	
	
}
