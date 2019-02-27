package main;

import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;

import com.njegos.entiteti.Biblioteka;
import com.njegos.entiteti.Clan;
import com.njegos.entiteti.Knjiga;
import com.njegos.logika.BibliotekaLogika;
import com.njegos.logika.Unos;

public class BibMain {
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stubBiblioteka biblioteka = new Biblioteka();
		Biblioteka biblioteka = new Biblioteka();
		Clan clan = null;
		Knjiga knjiga = null;
		int id = -1;
		int idKnjige = -1;
		int unos = -1;

		biblioteka.setRadi(true);
	    //BibliotekaLogika.procitajClanoveizFile(biblioteka.getClanovi(), clan);
	   // BibliotekaLogika.procitajKnjigeizFile(biblioteka.getKnjige(), knjiga);

		while (biblioteka.isRadi()) {
			System.out.println("1. registracija \n2. log in \n3. administratorske opcije \n4. izlaz");
			unos = Unos.unosIntegera();
			switch (unos) {
			case 1:
				clan = new Clan();
				System.out.println("Unesite ime");
				String ime = input.next();
				System.out.println("Unesite prezime");
				String prezime = input.next();
				clan.setIme(ime);
				clan.setPrezime(prezime);
				BibliotekaLogika.registracija(biblioteka.getClanovi(), clan);
				System.out.println("Vas id je " + clan.getId());
				break;
			case 2:
				System.out.println("unesite Clanski Broj");
				id = Unos.unosIntegera();
				
				clan = BibliotekaLogika.pronadjiClana(biblioteka.getClanovi(), id);

				if (clan != null) {
					System.out.println("Dobro dosli " + clan.getIme());
				}

				else {
					System.out.println("Nepostoji clan sa tim id-om");
				}

				while (clan != null) {
					System.out.println("1.Iznajmi knjigu \n2.Vrati knjigu \n3.Log out");
					unos = Unos.unosIntegera();
					switch (unos) {
					case 1:
						    for(Map.Entry<Integer, Knjiga> entry : biblioteka.getKnjige().entrySet()) {
						    	System.out.print(entry.getKey() + " ");
						        knjiga = entry.getValue();
						    	System.out.println(knjiga.getIme());
						    	
						    }
						    System.out.println("unesite id knjige koju zelite da iznajmite");
							id = Unos.unosIntegera();
							knjiga = BibliotekaLogika.pronadjiKnjigu(biblioteka.getKnjige(), id);
							int broj = -1;
							try {
							 broj= BibliotekaLogika.IznajmiKnjigu(clan, knjiga, id);
							}catch(NullPointerException e) {
								System.out.println("Ups");
								break;
							}

					      if (broj == 0 ) {
							System.out.println("Iznajmili ste " + knjiga.getIme());
					     }
					     
					     
						else if(broj == 1){
							System.out.println("Vec imate 3 iznajmljene knjige");
						}
						else {
							System.out.println("knjiga je vec iznajmljena");
						}

						break;

					case 2:
					
						 for(Map.Entry<Integer, Knjiga> entry : clan.getMojeKnjige().entrySet()) {
						    	System.out.print(entry.getKey() + " ");
						        knjiga = entry.getValue();
						    	System.out.println(knjiga.getIme());
						    	
						    }
						
						
						System.out.println("Unesite id knjige koju zelite da vratite");
						id = Unos.unosIntegera();
					    knjiga = BibliotekaLogika.vratiKnjigu(clan.getMojeKnjige(), id);
						
												
						System.out.println("vratili ste " + knjiga.getIme());
						break;
					case 3:
					clan = null;


					}
				}
				break;

			case 3:
				input.nextLine();
				while (unos != 0) {
					System.out.println("1. Dodaj Knjigu \n2. Izbrisi Knjigu \n3. Izbrisi Clana "
							+ "\n4.Pogledaj iznajmljene knjige \n5. stanje knjige \n6. nazad");

					unos = Unos.unosIntegera();

					switch (unos) {
					case 1:
						knjiga = new Knjiga();

						ime = input.nextLine();
						knjiga.setIme(ime);
						BibliotekaLogika.DodajKnjigu(biblioteka.getKnjige(), knjiga);
						System.out.println("Dodali ste knjigu " + ime);

						break;

					case 2:
						System.out.println("unesi id knjige koju zelis izbrisati: ");
						
						 for(Map.Entry<Integer, Knjiga> entry : biblioteka.getKnjige().entrySet()) {
						    	System.out.print(entry.getKey() + " ");
						        knjiga = entry.getValue();
						    	System.out.println(knjiga.getIme());
						    	
						    }
						
						id = Unos.unosIntegera();
						try {
						knjiga = BibliotekaLogika.izbrisiKnjigu(biblioteka.getKnjige(), id);
						
						
						if(knjiga == null) {
							System.out.println("ne mozete izbrisati, knjiga je iznajmljena");
						}
						else {
						System.out.println("Izbrisali ste " + knjiga.getIme());
						}
						break;
						}catch(NullPointerException e) {
							System.out.println("Usp");
							break;
						}

					case 3:
						System.out.println("Unesi id clana kojeg zelis izbrisati: ");
						
							System.out.println(biblioteka.getClanovi().entrySet());
						
						id = Unos.unosIntegera();
		                try {			
							clan = BibliotekaLogika.izbrisiClana(biblioteka.getClanovi(), id);
							
						if(clan == null) {
							System.out.println("Clan nije vratio sve knjige, ne mozete ga izbirsati");
						}
						else {
						System.out.println("izbrisali ste  "  + clan.getIme() + " " + clan.getPrezime()); //Ovde si mogao napraviti to string metodu da donijes ime i prezime fino
						}
		                break;
		                }catch(NullPointerException e) {
		                	System.out.println("ups");
		                	break;
		                }

					case 4:
						System.out.println("Upisite id clana od kojeg zelite vidjeti iznajmljene knjige");
						id = Unos.unosIntegera();
						try {
						clan = BibliotekaLogika.pronadjiClana(biblioteka.getClanovi(), id);
	                      if (clan.getMojeKnjige().isEmpty()) {
							System.out.println("Ovaj clan nije iznajmio ni jednu knjigu");
						} else {
							System.out.println(clan.getIme() + " je iznajmio:");
							for(Map.Entry<Integer, Knjiga> entry : clan.getMojeKnjige().entrySet()) {
						    	System.out.print(entry.getKey() + " ");
						        knjiga = entry.getValue();
						    	System.out.println(knjiga.getIme());
						    	
						    }
						}

						break;
						}
						catch(NullPointerException e) {
							System.out.println("pogresan id");
							break;
						}

					case 5:
						  for(Map.Entry<Integer, Knjiga> entry : biblioteka.getKnjige().entrySet()) {
						    	System.out.print(entry.getKey() + " ");
						        knjiga = entry.getValue();
						    	System.out.println(knjiga.getIme());
						    	
						    }
						System.out.println("Upisite id knjige od koje zelite vidjeti da li je iznajmljena");
						id = Unos.unosIntegera();
						try {
						knjiga = BibliotekaLogika.pronadjiKnjigu(biblioteka.getKnjige(), id);

						if (knjiga.getIznajmljena() == true) {
							System.out.println("Knjigu je iznajmio " + knjiga.getImeClana());
						}

						else {
							System.out.println("Knjiga se nalazi u biblioteci");
						}
						break;
						}catch(NullPointerException e) {
							System.out.println("Pogresan id");
							break;
						}
					case 6:
						unos = 0;
						break;

					}

				}
				break;
			case 4:
				//BibliotekaLogika.upisiClanoveUFile(biblioteka.getClanovi());
				//BibliotekaLogika.upisiKnjigeUFile(biblioteka.getKnjige());
				biblioteka.setRadi(false);
			}

		}
	}

}
