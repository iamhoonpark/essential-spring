package org.jbp.psh.controller;

import org.jbp.psh.dao.PlayersDAO;
import org.jbp.psh.service.PlayerService;
import org.jbp.psh.vo.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PlayerController {
	
	@Autowired
	public PlayerService playerService;
	
	//JSP) 페이지네이션 선수리스트
	@RequestMapping(value = "/player/page/{page}", method = RequestMethod.GET)
	public String playerList(Model model, @PathVariable int page) {
		model.addAllAttributes(playerService.getList(page));
		return "playerList";
	}//playerList() end
	
	//JSP) 선수 상세페이지
	@RequestMapping(value = "/player/{playerId}", method = RequestMethod.GET)
	public String playerDetail(Model model, @PathVariable int playerId) {
		/* 에러가 발생하지도 않고 JSP에 el코드로 데이터가 출력이 안 됨
		 * 메서드를 addAttribute() 에서 addAllAttributes()으로 수정 */
		model.addAllAttributes(playerService.getDetail(playerId));
		return "playerDetail";
	}//playerDetail() end
	
	//JSP) 선수 등록페이지
	@RequestMapping(value = "/player/register", method = RequestMethod.GET)
	public String playerInsert(Model model) {
		model.addAttribute("clubs", playerService.getClubList());
		model.addAttribute("playerConrollerType", "입력");
		return "playerForm";
	}//playerInsert() end
	
	//Redirect) 선수 등록실행
	@RequestMapping(value = "/player", method = RequestMethod.POST)
	public String playerInsert(Player player) {
		playerService.register(player);		
		return "redirect:/player/"+player.getPlayerId();
	}//playerInsert() end
	
	//Redirect) 선수 삭제실행
	@RequestMapping(value = "/player/{playerId}", method = RequestMethod.DELETE)
	public String playerDelete(@PathVariable int playerId) {
		playerService.delete(playerId);
		return "redirect:/player/page/1";
	}//playerDelete() end
	
	//JSP) 선수 수정페이지
	@RequestMapping(value = "/player/update/{playerId}", method = RequestMethod.GET)
	public String playerUpdate(Model model, @PathVariable int playerId) {
		model.addAllAttributes(playerService.getModifyDetail(playerId));
		model.addAttribute("playerConrollerType", "수정");
		return "playerForm";
	}//playerUpdate() end
	
	//Redirect) 선수 수정실행
	@RequestMapping(value = "/player", method = RequestMethod.PUT)
	public String playerUpdate(Player player) {
		playerService.modify(player);
		return "redirect:/player/"+player.getPlayerId();
	}//playerUpdate() end
	
}
