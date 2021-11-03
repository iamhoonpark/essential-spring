package org.jbp.psh.dao;

import java.util.List;

import org.jbp.psh.vo.PageVO;
import org.jbp.psh.vo.Player;

public interface PlayersDAO {
	
	//추상메서드 selectTotal
	public int selectTotal();
	
	//selectList
	public List<Player> selectList();
	public List<Player> selectList(PageVO pageVO);
	
	//selectClubPlayers
	public List<Player> selectClubPlayers(int clubId);
	
	//selectOne
	public Player selectOne(int playerId);
	
	//selectPageNo 리턴자료형 int.
	public int selectPageNo(int playerId);
	
	//insert
	public boolean insert(Player player);
	
	//delete
	public int delete(int playerId);
	
	//deleteByClubId
	public int deleteByClubId(int clubId);
	
	//update
	public boolean update(Player player);

}
