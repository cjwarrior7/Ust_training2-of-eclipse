package com.company.spring.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.company.spring.daolayer.MyDao;
import com.company.spring.model.Mail_info;
import com.company.spring.model.User_info;
@Component
public class MyServiceImp  implements MyService{
	 @Autowired
	 MyDao mdao;
	@Override
	public boolean register(User_info dto) {
		// TODO Auto-generated method stub
		boolean b=mdao.register(dto);
		return b;
		
	}

	@Override
	public boolean login(User_info dto, HttpSession session) {
		// TODO Auto-generated method stub
		mdao.login(dto, session);
		boolean b=mdao.login(dto, session);
		return b;
		
	}

	@Override
	public boolean compose(Mail_info dto, User_info udto, HttpServletRequest request, HttpSession session) {
		// TODO Auto-generated method stub
		boolean b=mdao.compose(dto, udto, request, session);
		return b;
	}

	@Override
	public List<Mail_info>  draft(Mail_info dto, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		List<Mail_info> dlist=mdao.draft(dto,  request,response, session);
		System.out.println(dlist);
		if(dlist!=null) {
			return dlist;
		}
		else {
			return null;
		}
	}

	@Override
	public  List<Mail_info>  inbox(Mail_info dto, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub

		List<Mail_info> ilist= mdao.inbox(dto,  request,response, session);
		System.out.println(ilist);
		if(ilist!=null) {
			return ilist;
		}
		else {
			return null;
		}
	}

	@Override
	public List<Mail_info>  sentbox(Mail_info dto, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		List<Mail_info> slist= mdao.sentbox(dto, request, response, session);
		System.out.println(slist);
		if(slist!=null) {
			return slist;
		}
		else {
			return null;
		}
		
	}

	@Override
	public boolean logout(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		boolean b= mdao.logout(request, response, session);
		return b;
	}

	@Override
	public boolean forgot(User_info dto, HttpServletRequest request, HttpServletResponse response,HttpSession session) {
		// TODO Auto-generated method stub
		boolean b= mdao.forgot(dto, request, response, session);
		return b;
	}

	@Override
	public boolean change(User_info dto, HttpServletRequest request, HttpServletResponse response,HttpSession session) {
		// TODO Auto-generated method stub
		boolean b= mdao.change(dto, request, response, session);
		return b;
	}

	@Override
	public boolean deletetempinb(Mail_info dto, HttpServletRequest request, HttpServletResponse response,HttpSession session) {
		// TODO Auto-generated method stub
		boolean b= mdao.deletetempinbdao(dto, request, response, session);
		return b;
	}
	public boolean deletetempdraft(Mail_info dto, HttpServletRequest request, HttpServletResponse response,HttpSession session) {
		// TODO Auto-generated method stub
		boolean b= mdao.deletetempdraftdao(dto, request, response, session);
		return b;
	}
	public boolean deletetempsent(Mail_info dto, HttpServletRequest request, HttpServletResponse response,HttpSession session) {
		// TODO Auto-generated method stub
		boolean b= mdao.deletetempsentdao(dto, request, response, session);
		return b;
	}

	@Override
	public boolean deleteitemperm(Mail_info dto, HttpServletRequest request, HttpServletResponse response,HttpSession session) {
		// TODO Auto-generated method stub
		boolean b= mdao.deleteitemperm(dto, request, response, session);
		return b;
	}

	@Override
	public List<Mail_info> fetchdelete(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		 List<Mail_info>list= mdao.fetchdelete(request, response, session);
		 System.out.println(list);
			if(list!=null) {
				return list;
			}
			else {
				return null;
			}
		
	}

	@Override
	public Mail_info fetchbody(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		 Mail_info m_info= mdao.fetchbody(request, response, session);
		 System.out.println(m_info);
			if(m_info!=null) {
				return m_info;
			}
			else {
				return null;
			}
	
	}
	@Override
	public boolean composeedit(HttpServletRequest req, HttpSession session) {
		// TODO Auto-generated method stub
		boolean b= mdao.composeedit(req,session);
		if(b) {
			return true;
		}
		else {
			return false;
			}
	}

	


}
