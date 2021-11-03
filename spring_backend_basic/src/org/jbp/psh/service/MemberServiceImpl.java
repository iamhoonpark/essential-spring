package org.jbp.psh.service;

import org.jbp.psh.dao.MembersDAO;
import org.jbp.psh.vo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
	
	//멤버필드 membersDAO
	@Autowired
	private MembersDAO membersDAO;
	
	//구현메서드 login
	@Override
	public Member login(Member member) {
		return membersDAO.selectLogin(member);
	}

}
