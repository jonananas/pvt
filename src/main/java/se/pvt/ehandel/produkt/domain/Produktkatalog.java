package se.pvt.ehandel.produkt.domain;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Produktkatalog {
	
	Map<String, Produkt> produkter = new HashMap<>();

	public static Produktkatalog skapa() {
		return new Produktkatalog();
	}

	public void läggTill(Produkt produkt) {
		this.produkter.put(produkt.getProduktId(), produkt);
	}

	public Collection<Produkt> allaProdukter() {
		return this.produkter.values();
	}

	public Produkt sökProduktId(String produktId) {
		return produkter.get(produktId);
	}

}
