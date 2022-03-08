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

	private final static String OLD_MAN_SMILING_PNG = "/images/old-man-smiling.png";

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String hello() {
		try {
			URL url = GreetingResource.class.getResource(OLD_MAN_SMILING_PNG);
			File file = new File(url.toURI());
			return "Hello My Friend! File size in bytes = " + file.length();
		} catch (URISyntaxException e) {
			e.printStackTrace();
			return "Hello My Friend! " + LocalDateTime.now() + ", ERROR!";
		}
	}
}
