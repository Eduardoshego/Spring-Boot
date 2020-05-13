package br.ueg.appDisciplina.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ueg.appDisciplina.models.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{
	
}