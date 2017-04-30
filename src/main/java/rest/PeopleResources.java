package rest;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import domain.Person;
import domain.services.PersonService;

@Path("/people")
public class PeopleResources {
	
	private PersonService db = new PersonService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Person> getAll(){
		return db.getAll();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response Add(Person person){
		db.add(person);
		return Response.ok(person.getId()).build();
	}

}

