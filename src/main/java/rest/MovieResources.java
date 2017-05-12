package rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import domain.Actor;
import domain.Comment;
import domain.Movie;
import domain.Rec;
import domain.services.MovieService;

@Path("/movie")
public class MovieResources {
	
	private MovieService db = new MovieService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Movie> getAll(){
		return db.getAll();
	}
	
	
	//dodaj film
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response Add(Movie movie){
		db.add(movie);
		return Response.ok(movie.getId()).build();
	}
	
	/*
	 * METODY FILMÓW
	 */
	
	//pobierz info o filmie
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response get(@PathParam("id") int id){
		Movie result = db.get(id);
		if(result==null){
			return Response.status(404).build();
		}
		return Response.ok(result).build();
	}
	
	//aktualizuj info o filmie
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("id") int id, Movie m){
		Movie result = db.get(id);
		if(result == null)
			return Response.status(404).build();
		m.setId(id);
		db.update(m);
		return Response.ok().build();
	}
	
	//usun film
	@DELETE
	@Path("/{movieId}")
	public Response delete(@PathParam("movieId") int movieId){
		Movie result = db.get(movieId);
		if(result==null) return Response.status(404).build();
		db.update(result);
		return Response.ok().build();
	}
	
	
	/*
	 * oceny
	 */
	
	@POST//tworzy ocene
	@Path("/{movieId}/recs")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addRec(@PathParam("movieId") int movieId, Rec rec){//addCar
		Movie result = db.get(movieId);
		if(result==null)
			return Response.status(404).build();
		if(result.getRecs()==null)
			result.setRecs(new ArrayList<Rec>());
		
		result.getRecs().add(rec);
		return Response.ok().build();
	}
	
	@GET//pobiera srednia ocene
	@Path("/{movieId}/totalRec")
	@Produces(MediaType.APPLICATION_JSON)
	public String getTotalRec(@PathParam("movieId") int movieId){
		Movie result = db.get(movieId);
		if(result==null)
			return null;
		if(result.getRecs()==null)
			result.setRecs(new ArrayList<Rec>());
		return String.valueOf(result.getTotalRec());

	}
	
	
	
	
	/*
	 * AKTORZY
	 */
	
	@GET//pobiera aktorow
	@Path("/{movieId}/actors")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Actor> getActors(@PathParam("movieId") int movieId){
		Movie result = db.get(movieId);
		if(result==null)
			return null;
		if(result.getActors()==null)
			result.setActors(new ArrayList<Actor>());
		return result.getActors();
	}
	
	@POST//tworzy aktora
	@Path("/{movieId}/actor")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addActor(@PathParam("movieId") int movieId, Actor actor){//addCar
		Movie result = db.get(movieId);
		if(result==null)
			return Response.status(404).build();
		if(result.getActors()==null)
			result.setActors(new ArrayList<Actor>());
		
		result.getActors().add(actor);
		return Response.ok().build();
	}
	
	
	/*
	 * METODY KOMENTARZY
	 */
	
	@GET//pobiera komentarze
	@Path("/{movieId}/comments")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Comment> getCars(@PathParam("movieId") int movieId){
		Movie result = db.get(movieId);
		if(result==null)
			return null;
		if(result.getComments()==null)
			result.setComments(new ArrayList<Comment>());
		return result.getComments();
	}
	
	@POST//tworzy komentarz
	@Path("/{movieId}/comments")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addComment(@PathParam("movieId") int movieId, Comment comment){//addCar
		Movie result = db.get(movieId);
		if(result==null)
			return Response.status(404).build();
		if(result.getComments()==null)
			result.setComments(new ArrayList<Comment>());
		
		result.getComments().add(comment);
		return Response.ok().build();
	}
	
	@DELETE
	@Path("/{movieId}/comments/{commentId}")
	public Response delete(@PathParam("movieId") int movieId, @PathParam("commentId") int commentId){
		Movie result = db.get(movieId);
		//Comment resultComment = result.getComments().get(commentId);
		if(result==null || result.getComments().get(commentId)==null) return Response.status(404).build();
		result.getComments().remove(commentId);
		db.update(result);
		return Response.ok().build();
	}

}

