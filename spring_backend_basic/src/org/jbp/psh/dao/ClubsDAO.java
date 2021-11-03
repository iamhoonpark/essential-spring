package org.jbp.psh.dao;

import java.util.List;

import org.jbp.psh.vo.Club;
import org.jbp.psh.vo.PageVO;

public interface ClubsDAO {
	
	//추상메서드 selectList
	public List<Club> selectList();
	public List<Club> selectList(PageVO pageVO);
	
	//추상메서드 selectTotal
	public int selectTotal();
	
	//추상메서드 selectOne
	public Club selectOne(int clubId);
	
	//추상메서드 selectPageNo
	public int selectPageNo(int clubId);
	
	//추상메서드 insert
	public int insert(Club club);
	
	//추상메서드 update
	public boolean update(Club club);
	
	//delete
	public boolean delete(int clubId);

}
