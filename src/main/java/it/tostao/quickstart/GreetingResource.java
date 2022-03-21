package it.tostao.quickstart;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.LocalDateTime;

@Path("/hello")
public class GreetingResource {


	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String hello() {
		try {
			URL imageUrl;
//			imageUrl = GreetingResource.class.getResource("/Resource2.txt");
			imageUrl = Thread.currentThread().getContextClassLoader().getResource("/Resource2.txt");
			File file = new File(imageUrl.toURI());
			return "Hello My Friend! File size in bytes = " + file.length();
		} catch (URISyntaxException e) {
			e.printStackTrace();
			return "Hello My Friend! " + LocalDateTime.now() + ", ERROR!" + e.getMessage();
		}
	}
}
