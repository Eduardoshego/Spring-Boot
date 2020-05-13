package br.ueg.appDisciplina.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.ueg.appDisciplina.models.PlanoDeEnsino;
import br.ueg.appDisciplina.services.PlanoDeEnsinoService;
import io.swagger.annotations.ApiOperation;

@RestController
public class PlanoDeEnsinoController {

	@Autowired
	private final PlanoDeEnsinoService planoDeEnsinoService;
	public PlanoDeEnsinoController(PlanoDeEnsinoService planoDeEnsinoService) {
		this.planoDeEnsinoService = planoDeEnsinoService;
	}
	@PostMapping("/plano")
	@ApiOperation(value = "Método para salavar um plano de ensino.")
	public PlanoDeEnsino savePlanoDeEnsino(@RequestBody PlanoDeEnsino planoDeEnsino) {
		return planoDeEnsinoService.savePlanoDeEnsino(planoDeEnsino);
	}
	@GetMapping("/plano")
	@ApiOperation(value = "Método para listar todos os planos de ensino.")
	public List<PlanoDeEnsino> listPlanoDeEnsino() {
		return planoDeEnsinoService.listPlanoDeEnsino();
	}
	@DeleteMapping("/plano/{id}")
	@ApiOperation(value = "Método para deletar um plano de ensino usando seu id.")
	public void deletePlanoDeEnsino(@PathVariable(value = "id")Long id) {
		planoDeEnsinoService.deletePlanoDeEnsino(id);
	}
	@GetMapping("/plano/{id}")
	@ApiOperation(value = "Método para buscar um plano de ensino usando seu id.")
	public PlanoDeEnsino findById(@PathVariable(value = "id")Long id) {
		return planoDeEnsinoService.findById(id);
	}
	
}