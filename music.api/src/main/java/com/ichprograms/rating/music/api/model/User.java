package com.ichprograms.rating.music.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
public class User {
	
	@Id
	private String id;			//User UID
	
	private int xp;				//Rating privilege value
	private String publicName;	//Name visible to others
	
	private String topGenre;	//Most rated genre(wont be set till you have at least 50 ratings in one genre)
	
	//Getters
	public String getId() {
		return this.id;
	}
	
	public int getXp() {
		return this.xp;
	}
	
	public String getPublicName() {
		return this.publicName;
	}
	
	public String getTopGenre() {
		return this.topGenre;
	}
	
	//Setters
	public boolean setXp(int xp_level) {
		this.xp = xp_level;
		return this.xp == xp_level;
	}
	
	public boolean setPublicName(String userName) {
		this.publicName = userName;
		return this.publicName == userName;
	}
	
	public boolean setTopGenre(String topGenre) {
		this.topGenre = topGenre;
		return this.topGenre == topGenre;
	}
}
