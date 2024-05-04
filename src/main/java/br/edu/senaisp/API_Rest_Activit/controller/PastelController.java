package br.edu.senaisp.API_Rest_Activit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.senaisp.API_Rest_Activit.model.Pastel;
import br.edu.senaisp.API_Rest_Activit.repository.PastelRepository;

@RestController
@RequestMapping("/pastel")
public class PastelController {
	
	@Autowired
	PastelRepository repository;
	
	@GetMapping("/listar")
	public String listarPastel() {
		String temp = "";
		
		for (Pastel pasteis : repository.lista()) {
			temp += pasteis.getSabor() + " / ";
		}
		
		return temp;
	}
	
	@GetMapping("/buscar/{id}")
	public String buscaPorId(@PathVariable Integer id) {
		return repository.buscaPorId(id).getSabor();
	}
	
	@PostMapping("/insere") 
	public String insere(@RequestBody Pastel pastel) {
		return String.valueOf(repository.insere(pastel));
	}
	
	@PutMapping("/altera/{id}") 
	public String insere(@RequestBody Pastel pastel, @PathVariable Integer id) {
		return String.valueOf(repository.altera(pastel, id));
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		return String.valueOf(repository.delete(id));
	}
	
}
