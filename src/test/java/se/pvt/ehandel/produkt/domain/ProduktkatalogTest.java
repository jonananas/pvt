package se.pvt.ehandel.produkt.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import se.pvt.ehandel.produkt.infrastructure.persistence.ProduktkatalogImpl;

public class ProduktkatalogTest {
	
	ProduktKatalog produktkatalog = ProduktkatalogImpl.skapa();
	Produkt produkt123 = Produkt.skapa("123");
	
	@Test
	public void skaInnehållaTillagdaProdukter() throws Exception {
		
		produktkatalog.läggTill(produkt123);
		
		assertThat(produktkatalog.allaProdukter()).contains(produkt123);
	}
	
	
	@Test
	public void skaHittaProduktId() throws Exception {
		
		produktkatalog.läggTill(produkt123);
		
		assertThat(produktkatalog.sökProduktId("123")).isEqualTo(produkt123);
	}

	@Test
	public void skaInteHittaProduktId() throws Exception {
		
		assertThat(produktkatalog.sökProduktId("123")).isNull();
	}
}
