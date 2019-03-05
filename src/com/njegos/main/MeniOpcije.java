package com.njegos.main;
import java.util.Scanner;

import com.njegos.entiteti.Biblioteka;
import com.njegos.entiteti.Clan;
import com.njegos.logika.BibliotekaLogika;
import com.njegos.logika.Unos;

public enum MeniOpcije {
   
	
   START("Start"), REGISTRACIJA("Registracija"), LOGIN("Log In"), ADMINISTRATORSKEOPCIJE("Administratorske Opcije"), IZLAZ("Izlaz");

	Scanner input = new Scanner(System.in);
	private String opcija;

	MeniOpcije(String opcija) {
		this.opcija = opcija;
	}

	public String getOpcija() {
		return opcija;
	}
	
	
	public void izvrsiRegistraciju(Clan clan, Biblioteka biblioteka) {
		clan = new Clan();
		System.out.println("Unesite ime");
		String ime = input.next();
		System.out.println("Unesite prezime");
		String prezime = input.next();
		clan.setIme(ime);
		clan.setPrezime(prezime);
		BibliotekaLogika.registracija(biblioteka.getClanovi(), clan);
		System.out.println("Vas id je " + clan.getId());
		
	}
	
	public void LogIn(Biblioteka biblioteka, int id) {
		System.out.println("unesite Clanski Broj");
		id = Unos.unosIntegera();
		
		Clan clan = BibliotekaLogika.pronadjiClana(biblioteka.getClanovi(), id);

		if (clan != null) {
			System.out.println("Dobro dosli " + clan.getIme());
		}

		else {
			System.out.println("Nepostoji clan sa tim id-om");
		}
	}
	
	
}
