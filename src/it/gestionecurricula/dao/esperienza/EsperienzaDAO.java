package it.gestionecurricula.dao.esperienza;

import java.util.List;

import it.gestionecurricula.dao.IBaseDAO;
import it.gestionecurricula.model.Curriculum;
import it.gestionecurricula.model.Esperienza;

public interface EsperienzaDAO extends IBaseDAO<Esperienza>{
	public Esperienza findEsperienzaNonConclusa(Curriculum curriculumInput) throws Exception;
	public List<Esperienza> findAllByCurriculumId(Long curriculumId) throws Exception;
	public int countAllByCurriculumId(Long curriculumId) throws Exception;
}