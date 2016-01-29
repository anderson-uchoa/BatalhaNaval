package br.ufc.es.batalhanaval.view;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import br.ufc.es.batalhanaval.model.Player;

import java.awt.Color;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.MouseListener;

import javax.swing.Box;

public class PlayerPanel extends JPanel {

	private static final long serialVersionUID = -426072769022022971L;
	private AreaDeBatalhaPanel areaDeBatalhaPanel;
	private AreaDeBatalhaPanel areaDeBatalhaDoInimigo;
	private JLabel lblPontos;
	private Player player;
	/**
	 * Create the panel.
	 *
	 */
	public PlayerPanel(Player player, Player inimigo, MouseListener conteudoAreaDeBatalha) {
		super();
		this.player = player;
		setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		areaDeBatalhaPanel = new AreaDeBatalhaPanel(player.getArea(), true , conteudoAreaDeBatalha);
		areaDeBatalhaPanel.setBounds(22, 79, 244, 244);
		areaDeBatalhaPanel.setVisible(true);
		setLayout(null);

		JLabel lblPlayerNome = new JLabel("");
		lblPlayerNome.setBounds(22, 21, 244, 25);
		lblPlayerNome.setBackground(Color.RED);
		lblPlayerNome.setLabelFor(areaDeBatalhaPanel);
		lblPlayerNome.setFont(new Font("Agency FB", Font.BOLD, 18));
		lblPlayerNome.setText(player.getNome());
		add(lblPlayerNome);

		JLabel lblInimigoNome = new JLabel("");
		lblInimigoNome.setBounds(297, 45, 244, 30);
		lblInimigoNome.setLabelFor(areaDeBatalhaDoInimigo);
		lblInimigoNome.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblInimigoNome.setBackground(Color.RED);
		lblInimigoNome.setText("Inimigo: "+inimigo.getNome());
		add(lblInimigoNome);
		add(areaDeBatalhaPanel);

		areaDeBatalhaDoInimigo = new AreaDeBatalhaPanel(inimigo.getArea(), false, conteudoAreaDeBatalha);
		areaDeBatalhaDoInimigo.setBounds(297, 79, 244, 244);
		areaDeBatalhaDoInimigo.setVisible(true);
		
		add(areaDeBatalhaDoInimigo);

		Component horizontalStrut = Box.createHorizontalStrut(20);
		horizontalStrut.setBounds(0, 127, 20, 1);
		add(horizontalStrut);

		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		horizontalStrut_1.setBounds(50, 138, 20, 1);
		add(horizontalStrut_1);
		
		lblPontos = new JLabel("");
		lblPontos.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblPontos.setBounds(22, 57, 68, 14);
		add(lblPontos);
	}
	
	@Override
	public void paint(Graphics arg0) {
		lblPontos.setText("Pontos: "+player.getNaviosAfundados());
		for(Component comp: getComponents()){
			comp.setEnabled(isEnabled());
		}
		super.paint(arg0);
	}

	/**
	 * @return the conteudoAreaBatahaListern
	 */

	/**
	 * @param conteudoAreaBatahaListern the conteudoAreaBatahaListern to set
	 */
	public void setConteudoAreaBatahaListern(MouseListener conteudoAreaBatahaListern) {
		areaDeBatalhaDoInimigo.setConteudoAreaBatahaListern(conteudoAreaBatahaListern);
	}
}
