package br.ueg.app.Disciplina.controller;



import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import br.ueg.appDisciplina.models.Disciplina;
import br.ueg.appDisciplina.services.DisciplinaService;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class DisciplinaControllerTest {

	@LocalServerPort
	private int port;
	
	@MockBean
	private DisciplinaService disciplinaService;
	
	@Autowired
	private TestRestTemplate testRestTemplate;
	
	@Test
	public void listDisciplinaReturn200() throws Exception{
		List<Disciplina> disciplina = new ArrayList<>();
		disciplina.add(new Disciplina(1L, "ProgramaçãoIII"));
		disciplina.add(new Disciplina(2L,"programaçãoII"));
		
		BDDMockito.when(disciplinaService.listDisciplina()).thenReturn(disciplina);
		
		ResponseEntity<String> response = testRestTemplate.getForEntity(new URL("http://localhost" + port + "/disciplina").toString(),String.class);
		assertEquals(200, response.getStatusCodeValue());
	}
}
