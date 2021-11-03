package org.jbp.psh.vo;

import java.sql.Date;
import java.sql.Timestamp;

public class Member {

	//접근제한자가 private인 멤버필드
	private int no;
	private String id, password, nickname, profile;
	private Timestamp regdate, birthDate;
	
	//기본생성자
	public Member() {
		
	}
	
	//멤버필드의 getter 및 setter 메서드
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Timestamp getRegdate() {
		return regdate;
	}

	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
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
