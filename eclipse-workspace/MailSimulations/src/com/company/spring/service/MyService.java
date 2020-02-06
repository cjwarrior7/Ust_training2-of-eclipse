package com.company.spring.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

import com.company.spring.model.*;

public interface MyService {
	boolean register(User_info dto);
	boolean login(User_info dto,HttpSession session);
	boolean compose(Mail_info dto,User_info udto,HttpServletRequest request,HttpSession session);
	List<Mail_info>  draft(Mail_info dto,HttpServletRequest request,HttpServletResponse response,HttpSession session);
	List<Mail_info> inbox(Mail_info dto,HttpServletRequest request,HttpServletResponse response,HttpSession session);
	List<Mail_info>  sentbox(Mail_info dto,HttpServletRequest request,HttpServletResponse response,HttpSession session);
	boolean logout(HttpServletRequest request,HttpServletResponse response,HttpSession session);
	boolean forgot(User_info dto,HttpServletRequest request,HttpServletResponse response,HttpSession session);
	boolean change(User_info dto,HttpServletRequest request,HttpServletResponse response,HttpSession session);
	boolean deletetempinb(Mail_info dto,HttpServletRequest request,HttpServletResponse response,HttpSession session);
	boolean deletetempdraft(Mail_info dto,HttpServletRequest request,HttpServletResponse response,HttpSession session);
	boolean deletetempsent(Mail_info dto,HttpServletRequest request,HttpServletResponse response,HttpSession session);
	boolean deleteitemperm(Mail_info dto,HttpServletRequest request,HttpServletResponse response, HttpSession session);
	List<Mail_info> fetchdelete(HttpServletRequest request,HttpServletResponse response,HttpSession session);
	Mail_info fetchbody(HttpServletRequest request, HttpServletResponse response,HttpSession session);
	boolean composeedit(HttpServletRequest req ,HttpSession session);
	
	
}
