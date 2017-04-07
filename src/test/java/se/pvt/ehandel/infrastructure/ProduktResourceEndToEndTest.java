package se.pvt.ehandel.infrastructure;

import static com.jayway.restassured.RestAssured.given;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.hamcrest.Matchers;
import org.junit.BeforeClass;
import org.junit.Test;

import se.pvt.ehandel.infrastructure.resources.ProduktResource;

public class ProduktResourceEndToEndTest {
	static ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
	
	@BeforeClass
	public static void startServer() throws Exception {
		context.setContextPath("/");
		Server jettyServer = new Server(8080);
		jettyServer.setHandler(context);
		
		ServletHolder jerseyServlet = context.addServlet(org.glassfish.jersey.servlet.ServletContainer.class, "/*");
		jerseyServlet.setInitOrder(0);
		jerseyServlet.setInitParameter("jersey.config.server.provider.classnames",
				ProduktResource.class.getCanonicalName());
		
		jettyServer.start();
	}
	
	@Test
	public void shouldNotGetProdukt() throws Exception {

		given().
			param("id", "123").
		when().
			get("/produkter").
		then().
			statusCode(204);
	}
	
	@Test
	public void shouldGetAddedProdukt() throws Exception {
		
		given().
			body("{\"produktId\":\"123\"}").
			header("Content-Type", "application/json").
		when().
			post("/produkter").
		then().
			statusCode(200);
		
		given().
			param("id", "123").
		when().
			get("/produkter").
		then().
			statusCode(200).
			and().
			body(Matchers.containsString("123"));
	}

}
