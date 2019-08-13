package com.itwillbs.dao;

import com.itwillbs.domain.BoardBean;

public interface BoardDAO {

	public Integer maxNum();
	public void write(BoardBean bb);
	
}
