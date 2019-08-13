package com.itwillbs.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.itwillbs.dao.BoardDAO;
import com.itwillbs.domain.BoardBean;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Inject
	BoardDAO boardDAO;
	
	@Override
	public void write(BoardBean bb) {
		//번호 구해서 저장
		bb.setNum(boardDAO.maxNum()+1);
		boardDAO.write(bb);
	}

}
