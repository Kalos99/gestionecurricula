package it.gestionecurricula.service.curriculum;

import java.util.List;

import it.gestionecurricula.dao.curriculum.CurriculumDAO;
import it.gestionecurricula.model.Curriculum;

public interface CurriculumService {
	
	public void setCurriculumDao(CurriculumDAO curriculumDao);

	public List<Curriculum> listAll() throws Exception;

	public Curriculum findById(Long idInput) throws Exception;

	public int aggiorna(Curriculum input) throws Exception;

	public int inserisciNuovo(Curriculum input) throws Exception;

	public int rimuovi(Curriculum input) throws Exception;

	public List<Curriculum> findByExample(Curriculum input) throws Exception;
}
