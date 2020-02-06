
package com.company.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;

import com.company.spring.model.Mail_info;

import com.company.spring.model.User_info;
import com.company.spring.service.MyService;

@Component
@RequestMapping("/")
public class MyController {
	@Autowired
	MyService ms;
	static HttpSession session;

	@RequestMapping("/link1")
	public String login() {
		return "login";
	}

	@RequestMapping("/link2")
	public String register() {
		return "Register";

	}

	@RequestMapping("/comp")
	public String compose() {

		try {

			String email = (String) session.getAttribute("email");
			System.out.println("email:" + email);
			if (email.equals(null)) {
				return "loginfirst";
			} else {
				return "compose";
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("IN catch");
			return "loginfirst";
		}

	}

	@RequestMapping("/forgot")
	public String forgot() {
		return "forgotpass";

	}

	@RequestMapping("/changep")
	public String changePassword() {

		try {

			String email = (String) session.getAttribute("email");
			System.out.println("email:" + email);
			if (email.equals(null)) {
				return "loginfirst";
			} else {
				return "changepass";
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("IN catch");
			return "loginfirst";
		}

	}

	@RequestMapping(value = "/loginvalidation", method = RequestMethod.POST)
	public String loginvalidation(@ModelAttribute User_info dto, HttpServletRequest request) {
		System.out.println("inside controller");

		System.out.println(dto.getEmail() + "," + dto.getPassword());
		session = request.getSession();
		session.setAttribute("email", dto.getEmail());
		ms.login(dto, session);
		return "home";

	}

	@RequestMapping(value = "/registerationvalidation", method = RequestMethod.POST)
	public String registerationvalidation(@ModelAttribute User_info dto, String SAmswer) {
		System.out.println("inside controller");
		System.out.println(dto.getUserName() + "," + dto.getEmail());
		boolean b = ms.register(dto);
		System.out.println(b);
		if (b) {
			System.out.println("register success");
			return "login";
		} else {
			System.out.println("registeration failed");
			return "Register";
		}

	}

	@RequestMapping(value = "/composevalidation", method = RequestMethod.POST)
	public ModelAndView composevalidation(@ModelAttribute Mail_info dto, User_info udto, HttpServletRequest request,
			HttpSession session) {
		System.out.println("inside controller");
		String email = (String) session.getAttribute("email");
		if (email == null) {
			return new ModelAndView("login", "msg", "please login first");
		}

		System.out.println(dto.getTo_id() + "," + dto.getBody() + "," + dto.getSubject());
		boolean b = ms.compose(dto, udto, request, session);
		if (b) {
			System.out.println("compose success saved");
			return new ModelAndView("home", "msg", "message successfully saved");
		} else {
			System.out.println("logout");
			return new ModelAndView("home", "msg", "it means you are logout");
		}

	}

	@RequestMapping("/inbox")
	public ModelAndView inboxmail(@ModelAttribute Mail_info dto, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		System.out.println("inside controller");
		// String user = (String)session.getAttribute("user");

		System.out.println(dto.getTo_id() + "," + dto.getBody() + "," + dto.getSubject());
		ms.inbox(dto, request, response, session);
		List<Mail_info> ilist = ms.inbox(dto, request, response, session);
		System.out.println(ilist);
		if (ilist != null) {
			return new ModelAndView("inbox", "list", ilist);
		} else {
			return new ModelAndView("loginfirst", "msg", "please login first");

		}

	}

	@RequestMapping("/sent")
	public ModelAndView sentboxmail(@ModelAttribute Mail_info dto, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		System.out.println("inside controller");
		// String user = (String)session.getAttribute("user");

		System.out.println(dto.getTo_id() + "," + dto.getBody() + "," + dto.getSubject());
		List<Mail_info> slist = ms.sentbox(dto, request, response, session);
		System.out.println(slist);
		if (slist != null) {
			return new ModelAndView("sentbox", "list", slist);
		} else {
			return new ModelAndView("loginfirst", "msg", "please login first");
		}

	}

	@RequestMapping("/draft")
	public ModelAndView draftmail(@ModelAttribute Mail_info dto, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		System.out.println("inside controller");
		// String user = (String)session.getAttribute("user");

		System.out.println(dto.getTo_id() + "," + dto.getBody() + "," + dto.getSubject());

		List<Mail_info> dlist = ms.draft(dto, request, response, session);
		System.out.println(dlist);
		if (dlist != null) {
			return new ModelAndView("draft", "list", dlist);
		} else {
			return new ModelAndView("loginfirst", "msg", "please login first");

		}

	}

	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		System.out.println("inside controller");
		String email = (String) session.getAttribute("email");
		if (email == null) {
			return new ModelAndView("login", "msg", "please login first");
		}
		boolean b = ms.logout(request, response, session);
		if (b) {
			return new ModelAndView("login", "msg", "logout successfully");
		} else {
			return new ModelAndView("login", "msg", "please login first");
		}
	}

	@RequestMapping(value = "/forgotvalidation", method = RequestMethod.POST)
	public ModelAndView forgotvalidation(@ModelAttribute User_info dto, HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("inside controller");
		// String email = (String)session.getAttribute("email");

		boolean b = ms.forgot(dto, request, response, session);
		if (b) {
			return new ModelAndView("login", "msg", "password update successfully");
		} else {
			return new ModelAndView("forgotpass", "msg", "forgot failed");

		}
	}

	@RequestMapping(value = "/changepassword", method = RequestMethod.POST)
	public ModelAndView changepassword(@ModelAttribute User_info dto, HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("inside controller");
		// String email = (String)session.getAttribute("email");

		boolean b = ms.change(dto, request, response, session);
		if (b) {
			return new ModelAndView("login", "msg", "password change successfully");
		} else {
			return new ModelAndView("changepass", "msg", "change failed");
		}

	}

	@RequestMapping(value = "/deleteinb")
	public ModelAndView deletetempinb(@ModelAttribute Mail_info dto, HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("inside controller");
		// String email = (String)session.getAttribute("email");

		boolean b = ms.deletetempinb(dto, request, response, session);
		if (b) {
			return new ModelAndView("home", "msg", "deleted successfully");
		} else {
			return new ModelAndView("home", "msg", "delete failed");

		}

	}
	@RequestMapping(value = "/deletedraft")
	public ModelAndView deletetempdraft(@ModelAttribute Mail_info dto, HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("inside controller");
		// String email = (String)session.getAttribute("email");

		boolean b = ms.deletetempdraft(dto, request, response, session);
		if (b) {
			return new ModelAndView("home", "msg", "deleted successfully");
		} else {
			return new ModelAndView("home", "msg", "delete failed");

		}

	}
	@RequestMapping(value = "/deletesentbox")
	public ModelAndView deletetempsentbox(@ModelAttribute Mail_info dto, HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("inside controller");
		// String email = (String)session.getAttribute("email");

		boolean b = ms.deletetempsent(dto, request, response, session);
		if (b) {
			return new ModelAndView("home", "msg", "deleted successfully");
		} else {
			return new ModelAndView("home", "msg", "delete failed");

		}

	}
	@RequestMapping(value = "/deleteitem")
	public ModelAndView deleteperm(Mail_info dto, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("inside controller");
		// String email = (String)session.getAttribute("email");

		boolean b = ms.deleteitemperm(dto, request, response, session);
		if (b) {
			return new ModelAndView("home", "msg", "deleted successfully");
		} else {
			return new ModelAndView("home", "msg", "delete failed");
		}

	}

	@RequestMapping(value = "/fetchdelete")
	public ModelAndView fetchdelete(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("inside controller");
		
		try { 
			String email = (String)session.getAttribute("email");
			
			}catch(IllegalStateException e) {
				return new ModelAndView("loginfirst", "msg", "login please");
			}
		 
			
		 List<Mail_info> flist = ms.fetchdelete(request, response, session);
		if (flist != null) {
			System.out.println("inside if");
			return new ModelAndView("delete", "list", flist);
		} 
		
       	else{
        	 System.out.println("inside else");
 			return new ModelAndView("loginfirst", "msg", "login please");

 		}
	
		 
		
		
		
      
	   

	}

	@RequestMapping(value = "/fetchbody")
	public ModelAndView fetchbody(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("inside controller");
		// String email = (String)session.getAttribute("email");

		Mail_info mail = ms.fetchbody(request, response, session);
		if (mail != null) {
		    return new ModelAndView("composeedit", "mdto", mail);
		} else {
			return new ModelAndView("loginfirst", "msg", "login first");

		}

	}
	@RequestMapping(value = "/composeeditup")
	public ModelAndView composeeditup(HttpServletRequest req, HttpSession session) {
		System.out.println("inside controller");
		String email = (String) session.getAttribute("email");
		if (email == null) {
			return new ModelAndView("login", "msg", "please login first");
		}

		//System.out.println(dto.getTo_id() + "," + dto.getBody() + "," + dto.getSubject());
		boolean b = ms.composeedit(req,session);
		if (b) {
			System.out.println("compose success saved");
			return new ModelAndView("home", "msg", "message successfully saved");
		} else {
			System.out.println("compose success in draft");
			return new ModelAndView("home", "msg", "message saved to draft");
		}

	}

}
