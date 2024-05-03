package br.edu.senaisp.ApiRest.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.edu.senaisp.ApiRest.model.Banda;

@Repository
public class BandaRepository implements iCrud{
	
	private String qrSelectAll = "select id, nome, lancamento from banda";
	
	private String qrSelectById = "select id, nome, lancamento from banda where id = ?";
	
	private String qrUpdate = "update banda set nome = ?, lancamento = ? where id = ?";
	
	private String qrInsere = "insert into banda (nome, lancamento) values (?, ?)";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Banda> lista() {
		return jdbcTemplate.query(qrSelectAll,
				(rs, rowNum) -> {
					return new Banda(rs.getInt("id"),
							rs.getString("nome"),
							rs.getInt("anolancamento")
							);
				}
				);
	}

	@Override
	public Banda buscaPorId(int id) {
		Object[] params = {id};
		
		return jdbcTemplate.queryForObject(qrSelectById, params,
				(rs, rowNum) -> {
					return new Banda(rs.getInt("id"),
							rs.getString("nome"),
							rs.getInt("anolancamento")
							);
				}
				);
	}

	@Override
	public int altera(Banda banda, int id) {
		Object[] params = {banda.getNome(), banda.getLancamento(), id};
		
		return jdbcTemplate.update(qrUpdate, params);
	}

	@Override
	public int insere(Banda banda) {
		
		Object[] params = {banda.getNome(), banda.getLancamento()};
		return jdbcTemplate.update(qrInsere, params);
		
		
	}
	
	
	
}
