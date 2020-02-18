package io.quarkus.devnexus;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Optional;

@Path("/hello")
public class HelloResource {

    final Optional<String> hostname = Optional.ofNullable(System.getenv().get("HOSTNAME"));

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {

        return "Hello, Devnexus!\n" + hostname.orElse("from Quarkus on an unknown server");
    }
}