package it.gestionecurricula.test;

import it.gestionecurricula.service.MyServiceFactory;
import it.gestionecurricula.service.curriculum.CurriculumService;
import it.gestionecurricula.service.esperienza.EsperienzaService;

public class TestGestioneCurricula {
	public static void main(String[] args) {
		
		// parlo direttamente con il service
		CurriculumService curriculumService = MyServiceFactory.getCurriculumServiceImpl();
		EsperienzaService esperienzaService = MyServiceFactory.getEsperienzaServiceImpl();

		try {

			// ora con il service posso fare tutte le invocazioni che mi servono
			System.out.println("In tabella ci sono " + curriculumService.listAll().size() + " elementi.");
			
			System.out.println("In tabella ci sono " + esperienzaService.listAll().size() + " elementi.");

			testInserimentoNuovoCurriculum(curriculumService);
			System.out.println("In tabella ci sono " + curriculumService.listAll().size() + " elementi.");
			
			testInserimentoNuovaEsperienza(esperienzaService);
			System.out.println("In tabella ci sono " + esperienzaService.listAll().size() + " elementi.");

			testRimozioneCurriculum(curriculumService);
			System.out.println("In tabella ci sono " + curriculumService.listAll().size() + " elementi.");
			
			testRimozioneEsperienza(esperienzaService);
			System.out.println("In tabella ci sono " + esperienzaService.listAll().size() + " elementi.");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void testInserimentoNuovoCurriculum(CurriculumService curriculumService) throws Exception{
		
	}
	
	private static void testInserimentoNuovaEsperienza(EsperienzaService esperienzaService) throws Exception{
		
	}
	
	private static void testRimozioneCurriculum(CurriculumService curriculumService) throws Exception{
		
	}
	
	private static void testRimozioneEsperienza(EsperienzaService esperienzaService) throws Exception{
		
	}
}
