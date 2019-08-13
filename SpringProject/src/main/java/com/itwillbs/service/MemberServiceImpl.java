package com.itwillbs.service;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.itwillbs.dao.MemberDAO;
import com.itwillbs.domain.MemberBean;

@Service
public class MemberServiceImpl implements MemberService{
//	MemberDAO memberDAO=new memberDAOImpl();
	@Inject
	MemberDAO memberDAO;
	//set메서드
//	@Inject
//	public void setMemberDAO(MemberDAO memberDAO) {
//		this.memberDAO = memberDAO;
//	}
	@Override
	public void insertForm(MemberBean mb) {
		System.out.println("MemberServiceImpl insertForm");
		mb.setReg_date(new Timestamp(System.currentTimeMillis()));
		System.out.println(mb.getReg_date());
		
//		MemberDAO memberDAO=new memberDAOImpl();
		memberDAO.insertForm(mb);
	}
	@Override
	public MemberBean info(String id) {
		System.out.println("MemberServiceImpl info");
//		MemberDAO memberDAO=new memberDAOImpl();
		MemberBean mb=memberDAO.info(id);
		return mb;
	}
	@Override
	public List<MemberBean> list() {
		return memberDAO.list();
	}
	
	
}
