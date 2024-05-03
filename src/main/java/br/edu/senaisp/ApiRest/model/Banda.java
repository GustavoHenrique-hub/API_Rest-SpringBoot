package br.edu.senaisp.ApiRest.model;

public class Banda {
	private Integer id;
	private String nome;
	private Integer lancamento;
	
	public Banda() {
		
	}

	public Banda(Integer id, String nome, Integer lancamento) {
		super();
		this.id = id;
		this.nome = nome;
		this.lancamento = lancamento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getLancamento() {
		return lancamento;
	}

	public void setLancamento(Integer lancamento) {
		this.lancamento = lancamento;
	}

	
}

