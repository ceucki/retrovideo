package be.vdab.entities;

import java.io.Serializable;

public class Klant implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String familienaam,voornaam,straatNummer,postcode,gemeente;
	
	public Klant(int id, String familienaam, String voornaam,String straatNummer, String postcode, String gemeente){
		setFamilienaam(familienaam);
		setVoornaam(voornaam);
		setGemeente(gemeente);
		setId(id);
		setPostcode(postcode);
		setStraatNummer(straatNummer);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVoornaam() {
		return voornaam;
	}

	public void setVoornaam(String voornaam) {
		this.voornaam = voornaam;
	}

	public String getStraatNummer() {
		return straatNummer;
	}

	public void setStraatNummer(String straatNummer) {
		this.straatNummer = straatNummer;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getGemeente() {
		return gemeente;
	}

	public void setGemeente(String gemeente) {
		this.gemeente = gemeente;
	}	
	

	public String getFamilienaam() {
		return familienaam;
	}

	public void setFamilienaam(String familienaam) {
		this.familienaam = familienaam;
	}

}
