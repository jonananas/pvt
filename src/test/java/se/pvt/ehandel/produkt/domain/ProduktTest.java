package se.pvt.ehandel.produkt.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import se.pvt.ehandel.produkt.domain.Produkt;

public class ProduktTest {

	@Test
	public void shouldCreateProdukt() throws Exception {
		
		Produkt produkt = Produkt.skapa("IBN1234");
		
		assertThat(produkt.getProduktId()).isEqualTo("IBN1234");
	}
}
