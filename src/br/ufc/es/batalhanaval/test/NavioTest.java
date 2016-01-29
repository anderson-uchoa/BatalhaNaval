package br.ufc.es.batalhanaval.test;

import static org.junit.Assert.*;

import org.junit.Test;

import br.ufc.es.batalhanaval.model.Navio;
import br.ufc.es.batalhanaval.model.creators.SubmarinoCreator;

public class NavioTest {

	@Test
	public void foiAtingido(){
		Navio navio = new SubmarinoCreator().novoNavio(true);
		navio.atingido();
		navio.atingido();
		assertFalse(navio.foiAfundado());
	}
	
	@Test
	public void foiAfundado(){
		Navio navio = new SubmarinoCreator().novoNavio(true);
		navio.atingido();
		navio.atingido();
		navio.atingido();
		assertTrue(navio.foiAfundado());
	}
	
}
