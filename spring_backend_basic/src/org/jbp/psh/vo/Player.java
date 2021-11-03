package org.jbp.psh.vo;

import java.sql.Timestamp;

public class Player {
	
	//멤버필드
	private int playerId, height, weight, clubId;
	private String name, profile, clubName;
	private Timestamp birthDate;
	
	//기본생성자
	public Player() {
		// TODO Auto-generated constructor stub
	}
	
	//clubName의 getter, setter메서드
	public String getClubName() {
		return clubName;
	}
	public void setClubName(String clubName) {
		this.clubName = clubName;
	}

	//멤버필드의 getter, setter 메서드
	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getClubId() {
		return clubId;
	}

	public void setClubId(int clubId) {
		this.clubId = clubId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public Timestamp getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Timestamp birthDate) {
		this.birthDate = birthDate;
	}

}
