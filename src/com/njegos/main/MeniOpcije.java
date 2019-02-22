package com.njegos.main;

public enum MeniOpcije {

	r("Registracija"), l("Log In"), a("Administratorske Opcije"), i("Izlaz");

	private String opcija;

	MeniOpcije(String opcija) {
		this.opcija = opcija;
	}

	public String getOpcija() {
		return opcija;
	}
}
