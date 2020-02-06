package com.company.spring.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.company.spring.daolayer.MyDao;
import com.company.spring.model.Addcart;
import com.company.spring.model.Products_info;
import com.company.spring.model.Stock_User_info;
@Component
public class MyServiceImp implements MyService{
	@Autowired
	MyDao mdao;


	
	@Override
	public boolean register(Stock_User_info dto) {
		// TODO Auto-generated method stub
		boolean b=mdao.register(dto);
		if(b) {
			return true;
		}else {
			return false;
		}
		
	}


	@Override
	public void addproducttodb(Products_info dto, HttpSession session, HttpServletRequest req,HttpServletResponse resp) {
		// TODO Auto-generated method stub
		System.out.println("Inside Service");
		mdao.addproducttodb(dto, session, req, resp);
	}

	@Override
	public boolean login(Stock_User_info dto, HttpSession session) {
		// TODO Auto-generated method stub
		boolean b=mdao.login(dto, session);
		if(b) {
			return true;
		}else {
			return false;
		}
	}

	
@Override
	public List<Products_info> showprod() {
		// TODO Auto-generated method stub
		List<Products_info> list=mdao.showprod();
		if(list!=null) {
			return list;
		}
		else {
		return null;
		}
	}


@Override
public Products_info modifyprod(HttpServletRequest req) {
	// TODO Auto-generated method stub
	Products_info pdto=mdao.modifyprod(req);
	if(pdto!=null) {
		return pdto;
	}
	else {
	return null;
	}
	
	
}
public boolean modifyprodofdb(HttpServletRequest req) {
	// TODO Auto-generated method stub
	boolean pdto=mdao.modifyprodofdb(req);
	if(pdto) {
		return true;
	}
	else {
	return false;
	}
	
	
}



@Override
public List<Products_info> searchproduct(HttpServletRequest req) {
	// TODO Auto-generated method stub
	List<Products_info>pdto=mdao.searchproduct(req);
	if(pdto!=null) {
		return pdto;
	}
	else {
	return null;
	}
}


@Override
public Products_info addtocart(HttpServletRequest req) {
	// TODO Auto-generated method stub
	Products_info plist=mdao.addtocart(req);
	if(plist!=null) {
		return plist;
	}
	else {
		return null;
	}
	
}



//public List<Products_info> showcart() {
//	// TODO Auto-generated method stub
//	
//	List<Products_info> list=mdao.showcart();
//	if(list!=null) {
//		return list;
//	}
//	else {
//	return null;
//	}
	
	
//}


@Override
public List<Products_info> addcartdata(Products_info dto,HttpSession session ,HttpServletRequest req) {
	// TODO Auto-generated method stub
	List<Products_info> plist=mdao.addcartdata(dto,session,req);
	if(plist!=null) {
	return plist;
	}
	else {
		return null;
	}
	
}


@Override
public List<Addcart> removecart( HttpSession session, HttpServletRequest req) {
	// TODO Auto-generated method stub
	List<Addcart> plist=mdao.removecart(session,req);
	if(plist!=null) {
	return plist;
	}
	else {
		return null;
	}
	
	
}
public double billgen( HttpSession session, HttpServletRequest req) {
	// TODO Auto-generated method stub
	double amt=mdao.billgen(session,req);
	if(amt>0) {
	return amt;
	}
	else {
		return 0;
	}
	
	
}
@Override
public boolean logout(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
	// TODO Auto-generated method stub
	boolean b= mdao.logout(request, response, session);
	return b;
}






}
