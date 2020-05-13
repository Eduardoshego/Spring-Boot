package br.ueg.appDisciplina.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ueg.appDisciplina.models.Disciplina;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long>{

}
