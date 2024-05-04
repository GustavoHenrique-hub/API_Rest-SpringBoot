package br.edu.senaisp.API_Rest_Activit.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.edu.senaisp.API_Rest_Activit.model.Pastel;

@Repository
public class PastelRepository implements iCrud {
	
	private String qrSelectAll = "SELECT id, sabor FROM pastel";
	private String qrSelectById = "SELECT id, sabor FROM pastel WHERE id = ?";
	private String qrUpdate = "UPDATE pastel SET sabor = ? WHERE id = ?";
	private String qrInsert = "INSERT INTO pastel (sabor) VALUES (?)";
	private String qrDelete = "DELETE FROM pastel WHERE id = ?";
	
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<Pastel> lista() {
		return jdbcTemplate.query(qrSelectAll, (rs, rowNum) -> {
			return new Pastel( 
					rs.getLong("id"), 
					rs.getString("sabor"));
		});
	}

	@Override
	public int insere(Pastel pastel) {
		Object[] params = {pastel.getSabor()};
		
		return jdbcTemplate.update(qrInsert, params);
	}

	@Override
	public int altera(Pastel pastel, Integer id) {
		Object[] params = {pastel.getSabor(), id};
		
		return jdbcTemplate.update(qrUpdate, params);
	}

	@Override
	public Pastel buscaPorId(Integer id) {
		Object[] params = {id};
		
		return jdbcTemplate.queryForObject(qrSelectById, params, (rs, rowNum) -> {
			return new Pastel( 
					rs.getLong("id"), 
					rs.getString("sabor"));
		});
	}

	@Override
	public int delete(Integer id) {
		Object[] params = {id};
		
		return jdbcTemplate.update(qrDelete, params);
	}
	
}
