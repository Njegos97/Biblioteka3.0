package entiteti;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Biblioteka {

	private Map<Integer, Clan> clanovi = new LinkedHashMap<>(); 
	private Map<Integer, Knjiga> knjige = new TreeMap<>();
	private boolean radi;
	

	// konstruktor
	public Biblioteka() {

	}

	public Biblioteka(Map<Integer, Clan> clanovi, Map<Integer, Knjiga> knjige) {

		this.clanovi = clanovi;
		this.knjige = knjige;
	}

	// getter
	public Map<Integer, Clan> getClanovi() {
		return clanovi;
	}

	public Map<Integer, Knjiga> getKnjige() {
		return knjige;
	}

	public boolean isRadi() {
		return radi;
	}
	
	

	// setter
	public void setClanovi(Map<Integer, Clan> clanovi) {
		this.clanovi = clanovi;
	}

	public void setKnjige(Map<Integer, Knjiga> knjige) {
		this.knjige = knjige;
	}

	public void setRadi(boolean radi) {
		this.radi = radi;
	}
	
	

}
