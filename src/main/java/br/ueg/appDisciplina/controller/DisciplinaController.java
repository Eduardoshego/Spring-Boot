package br.ueg.appDisciplina.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.ueg.appDisciplina.models.Disciplina;
import br.ueg.appDisciplina.services.DisciplinaService;
import io.swagger.annotations.ApiOperation;

@RestController
public class DisciplinaController {
	
	@Autowired
	private final DisciplinaService disciplinaService;
	public DisciplinaController(DisciplinaService disciplinaService) {
		this.disciplinaService = disciplinaService;
	}
	
	@PostMapping("/disciplina")
	@ApiOperation(value = "Método que salva a disciplina")
	public Disciplina saveDisciplina(@RequestBody Disciplina disciplina) {
		return disciplinaService.saveDisciplina(disciplina);
	}
	@GetMapping("/disciplina")
	@ApiOperation(value = "Método que retorna uma lista com todas as Disciplinas salvas")
	public List<Disciplina> listDisciplina(){
		return disciplinaService.listDisciplina();
	}
	@GetMapping("/disciplina/{id}")
	@ApiOperation(value = "Método Responsável por buscar uma disciplina pelo seu id (*id = n° de identificação)")
	public Disciplina findById(@PathVariable (value = "id")Long id) {
		return disciplinaService.findById(id);
	}
	@DeleteMapping("/disciplina/{id}")
	@ApiOperation(value = "Método Responsável por deletar uma disciplina pelo seu id (*id = n° de identificação)")
	public void deleteDisciplina(@PathVariable(value = "id")Long id) {
		disciplinaService.deleteDisciplina(id);
	}

}
