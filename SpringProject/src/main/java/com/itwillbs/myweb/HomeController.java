package com.itwillbs.myweb;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.MemberBean;
import com.itwillbs.service.MemberService;



/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	//멤버변수(인터페이스)  선언
	// MemberService memberService=new MemberService1();
	// HomeController 이 MemberService1에 의존관계에 있고 
	// MemberService1 xml에서 객체생성 해서  HomeController에 set메서드를 통해서 
	// 객체생성한 값을 전달(주입)
//	MemberService memberService;
	
	// memberService 값을 받을 준비
	//생성자
//	public HomeController(MemberService memberService) {
//		this.memberService=memberService;
//	}
	//set메서드 통해서 받을 준비
	
//	@Inject
//	public void setMemberService(MemberService memberService) {
//		this.memberService = memberService;
//	}




	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		//   /WEB-INF/views/insert.jsp
		return "insert";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insertPost(Locale locale, Model model, MemberBean mb) {
		logger.info("id :"+ mb.getId());
		System.out.println("pass : "+mb.getPass());
		logger.info("name :"+ mb.getName());
		// 처리 MemberService   => 디비 MemberDAO => 디비 insert 
		//  MemberService  insert() 호출
		
//		1. 지정된 자바 파일 객체생성 
//		MemberService1 memberService1=new MemberService1();
//		memberService1.insert1(mb);
//		
//		MemberService2 memberService2=new MemberService2();
//		memberService2.insert2(mb);
		
		// 2. 인터페이스 = 상속받은 클래스 객체생성  업캐스팅
//		MemberService memberService=new MemberService1();
//		memberService.insert();
		
//		MemberService memberService2=new MemberService2();
//		memberService2.insert();
		
		// 3.인터페이스 = 스프링 xml 파일에서 상속받은 클래스 객체생성해서 set,생성자 값 저장
//		memberService.insert();
		
		//   /login.me 로 이동
		return "redirect:/login.me";
	}
	
	
	
}
