package org.jbp.psh.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.jbp.psh.vo.Club;
import org.jbp.psh.vo.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ClubsDAOImpl implements ClubsDAO {
	
	//session 멤버필드
	@Autowired
	private SqlSession session;
	
	//selectList
	@Override
	public List<Club> selectList() {
		return session.selectList("clubs.selectList");
	}
	@Override
	public List<Club> selectList(PageVO pageVO) {
		return session.selectList("clubs.selectPageList", pageVO);
	}
	
	//selectTotal
	@Override
	public int selectTotal() {
		return session.selectOne("clubs.selectTotal");
	}
	
	//selectOne
	@Override
	public Club selectOne(int clubId) {
		return session.selectOne("clubs.selectOne", clubId);
	}
	
	//selectPageNo
	@Override
	public int selectPageNo(int clubId) {
		
		/*//①일단 page를 1로 초기화
		int page = 1;
		System.out.println("①page: "+page);
		
		//②pageNo는 int형을 배열로 가지고 있는 Integer(Wrapper클래스) 객체
		//  거기에 담겨있는 객체의 수만큼 대입하여 초기화
		Integer pageNo = session.selectOne("clubs.selectPageNo", clubId);
		System.out.println("②pageNo: "+pageNo);
		
		//③만약에 pageNo에 객체가 있을 경우 1이었던 page를 ②번의 숫자로 초기화
		if(pageNo!=null) page = pageNo;
		System.out.println("③page: "+page+" / pageNo: "+pageNo);
		
		//④page를 리턴
		//(3번에 객체가 없을 경우 1을 리턴, 객체가 있을경우 pageNo로 초기화하여 리턴)
		return page; */
		
		int pageNo = session.selectOne("clubs.selectPageNo", clubId);
		System.out.println("ClubsDAOImpl의 pageNo:"+pageNo);
		return session.selectOne("clubs.selectPageNo", clubId);
	}
	
	//insert
	@Override
	public int insert(Club club) {
		return session.insert("clubs.insert", club);
	}
	
	//update
	@Override
	public boolean update(Club club) {
		return 1==session.update("clubs.update", club);
	}
	
	//delete
	@Override
	public boolean delete(int clubId) {
		return 1==session.delete("clubs.delete", clubId);
	}	

}
