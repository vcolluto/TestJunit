package org.lessons.java;

import java.util.ArrayList;

public class Gruppo {
	
	private String nome;
	private ArrayList<Persona> elencoPersone;
	
	public Gruppo(String nome) {
		super();
		this.nome = nome;
		elencoPersone=new ArrayList<>();
	}
	
	public String getNome() {
		return nome;
	} 
	
	public void inserisciPersona(String nome, int età) throws Exception {
		if (nome.isEmpty())
			throw new Exception("Empty name");
		else if (età<0)
			throw new Exception("Negative age");
		else {
			if (verificaNome(nome)) {
				Persona p=new Persona(nome, età);
				elencoPersone.add(p);
			} else
				throw new LowerCaseNameException(nome);
		}
			
	}
	
	private boolean verificaNome(String n) {	//verifica se il primo carattere è maiuscolo
		return Character.isUpperCase(n.charAt(0));
	}
	
	public ArrayList<Persona> getElencoPersone() {
		return elencoPersone;
	}
	
	public ArrayList<Persona> cercaPerNome(String nome) {
		ArrayList<Persona> res=new ArrayList<>();
		
		for(Persona p: elencoPersone)
			if (p.getNome().equals(nome))
				res.add(p);
		
		return res;
	}
	
	
	

}
