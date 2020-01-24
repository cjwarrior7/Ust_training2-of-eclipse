package com.company.spring;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Component
@RequestMapping("/")
public class MyController {
	@RequestMapping("/login")
	public  String m1() {
		return "success1";
		
	}
	@RequestMapping("/register")
	public ModelAndView m2() {
		return new ModelAndView("success2");
		
	}
	@RequestMapping("/profile")
	public ModelAndView m3() {
		return new ModelAndView("success3","data","data from controller");
	}
	@RequestMapping("/link4")
	public ModelAndView m4() {
		DTO dto=new DTO();
		dto.setId(123);
		dto.setName("test1");
		return new ModelAndView("success4","dto",dto);
	}
	

}
