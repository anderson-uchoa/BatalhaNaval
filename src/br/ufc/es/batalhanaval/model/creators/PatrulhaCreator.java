package br.ufc.es.batalhanaval.model.creators;
import br.ufc.es.batalhanaval.model.Navio;
import br.ufc.es.batalhanaval.model.Patrulha;


public class PatrulhaCreator implements NavioCreator{
	@Override
	public Navio novoNavio() {
		return new Patrulha();
	}
	public Navio novoNavio(boolean horizontal) {
		return new Patrulha(horizontal);
	}
}
