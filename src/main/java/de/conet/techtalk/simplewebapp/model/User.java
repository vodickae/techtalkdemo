package de.conet.techtalk.simplewebapp.model;

public class User {
	private int id;
	private String name;
	private String passwort;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPasswort() {
		return passwort;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", passwort=" + passwort
				+ "]";
	}
	
	
}
