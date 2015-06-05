package be.vdab.entities;

import java.io.Serializable;
import java.math.BigDecimal;

public class Film implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id, voorraad, gereserveerd, beschikbaar;
	private String titel;
	private BigDecimal prijs;
	
	public Film(int id, String titel, int voorraad, int gereserveerd,
			BigDecimal prijs) {
		setId(id);
		setTitel(titel);
		setVoorraad(voorraad);
		setGereserveerd(gereserveerd);
		setPrijs(prijs);
	}

	public void setReserverenMogelijk(boolean reserverenMogelijk) {
	}

	public Film(int id, String titel, int voorraad, int gereserveerd,
			BigDecimal prijs, int beschikbaar) {
		setId(id);
		setTitel(titel);
		setVoorraad(voorraad);
		setGereserveerd(gereserveerd);
		setPrijs(prijs);
		setBeschikbaar(beschikbaar);
	}

	public int getBeschikbaar() {
		return beschikbaar;
	}

	public void setBeschikbaar(int beschikbaar) {
		this.beschikbaar = beschikbaar;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getVoorraad() {
		return voorraad;
	}

	public void setVoorraad(int voorraad) {
		this.voorraad = voorraad;
	}

	public int getGereserveerd() {
		return gereserveerd;
	}

	public void setGereserveerd(int gereserveerd) {
		this.gereserveerd = gereserveerd;
	}

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public BigDecimal getPrijs() {
		return prijs;
	}

	public void setPrijs(BigDecimal prijs) {
		this.prijs = prijs;
	}

	public String getReserverenMogelijk() {
		if (getGereserveerd() < getVoorraad()) {
			return "reservatie mogelijk";
		} else {
			return "reservatie niet mogelijk";
		}

	}
	
}
