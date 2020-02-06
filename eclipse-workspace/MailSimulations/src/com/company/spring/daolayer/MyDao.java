package com.company.spring.daolayer;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

import com.company.spring.model.Mail_info;

import com.company.spring.model.User_info;

public interface MyDao {
	boolean register(User_info dto);
	         
	boolean login(User_info dto,HttpSession session);
	boolean compose (Mail_info dto,User_info udto,HttpServletRequest request,HttpSession session);
	 List<Mail_info>  draft(Mail_info dto,HttpServletRequest request,HttpServletResponse response,HttpSession session);
	 List<Mail_info>  inbox(Mail_info dto,HttpServletRequest request,HttpServletResponse response,HttpSession session);
	 List<Mail_info>  sentbox(Mail_info dto,HttpServletRequest request,HttpServletResponse response,HttpSession session);
	boolean logout(HttpServletRequest request,HttpServletResponse response,HttpSession session);
	boolean forgot(User_info dto,HttpServletRequest request,HttpServletResponse response,HttpSession session);
	boolean change(User_info dto,HttpServletRequest request,HttpServletResponse response,HttpSession session);
	boolean deletetempinbdao(Mail_info dto,HttpServletRequest request,HttpServletResponse response,HttpSession session);
	boolean deletetempdraftdao(Mail_info dto,HttpServletRequest request,HttpServletResponse response,HttpSession session);
	boolean deletetempsentdao(Mail_info dto,HttpServletRequest request,HttpServletResponse response,HttpSession session);
	boolean deleteitemperm(Mail_info dto,HttpServletRequest request,HttpServletResponse response,HttpSession session);
	List<Mail_info> fetchdelete(HttpServletRequest request,HttpServletResponse response,HttpSession session);
	Mail_info fetchbody(HttpServletRequest request,HttpServletResponse response,HttpSession session);
	boolean composeedit(HttpServletRequest req,HttpSession session);
}
