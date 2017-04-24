package com.movie_prj;

public class MemberDTO {
	private Integer code;
	private String tilte;
	private Integer price;
	private String director;
	private String actor;
	private String poster;
	private String synopsis;
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getTilte() {
		return tilte;
	}
	public void setTilte(String tilte) {
		this.tilte = tilte;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public String getSynopsis() {
		return synopsis;
	}
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}
	@Override
	public String toString() {
		return "MemberDTO [code=" + code + ", tilte=" + tilte + ", price=" + price + ", director=" + director
				+ ", actor=" + actor + ", poster=" + poster + ", synopsis=" + synopsis + "]";
	}
	
	
	
}
