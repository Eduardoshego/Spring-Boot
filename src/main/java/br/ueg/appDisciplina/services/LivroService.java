package br.ueg.appDisciplina.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ueg.appDisciplina.models.Livro;
import br.ueg.appDisciplina.repositories.LivroRepository;

@Service
public class LivroService {
	@Autowired
	private final LivroRepository livroRepository;
	public LivroService(LivroRepository livroRepository) {
		this.livroRepository = livroRepository;
	}
	public Livro saveLivro(Livro livro) {
		return livroRepository.save(livro);
	}
	public List<Livro> listLivro(){
		return livroRepository.findAll();
	}
	public void deleteLivro(Long id) {
		livroRepository.deleteById(id);
	}
	public Livro findById(Long id) {
		Optional<Livro> optLivro = livroRepository.findById(id);
		return optLivro.get();
	}
}
