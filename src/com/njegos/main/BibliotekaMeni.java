package com.njegos.main;

import com.njegos.entiteti.Biblioteka;
import com.njegos.entiteti.Clan;
import com.njegos.entiteti.Knjiga;
import com.njegos.logika.BibliotekaLogika;
import com.njegos.logika.Unos;

import java.util.Map;
import java.util.Scanner;

public class BibliotekaMeni {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		Biblioteka biblioteka = new Biblioteka();
		Clan clan = null;
		Knjiga knjiga = null;
		int id = -1;
		int idKnjige = -1;
		int unos = -1;

		// biblioteka.setRadi(true);

		MeniOpcije meniOpcije = MeniOpcije.s;
		LogInOpcije logInOpcije = LogInOpcije.s;
		AdministratorskeOpcije administratorskeOpcije = AdministratorskeOpcije.START;

		while (meniOpcije != meniOpcije.i) {

			meniOpcije();
			meniOpcije = MeniOpcije.values()[Integer.parseInt(input.nextLine().trim())];

			switch (meniOpcije) {
			
			case r:
				clan = new Clan();
				System.out.println("Unesite ime");
				String ime = input.next();
				System.out.println("Unesite prezime");
				String prezime = input.next();
				clan.setIme(ime);
				clan.setPrezime(prezime);
				BibliotekaLogika.registracija(biblioteka.getClanovi(), clan);
				System.out.println("Vas id je " + clan.getId());
				input.nextLine();
				break;

			case l:
				System.out.println("unesite Clanski Broj");
				id = Unos.unosIntegera();

				clan = BibliotekaLogika.pronadjiClana(biblioteka.getClanovi(), id);

				if (clan != null) {
					System.out.println("Dobro dosli " + clan.getIme());
				}

				else {
					System.out.println("Nepostoji clan sa tim id-om");
				}

				while (logInOpcije != LogInOpcije.n) {
					logInOpcije();
					logInOpcije = LogInOpcije.values()[Integer.parseInt(input.nextLine().trim())];

					switch (logInOpcije) {

					case i:
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
                    
					case v:
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
					case n:
						
					}
				}

			case a:
				while (administratorskeOpcije != AdministratorskeOpcije.n) {
					administratorskeOpcije();
					administratorskeOpcije = AdministratorskeOpcije.values()[Integer.parseInt(input.nextLine().trim()) - 1];

					switch (administratorskeOpcije) {
					case d:
						knjiga = new Knjiga();

					    ime = input.nextLine();
						knjiga.setIme(ime);
						BibliotekaLogika.DodajKnjigu(biblioteka.getKnjige(), knjiga);
						System.out.println("Dodali ste knjigu " + ime);

						break;
					case i:
						System.out.println("unesi id knjige koju zelis izbrisati: ");

						for (Map.Entry<Integer, Knjiga> entry : biblioteka.getKnjige().entrySet()) {
							System.out.print(entry.getKey() + " ");
							knjiga = entry.getValue();
							System.out.println(knjiga.getIme());

						}

						id = Unos.unosIntegera();
						try {
							knjiga = BibliotekaLogika.izbrisiKnjigu(biblioteka.getKnjige(), id);

							if (knjiga == null) {
								System.out.println("ne mozete izbrisati, knjiga je iznajmljena");
							} else {
								System.out.println("Izbrisali ste " + knjiga.getIme());
							}
							break;
						} catch (NullPointerException e) {
							System.out.println("Usp");
							break;
						}
					case c:
						System.out.println("Unesi id clana kojeg zelis izbrisati: ");

						System.out.println(biblioteka.getClanovi().entrySet());

						id = Unos.unosIntegera();
						try {
							clan = BibliotekaLogika.izbrisiClana(biblioteka.getClanovi(), id);

							if (clan == null) {
								System.out.println("Clan nije vratio sve knjige, ne mozete ga izbirsati");
							} else {
								System.out.println("izbrisali ste  " + clan.getIme() + " " + clan.getPrezime());

							}
							break;
						} catch (NullPointerException e) {
							System.out.println("ups");
							break;
						}
					case p:
						System.out.println("Upisite id clana od kojeg zelite vidjeti iznajmljene knjige");
						id = Unos.unosIntegera();
						try {
							clan = BibliotekaLogika.pronadjiClana(biblioteka.getClanovi(), id);
							if (clan.getMojeKnjige().isEmpty()) {
								System.out.println("Ovaj clan nije iznajmio ni jednu knjigu");
							} else {
								System.out.println(clan.getIme() + " je iznajmio:");
								for (Map.Entry<Integer, Knjiga> entry : clan.getMojeKnjige().entrySet()) {
									System.out.print(entry.getKey() + " ");
									knjiga = entry.getValue();
									System.out.println(knjiga.getIme());

								}
							}

							break;
						} catch (NullPointerException e) {
							System.out.println("pogresan id");
							break;
						}
					case s:
						for (Map.Entry<Integer, Knjiga> entry : biblioteka.getKnjige().entrySet()) {
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
						} catch (NullPointerException e) {
							System.out.println("Pogresan id");
							break;
						}
					case n:
						 
					}
					
				}
			case i:
           
			}

		}

	}

	public static void meniOpcije() {
		System.out.println("1. Registracija");
		System.out.println("2. Log In");
		System.out.println("3. Administratorske Opcije");
		System.out.println("4. Izlaz");

	}

	public static void logInOpcije() {
		System.out.println("1. Iznajmi Knjigu");
		System.out.println("2. Vrati Knjigu");
		System.out.println("3. nazad");
	}

	public static void administratorskeOpcije() {
		System.out.println("1. Dodaj Knjigu");
		System.out.println("2. izbrisi Knjigu");
		System.out.println("3. izbrisi Clana");
		System.out.println("4. Pogledaj Knjige Koje Je Clan Iznajmio");
		System.out.println("5. Stanje Knjige");
		System.out.println("6. Nazad");
	}

}