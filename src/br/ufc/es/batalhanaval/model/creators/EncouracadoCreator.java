package br.ufc.es.batalhanaval.model.creators;
import br.ufc.es.batalhanaval.model.Encouracado;
import br.ufc.es.batalhanaval.model.Navio;


public class EncouracadoCreator implements NavioCreator {

	@Override
	public Navio novoNavio() {
		return new Encouracado();
	}
	public Navio novoNavio(boolean horizontal) {
		return new Encouracado(horizontal);
	}
}
