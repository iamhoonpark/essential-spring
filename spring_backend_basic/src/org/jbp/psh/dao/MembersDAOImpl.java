package org.jbp.psh.dao;

import org.apache.ibatis.session.SqlSession;
import org.jbp.psh.vo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MembersDAOImpl implements MembersDAO {

	//멤버필드 session
	@Autowired
	private SqlSession session;
	
	//구현메서드 selectLogin
	@Override
	public Member selectLogin(Member member) {
		return session.selectOne("members.selectLogin", member);
	}
	
}
