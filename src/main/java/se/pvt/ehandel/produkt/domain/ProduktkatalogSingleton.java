package se.pvt.ehandel.produkt.domain;

import se.pvt.ehandel.produkt.infrastructure.persistence.ProduktkatalogImpl;

public class ProduktkatalogSingleton {
	
	private static ProduktKatalog instans;

	public static ProduktKatalog get() {
		if(instans == null)
			instans = ProduktkatalogImpl.skapa();
		return instans;
	}
}
