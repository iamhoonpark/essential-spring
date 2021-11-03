package org.jbp.psh.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.jbp.psh.vo.PageVO;
import org.jbp.psh.vo.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PlayersDAOImpl implements PlayersDAO {

	//멤버필드 session
	@Autowired
	private SqlSession session;
	
	//selectTotal 구현메서드
	@Override
	public int selectTotal() {
		return session.selectOne("players.selectTotal");
	}
	
	//selectList 구현메서드
	@Override
	public List<Player> selectList() {
		return session.selectList("players.selectList");
	}
	@Override
	public List<Player> selectList(PageVO pageVO) {
		return session.selectList("players.selectPageList", pageVO);
	}
	
	//selectClubList
	@Override
	public List<Player> selectClubPlayers(int clubId) {
		return session.selectList("players.selectClubPlayers", clubId);
	}
	
	//selectOne
	@Override
	public Player selectOne(int playerId) {
		return session.selectOne("players.selectOne", playerId);
	}
	
	//selectPageNo
	@Override
	public int selectPageNo(int playerId) {
		return session.selectOne("players.selectPageNo", playerId);
	}
	
	//insert
	@Override
	public boolean insert(Player player) {
		return 1==session.insert("players.insert", player);
	}
	
	//delete
	@Override
	public int delete(int playerId) {
		return session.delete("players.delete", playerId);
	}
	
	//deleteByClubId
	@Override
	public int deleteByClubId(int clubId) {
		return session.delete("players.deleteByClubId", clubId);
	}
	
	//update
	@Override
	public boolean update(Player player) {
		return 1==session.update("players.update", player);
	}
}
