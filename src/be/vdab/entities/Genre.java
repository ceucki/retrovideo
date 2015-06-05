package be.vdab.entities;

import java.io.Serializable;

public class Genre implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private String naam;

	public Genre(long id, String naam) {
		setId(id);
		setNaam(naam);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}
	
}
