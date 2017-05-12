package domain;

import java.util.List;

public class Movie {
	
	private int id;
	//private Date date;
	private String title;
	private String synopsis;
	private List<Comment> comments;
	
	private List<Rec> recs;
	private Double totalRec;

	private List<Actor> actors;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	/*public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}*/
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
	public String getSynopsis() {
		return synopsis;
	}
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}
	
	
	public List<Actor> getActors() {
		return actors;
	}
	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}
	
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	
	public List<Rec> getRecs() {
		return recs;
	}
	
	public void setRecs(List<Rec> recs) {
		this.recs = recs;
	}
	
	public Double getTotalRec(){
		Double sum = 0.0;
		for(Rec r : recs){
			sum += r.getValue();
			System.out.println(sum);
		}
		
		totalRec = sum/recs.size();
		System.out.println(totalRec);
		return totalRec;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*public List<Double> getAllRecs(){
		return recs;
	}
	
	public void setAllRecs(List<Double> recs) {
		this.recs = recs;
	}
	
	public void addRec(Double rec){
		recs.add(rec);
	}
	
	public void delRec(int recIndex) {
		recs.remove(recIndex);
	}
	
	public double getTotalRec() {
		Double sum = 0.0;
		for(Double rec : recs){
			sum+=rec;
		}
		totalRec = sum/recs.size();
		return totalRec;
	}
	
	
	public void setTotalRec(double totalRec) {
		this.totalRec = totalRec;
	}*/
	
	
}
