package se.pvt.ehandel.infrastructure;

import org.eclipse.jetty.server.Server;
import org.junit.Test;

public class JettyTest {

	@Test
	public void shouldRunJetty() throws Exception {
		Server server = new Server(8080);
		server.start();
		server.dumpStdErr();
		
		
		
		server.join();
	}

}
