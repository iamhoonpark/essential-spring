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
public class PlayerServiceImpl implements PlayerService {

	//멤버필드 playersDAO
	@Autowired
	private PlayersDAO playersDAO;
	@Autowired
	private PaginateUtil paginateUtil;
	@Autowired
	private ClubsDAO clubsDAO;
	
	//getList 구현메서드
	@Override
	public Map<String, Object> getList(int page) {
		
		//리턴자료형과 동일한 자료형으로 변수명을 선언하고 초기화
		Map<String, Object> map = new ConcurrentHashMap<String, Object>();
		
		//한페이지에 보여질 게시글 수
		int numPage = 6;
		
		//PageVO객체
		PageVO pageVO = new PageVO(page, numPage);
		
		//total, numBlck, url
		int total = playersDAO.selectTotal();
		int numBlock = 3;
		String url = "/player/page/";
		
		//paginate
		String paginate = paginateUtil.getPaginate(page, total, numPage, numBlock, url);
		
		//List호출
		List<Player> players = playersDAO.selectList(pageVO);
		
		//세팅
		map.put("total", total);
		map.put("players", players);
		map.put("paginate", paginate);
		
		//세팅한 map 리턴
		return map;
	}//getList() end
	
	//getDetail
	@Override
	public Map<String, Object> getDetail(int playerId) {
		Map<String, Object> map = new ConcurrentHashMap<String, Object>();
			map.put("player", playersDAO.selectOne(playerId));
			map.put("pageNo", playersDAO.selectPageNo(playerId));
		return map;
	}//getDetail() end
	
	//getClubList
	@Override
	public List<Club> getClubList() {
		return clubsDAO.selectList();
	}//getClubList() end
	
	//register
	@Override
	public void register(Player player) {
		playersDAO.insert(player);		
	}	
	
	//delete
	@Override
	public void delete(int playerId) {
		playersDAO.delete(playerId);
	}
	
	//getModifyDetail
	@Override
	public Map<String, Object> getModifyDetail(int playerId) {		
		Map<String, Object> map = new ConcurrentHashMap<String, Object>();
			map.put("clubs", clubsDAO.selectList());
			map.put("player", playersDAO.selectOne(playerId));
		return map;
	}
	
	//modify
	@Override
	public void modify(Player player) {
		playersDAO.update(player);
	}
	
}
