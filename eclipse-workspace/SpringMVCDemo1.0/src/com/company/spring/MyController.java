package com.company.spring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Component
@RequestMapping("/")
public class MyController {
	@RequestMapping("/login") /* HttpServletRequest request is replaced by @RequestParam in Spring*/
	public ModelAndView m1(@RequestParam String email ,String password ) {
		if(email.equals("admin@gmail.com")&&password.equals("incorrect")) {
			return new ModelAndView("home","msg","login success");
		}else
		return new ModelAndView("login","msg","login failed");
		

	}
	@RequestMapping("/link8")
	public ModelAndView m8() {
		return new ModelAndView("login");
	}
	@RequestMapping("/registeration")
	public ModelAndView m2(@ModelAttribute RegistrationDto rdto) {
		return new ModelAndView("home","rdto",rdto);

	}
	@RequestMapping("/link7")
	public ModelAndView m7() {
		return new ModelAndView("register");
	}

	@RequestMapping("/profile")
	public ModelAndView m3() {
		return new ModelAndView("success3", "data", "data from controller");
	}

	@RequestMapping("/link4")
	public ModelAndView m4() {
		DTO dto = new DTO();
		dto.setId(12);
		dto.setName("baburao");
		return new ModelAndView("success4", "dto", dto);
	}

	@RequestMapping("/link5")
	public ModelAndView m5() {
		DTO dto1 = new DTO();
		dto1.setId(123);
		dto1.setName("test1");
		DTO dto2 = new DTO();
		dto2.setId(124);
		dto2.setName("test2");
		List<DTO> list = new ArrayList();
		list.add(dto1);
		list.add(dto2);
		return new ModelAndView("success5", "list", list);
	}

}
