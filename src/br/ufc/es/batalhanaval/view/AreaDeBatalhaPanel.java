package br.ufc.es.batalhanaval.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import br.ufc.es.batalhanaval.model.AreaBatalha;
import br.ufc.es.batalhanaval.model.PontoDaArea;

public class AreaDeBatalhaPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -370755938006563093L;
	private AreaBatalha area;
	private MouseListener conteudoAreaBatahaListern;

	/**
	 * Create the panel.
	 * @param area
	 * @param exibirNavios 
	 * @param conteudoDaAreaDeBatalha 
	 */
	public AreaDeBatalhaPanel(AreaBatalha area, boolean exibirNavios, MouseListener conteudoAreaDeBatalha) {
		super();
		this.area =  area;
		this.conteudoAreaBatahaListern = conteudoAreaDeBatalha;
		setBorder(new LineBorder(new Color(0, 0, 0), 2));
		setLayout(new GridLayout(10, 10, 0, 0));
		if (area!=null){		
			if(exibirNavios){
				adicionarNavios();
			}else{
				adicionaNaviosInimigos();
			}
		}

	}

	@Override

	public void paint(Graphics g) {
		super.paint(g);
		for(Component comp: getComponents()){
			comp.setEnabled(isEnabled());
		}
	}

	//Adiciona os navio e os mostra
	private void adicionarNavios() {
		ConteudoAreaDeBatalhaPanel conteudo;
		for (PontoDaArea ponto: area){
			conteudo = new ConteudoAreaDeBatalhaPanel(ponto, true);
			this.add(conteudo);
		}

	}

	//Adiciona as referencias do navio inimigo mas n�o os mostra
	private void adicionaNaviosInimigos(){
		ConteudoAreaDeBatalhaPanel conteudo;
		for (PontoDaArea ponto: area){
			conteudo = new ConteudoAreaDeBatalhaPanel(ponto, false);
			conteudo.addMouseListener(this.conteudoAreaBatahaListern); // O conteudo da area de batalha do inimigo � clicavel
			this.add(conteudo);
		}
	}


	public MouseListener getConteudoAreaBatahaListern() {
		return conteudoAreaBatahaListern;
	}

	public void setConteudoAreaBatahaListern(MouseListener conteudoAreaBatahaListern) {
		this.conteudoAreaBatahaListern = conteudoAreaBatahaListern;
	}



}
