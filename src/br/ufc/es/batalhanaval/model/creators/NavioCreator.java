package br.ufc.es.batalhanaval.model.creators;
import br.ufc.es.batalhanaval.model.Navio;


public interface NavioCreator {

	Navio novoNavio();
	Navio novoNavio(boolean horizontal);
	
}
