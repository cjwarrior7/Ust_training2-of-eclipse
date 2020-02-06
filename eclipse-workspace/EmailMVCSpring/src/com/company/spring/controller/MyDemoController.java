package com.company.spring.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.company.spring.service.MyService;
import com.company.spring.model.EmailDT0;
import com.company.spring.model.UserDTO;

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
	@RequestMapping("/comp")
	public String compose(){
		return "compose";
		
	}

	@RequestMapping(value="/loginvalidation",method=RequestMethod.POST)
	public String loginvalidation(@ModelAttribute UserDTO dto,HttpServletRequest request) {
		System.out.println("inside controller");
		
		System.out.println(dto.getEmail()+","+dto.getPassword());
		 HttpSession session = request.getSession();
         session.setAttribute("email",dto.getEmail());
		boolean b=ms.login(dto,session);
		if(b ) {
			System.out.println("login success");
			
			return "home";
		}
		else {
			System.out.println("login failed");
			return "login";
		}
		
	}
	@RequestMapping(value="/registerationvalidation",method=RequestMethod.POST)
	public String registerationvalidation(@ModelAttribute UserDTO dto) {
		System.out.println("inside controller");
		System.out.println(dto.getName()+","+dto.getEmail());
		boolean b=ms.register(dto);
		if(b ) {
			System.out.println("login success");
			return "login";
		}
		else {
			System.out.println("registeration failed");
			return "register";
		}
		
		
		
		
	}
	@RequestMapping(value="/composevalidation",method=RequestMethod.POST)
	public String composevalidation(@ModelAttribute EmailDT0 dto,UserDTO udto,HttpServletRequest request,HttpSession session) {
		System.out.println("inside controller");
		//String user = (String)session.getAttribute("user");
		
		System.out.println(dto.getReceiver()+","+dto.getBody()+","+dto.getSubject());
		boolean b=ms.compose(dto,udto,request,session);
		if(b ) {
			System.out.println("compose success saved");
			return "home";
		}
		else {
			System.out.println("compose saved to draft");
			return "home";
		}
		
		
		
		
	}
	@RequestMapping("/draft")
	public void draftmail(@ModelAttribute EmailDT0 dto,HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		System.out.println("inside controller");
		//String user = (String)session.getAttribute("user");
		
		System.out.println(dto.getReceiver()+","+dto.getBody()+","+dto.getSubject());
		ms.draft(dto,request, response,session);
	
		
		
		
		
	}
	@RequestMapping("/inbox")
	public void inboxmail(@ModelAttribute EmailDT0 dto,HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		System.out.println("inside controller");
		//String user = (String)session.getAttribute("user");
		
		System.out.println(dto.getReceiver()+","+dto.getBody()+","+dto.getSubject());
		ms.inbox(dto,request,response,session);
	
		
		
		
		
	}
	

	
	

}
