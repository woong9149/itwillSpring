package com.itwillbs.dao;

import java.util.List;

import com.itwillbs.domain.MemberBean;

public interface MemberDAO {
	public void insert(MemberBean mb);
	public MemberBean login(MemberBean mb);
	public MemberBean info(String id);
	public void update(MemberBean mb);
	public void delete(MemberBean mb);
	public List<MemberBean> list();
}
