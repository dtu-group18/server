package org.restadapter;
import businesslogic.Person;
import businesslogic.PersonRegister;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello/person")
public class PersonResource{

    PersonRegister personRegister = PersonRegister.getRegister();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Person getPerson(){return personRegister.getPerson();}

}
