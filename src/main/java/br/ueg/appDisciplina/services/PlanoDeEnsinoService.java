package br.ueg.appDisciplina.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.ueg.appDisciplina.models.PlanoDeEnsino;
import br.ueg.appDisciplina.repositories.PlanoDeEnsinoRepository;

@Service
public class PlanoDeEnsinoService {
	private final PlanoDeEnsinoRepository planoDeEnsinoRepository;
	public PlanoDeEnsinoService(PlanoDeEnsinoRepository planoDeEnsinoRepository) {
		this.planoDeEnsinoRepository = planoDeEnsinoRepository;
	}
	public PlanoDeEnsino savePlanoDeEnsino(PlanoDeEnsino planoDeEnsino) {
		return planoDeEnsinoRepository.save(planoDeEnsino);
	}
	public void deletePlanoDeEnsino(Long id) {
		planoDeEnsinoRepository.deleteById(id);
	}
	public List<PlanoDeEnsino> listPlanoDeEnsino() {
		return planoDeEnsinoRepository.findAll();
	}
	public PlanoDeEnsino findById(Long id) {
		Optional<PlanoDeEnsino> optPlanoDeEnsino = planoDeEnsinoRepository.findById(id);
		return optPlanoDeEnsino.get();
	}
}
