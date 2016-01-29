package br.ufc.es.batalhanaval.view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import br.ufc.es.batalhanaval.model.PontoDaArea;


public class ConteudoAreaDeBatalhaPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PontoDaArea ponto;
	private boolean mostrarNavio;
	private LineBorder linhabranca;
	private Color corDaCelula;
	
	/**
	 * Create the panel.
	 */
	public ConteudoAreaDeBatalhaPanel(PontoDaArea ponto, boolean mostrarNavio) {
		super();
		this.ponto = ponto;
		this.mostrarNavio = mostrarNavio;
		this.linhabranca = new LineBorder(Color.white, 1);
		this.corDaCelula = new Color(127, 255, 212);
		this.setBorder(linhabranca);	
	}
	

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if(mostrarNavio || ponto.isAcertado()){
			setBackground(ponto.getCor());
		}
		else{
			setBackground(corDaCelula);
		}
	}

	public int getLinha() {
		return this.ponto.getLinha();
	}

	public int getColuna(){
		return this.ponto.getColuna();
	}

}
