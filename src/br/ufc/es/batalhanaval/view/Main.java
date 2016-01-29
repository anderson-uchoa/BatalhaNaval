package br.ufc.es.batalhanaval.view;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;

import br.ufc.es.batalhanaval.control.BatalhaNavalController;
import br.ufc.es.batalhanaval.model.AreaBatalha;
import br.ufc.es.batalhanaval.model.Navio;
import br.ufc.es.batalhanaval.model.Player;
import br.ufc.es.batalhanaval.model.creators.DestroyerCreator;
import br.ufc.es.batalhanaval.model.creators.EncouracadoCreator;
import br.ufc.es.batalhanaval.model.creators.NavioCreator;
import br.ufc.es.batalhanaval.model.creators.PatrulhaCreator;
import br.ufc.es.batalhanaval.model.creators.PortaAvioesCreator;
import br.ufc.es.batalhanaval.model.creators.SubmarinoCreator;

public class Main {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					//Lista com todos os criadores de navios;
					List<NavioCreator> navioCreators = new ArrayList<NavioCreator>();
					navioCreators.add(new EncouracadoCreator());
					navioCreators.add(new DestroyerCreator());
					navioCreators.add(new PatrulhaCreator());
					navioCreators.add(new PortaAvioesCreator());
					navioCreators.add(new SubmarinoCreator());				

					Player player1 = new Player();
					Player player2 = new Player();

					player1.setNome( JOptionPane.showInputDialog(null, "Jogador 1:", "Digite seu nome") );
					player2.setNome( JOptionPane.showInputDialog(null, "Jogador 2:", "Digite seu nome") );

					AreaBatalha areaBatalhaPlayer1 = new AreaBatalha();
					AreaBatalha areaBatalhaPlayer2 = new AreaBatalha();

					adicionarNaviosAleatoriamente(areaBatalhaPlayer1, navioCreators);
					adicionarNaviosAleatoriamente(areaBatalhaPlayer2, navioCreators);

					player1.setArea(areaBatalhaPlayer1);
					player2.setArea(areaBatalhaPlayer2);

					BatalhaNavalController controller = new BatalhaNavalController(player1, player2, 5);

					FormPrincipal frame = new FormPrincipal(controller);
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			private void adicionarNaviosAleatoriamente(AreaBatalha areaBatalha, List<NavioCreator> navioCreators) {
				int x, y;
				int max = AreaBatalha.TAMANHO_LADO;
				Random rand = new Random();
				Navio navio;

				//adicionar todos os navios
				for(NavioCreator criador: navioCreators){
					boolean adicionado = false;
					navio = criador.novoNavio(rand.nextBoolean());
					while(!adicionado){
						x = rand.nextInt(max);
						y = rand.nextInt(max);
						adicionado = areaBatalha.adicionarNavio(navio, x, y);
					}
				}

			}
		});
	}
}
