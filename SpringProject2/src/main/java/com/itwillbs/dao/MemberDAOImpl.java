package com.itwillbs.dao;

import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.MemberBean;

@Repository
public class MemberDAOImpl implements MemberDAO{
	//스프링에서 디비연동정보를 받아서 sql 구문을 실행
//		JdbcTemplate jdbcTemplate;
		
		//디비연동 => 받아서 사용
//		@Inject
//		public void setDataSource(DataSource dataSource) {
//			jdbcTemplate=new JdbcTemplate(dataSource);
//		}
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace="com.itwillbs.mapper.MemberMapper";
		
//		String insertsql="insert into member(id,pass,name,reg_date) values(?,?,?,?)";
	@Override
	public void insert(MemberBean mb) {
		System.out.println("MemberDAOImpl insert()");
		// "'"+${name}+"'"
		// insertsql 실행
//		jdbcTemplate.update(insertsql, mb.getId(),mb.getPass(),mb.getName(),mb.getReg_date());
		sqlSession.insert(namespace+".insert",mb);
//		sqlSession.selectList(statement);
//		sqlSession.selectOne(statement);
	}

	@Override
	public MemberBean login(MemberBean mb) {
		return sqlSession.selectOne(namespace+".login",mb);
	}

	@Override
	public MemberBean info(String id) {
		return sqlSession.selectOne(namespace+".info",id);
	}

	@Override
	public void update(MemberBean mb) {
		sqlSession.update(namespace+".update",mb);
	}

	@Override
	public void delete(MemberBean mb) {
		sqlSession.delete(namespace+".delete",mb);
	}

	@Override
	public List<MemberBean> list() {
		return sqlSession.selectList(namespace+".list");
	}
	
	

}
