package com.njegos.main;
import java.util.Map;
import java.util.Scanner;

import com.njegos.entiteti.Biblioteka;
import com.njegos.entiteti.Clan;
import com.njegos.entiteti.Knjiga;
import com.njegos.logika.BibliotekaLogika;
import com.njegos.logika.Unos;

public enum LogInOpcije {
	
	s("Start"), i("Iznajmi Knjigu"), v("Vrati Knjigu"), n("Nazad");
	
	Scanner input = new Scanner(System.in);
	
	private String opcija;
	
	LogInOpcije(String opcija){
		this.opcija = opcija;
	}
	
	public String getOpcije() {
		return opcija;
	}
	
	public void iznajmiKnjigu(Biblioteka biblioteka, Knjiga knjiga,  Clan clan) {
		for(Map.Entry<Integer, Knjiga> entry : biblioteka.getKnjige().entrySet()) {
		    	System.out.print(entry.getKey() + " ");
		        knjiga = entry.getValue();
		    	System.out.println(knjiga.getIme());
		    	
		    }
		    System.out.println("unesite id knjige koju zelite da iznajmite");
			int id = Unos.unosIntegera();
			knjiga = BibliotekaLogika.pronadjiKnjigu(biblioteka.getKnjige(), id);
			int broj = -1;
			try {
			 broj= BibliotekaLogika.IznajmiKnjigu(clan, knjiga, id);
			}catch(NullPointerException e) {
				System.out.println("Ups");
				
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
	}
	
	public void vratiKnjigu(Knjiga knjiga, int id, Clan clan) {
		  for(Map.Entry<Integer, Knjiga> entry : clan.getMojeKnjige().entrySet()) {
		    	System.out.print(entry.getKey() + " ");
		        knjiga = entry.getValue();
		    	System.out.println(knjiga.getIme());
		    	
		    }
		
		
		System.out.println("Unesite id knjige koju zelite da vratite");
		id = Unos.unosIntegera();
	    knjiga = BibliotekaLogika.vratiKnjigu(clan.getMojeKnjige(), id);
		
								
		System.out.println("vratili ste " + knjiga.getIme());
	}
}
