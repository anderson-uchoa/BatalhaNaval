package br.ufc.es.batalhanaval.model.creators;
import br.ufc.es.batalhanaval.model.Navio;
import br.ufc.es.batalhanaval.model.Submarino;


public class SubmarinoCreator implements NavioCreator{
	@Override
	public Navio novoNavio() {
		return new Submarino();
	}
	public Navio novoNavio(boolean horizontal) {
		return new Submarino(horizontal);
	}
}
