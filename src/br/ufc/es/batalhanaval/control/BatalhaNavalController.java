package br.ufc.es.batalhanaval.control;

import javax.swing.JOptionPane;

import br.ufc.es.batalhanaval.model.Navio;
import br.ufc.es.batalhanaval.model.Player;
import br.ufc.es.batalhanaval.view.FormPrincipal;

public class BatalhaNavalController{

	private Player player1;
	private Player player2;
	private Player playerAlvo;
	
	private final int quantidadadeMaximaDeNavios;
	
	public Player getPlayerAlvo() {
		return playerAlvo;
	}

	public BatalhaNavalController(Player player1,
			Player player2, int quantidadadeMaximaDeNavios) {
		super();
		this.player1 = player1;
		this.player2 = player2;
		this.playerAlvo = player2;
		this.quantidadadeMaximaDeNavios = quantidadadeMaximaDeNavios;
	}

	public Player getPlayer1() {
		return player1;
	}

	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}

	//retorna verdadeiro se a bomba pode ser lancada no ponto
	public boolean atacarNoPonto(int linha, int coluna) {
		if (playerAlvo.getArea().lancarBombaNoPonto(linha, coluna)){
			Navio navioAtirado =  playerAlvo.getArea().getNavioNaPosicao(linha, coluna).getNavio();
			if (navioAtirado!= null && navioAtirado.foiAfundado()){
				JOptionPane.showMessageDialog(null,"O " + navioAtirado.getNome() +" de "+playerAlvo.getNome()+" foi afundado!");
				trocarPlayerAlvo();// Troca o player para aumentar a pontua��o;
				playerAlvo.maisUmNavioAfundado();
				if (playerAlvoVencedor()){
					JOptionPane.showMessageDialog(null,"Parab�ns, " + playerAlvo.getNome() +", voc� venceu!\nPressione ok para sair");
					if (FormPrincipal.getInstanciaAtual() != null){
						FormPrincipal.getInstanciaAtual().dispose();
					}
				}
				trocarPlayerAlvo();//Volta pro alvo anterior
			}
			trocarPlayerAlvo();
			return true;
		}
		return false;
	}
	
	private void trocarPlayerAlvo(){
		if (playerAlvo == player1)
			playerAlvo = player2;
		else
			playerAlvo = player1;
	}
	
	public boolean playerAlvoVencedor(){
		return (playerAlvo.getNaviosAfundados() == this.quantidadadeMaximaDeNavios);
	}	

}
