package se.pvt.ehandel.produkt.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class ProduktkatalogSingletonTest {

	@Test
	public void singletonRetSammaVarjeGång() throws Exception {
		ProduktKatalog produktKatalog1 = ProduktkatalogSingleton.get();
		ProduktKatalog produktKatalog2 = ProduktkatalogSingleton.get();
		
		assertThat(produktKatalog1).isSameAs(produktKatalog2);
	}

}
