package br.edu.senaisp.ApiRest.repository;

import java.util.List;

import br.edu.senaisp.ApiRest.model.Banda;

public interface iCrud {
	
	public List<Banda> lista();
	
	public Banda buscaPorId(int id);
	
	public int altera(Banda banda, int id);
	
	public int insere(Banda banda);
}
