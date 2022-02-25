package it.gestionecurricula.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import it.gestionecurricula.model.Curriculum;
import it.gestionecurricula.model.Esperienza;
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
			
			testInserimentoNuovaEsperienza(curriculumService, esperienzaService);
			System.out.println("In tabella ci sono " + esperienzaService.listAll().size() + " elementi.");

			testRimozioneCurriculum(curriculumService);
			System.out.println("In tabella ci sono " + curriculumService.listAll().size() + " elementi.");
			
			testRimozioneEsperienza(curriculumService, esperienzaService);
			System.out.println("In tabella ci sono " + esperienzaService.listAll().size() + " elementi.");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void testInserimentoNuovoCurriculum(CurriculumService curriculumService) throws Exception{
		System.out.println(".......testInserimentoNuovoCurriculum inizio.............");
		System.out.println("");
		Date dataNascita1 = new SimpleDateFormat("dd-MM-yyyy").parse("20-06-1999");
		Curriculum newCurriculumInstance = new Curriculum("Calogero", "Corsello", dataNascita1, "calogerocorsello1999@gmail.com", "3887790486");
		if (curriculumService.inserisciNuovo(newCurriculumInstance) != 1)
			throw new RuntimeException("testInserimentoNuovoCurriculum FAILED ");

		System.out.println(".......testInserimentoNuovoCurriculum PASSED.............");
		System.out.println("");
	}
	
	private static void testInserimentoNuovaEsperienza(CurriculumService curriculumService, EsperienzaService esperienzaService) throws Exception{
		System.out.println(".......testInserimentoNuovaEsperienza inizio.............");
		System.out.println("");
		Date dataNascita1 = new SimpleDateFormat("dd-MM-yyyy").parse("02-12-1999");
		Curriculum newCurriculumInstance = new Curriculum("Flavio", "Amato", dataNascita1, "flavioamato1999@gmail.com", "3892143701");
		if (curriculumService.inserisciNuovo(newCurriculumInstance) != 1)
			throw new RuntimeException("testInserimentoNuovoCurriculum FAILED ");
		
		List<Curriculum> curriculumPresenti = curriculumService.listAll();
		Curriculum ultimoCaricato = curriculumPresenti.get(curriculumPresenti.size()-1);
		
		Date dataInizio1 = new SimpleDateFormat("dd-MM-yyyy").parse("10-02-2022");
		Date dataFine1 = new SimpleDateFormat("dd-MM-yyyy").parse("21-04-2022");
		Esperienza newEsperienzaInstance1 = new Esperienza("Solving Team", dataInizio1, dataFine1, "Programmazione Java Full Stack", ultimoCaricato);
		if (esperienzaService.inserisciNuovo(newEsperienzaInstance1) != 1)
			throw new RuntimeException("testInserimentoNuovoCurriculum FAILED ");
		
//		Date dataInizio2 = new SimpleDateFormat("dd-MM-yyyy").parse("19-04-2022");
//		Date dataFine2 = new SimpleDateFormat("dd-MM-yyyy").parse("12-05-2022");
//		Esperienza newEsperienzaInstance2 = new Esperienza("Esperienza futura", dataInizio2, dataFine2, "Conoscenze future", ultimoCaricato);
//		if (esperienzaService.inserisciNuovo(newEsperienzaInstance2) != 1)
//			throw new RuntimeException("testInserimentoNuovoCurriculum FAILED ");
		

		System.out.println(".......testInserimentoNuovaEsperienza PASSED.............");
		System.out.println("");
	}
	
	private static void testRimozioneCurriculum(CurriculumService curriculumService) throws Exception{
		System.out.println(".......testRimozioneCurriculum inizio.............");
		System.out.println("");
		Date dataNascita1 = new SimpleDateFormat("dd-MM-yyyy").parse("18-11-1999");
		Curriculum newCurriculumInstance = new Curriculum("Francesco", "Carmone", dataNascita1, "francescocarmone1999@gmail.com", "3205767599");
		if (curriculumService.inserisciNuovo(newCurriculumInstance) != 1)
			throw new RuntimeException("testRimozioneCurriculum FAILED ");
		
		List<Curriculum> curriculumPresenti = curriculumService.listAll();
		Curriculum ultimoDellaLista = curriculumPresenti.get(curriculumPresenti.size()-1);
		
		if (curriculumService.rimuovi(ultimoDellaLista) != 1)
			throw new RuntimeException("testRimozioneCurriculum FAILED ");
		
		System.out.println(".......testRimozioneCurriculum PASSED.............");
		System.out.println("");
	}
	
	private static void testRimozioneEsperienza(CurriculumService curriculumService, EsperienzaService esperienzaService) throws Exception{
		System.out.println(".......testRimozioneEsperienza inizio.............");
		System.out.println("");
		Date dataNascita1 = new SimpleDateFormat("dd-MM-yyyy").parse("12-02-1999");
		Curriculum newCurriculumInstance = new Curriculum("Giuseppe", "Aloi", dataNascita1, "giuseppealoi1999@gmail.com", "3297789055");
		if (curriculumService.inserisciNuovo(newCurriculumInstance) != 1)
			throw new RuntimeException("testRimozioneEsperienza FAILED ");
		
		List<Curriculum> curriculumPresenti = curriculumService.listAll();
		Curriculum ultimoCaricato = curriculumPresenti.get(curriculumPresenti.size()-1);
		
		Date dataInizio1 = new SimpleDateFormat("dd-MM-yyyy").parse("10-02-2022");
		Date dataFine1 = new SimpleDateFormat("dd-MM-yyyy").parse("21-04-2022");
		Esperienza newEsperienzaInstance1 = new Esperienza("Solving Team", dataInizio1, dataFine1, "Programmazione Java Full Stack", ultimoCaricato);
		if (esperienzaService.inserisciNuovo(newEsperienzaInstance1) != 1)
			throw new RuntimeException("testRimozioneEsperienza FAILED ");
		
		if(esperienzaService.rimuovi(newEsperienzaInstance1) != 1)
			throw new RuntimeException("testRimozioneEsperienza FAILED ");
		
		System.out.println(".......testRimozioneCurriculum PASSED.............");
		System.out.println("");
	}
}
