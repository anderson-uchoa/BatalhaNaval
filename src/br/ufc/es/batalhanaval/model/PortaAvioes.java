package br.ufc.es.batalhanaval.model;

import java.awt.Color;

public class PortaAvioes extends Navio {
	public PortaAvioes(){
		super(5, "Porta Avioes", new Color(34, 139, 34) );
	}
	public PortaAvioes(boolean horizontal){
		super(5, horizontal, "Porta Avioes", new Color(34, 139, 34));
	}
	@Override
	public String toString() {
		return "Porta Avioes";
	}
}
