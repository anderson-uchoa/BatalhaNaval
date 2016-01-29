package br.ufc.es.batalhanaval.model;

import java.awt.Color;

public class Patrulha extends Navio {
	public Patrulha(){
		super(2, "Patrula", Color.ORANGE);
	}
	public Patrulha(boolean horizontal){
		super(2, horizontal, "Patrulha", Color.ORANGE);
	}
	@Override
	public String toString() {
		return "Patrulha";
	}
}
