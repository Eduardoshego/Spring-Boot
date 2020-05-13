package br.ueg.appDisciplina.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.ueg.appDisciplina.models.Livro;
import br.ueg.appDisciplina.services.LivroService;
import io.swagger.annotations.ApiOperation;

@RestController
public class LivroController {
	@Autowired
	private final LivroService livroService;
	public LivroController (LivroService livroService) {
		this.livroService =livroService;
	}
	@PostMapping("/livros")
	@ApiOperation(value = "Método para salvar um livro ")
	public Livro saveLivro(@RequestBody Livro livro ) {
		return livroService.saveLivro(livro);
	}
	@GetMapping("/livros")
	@ApiOperation(value = "Método para listar todos os livros")
	public List<Livro> listLivro(){
		return livroService.listLivro();
	}
	@DeleteMapping("/livros/{id}")
	@ApiOperation(value = "Método para deletar um livro pelo seu id")
	public void deleteLivro(@PathVariable(value = "id")Long id) {
		livroService.deleteLivro(id);
	}
	@GetMapping("/livros/{id}")
	@ApiOperation(value = "Método para buscar um livro pelo seu id.")
	public Livro findById(@PathVariable(value = "id")Long id) {
		return livroService.findById(id);
	}
}
