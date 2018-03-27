package se.pvt.ehandel.produkt.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class ProduktTest {

	@Test
	public void shouldCreateProdukt() throws Exception {
		
		Produkt produkt = Produkt.av("IBN1234", "Mellanmjölk");
		
		assertThat(produkt.getProduktId()).isEqualTo("IBN1234");
		assertThat(produkt.getNamn()).isEqualTo("Mellanmjölk");
	}
}
