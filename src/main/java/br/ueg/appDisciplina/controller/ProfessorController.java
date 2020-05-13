package br.ueg.appDisciplina.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.ueg.appDisciplina.models.Professor;
import br.ueg.appDisciplina.services.ProfessorService;
import io.swagger.annotations.ApiOperation;

@RestController
public class ProfessorController {

	@Autowired
	private final ProfessorService professorService;
	public ProfessorController(ProfessorService professorService) {
		this.professorService = professorService;
	}
	@GetMapping("/professores")
	@ApiOperation(value = "Método para listar todos os professores.")
	public List<Professor> listProfessor(){
		return professorService.listProfessor();
	}
	@ApiOperation(value = "Método para salvar um professor.")
	@PostMapping("/professores")
	public Professor saveProfessor(@RequestBody Professor professor) {
		return professorService.saveProfessor(professor);
	}
	@ApiOperation(value = "Método para deletar um professor pelo seu id.")
	@DeleteMapping("/professores/{id}")
	public void deleteProfessor(@PathVariable(value = "id")Long id) {
		professorService.deleteProfessor(id);
	}
	@ApiOperation(value = "Método para listar um professor pelo seu id.")
	@GetMapping("professores/{id}")
	public Professor findById(@PathVariable(value = "id")Long id) {
		return professorService.findById(id);
	}
	
	
}
