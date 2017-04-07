package se.pvt.ehandel.infrastructure.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import se.pvt.ehandel.produkt.domain.Produkt;

@Path("produkter")
public class ProduktResource {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Produkt getProdukt(@QueryParam("id") String produktId) {
		Produkt produkt = Produkt.skapa(produktId);
		return produkt;
	}
}
