package org.lessons.java;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GruppoTest {

	static Gruppo g;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		g=new Gruppo("prova");
		
		g.inserisciPersona("Franco", 22);
		g.inserisciPersona("Pina", 23);
		g.inserisciPersona("Franco", 43);
	}

	@Test
	@DisplayName("verifica inserimento corretto")
	void testInsertOK() {
		int size=g.getElencoPersone().size();
		try {
			g.inserisciPersona("Mario", 20);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(size+1, g.getElencoPersone().size(),"numero di persone deve aumentare di 1");
	}

	@Test
	@DisplayName("verifica inserimento non corretto")
	void testInsertKO() {
		assertThrows(
			Exception.class, 
			() -> g.inserisciPersona("Mario", -20),
			"deve essere generata un'eccezione");
	}
	
	@Test
	@DisplayName("verifica inserimento corretto tramite eccezione")
	void testInsertOKExc() {
		assertDoesNotThrow( 
			() -> g.inserisciPersona("Mario", 20),
			"non deve essere generata un'eccezione");
	}
	
	
	@Test
	@DisplayName("verifica inserimento non corretto per nome minuscolo")
	void testInsertKOUpperCase() {
		assertThrows(
			LowerCaseNameException.class, 
			() -> g.inserisciPersona("mario", 20),
			"deve essere generata un'eccezione");
	}
	
	@Test
	@DisplayName("verifica che la ricerca restituisca 2 persone")
	void testRicerca2() {
		ArrayList<Persona> risultato=g.cercaPerNome("Franco");
		assertEquals(2, risultato.size(),"Il risultato della ricerca Franco deve essere 2");
	}
	
	@Test
	@DisplayName("verifica che la ricerca restituisca una lista vuota")
	void testRicercaEmpty() {
		ArrayList<Persona> risultato=g.cercaPerNome("xxxxxx");
		assertEquals(0, risultato.size(),"Il risultato della ricerca xxxx deve essere 0");
	}
}
