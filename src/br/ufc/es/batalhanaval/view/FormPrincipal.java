package br.ufc.es.batalhanaval.view;

import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.ufc.es.batalhanaval.control.BatalhaNavalController;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class FormPrincipal extends JFrame implements MouseListener{

	/**
	 * 
	 */

	private static FormPrincipal instanciaAtual;

	private static final long serialVersionUID = 8931359298273038377L;
	private JPanel contentPane;
	private BatalhaNavalController controller;
	private PlayerPanel player1Panel;
	private PlayerPanel player2Panel;

	/**
	 * Create the frame.
	 */
	public FormPrincipal(BatalhaNavalController controller) {
		
		FormPrincipal.instanciaAtual = this;
		
		setResizable(false);
		setTitle("Batalha Naval");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 731);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(2, 1, 0, 0));

		this.controller = controller;

		player1Panel = new PlayerPanel( this.controller.getPlayer1(), this.controller.getPlayer2(), this );
		player1Panel.setVisible(true);
		player1Panel.setBackground(Color.white);
		contentPane.add(player1Panel);

		player2Panel = new PlayerPanel( this.controller.getPlayer2(), this.controller.getPlayer1(), this );
		player2Panel.setEnabled(false);
		player2Panel.setVisible(true);
		contentPane.add(player2Panel);

		contentPane.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		try{
			ConteudoAreaDeBatalhaPanel conteudo = (ConteudoAreaDeBatalhaPanel)e.getComponent();
			if(conteudo.isEnabled()){ // Funciona apenas para ConteudoAreaDeBatalha
				if(controller.atacarNoPonto(conteudo.getLinha(), conteudo.getColuna())){ // Verifica se a jogada � valida
					conteudo.setBackground(Color.red);

					if(player1Panel.isEnabled()){
						player1Panel.setBackground(null);
						player1Panel.setEnabled(false);
						player2Panel.setEnabled(true);
						player2Panel.setBackground(Color.white);
					}
					else{
						player1Panel.setBackground(Color.white);
						player1Panel.setEnabled(true);
						player2Panel.setEnabled(false);
						player2Panel.setBackground(null);
					}

				}
				this.repaint();
			}
		}catch(ClassCastException ex){
			//Se n�o for ConteudoAreaBatalhaPanel, nada a fazer!
		}

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public static final FormPrincipal getInstanciaAtual(){
		return instanciaAtual;
	}

}
