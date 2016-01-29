package br.ufc.es.batalhanaval.model;

import java.awt.Color;

public class Submarino extends Navio {
	public Submarino(){
		super(3, "Submarino", Color.BLUE);
	}
	public Submarino(boolean horizontal){
		super(3, horizontal,"Submarino", Color.DARK_GRAY);
	}
	@Override
	public String toString() {
		return "Submarino";
	}
}
