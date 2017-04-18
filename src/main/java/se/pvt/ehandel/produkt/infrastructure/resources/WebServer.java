package se.pvt.ehandel.produkt.infrastructure.resources;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.joining;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.media.multipart.MultiPartFeature;

public class WebServer {
	public static void main(String[] args) throws Exception {
		ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
		context.setContextPath("/");
		Server jettyServer = new Server(8080);
		jettyServer.setHandler(context);

		addJerseyREST(context);

		try {
			jettyServer.start();
			jettyServer.join();
		} finally {
			jettyServer.destroy();
		}
	}

	private static void addJerseyREST(ServletContextHandler context) {
		ServletHolder jerseyServlet = context.addServlet(org.glassfish.jersey.servlet.ServletContainer.class, "/*");
		jerseyServlet.setInitOrder(0);

		Class<?> [] resourceAndJerseyClasses = { 
				ProduktResource.class, 
				FileResource.class, 
				LoggingFilter.class,
				MultiPartFeature.class 
		};
		
		jerseyServlet.setInitParameter("jersey.config.server.provider.classnames",
				stream(resourceAndJerseyClasses).map(clazz -> clazz.getCanonicalName()).collect(joining(";")));
	}

}
