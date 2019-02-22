package entiteti;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Clan {
	
	final public static int MAKSIMALAN_BROJ_KNJIGA = 3;
	
	private String ime;
	private String prezime;
	private int id; 
    private Map<Integer, Knjiga> mojeKnjige = new LinkedHashMap<>();
	
	//Konstruktor
	public Clan() {
		
	}
	
	public Clan(String ime, String prezime, int id) {
		this.ime = ime;
		this.prezime = prezime;
		this.id = id;
		
		}

	//getter
	public String getIme() {
		return ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public int getId() {
		return id;
	}

	
	public Map<Integer, Knjiga> getMojeKnjige() {
		return mojeKnjige;
	}

	
	//Setter
	public void setIme(String ime) {
		this.ime = ime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void setMojeKnjige(Map<Integer, Knjiga> mojeKnjige) {
		this.mojeKnjige = mojeKnjige;
	}

	@Override
	public String toString() {
		return "[ime=" + ime + ", prezime=" + prezime + ", id=" + id + ", mojeKnjige=" + mojeKnjige + "]";
	}

	

}
