package se.pvt.ehandel.infrastructure;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.junit.Test;

import se.pvt.ehandel.infrastructure.resources.ProduktResource;

public class ProduktResourceEndToEndTest {

	@Test
	public void shouldRunJetty() throws Exception {
		ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
		context.setContextPath("/");
		Server jettyServer = new Server(8080);
		jettyServer.setHandler(context);

		ServletHolder jerseyServlet = context.addServlet(org.glassfish.jersey.servlet.ServletContainer.class, "/*");
		jerseyServlet.setInitOrder(0);
		jerseyServlet.setInitParameter("jersey.config.server.provider.classnames",
				ProduktResource.class.getCanonicalName());

		try {
			jettyServer.start();
			jettyServer.join();
		} finally {
			jettyServer.destroy();
		}
	}

}
