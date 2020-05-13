package br.ueg.appDisciplina.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ueg.appDisciplina.models.Disciplina;
import br.ueg.appDisciplina.repositories.DisciplinaRepository;

@Service
public class DisciplinaService {
	
	@Autowired
	private final DisciplinaRepository disciplinaRepository;
	
	public DisciplinaService(DisciplinaRepository disciplinaRepository) {
		this.disciplinaRepository = disciplinaRepository;
	}
	public Disciplina saveDisciplina(Disciplina disciplina) {
		return disciplinaRepository.save(disciplina);
	}
	public List<Disciplina> listDisciplina(){
		return disciplinaRepository.findAll();
	}
	public Disciplina findById(Long id) {
		Optional<Disciplina> optDisciplina = disciplinaRepository.findById(id);
		return optDisciplina.get();
	}
	public void deleteDisciplina(Long id) {
		disciplinaRepository.deleteById(id);
	}

}
