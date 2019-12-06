package services;

import services.Alien;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("aliens")
public class AlienResources {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Alien getAlien(){
        Alien al = new Alien();
        al.setName("Murthy");
        al.setPoints(100);
        return al;
    }
}
