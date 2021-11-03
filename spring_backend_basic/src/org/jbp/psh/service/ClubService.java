package org.jbp.psh.service;

import java.util.List;
import java.util.Map;

import org.jbp.psh.vo.Club;

public interface ClubService {
	
	//추상메서드 getList
	public Map<String, Object> getList(int page);
	
	//추상메서드 getOne
	public Map<String, Object> getOne(int clubId);
	public Club getDetail(int clubId);
	
	//추상메서드 register
	public int register(Club club);
	
	//추상메서드 modify
	public void modify(Club club);
	
	//추상메서드 remove
	public void remove(int clubId);
	
}
