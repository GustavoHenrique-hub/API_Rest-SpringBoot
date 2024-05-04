package br.edu.senaisp.API_Rest_Activit.repository;

import java.util.List;

import br.edu.senaisp.API_Rest_Activit.model.Pastel;

public interface iCrud {
	public List<Pastel> lista();
	
	public int insere(Pastel pastel);
	
	public int altera(Pastel pastel, Integer id);
	
	public Pastel buscaPorId(Integer id);
	
	public int delete(Integer id);
}
