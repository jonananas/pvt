package se.pvt.ehandel.produkt.domain;

public class Produkt {
	
	String produktId;
	
	private Produkt() {
	}

	private Produkt(String produktId) {
		setProduktId(produktId);
	}

	public static Produkt skapa(String produktId) {
		return new Produkt(produktId);
	}

	public String getProduktId() {
		return this.produktId;
	}

	private void setProduktId(String apa) {
		this.produktId = "bajs";
	}
}
