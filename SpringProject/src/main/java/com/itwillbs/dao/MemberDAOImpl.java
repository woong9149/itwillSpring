package com.itwillbs.dao;

import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.MemberBean;

@Repository
public class MemberDAOImpl implements MemberDAO{
	//스프링에서 디비연동정보를 받아서 sql 구문을 실행
	JdbcTemplate jdbcTemplate;
	
	//디비연동 => 받아서 사용
	@Inject
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate=new JdbcTemplate(dataSource);
	}
	
	String insertsql="insert into member(id,pass,name,reg_date) values(?,?,?,?)";
	@Override
	public void insertForm(MemberBean mb) {
		System.out.println("MemberDAOImpl insertForm");
		// insertsql 실행
		jdbcTemplate.update(insertsql, mb.getId(),mb.getPass(),mb.getName(),mb.getReg_date());
//		jdbcTemplate.query(sql, rowMapper);
//		jdbcTemplate.queryForObject(sql, rowMapper, args);
	}
	String infosql="select * from member where id=?";
	@Override
	public MemberBean info(String id) {
		System.out.println("MemberDAOImpl info");
		RowMapper<MemberBean> mapper=new BeanPropertyRowMapper<MemberBean>(MemberBean.class);
		return jdbcTemplate.queryForObject(infosql, mapper,id);
	}
	String listsql="select * from member";
	@Override
	public List<MemberBean> list() {
		RowMapper<MemberBean> mapper=new BeanPropertyRowMapper<MemberBean>(MemberBean.class);
		return jdbcTemplate.query(listsql, mapper);
	}
	
	
}
