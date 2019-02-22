package com.njegos.main;

public enum LogInOpcije {

	i("Iznajmi Knjigu"), v("Vrati Knjigu"), n("Nazad");
	
	private String opcije;
	
	LogInOpcije(String opcije){
		this.opcije = opcije;
	}
	
	public String getOpcije() {
		return opcije;
	}
}
