package com.company.shop;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class ProductOper {
	public static void showitem(Session ss) {
		
		Query query=ss.createQuery("from Product_info");
		List<Product_info> list=query.list();
		System.out.println(list);
		
	}
	public static void searchitem(Session ss) {
	
		
		
	}

}
