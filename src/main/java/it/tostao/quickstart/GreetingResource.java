package it.tostao.quickstart;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.nio.file.Files;
import java.nio.file.Paths;

@Path("/hello")
public class GreetingResource {

	private static final Logger log = LoggerFactory.getLogger(GreetingResource.class);

	@ConfigProperty(name = "images.location")
	String imageLocation;

	private final static String FILE_NAME = "IMG_3_3M.jpg";

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String hello() {
		var imagePath = Paths.get(imageLocation + FILE_NAME);
		var existsAndIsReadable = Files.isReadable(imagePath) && Files.isRegularFile(imagePath);
		log.info("existsAndIsReadable - {}, imagePath - {}", existsAndIsReadable, imagePath);
		var file = imagePath.toFile();
		return "File size is = " + file.length();
	}
}
