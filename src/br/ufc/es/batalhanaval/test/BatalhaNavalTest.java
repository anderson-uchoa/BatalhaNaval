package br.ufc.es.batalhanaval.test;
import static org.junit.Assert.*;

import org.junit.Test;

import br.ufc.es.batalhanaval.control.BatalhaNavalController;
import br.ufc.es.batalhanaval.model.AreaBatalha;
import br.ufc.es.batalhanaval.model.Navio;
import br.ufc.es.batalhanaval.model.Player;
import br.ufc.es.batalhanaval.model.PontoDaArea;
import br.ufc.es.batalhanaval.model.creators.SubmarinoCreator;





public class BatalhaNavalTest {
	Navio navioTest = new SubmarinoCreator().novoNavio(true);
	PontoDaArea mapa[][] = {
			{new PontoDaArea(0,0,navioTest),new PontoDaArea(0,1,navioTest), new PontoDaArea(0,2,navioTest), new PontoDaArea(0,3), new PontoDaArea(0,4), new PontoDaArea(0,5), new PontoDaArea(0,6), new PontoDaArea(0,7), new PontoDaArea(0,8), new PontoDaArea(0,9)},
			{new PontoDaArea(1,0),new PontoDaArea(1,1,navioTest), new PontoDaArea(1,2,navioTest), new PontoDaArea(1,3,navioTest), new PontoDaArea(1,4), new PontoDaArea(1,5), new PontoDaArea(1,6), new PontoDaArea(1,7), new PontoDaArea(1,8), new PontoDaArea(1,9)},
			{new PontoDaArea(2,0),new PontoDaArea(2,1), new PontoDaArea(2,2), new PontoDaArea(2,3), new PontoDaArea(2,4), new PontoDaArea(2,5), new PontoDaArea(2,6), new PontoDaArea(2,7), new PontoDaArea(2,8), new PontoDaArea(2,9)},
			{new PontoDaArea(3,0),new PontoDaArea(3,1), new PontoDaArea(3,2), new PontoDaArea(3,3), new PontoDaArea(3,4), new PontoDaArea(3,5), new PontoDaArea(3,6), new PontoDaArea(3,7), new PontoDaArea(3,8), new PontoDaArea(3,9)},
			{new PontoDaArea(4,0),new PontoDaArea(4,1), new PontoDaArea(4,2), new PontoDaArea(4,3), new PontoDaArea(4,4), new PontoDaArea(4,5), new PontoDaArea(4,6), new PontoDaArea(4,7), new PontoDaArea(4,8), new PontoDaArea(4,9)},
			{new PontoDaArea(5,0),new PontoDaArea(5,1), new PontoDaArea(5,2), new PontoDaArea(5,3), new PontoDaArea(5,4), new PontoDaArea(5,5), new PontoDaArea(5,6), new PontoDaArea(5,7), new PontoDaArea(5,8), new PontoDaArea(5,9)},
			{new PontoDaArea(6,0),new PontoDaArea(6,1), new PontoDaArea(6,2), new PontoDaArea(6,3), new PontoDaArea(6,4), new PontoDaArea(6,5), new PontoDaArea(6,6), new PontoDaArea(6,7), new PontoDaArea(6,8), new PontoDaArea(6,9)},
			{new PontoDaArea(7,0),new PontoDaArea(7,1), new PontoDaArea(7,2), new PontoDaArea(7,3), new PontoDaArea(7,4), new PontoDaArea(7,5), new PontoDaArea(7,6), new PontoDaArea(7,7), new PontoDaArea(7,8), new PontoDaArea(7,9)},
			{new PontoDaArea(8,0),new PontoDaArea(8,1), new PontoDaArea(8,2), new PontoDaArea(8,3), new PontoDaArea(8,4), new PontoDaArea(8,5), new PontoDaArea(8,6), new PontoDaArea(8,7), new PontoDaArea(8,8), new PontoDaArea(8,9)},
			{new PontoDaArea(9,0),new PontoDaArea(9,1), new PontoDaArea(9,2), new PontoDaArea(9,3), new PontoDaArea(9,4), new PontoDaArea(9,5), new PontoDaArea(9,6), new PontoDaArea(9,7), new PontoDaArea(9,8), new PontoDaArea(9,9)}
	};

