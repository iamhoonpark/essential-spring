package org.jbp.psh.vo;

import java.sql.Timestamp;

public class Club {
	
	//접근제한자가 private인 멤버필드
	private int clubId;
	private String name, coach;
	private Timestamp foundingDate;
	
	//기본생성자
	public Club() {
		// TODO Auto-generated constructor stub
	}

	//멤버필드의 getter, setter 메서드
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

	public String getCoach() {
		return coach;
	}

	public void setCoach(String coach) {
		this.coach = coach;
	}

	public Timestamp getFoundingDate() {
		return foundingDate;
	}

	public void setFoundingDate(Timestamp foundingDate) {
		this.foundingDate = foundingDate;
	}	
	

}
