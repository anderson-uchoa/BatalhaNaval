package br.ufc.es.batalhanaval.model;

import java.util.Iterator;

public class AreaBatalha implements Iterable<PontoDaArea>{

	public static final int TAMANHO_LADO = 10;

	private PontoDaArea mapa[][];

	public AreaBatalha() {
		mapa = new PontoDaArea[10][10];
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				mapa[i][j] = new PontoDaArea(i, j);
			}
		}
	}

	public AreaBatalha(PontoDaArea[][] mapa2) {
		mapa = mapa2;
	}

	public boolean lancarBombaNoPonto(int x, int y) {
		return mapa[x][y].acertar();
	}

	public boolean adicionarNavio(Navio navio, int x, int y){

		if (podeAdicionarNavioAPartirDaPosicao(navio, x, y)){
			//adiciona
			if(navio.isHorizontal()){
				int coluna = y;

				int nPosicoes = 0;
				while(coluna < AreaBatalha.TAMANHO_LADO && nPosicoes<navio.getTamanho()){// verifica se as posições não estao preenchidas
				
					mapa[x][coluna].setNavio(navio);
					coluna++;
					nPosicoes++;
				}
			}
			else{
				int linha = x;

				int nPosicoes = 0;
				while(linha < AreaBatalha.TAMANHO_LADO && nPosicoes<navio.getTamanho()){// verifica se as posições não estao preenchidas
					mapa[linha][y].setNavio(navio);
					linha++;
					nPosicoes++;
				}

			}
			return true;
		}
		return false;
	}

	public boolean podeAdicionarNavioAPartirDaPosicao(Navio navio, int x, int y){
		if(navio.isHorizontal()){
			int coluna = y;
			int nPosicoes = 0;
			if(AreaBatalha.TAMANHO_LADO-x>=navio.getTamanho()){//Verifica se cabe no campo
				
				while(coluna < AreaBatalha.TAMANHO_LADO && (!mapa[x][coluna].contemNavio()) && nPosicoes<navio.getTamanho()){// verifica se as posições não estao preenchidas
					coluna++;
					nPosicoes++;
				}
				 

			}
			return (nPosicoes == navio.getTamanho());
		}
		else{
			int linha = x;
			int nPosicoes = 0;
			if(AreaBatalha.TAMANHO_LADO-y>=navio.getTamanho()){
				
				while(linha < AreaBatalha.TAMANHO_LADO && (!mapa[linha][y].contemNavio()) && nPosicoes<navio.getTamanho()){ // verifica se as posições não estao preenchidas
					linha++; 
					nPosicoes++;
				}
				
			}
			return (nPosicoes == navio.getTamanho()); 
		}
		
	}

	public PontoDaArea getNavioNaPosicao(int x, int y){
		return mapa[x][y];
	}

	public PontoDaArea getPontoDaPosicao(int x, int y) {
		return mapa[x][y];
	}

	@Override
	public Iterator<PontoDaArea> iterator() {
		return new PontoDaAreaIterator();
	}
	
	private class PontoDaAreaIterator implements Iterator<PontoDaArea>{

		private int linha;
		private int coluna;
		
		public PontoDaAreaIterator(){
			linha = coluna = 0;
		}
		
		@Override
		public boolean hasNext() {
			if (coluna == 10){
				coluna = 0;
				linha++;
			}
			return (linha < AreaBatalha.TAMANHO_LADO);
		}

		@Override
		public PontoDaArea next() {
			PontoDaArea ponto = mapa[linha][coluna];
			coluna++;
			return ponto;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
	}

}
