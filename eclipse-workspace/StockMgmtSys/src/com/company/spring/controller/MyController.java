package com.company.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.company.spring.model.Stock;
import com.company.spring.service.MyService;
@Component
@RequestMapping("/")
public class MyController {
	@Autowired
	MyService ms;
	@RequestMapping("/link1")
	public String add() {
		return "addprod";
	}
	@RequestMapping(value="/addproductinstock",method=RequestMethod.POST)
	public String addproductinstock(@ModelAttribute Stock dto) {
		System.out.println("inside controller");
		ms.addproduct(dto);
		System.out.println(dto.getPName()+","+dto.getPrice());
		 return "addprod";
		
		
		
	}
	
}