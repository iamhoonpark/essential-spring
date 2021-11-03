package org.jbp.psh.service;

import java.util.List;
import java.util.Map;

import org.jbp.psh.vo.Club;
import org.jbp.psh.vo.Player;

public interface PlayerService {
	
	//추상메서드 getList
	public Map<String, Object> getList(int page);
	
	//추상메서드 getDetail
	public Map<String, Object> getDetail(int playerId);
	
	//추상메서드 getList
	public List<Club> getClubList();
	
	//추상메서드 register
	public void register(Player player);
	
	//추상메서드 delete
	public void delete(int playerId);
	
	//추상메서드 getModifyDetail
	public Map<String, Object> getModifyDetail(int playerId);
	
	//추상메서드 update
	public void modify(Player player);

}
