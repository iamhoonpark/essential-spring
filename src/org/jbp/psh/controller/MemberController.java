package org.jbp.psh.controller;

import javax.servlet.http.HttpSession;

import org.jbp.psh.service.MemberService;
import org.jbp.psh.vo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MemberController {
	
	//멤버필드 memberService
	@Autowired
	private MemberService memberService;

	//JSP) 메인페이지
	@RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
	public String index() {
		return "index";
	}//index() end
	
	//Redirect) 로그인
	@RequestMapping(value = "/session", method = RequestMethod.POST)
	public String login(Member member, HttpSession session, 
						RedirectAttributes ra) {
		Object loginMember = memberService.login(member);
		if (loginMember!=null) {
			session.setAttribute("loginMember", loginMember);
		} else {
			ra.addFlashAttribute("msg","아이디 또는 비밀번호가 틀렸습니다.");
		}
		return "redirect:/";
	}//login() end
	
	//Redirect) 로그아웃
	@RequestMapping(value = "/session", method = RequestMethod.DELETE)
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}//logout() end
	
}
