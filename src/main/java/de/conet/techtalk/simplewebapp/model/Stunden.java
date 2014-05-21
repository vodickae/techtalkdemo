package de.conet.techtalk.simplewebapp.model;

public class Stunden {

	/**
	 * Interne id.
	 */
	private int id;
	
	/**
	 * ID des Users.
	 */
	private int userid;

	/**
	 * Anzahl der Stunden, die geleistet wurden.
	 */
	private int anzahl;

	/**
	 * Freigegebene Datensätze können auch von anderen Nutzern eingesehen
	 * werden.
	 */
	private boolean freigegeben;

	/**
	 * Projekt
	 */
	private String projekt;

	/**
	 * Was hat er getan?
	 */
	private String kommentar;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getAnzahl() {
		return anzahl;
	}

	public void setAnzahl(int anzahl) {
		this.anzahl = anzahl;
	}

	public String getKommentar() {
		return kommentar;
	}

	public void setKommentar(String kommentar) {
		this.kommentar = kommentar;
	}

	public String getProjekt() {
		return projekt;
	}

	public void setProjekt(String projekt) {
		this.projekt = projekt;
	}

	public boolean isFreigegeben() {
		return freigegeben;
	}

	public void setFreigegeben(boolean freigegeben) {
		this.freigegeben = freigegeben;
	}

	@Override
	public String toString() {
		return "Stunden [id=" + id + ", userid=" + userid + ", anzahl="
				+ anzahl + ", freigegeben=" + freigegeben + ", projekt="
				+ projekt + ", kommentar=" + kommentar + "]";
	}

	

}
