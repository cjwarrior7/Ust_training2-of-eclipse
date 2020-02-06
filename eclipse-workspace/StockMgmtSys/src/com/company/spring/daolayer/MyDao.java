package com.company.spring.daolayer;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.spring.model.Addcart;
import com.company.spring.model.Products_info;
import com.company.spring.model.Stock_User_info;


public interface MyDao {
    void addproducttodb(Products_info dto,HttpSession session,HttpServletRequest req,HttpServletResponse resp);
    boolean register(Stock_User_info dto);
	boolean login(Stock_User_info dto,HttpSession session);
	List<Products_info> showprod();
	Products_info modifyprod(HttpServletRequest req);
	boolean modifyprodofdb(HttpServletRequest req);
	List<Products_info> searchproduct(HttpServletRequest req);
	Products_info addtocart(HttpServletRequest req);
	//List<Products_info> showcart();
	List<Products_info> addcartdata(Products_info dto,HttpSession session ,HttpServletRequest req);
	List<Addcart> removecart(HttpSession session ,HttpServletRequest req);
	double billgen(HttpSession session ,HttpServletRequest req);
	boolean logout(HttpServletRequest request,HttpServletResponse response,HttpSession session);
	
}
