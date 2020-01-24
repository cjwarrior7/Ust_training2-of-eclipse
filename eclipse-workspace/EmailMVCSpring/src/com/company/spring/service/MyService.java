package com.company.spring.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.spring.model.EmailDT0;
import com.company.spring.model.UserDTO;

public interface MyService {
	boolean register(UserDTO dto);
	boolean login(UserDTO dto,HttpSession session);
	boolean compose(EmailDT0 dto,UserDTO udto,HttpServletRequest request,HttpSession session);
	void draft(EmailDT0 dto,HttpServletRequest request,HttpServletResponse response,HttpSession session);
	void inbox(EmailDT0 dto,HttpServletRequest request,HttpServletResponse response,HttpSession session);
	void sentbox(EmailDT0 dto,HttpServletRequest request,HttpServletResponse response,HttpSession session);
	
	

}
