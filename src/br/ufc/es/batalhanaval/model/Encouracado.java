package br.ufc.es.batalhanaval.model;

import java.awt.Color;

public class Encouracado extends Navio {

	public Encouracado(){
		super(4, "Encouracado", new Color(255, 40, 147));
	}
	public Encouracado(boolean horizontal){
		super(4, horizontal, "Encouracado", new Color(255, 40, 147) );
	}
	@Override
	public String toString() {
		return "Encouracado";
	}
	
}
