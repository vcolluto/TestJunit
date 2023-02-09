package org.lessons.java;

public class LowerCaseNameException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;

	public LowerCaseNameException(String name) {
		super("Lower case name: "+name);
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	

}
