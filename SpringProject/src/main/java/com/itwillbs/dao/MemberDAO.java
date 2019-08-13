package com.itwillbs.dao;

import java.util.List;

import com.itwillbs.domain.MemberBean;

public interface MemberDAO {
	//추상메서드 : 메서드틀
	//public void insert();
	public void insertForm(MemberBean mb);
	public MemberBean info(String id);
	public List<MemberBean> list();
}
