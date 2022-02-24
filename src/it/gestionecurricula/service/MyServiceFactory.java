package it.gestionecurricula.service;

import it.gestionecurricula.dao.curriculum.CurriculumDAOImpl;
import it.gestionecurricula.dao.esperienza.EsperienzaDAOImpl;
import it.gestionecurricula.service.curriculum.CurriculumService;
import it.gestionecurricula.service.curriculum.CurriculumServiceImpl;
import it.gestionecurricula.service.esperienza.EsperienzaService;
import it.gestionecurricula.service.esperienza.EsperienzaServiceImpl;

public class MyServiceFactory {
	public static CurriculumService getCurriculumServiceImpl() {
		CurriculumService curriculumService = new CurriculumServiceImpl();
		curriculumService.setCurriculumDao(new CurriculumDAOImpl());
		return curriculumService;
	}
	
	public static EsperienzaService getEsperienzaServiceImpl() {
		EsperienzaService esperienzaService = new EsperienzaServiceImpl();
		esperienzaService.setEsperienzaDao(new EsperienzaDAOImpl());
		return esperienzaService;
	}
}
