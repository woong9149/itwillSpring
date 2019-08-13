package com.itwillbs.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.BoardBean;

@Repository
public class BoardDAOImpl implements BoardDAO{
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace="com.itwillbs.mapper.BoardMapper";
	
	@Override
	public Integer maxNum() {
		return sqlSession.selectOne(namespace+".maxNum");
	}

	@Override
	public void write(BoardBean bb) {
		sqlSession.insert(namespace+".write",bb);
	}

}
