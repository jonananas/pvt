package se.pvt.ehandel.produkt.infrastructure.resources;

import static java.nio.file.Files.copy;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

@Path("files")
public class FileResource {

	// Test with curl -F "file=@README.md" localhost:8080/files/upload

	@POST
	@Path("/upload")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response uploadFile(@FormDataParam("file") InputStream uploadInputStream,
			@FormDataParam("file") FormDataContentDisposition fileDetail) throws IOException {
		
		String fileLocation = "/tmp/" + fileDetail.getFileName();

		long bytes = copy(uploadInputStream, new File(fileLocation).toPath(), REPLACE_EXISTING);
		String output = "File (" + bytes + " bytes) successfully uploaded to : " + fileLocation;
		return Response.status(200).entity(output).build();
	}
}
