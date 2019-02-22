package entiteti;

public class Knjiga {
	private String ime;
	private int id;
	private boolean iznajmljena;
	String imeClana;
	
	
	//konstruktor
	public Knjiga() {
		
	}
	
	public Knjiga(String ime, int id, boolean iznajmljena, String imeClana) {
		this.ime = ime;
		this.id = id;
		this.iznajmljena = iznajmljena;
		this.imeClana = imeClana;
	}

	//getter
	public String getIme() {
		return ime;
	}

	public int getId() {
		return id;
	}
	
	public String getImeClana(){
		return imeClana;
	}
	
	public boolean getIznajmljena() {
		return iznajmljena;
	}

	//setter
	public void setIme(String ime) {
		this.ime = ime;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void setImeClana(String imeClana) {
		this.imeClana = imeClana;
	}
	
	public void setIznajmljena(boolean iznajmljena) {
		this.iznajmljena = iznajmljena;
	}
}
