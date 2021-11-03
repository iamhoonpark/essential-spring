package org.jbp.psh.service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.jbp.psh.dao.ClubsDAO;
import org.jbp.psh.dao.PlayersDAO;
import org.jbp.psh.util.PaginateUtil;
import org.jbp.psh.vo.Club;
import org.jbp.psh.vo.PageVO;
import org.jbp.psh.vo.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClubServiceImpl implements ClubService {
	
	//멤버필드
	@Autowired
	private ClubsDAO clubsDAO;
	@Autowired
	private PaginateUtil paginateUtil;
	@Autowired
	private PlayersDAO playersDAO;
	
	//구현메서드 getList
	@Override
	public Map<String, Object> getList(int page) {
		
		//리턴자료형과 동일한 자료형으로 변수명을 선언하고 초기화
		Map<String, Object> modelMap = new ConcurrentHashMap<String, Object>();
		
		//한 페이지에 보여질 컨텐츠 수
		int numPage = 5;
		
		//new 키워드를 통해 heap메모리 영역에 공간을 할당받고
		//PageVO클래스의 인자가 2개인 생성자를 호출하여
		//그 레퍼런스를 변수 pageVO에 대입
		PageVO pageVO = new PageVO(page, numPage);
		
		//페이지의 네비게이션 수
		int numBlock = 3;
		//페이지의 url
		String url = "/club/page/";
		
		//total
		int total = clubsDAO.selectTotal();
		//clubs
		List<Club> clubs = clubsDAO.selectList(pageVO);
		//Paginate
		String paginate = paginateUtil.getPaginate(page, total, numPage, numBlock, url);
		
		//변수 modelMap에 세팅
		modelMap.put("total", total);
		modelMap.put("clubs", clubs);
		modelMap.put("paginate", paginate);
		
		//변수 modelMap 리턴
		return modelMap;
	}//getList() end
	
	//getOne
	@Override
	public Map<String, Object> getOne(int clubId) {
		
		//리턴자료형과 동일한 자료형으로 변수명으로 선언하여 초기화
		Map<String, Object> map = new ConcurrentHashMap<String, Object>();
		
		//호출
		Club club = clubsDAO.selectOne(clubId);
		List<Player> clubPlayers = playersDAO.selectClubPlayers(clubId);
		int pageNo = clubsDAO.selectPageNo(clubId);
		
		//만약 Club객체에 값이 없다면(==null 값이라면)
		if (club==null) {
			//기본 생성자를 호출하여 응답(clubWonder로 테스트해보기)
			club = new Club();
		}//이 작업을 수행하지 않으면 16진수로 출력되기 때문
		//test
		Club clubWonder = new Club();
		
		//세팅
		map.put("wondering", clubWonder);
		map.put("club", club);
		map.put("clubPlayers", clubPlayers);
		map.put("pageNo", pageNo);
		
		//리턴
		return map;
	}//getOne() end
	
	//register
	@Override
	public int register(Club club) {
		return clubsDAO.insert(club);
	}//register() end
	
	//modify
	@Override
	public void modify(Club club) {
		clubsDAO.update(club);		
	}//modify() end
	
	//getDetail
	@Override
	public Club getDetail(int clubId) {
		return clubsDAO.selectOne(clubId);
	}//getDetail() end

	//remove
	@Override
	public void remove(int clubId) {
		//①번이 상위에 올라와있어야 함
		//먼저 삭제되고 clubs삭제처리
		playersDAO.deleteByClubId(clubId);
		clubsDAO.delete(clubId);
		/* 추가해야 할 기능
		 ① FK(Foreign key)로 인해 연결된 데이터를이 안 지워져서 에러발생
		    따라서 같이 삭제될 수 있도록 메서드*를 추가해야 함
		    *playersDAO.deleteByClubId(clubId);
		 ② 실행취소를 위한 @Transactional를 Override대신 사용해야 함 */
		//playersDAO.deleteByClubId(clubId);
	}//remove
	
}
