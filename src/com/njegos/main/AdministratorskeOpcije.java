package com.njegos.main;

public enum AdministratorskeOpcije {
   
	d("Dodaj Knjigu"), i("Izbrisi Knjigu"), c("Izbrisi Clana"), p("Pogledaj knjige koje je clan iznajmio"),
	s("Stanje Knjige"), n("Nazad"), START("Start");
	
	
    private String opcija;
	
	AdministratorskeOpcije(String opcija){
		this.opcija = opcija;
	}
	
	public String getOpcija() {
		return opcija;
	}
}
