package com.itwillbs.service;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.itwillbs.dao.MemberDAO;
import com.itwillbs.domain.MemberBean;

@Service
public class MemberServiceImpl implements MemberService{
	//주입받는(객체생성한 객체를 주입받는) 멤버변수
	@Inject
	MemberDAO memberDao;
	
	@Override
	public void insert(MemberBean mb) {
		System.out.println("MemberServiceImpl insert()");
		//가입날짜
		mb.setReg_date(new Timestamp(System.currentTimeMillis()));
		memberDao.insert(mb);
	}

	@Override
	public MemberBean login(MemberBean mb) {
		return memberDao.login(mb);
	}

	@Override
	public MemberBean info(String id) {
		return memberDao.info(id);
	}

	@Override
	public void update(MemberBean mb) {
		memberDao.update(mb);
	}

	@Override
	public void delete(MemberBean mb) {
		memberDao.delete(mb);
	}

	@Override
	public List<MemberBean> list() {
		return memberDao.list();
	}
	

}
