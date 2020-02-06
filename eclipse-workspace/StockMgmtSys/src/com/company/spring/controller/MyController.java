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

import com.company.spring.model.Addcart;
import com.company.spring.model.Products_info;
import com.company.spring.model.Stock_User_info;
import com.company.spring.service.MyService;
@Component
@RequestMapping("/")
public class MyController {
	@Autowired
	MyService ms;
	static HttpSession session;

	
	@RequestMapping("/link3")
	public String add() {
		try {
		String email = (String) session.getAttribute("email");
		
		System.out.println("email:" + email);
		if (email.equals(null)) {
			return "loginfirst";
		} else {
			return "addprod";
		}
		} catch (Exception e) {
			// TODO: handle exception
			return "loginfirst";
		}
	}
	@RequestMapping("/link4")
	public String search() {
		try {
		String email = (String) session.getAttribute("email");
		System.out.println("email:" + email);
		if (email.equals(null)) {
			return "loginfirst";
		} else {
			return "searchprod";
		}
		}
		catch (Exception e) {
			// TODO: handle exception
			return "loginfirst";
		}
	}
	
	@RequestMapping("/link1")
	public String login() {
		return "login";
	}
	@RequestMapping("/link2")
	public String register() {
		return "Register";

	}
	@RequestMapping(value="/addproductindb",method=RequestMethod.POST)
	public ModelAndView addproductindb(@ModelAttribute Products_info dto,HttpSession session,HttpServletRequest req,HttpServletResponse resp) {
		System.out.println("inside controller");
		ms.addproducttodb(dto,session,req,resp);
	//	System.out.println(dto.getCompany()+","+dto.getCategory());
		 return new ModelAndView("home","msg","successfully add");
		
}
	@RequestMapping(value = "/loginvalidation", method = RequestMethod.POST)
	public ModelAndView loginvalidation(@ModelAttribute Stock_User_info dto, HttpServletRequest request) {
		System.out.println("inside controller");

		System.out.println(dto.getEmail() + "," + dto.getPassword());
		session = request.getSession();
		session.setAttribute("email", dto.getEmail());
		boolean b=ms.login(dto, session);
		if(b) {
		return new ModelAndView("home","msg","");
		}
		else {
			return new ModelAndView("login","msg","login failed");
		}

	}
	@RequestMapping(value = "/registerationvalidation", method = RequestMethod.POST)
	public ModelAndView registerationvalidation(@ModelAttribute Stock_User_info dto, String SAmswer) {
		System.out.println("inside controller");
		System.out.println(dto.getUserName() + "," + dto.getEmail());
		
		boolean b = ms.register(dto);
		System.out.println(b);
		if (b) {
			System.out.println("register success");
			return new ModelAndView("login","msg","registration successfull");
		} else {
			System.out.println("registeration failed");
			return new ModelAndView("Register","msg","registration failed");
			
		}
		
	

	}	@RequestMapping(value="/showproductofdb")
	public ModelAndView showproductofdb(HttpSession session) {
		System.out.println("inside controller");
		String email=(String) session.getAttribute("email");
		if(email!=null) {
	    List<Products_info> plist=ms.showprod();
	    		if(plist!=null) {
		        return new ModelAndView("showprod","list",plist);
	    		}
	    		else {
	    			return new ModelAndView("showprod","msg","not found");
	    		}
	    }
		else {
			return new ModelAndView("loginfirst","","");
		}
		
		
		
	}
	@RequestMapping(value="/modifyproduct")
	public ModelAndView modifyproduct(HttpSession session,HttpServletRequest req,HttpServletResponse resp) {
		System.out.println("inside controller");
		String email=(String) session.getAttribute("email");
		if(email!=null) {
	    Products_info plist=ms.modifyprod(req);
	    		if(plist!=null){
		        return new ModelAndView("modifyprod","plist",plist);
	    		}
	    		else {
	    			return new ModelAndView("showprod","msg","not found");
	    		}
	    }
		else {
			return new ModelAndView("loginfirst","","");
		}
		
		
		
	}
	@RequestMapping(value="/modifyproductofdb",method=RequestMethod.POST)
	public ModelAndView modifyproductofdb(HttpSession session,HttpServletRequest req,HttpServletResponse resp) {
		System.out.println("inside controller");
		String email=(String) session.getAttribute("email");
		if(email!=null) {
	    boolean plist=ms.modifyprodofdb(req);
	    		if(plist){
		        return new ModelAndView("home","list",plist);
	    		}
	    		else {
	    			return new ModelAndView("home","msg","failed");
	    		}
	    }
		else {
			return new ModelAndView("loginfirst","","");
		}
		
		
		
	}
	@RequestMapping(value="/searchproduct")
	public ModelAndView searchproduct(HttpSession session,HttpServletRequest req,HttpServletResponse resp) {
		System.out.println("inside controller");
		String email=(String) session.getAttribute("email");
		if(email!=null) {
	    List<Products_info> plist=ms.searchproduct(req);
	    System.out.println(plist);
	    		if(plist!=null){
		        return new ModelAndView("displayprod","list",plist);
	    		}
	    		if(plist.size()==0) {
	    			System.out.println("inside if");
	    			return new ModelAndView("displayprod","msg","not found");	
	    		}
	    		else {
	    			System.out.println("inside else");
	    			return new ModelAndView("displayprod","msg","not found");
	    		}
	    }
		
		else {
			return new ModelAndView("loginfirst","","");
		}
		
		
		
	}
	@RequestMapping(value="/addtocart")
	public ModelAndView addtocart(HttpSession session,HttpServletRequest req,HttpServletResponse resp) {
		System.out.println("inside controller");
		Products_info pdto=ms.addtocart(req);
		if(pdto!=null) {
			return new ModelAndView("cart","dto",pdto);
		}
		else {
			return new ModelAndView("cart","dto",pdto);
		}
		
	   }
	
	
	@RequestMapping(value="/addcartdata",method=RequestMethod.POST)
	public ModelAndView addcartdata(Products_info dto,HttpSession session,HttpServletRequest req){
		   List<Products_info> plist=ms.addcartdata(dto,session,req);
  		  if(plist!=null) {
  			  System.out.println("inside if");
	        return new ModelAndView("showcart","list",plist);
	        }
  		else {

			  System.out.println("inside else");
  			return new ModelAndView("cart","msg","no item");
  		}
		
	}
	@RequestMapping(value="/removecart")
	public ModelAndView removecart(HttpSession session,HttpServletRequest req){
		
		   List<Addcart> plist=ms.removecart(session,req);
  		  if(plist!=null) {
  			  System.out.println("inside if");
	          return new ModelAndView("showcart","list",plist);
	        }
  		else {
             System.out.println("inside else");
  			 return new ModelAndView("showcart","msg","no item");
  		}
		
	}
	@RequestMapping(value="/billgen")
	public ModelAndView billgen(HttpSession session,HttpServletRequest req){
		
		   double amt =ms.billgen(session,req);
  		  if(amt>0) {
  			  System.out.println("inside if");
	          return new ModelAndView("totalmoney","amt_pay",amt);
	        }
  		else {
             System.out.println("inside else");
  			 return new ModelAndView("totalmoney","amt_pay",0);
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
	

	
}
