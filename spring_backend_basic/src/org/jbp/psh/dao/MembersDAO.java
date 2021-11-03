package org.jbp.psh.dao;

import org.jbp.psh.vo.Member;

public interface MembersDAO {
	
	//추상메서드 selectLogin
	public Member selectLogin(Member member);

}
