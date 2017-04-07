package se.pvt.ehandel.infrastructure.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import se.pvt.ehandel.infrastructure.persistence.ProduktkatalogImpl;
import se.pvt.ehandel.produkt.domain.Produkt;
import se.pvt.ehandel.produkt.domain.ProduktKatalog;

@Path("produkter")
public class ProduktResource {
	static ProduktKatalog produkter = new ProduktkatalogImpl();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Produkt getProdukt(@QueryParam("id") String produktId) {
		return produkter.sökProduktId(produktId);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public String postProdukt(Produkt produkt) {
		produkter.läggTill(produkt);
		return produkt.getProduktId();
	}
	
}