	@Test
	public void mapaVazio(){
		AreaBatalha area = new AreaBatalha();
		assertTrue(area.getNavioNaPosicao(0,0).getNavio()==null);
		
	}
	
	@Test
	public void atingeNavio(){
		AreaBatalha area = new AreaBatalha(mapa);
		assertTrue(area.getNavioNaPosicao(0,0).getNavio()!=null);
		assertTrue(area.getNavioNaPosicao(0,1).getNavio()!=null);
		
	}
	
	@Test
	public void naoAtingeNavio(){
		AreaBatalha area = new AreaBatalha(mapa);
		assertTrue(area.getNavioNaPosicao(2,0).getNavio()==null);
	}
	
	@Test 
	public void podeAdicionarNavioMapa(){
		AreaBatalha area = new AreaBatalha();
		assertTrue(area.podeAdicionarNavioAPartirDaPosicao(new SubmarinoCreator().novoNavio(true),0,0));
	}
	
	@Test
	public void adicionarNavioMapaNaHorizontal(){
		AreaBatalha area = new AreaBatalha();
		area.adicionarNavio(new SubmarinoCreator().novoNavio(true),0,0);
		assertTrue(area.getNavioNaPosicao(0,0).getNavio()!=null);
		assertTrue(area.getNavioNaPosicao(0,2).getNavio()!=null);
		assertTrue(area.getNavioNaPosicao(0,3).getNavio()==null);
	}
	
	@Test
	public void adicionarNavioMapaNaVertical(){
		AreaBatalha area = new AreaBatalha();
		area.adicionarNavio(new SubmarinoCreator().novoNavio(),0,0);
		assertTrue(area.getNavioNaPosicao(0,0).getNavio()!=null);
		assertTrue(area.getNavioNaPosicao(2,0).getNavio()!=null);
		assertTrue(area.getNavioNaPosicao(3,0).getNavio()==null);
	}
	
	@Test
	public void afundarNavio(){
		AreaBatalha area = new AreaBatalha();
		Navio sub = new SubmarinoCreator().novoNavio(true);
		area.adicionarNavio(sub,0,0);
		area.lancarBombaNoPonto(0, 0);
		area.lancarBombaNoPonto(0, 1);
		area.lancarBombaNoPonto(0, 2);
		assertTrue(sub.foiAfundado());
	}
	
	@Test
	public void naoAfundarNavio(){
		AreaBatalha area = new AreaBatalha();
		Navio sub =new SubmarinoCreator().novoNavio(true);
		area.adicionarNavio(sub,0,0);
		area.lancarBombaNoPonto(0, 0);
		area.lancarBombaNoPonto(0, 1);
		assertFalse(sub.foiAfundado());
	}
	
	@Test
	public void naoAfundaSeAtirarSempreNoMesmoPonto(){
		AreaBatalha area = new AreaBatalha();
		Navio sub = new SubmarinoCreator().novoNavio(true);
		area.adicionarNavio(sub,0,0);
		area.lancarBombaNoPonto(0, 0);
		area.lancarBombaNoPonto(0, 0);
		area.lancarBombaNoPonto(0, 0);
		assertFalse(sub.foiAfundado());
	}
	
	@Test
	public void houveVencedor(){
		AreaBatalha area = new AreaBatalha(mapa);
		Player player1 = new Player("fulano", area);
		Player player2 = new Player("fulano2", area);
		BatalhaNavalController controller = new BatalhaNavalController(player1, player2, 1);
		controller.atacarNoPonto(0, 0);
		controller.atacarNoPonto(0, 1);
		controller.atacarNoPonto(0, 2);
		assertTrue(controller.playerAlvoVencedor());
	}
}
