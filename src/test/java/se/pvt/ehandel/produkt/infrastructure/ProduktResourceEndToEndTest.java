package se.pvt.ehandel.produkt.infrastructure;

import static com.jayway.restassured.RestAssured.given;

import org.eclipse.jetty.server.NetworkConnector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.hamcrest.Matchers;
import org.junit.BeforeClass;
import org.junit.Test;

import se.pvt.ehandel.produkt.infrastructure.resources.ProduktResource;

public class ProduktResourceEndToEndTest {
	private static int port = -1;
	
	@BeforeClass
	public static void startServer() throws Exception {
		ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
		context.setContextPath("/");
		Server jettyServer = new Server(0);
		jettyServer.setHandler(context);
		
		ServletHolder jerseyServlet = context.addServlet(org.glassfish.jersey.servlet.ServletContainer.class, "/*");
		jerseyServlet.setInitOrder(0);
		jerseyServlet.setInitParameter("jersey.config.server.provider.classnames",
				ProduktResource.class.getCanonicalName());
		
		jettyServer.start();
		port = ((NetworkConnector)jettyServer.getConnectors()[0]).getLocalPort();
	}
	
	@Test
	public void shouldNotGetProdukt() throws Exception {

		given().
			port(port).
		when().
			get("/produkter/123").
		then().
			statusCode(204);
	}
	
	@Test
	public void shouldAddProdukt() throws Exception {
		
		given().
			port(port).
			body("{\"produktId\":\"123\"}").
			header("Content-Type", "application/json").
		when().
			post("/produkter").
		then().
			statusCode(200);
	}
	
	@Test
	public void shouldGetAddedProdukt() throws Exception {
		
		shouldAddProdukt();
		
		given().
			port(port).
		when().
			get("/produkter/123").
		then().
			statusCode(200).
			and().
			body(Matchers.containsString("123"));
	}
	
	@Test
	public void shouldGetProdukter() throws Exception {
		
		given().
			port(port).
		when().
			get("/produkter").
		then().
			statusCode(200).
			and().
			body(Matchers.startsWith("["));
	}

}
