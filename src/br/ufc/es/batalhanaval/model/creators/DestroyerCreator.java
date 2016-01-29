package br.ufc.es.batalhanaval.model.creators;
import br.ufc.es.batalhanaval.model.Destroyer;
import br.ufc.es.batalhanaval.model.Navio;


public class DestroyerCreator implements NavioCreator{
	@Override
	public Navio novoNavio() {
		return new Destroyer();
	}
	public Navio novoNavio(boolean horizontal) {
		return new Destroyer(horizontal);
	}
}
