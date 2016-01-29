package br.ufc.es.batalhanaval.model.creators;
import br.ufc.es.batalhanaval.model.Navio;
import br.ufc.es.batalhanaval.model.PortaAvioes;


public class PortaAvioesCreator implements NavioCreator{
	@Override
	public Navio novoNavio() {
		return new PortaAvioes();
	}
	public Navio novoNavio(boolean horizontal) {
		return new PortaAvioes(horizontal);
	}
}
