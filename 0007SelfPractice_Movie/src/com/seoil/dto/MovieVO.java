package com.seoil.dto;

public class MovieVO {
	int code, price;
	String title, director, actor, poster, synopsis;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String tilte) {
		this.title = tilte;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String direcor) {
		this.director = direcor;
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
		return "MovieVO [code=" + code + ", price=" + price + ", title=" + title + ", direcor=" + director + ", actor="
				+ actor + ", poster=" + poster + ", synopsis=" + synopsis + "]";
	}
	
	
}
