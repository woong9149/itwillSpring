package com.itwillbs.myweb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController2 {

	@RequestMapping(value = "/login.me", method = RequestMethod.GET)
	public String login(Model model) {
		
		model.addAttribute("mname", "name Value");
		
		return "login";
	}
}
