package com.company.spring.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.company.spring.DaoLayer.MyDao;
import com.company.spring.Model.ModelDTO;
@Component
public class MyServiceImp1 implements MyService {
@Autowired
MyDao mdao;
	@Override
	public void register(ModelDTO dto) {
		// TODO Auto-generated method stub
		System.out.println("Inside Service");
		mdao.register(dto);
	}

	@Override
	public boolean login(ModelDTO dto) {
		// TODO Auto-generated method stub
		System.out.println("Inside Service");
		boolean b=mdao.login(dto);
		return b;
		
	}

	



}
