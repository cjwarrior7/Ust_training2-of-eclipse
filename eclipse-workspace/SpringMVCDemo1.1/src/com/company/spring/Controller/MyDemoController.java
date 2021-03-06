package com.company.spring.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.company.spring.Model.ModelDTO;
import com.company.spring.Service.MyService;

@Component
@RequestMapping("/")
public class MyDemoController {
	@Autowired
	MyService ms;
	@RequestMapping("/link1")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/link2")
	public String register(){
		return "register";
		
	}
	@RequestMapping(value="/loginvalidation",method=RequestMethod.POST)
	public String loginvalidation(@ModelAttribute ModelDTO dto) {
		System.out.println("inside controller");
		
		System.out.println(dto.getName()+","+dto.getPassword());
		boolean b=ms.login(dto);
		if(b ) {
			System.out.println("login success");
		}
		else {
			System.out.println("login failed");
		}
		return "login";
	}
	@RequestMapping(value="/registerationvalidation",method=RequestMethod.POST)
	public String registerationvalidation(@ModelAttribute ModelDTO dto) {
		System.out.println("inside controller");
		ms.register(dto);
		System.out.println(dto.getAddress()+","+dto.getEmail());
		 return "register";
		
		
		
	}
	

}
