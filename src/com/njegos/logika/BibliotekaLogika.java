package com.njegos.logika;

import java.util.*;

import com.njegos.entiteti.Clan;
import com.njegos.entiteti.Knjiga;

import java.io.*;

public class BibliotekaLogika  {
	

	public static boolean registracija(Map<Integer, Clan> listaClanova, Clan clanKojiSeRegistruje) {

		
		
		
		int key = generisiKeyZaClana(listaClanova);
		clanKojiSeRegistruje.setId(key);


		listaClanova.put(key, clanKojiSeRegistruje);

		return true;
	}

	public static boolean DodajKnjigu(Map<Integer, Knjiga> listaKnjiga, Knjiga knjiga) {

		
		
		int key = generisiKeyZaKnjigu(listaKnjiga);

		listaKnjiga.put(key, knjiga);

		return true;
	}



	public static int IznajmiKnjigu(Clan clan, Knjiga knjiga, int key) {

		if (clan.getMojeKnjige().size() < Clan.MAKSIMALAN_BROJ_KNJIGA && knjiga.getIznajmljena() == false) {
			clan.getMojeKnjige().put(key, knjiga);
			knjiga.setImeClana(clan.getIme());
			knjiga.setIznajmljena(true);
			return 0;
		} else if (clan.getMojeKnjige().size() >= Clan.MAKSIMALAN_BROJ_KNJIGA) {
			return 1;
		}

		else {
			return 2;
		}

	}

	public static Knjiga vratiKnjigu(Map<Integer, Knjiga> listaKnjiga, int key) {

		listaKnjiga.get(key).setIznajmljena(false);
		return listaKnjiga.remove(key);

		

	}

	public static boolean upisiKnjigeUFile(Map<Integer, Knjiga> listaKnjiga) throws FileNotFoundException {
		File file = new File("SpisakKnjiga.txt");

		PrintWriter pw = new PrintWriter(file);
		for (int i = 0; i < listaKnjiga.size(); i++) {
			int key = (int) listaKnjiga.keySet().toArray()[i];
			pw.print(key);
			String nazivKnjige = listaKnjiga.get(key).getIme();
			pw.print(" " + nazivKnjige);
			boolean iznajmljena = listaKnjiga.get(key).getIznajmljena();
			pw.print(" " + iznajmljena);
			String imeClanaKojiJeIznajmioKnjigu= listaKnjiga.get(key).getImeClana();
			pw.println(" " + imeClanaKojiJeIznajmioKnjigu);
		}
		pw.close();

		return true;
	}
	
	public static boolean upisiClanoveUFile(Map<Integer, Clan> listaClanova) throws FileNotFoundException {
		File file = new File("SpisakClanova.txt");

		PrintWriter pw = new PrintWriter(file);
		
		for (int i = 0; i < listaClanova.size(); i++) {
			int key = (int) listaClanova.keySet().toArray()[i];
			pw.print(key);
			String nazivClana = listaClanova.get(key).getIme();
			pw.print(" " + nazivClana);
			String prezimeClana = listaClanova.get(key).getPrezime();
			pw.println(" " + prezimeClana);
			
		}
		pw.close();

		return true;
	}
	
	public static boolean procitajClanoveizFile(Map<Integer, Clan> listaClanova, Clan clan) throws FileNotFoundException{
		File file = new File("SpisakClanova.txt");
		
		Scanner read = new Scanner(file);
		
		while(read.hasNext()) {
			 clan = new Clan();
			 int id = read.nextInt();
		     clan.setId(id);
		     String ime = read.next();
		     clan.setIme(ime);
		     String prezime = read.next();
		     clan.setPrezime(prezime);
		     
		    registracija(listaClanova, clan);
			
			//listaClanova.put(id, clan);
		}
		
		read.close();
		
		return true;
		
		
	}
	
	public static boolean procitajKnjigeizFile(Map<Integer, Knjiga> listaKnjiga, Knjiga knjiga) throws FileNotFoundException{
		File file = new File("SpisakKnjiga.txt");
		
		Scanner read = new Scanner(file);
		
		while(read.hasNext()) {
			knjiga = new Knjiga();
			int key = read.nextInt();
			knjiga.setId(key);
			String ime = read.next();
			knjiga.setIme(ime);
			boolean iznajmljena = read.nextBoolean();
			knjiga.setIznajmljena(iznajmljena);
			String imeClanaKojiJeiznajmioKnjigu = read.next();
			knjiga.setImeClana(imeClanaKojiJeiznajmioKnjigu);
			
			
			DodajKnjigu(listaKnjiga, knjiga);
			
		}
		
		read.close();
		
		return true;
		
		
	}
	
	public static int generisiKeyZaClana(Map<Integer, Clan> lista) {
		int key = lista.size() + 1;
		for (int i = 0; i < lista.size(); i++) {
			if (lista.containsKey(key)) {
				key += 1;
				/*
				 * i = 0; ZA SAD RADI, POKUSAJ OVO U SLUCAJU NEKE GRESKE prodji opet kroz listu
				 * ako bi opet bila knjiga sa istim id-om
				 */

			}
		}

		return key;
	}
	
	public static int generisiKeyZaKnjigu(Map<Integer, Knjiga> lista) {
		int key = lista.size() + 1;
		for (int i = 0; i < lista.size(); i++) {
			if (lista.containsKey(key)) {
				key += 1;
				/*
				 * i = 0; ZA SAD RADI, POKUSAJ OVO U SLUCAJU NEKE GRESKE prodji opet kroz listu
				 * ako bi opet bila knjiga sa istim id-om
				 */

			}
		}

		return key;
	}
	
	public static Clan izbrisiClana(Map<Integer, Clan> lista, int key) {
	
       return lista.remove(key);
		
	}
	
	public static Knjiga izbrisiKnjigu(Map<Integer, Knjiga> lista, int key) {
		
        return lista.remove(key);
		
	}
	

	public  static Clan pronadjiClana(Map<Integer, Clan> map, int key) {

		return map.get(key);
	}
	
	public  static Knjiga pronadjiKnjigu(Map<Integer, Knjiga> map, int key) {

		return map.get(key);
	}
	
	
	

}
