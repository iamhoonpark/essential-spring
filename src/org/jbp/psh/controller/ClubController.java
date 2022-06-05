package org.jbp.psh.controller;

import org.apache.commons.logging.Log;
import org.jbp.psh.service.ClubService;
import org.jbp.psh.service.PlayerService;
import org.jbp.psh.vo.Club;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ClubController {
	
	//멤버필드
	@Autowired
	private ClubService clubsService;
	@Autowired
	private PlayerService playerService;

	//JSP) 페이지네이션 클럽리스트
	@RequestMapping(value = "/club/page/{page}", method = RequestMethod.GET)
	public String clubList(Model model, @PathVariable int page) {		
		model.addAllAttributes(clubsService.getList(page));
		return "clubList";
	}//clubList() end
	
	//JSP) 클럽 상세페이지
	@RequestMapping(value = "/club/{clubId}", method = RequestMethod.GET)
	public String clubDetail(Model model, @PathVariable int clubId) {
		model.addAllAttributes(clubsService.getOne(clubId));
		return "clubDetail";
	}//clubDetail() end
	
	//JSP) 클럽 입력페이지
	@RequestMapping(value = "/club/register", method = RequestMethod.GET)
	public String clubInsert() {
		return "clubForm";
	}//clubForm() end
	
	//Redirect) 클럽 입력실행
	@RequestMapping(value = "/club", method = RequestMethod.POST)
	public String clubInsert(Club club) {
		clubsService.register(club);
		return "redirect:/club/"+club.getClubId();
	}//clubInsert() end
	
	//JSP) 클럽 수정페이지
	@RequestMapping(value = "/club/{clubId}/edit", method = RequestMethod.GET)
	public String clubUpdate(Model model, @PathVariable int clubId) {
		model.addAttribute("club", clubsService.getDetail(clubId));
		return "clubForm";
	}//clubUpdate() end
	
	//Redirect) 클럽 수정실행
	@RequestMapping(value = "/club", method = RequestMethod.PUT)
	public String clubUpdate(Club club) {
		clubsService.modify(club);
		return "redirect:/club/"+club.getClubId();
	}//clubUpdate() end
	
	//Redirect) 클럽 삭제실행
	@RequestMapping(value = "/club/{clubId}", method = RequestMethod.DELETE)
	public String clubDelete(@PathVariable int clubId) {
		
		try {
			//에러(예외)가 발생할 수 있는 구문
			clubsService.remove(clubId);
		} catch (Exception e) {
			//에러(예외)가 발생 시 구동시킬 구문
			e.printStackTrace();//에러 메세지의 발생 근원지를 찾아서 단계별로 에러를 출력
		}//finally { 에러(예외)가 발생되거나, 발생하지 않더라도 무조건 작동되는 구문 }
		
		return "redirect:/club/page/1";
	}//clubDelete() end
	
}