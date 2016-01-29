package br.ufc.es.batalhanaval.model;

import java.awt.Color;

public class Destroyer extends Navio {
	public Destroyer(){
		super(3, "Destroyer", new Color(255, 255, 0));
	}
	public Destroyer(boolean horizontal){
		super(3, horizontal, "Destroyer", new Color(255, 255, 0));
	}
	@Override
	public String toString() {
		return "Destroyer";
	}
}
