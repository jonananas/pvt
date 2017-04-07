package se.pvt.ehandel.infrastructure.persistence;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import se.pvt.ehandel.produkt.domain.Produkt;
import se.pvt.ehandel.produkt.domain.ProduktKatalog;

public class ProduktkatalogImpl implements ProduktKatalog {
	
	Map<String, Produkt> produkter = new HashMap<>();

	public static ProduktKatalog skapa() {
		return new ProduktkatalogImpl();
	}

	@Override
	public void läggTill(Produkt produkt) {
		this.produkter.put(produkt.getProduktId(), produkt);
	}

	@Override
	public Collection<Produkt> allaProdukter() {
		return this.produkter.values();
	}

	@Override
	public Produkt sökProduktId(String produktId) {
		return produkter.get(produktId);
	}

}
