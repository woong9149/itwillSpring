package com.itwillbs.myweb;

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
//	MemberService memberService=new memberServiceImpl();
	@Inject
	MemberService memberService;
	
//	@Inject
//	public void setMemberService(MemberService memberService) {
//		this.memberService = memberService;
//	}


	//	http://localhost:8080/myweb/insertForm
	@RequestMapping(value = "/insertForm", method = RequestMethod.GET)
	public String insertForm() {
		//   /WEB-INF/views/insertForm.jsp
		return "insertForm";
	}
	@RequestMapping(value = "/insertForm", method = RequestMethod.POST)
	public String insertFormPost(MemberBean mb,HttpSession session) {
		System.out.println(mb.getId());
		System.out.println(mb.getPass());
		System.out.println(mb.getName());
		// 회원가입처리 
//		MemberService memberService=new memberServiceImpl();
		memberService.insertForm(mb);
		//세션 생성
		session.setAttribute("id", mb.getId());
		//   login.me
		//return redirect:login.me;
		// 회원정보 조회   /info 
		return "redirect:info";
	}
	
//	http://localhost:8080/myweb/info
	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public String info(HttpSession session,Model model) {
		//세션값 가져오기
		String id=(String)session.getAttribute("id");
		// 회원정보조회
//		MemberService memberService=new memberServiceImpl();
		MemberBean mb=memberService.info(id);
		// model 저장 "mb",mb
		model.addAttribute("mb",mb);
		//   /WEB-INF/views/info.jsp
		return "info";
	}
	
	//	http://localhost:8080/myweb/list
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {
		// List<MemberBean> memberList  = memberService.list() 호출
		List<MemberBean> memberList=memberService.list();
		
		// model 저장 "memberList",memberList
		model.addAttribute("memberList",memberList);
		
		return "list";
	}
	
	
}



