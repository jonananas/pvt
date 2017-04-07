package se.pvt.ehandel.produkt.domain;

import java.util.Collection;

public interface ProduktKatalog {

	void läggTill(Produkt produkt);

	Collection<Produkt> allaProdukter();

	Produkt sökProduktId(String produktId);

}