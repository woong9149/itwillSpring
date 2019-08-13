package com.itwillbs.controller;


import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.MemberBean;
import com.itwillbs.service.MemberService;

@Controller
public class MemberController {
	//주입받는(객체생성한 객체를 주입받는) 멤버변수
	@Inject
	MemberService memberService;
	
	@RequestMapping(value = "/member/insert", method = RequestMethod.GET)
	public String insert() {
//		회원가입 가상주소
//		http://localhost:8080/myweb2/member/insert
	//
//		패키지 com.itwillbs.controller
//		MemberController 자바파일
//		주소매핑 /member/insert    GET
	//   메서드이름 insert()	
	//
//		jsp페이지 이동
//		/WEB-INF/views/member/insertForm.jsp
		return "/member/insertForm";
	}
	
	@RequestMapping(value = "/member/insert", method = RequestMethod.POST)
	public String insertPost(MemberBean mb) {
//		회원가입 가상주소
//		http://localhost:8080/myweb2/member/insert
		
//		패키지 com.itwillbs.controller
//		MemberController 자바파일
//		주소매핑 /member/insert    POST
	//   메서드이름 insertPost(MemberBean mb)	
		
//		com.itwillbs.service 패키지  만들고 추가 
//		=> MemberService인터페이스 MemberServiceImpl 상속받은 클래스
//		리턴값 없음 = insert(mb)
//		com.itwillbs.dao 패키지 만들고 추가=>
//		=> MemberDAO인터페이스 MemberDAOImpl 상속받은 클래스
//		리턴값 없음 = insert(mb)
		
//		MemberService memberService=new MemberServiceImpl()
		//디비 memberService.insert(mb)메서드호출
		memberService.insert(mb);
		
		
//		가상주소 이동
//		/member/login
		return "redirect:/member/login";
	}
	@RequestMapping(value = "/member/login", method = RequestMethod.GET)
	public String login() {
//		http://localhost:8080/myweb2/member/login
		
//		/WEB-INF/views/member/loginForm.jsp
		return "/member/loginForm";
	}
	
	@RequestMapping(value = "/member/login", method = RequestMethod.POST)
	public String loginPost(MemberBean mb,HttpSession session) {
//		http://localhost:8080/myweb2/member/login
//		MemberService memberService=new MemberServiceImpl()
		//디비 memberService.login(mb)메서드호출
		MemberBean mb2=memberService.login(mb);
		//mb2 있으면  세션값 생성 
		if(mb2!=null) {
			session.setAttribute("id", mb.getId());
		}else {
			System.out.println("로그인 정보 틀림");
		}
//		가상주소 이동
//		/member/main
		return "redirect:/member/main";
	}
	@RequestMapping(value = "/member/main", method = RequestMethod.GET)
	public String main() {
//		http://localhost:8080/myweb2/member/main
//		/WEB-INF/views/member/main.jsp
		return "/member/main";
	}
	
	@RequestMapping(value = "/member/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
//		http://localhost:8080/myweb2/member/logout
		//세션 초기화
		session.invalidate();
//		가상주소 이동
//		/member/login
		return "redirect:/member/login";
	}
	
	@RequestMapping(value = "/member/info", method = RequestMethod.GET)
	public String info(HttpSession session,Model model) {
//		http://localhost:8080/myweb2/member/info
		// 세션값 가져오기
		String id=(String)session.getAttribute("id");
		MemberBean mb=memberService.info(id);
		// model   mb 저장
		model.addAttribute("mb",mb);
//		/WEB-INF/views/member/info.jsp
		return "/member/info";
	}
	@RequestMapping(value = "/member/update", method = RequestMethod.GET)
	public String update(HttpSession session,Model model) {
//		http://localhost:8080/myweb2/member/update
		// 세션값 가져오기
		String id=(String)session.getAttribute("id");
		MemberBean mb=memberService.info(id);
		// model   mb 저장
		model.addAttribute("mb",mb);
//		/WEB-INF/views/member/updateForm.jsp
		return "/member/updateForm";
	}
	@RequestMapping(value = "/member/update", method = RequestMethod.POST)
	public String updatePost(MemberBean mb) {
//		http://localhost:8080/myweb2/member/update
		//디비 memberService.login(mb)메서드호출
				MemberBean mb2=memberService.login(mb);
				//mb2 있으면  세션값 생성 
				if(mb2!=null) {
					// 수정 작업
					memberService.update(mb);
				}else {
					System.out.println("정보 틀림");
				}
//		가상주소 이동
//		/member/main
		return "redirect:/member/main";
	}
	
	// /member/delete
	@RequestMapping(value = "/member/delete", method = RequestMethod.GET)
	public String delete() {
//		http://localhost:8080/myweb2/member/delete
		
//		/WEB-INF/views/member/deleteForm.jsp
		return "/member/deleteForm";
	}
	
	@RequestMapping(value = "/member/delete", method = RequestMethod.POST)
	public String deletePost(MemberBean mb,HttpSession session) {
//		http://localhost:8080/myweb2/member/delete
		//디비 memberService.login(mb)메서드호출
				MemberBean mb2=memberService.login(mb);
				//mb2 있으면  세션값 생성 
				if(mb2!=null) {
					// 삭제 작업
					memberService.delete(mb);
					// 세션 초기화
					session.invalidate();
				}else {
					System.out.println("정보 틀림");
				}
//		가상주소 이동
//		/member/main
		return "redirect:/member/main";
	}
	
	//     /member/list
	@RequestMapping(value = "/member/list", method = RequestMethod.GET)
	public String list(Model model) {
//		http://localhost:8080/myweb2/member/list
		//  List<MemberBean> memberList =   memberService.list();
		List<MemberBean> memberList = memberService.list();
		// model 회원정보 리스트(memberList) 저장해서 list.jsp 이동
		model.addAttribute("memberList",memberList);
//		/WEB-INF/views/member/list.jsp
		return "/member/list";
	}
	
	
}



