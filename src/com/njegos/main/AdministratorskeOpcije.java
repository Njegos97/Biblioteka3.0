package com.njegos.main;

public enum AdministratorskeOpcije {
   
 DODAJKNJIGU("Dodaj Knjigu"), IZBRISIKNJIGU("Izbrisi Knjigu"), IZBRISICLANA("Izbrisi Clana"), STANJECLANA("Pogledaj knjige koje je clan iznajmio"),
	STANJEKNJIGE("Stanje Knjige"), NAZAD("Nazad"), START("Start");
	
	
    private String opcija;
	
	AdministratorskeOpcije(String opcija){
		this.opcija = opcija;
	}
	
	public String getOpcija() {
		return opcija;
	}
}
