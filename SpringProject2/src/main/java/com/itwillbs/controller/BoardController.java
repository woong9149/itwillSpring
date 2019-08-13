package com.itwillbs.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.BoardBean;
import com.itwillbs.domain.PageBean;
import com.itwillbs.service.BoardService;

@Controller
public class BoardController {
	@Inject
	BoardService boardService;
	
	@RequestMapping(value = "/board/write", method = RequestMethod.GET)
	public String write() {
//		글쓰기 가상주소
//		http://localhost:8080/myweb2/board/write
		
//		패키지 com.itwillbs.controller 	BoardController 자바파일
//		주소매핑 /board/write    GET   메서드이름 write()
		
//		jsp페이지 이동
//		/WEB-INF/views/board/writeForm.jsp
		return "/board/writeForm";
	}
	@RequestMapping(value = "/board/write", method = RequestMethod.POST)
	public String writePost(BoardBean bb) {
//		글쓰기 가상주소
//		http://localhost:8080/myweb2/board/write
		
//		com.itwillbs.service 패키지  만들고 추가 
//		=> BoardService인터페이스 BoardServiceImpl 상속받은 클래스
//		리턴값 없음 = write(bb)
//		com.itwillbs.dao 패키지 만들고 추가=>
//		=> BoardDAO인터페이스 BoardDAOImpl 상속받은 클래스
//		리턴값 없음 = write(bb)
		//  Integer maxNum()
		
//		src/main/resources - mappers - boardMapper.xml 
		//  write      maxNum
		
//		BoardService boardService=new BoardServiceImpl()
		//디비 boardService.write(bb)메서드호출
		boardService.write(bb);
		
//		가상주소 이동
//		/board/list
		return "redirect:/board/list";
	}
	
	@RequestMapping(value = "/board/list", method = RequestMethod.GET)
	public String list(HttpServletRequest request) {
//		글쓰기 가상주소
//		http://localhost:8080/myweb2/board/list
		
		// PageBean 클래스 만들기
		PageBean pb=new PageBean();
		pb.setPageSize(10);
				
		String pageNum=request.getParameter("pageNum");
		if(pageNum==null) {
			pb.setPageNum(1);
		}else {
			pb.setPageNum(Integer.parseInt(pageNum));
		}
		
		//메서드호출  Integer getBoardCount() /   List<BoardBean> list(pb)
		// getBoardCount()  select count(*) from board
		// List<BoardBean> list(pb) select * from board order by num desc limit ?,?
		
		//model 데이터 저장 
		
//		jsp페이지 이동
//		/WEB-INF/views/board/list.jsp
		return "/board/list";
	}
	
}
