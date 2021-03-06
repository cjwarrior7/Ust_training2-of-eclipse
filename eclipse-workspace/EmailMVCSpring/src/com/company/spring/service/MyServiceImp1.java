package com.company.spring.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.company.spring.daolayer.MyDao;
import com.company.spring.model.UserDTO;
import com.company.spring.model.EmailDT0;
@Component
public class MyServiceImp1 implements MyService {
@Autowired
MyDao mdao;
	@Override
	public boolean register(UserDTO dto) {
		// TODO Auto-generated method stub
		System.out.println("Inside Service");
		boolean b=mdao.register(dto);
		return b;
	}

	@Override
	public boolean login(UserDTO dto,HttpSession session) {
		// TODO Auto-generated method stub
		System.out.println("Inside Service");
		boolean b=mdao.login(dto,session);
		return b;
		
	}

	@Override
	public boolean compose(EmailDT0 dto, UserDTO udto,HttpServletRequest request,HttpSession session) {
		// TODO Auto-generated method stub
		System.out.println("Inside Service");
		boolean b=mdao.compose(dto,udto,request,session);
		return b;
	}

	@Override
	public void draft(EmailDT0 dto, HttpServletRequest request, HttpServletResponse response,HttpSession session) {
		// TODO Auto-generated method stub
		System.out.println("Inside Service");
		mdao.draft(dto,request,response,session);
	}

	@Override
	public void inbox(EmailDT0 dto, HttpServletRequest request,HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		System.out.println("Inside Service");
		mdao.inbox(dto,request,response,session);
	}

	@Override
	public void sentbox(EmailDT0 dto, HttpServletRequest request,HttpServletResponse response , HttpSession session) {
		// TODO Auto-generated method stub
		System.out.println("Inside Service");
		mdao.sentbox(dto,request,response,session);
		
	}

	



}
