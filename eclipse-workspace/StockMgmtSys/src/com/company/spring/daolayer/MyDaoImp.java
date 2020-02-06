package com.company.spring.daolayer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.company.spring.model.Addcart;
import com.company.spring.model.Products_info;
import com.company.spring.model.Stock_User_info;

@Component
public class MyDaoImp implements MyDao {
	@Autowired
	SessionFactory sf;
	List<Products_info> cartlist;

	@Override
	public boolean register(Stock_User_info dto) {
		// TODO Auto-generated method stub
		System.out.println("Inside dao");
		Session ss = sf.openSession();
		Criteria cr = ss.createCriteria(Stock_User_info.class);
		cr.add(Restrictions.eq("Email", dto.getEmail()));
		Stock_User_info mdto = (Stock_User_info) cr.uniqueResult();
		if (mdto != null) {
			System.out.println("inside if");
			return false;
		} else if (dto.getPassword().isEmpty() || dto.getEmail().isEmpty()) {
			System.out.println("inside else if");
			return false;
		} else {
			System.out.println("inside else ");
			ss.save(dto);
			ss.beginTransaction().commit();
			ss.close();
			return true;
		}

	}

	@Override
	public boolean login(Stock_User_info dto, HttpSession session) {
		// TODO Auto-generated method stub
		System.out.println("Inside dao");
		Session ss = sf.openSession();
		String email = (String) session.getAttribute("email");
		Criteria cr = ss.createCriteria(Stock_User_info.class);
		cr.add(Restrictions.eq("Email", dto.getEmail()));
		cr.add(Restrictions.eq("Password", dto.getPassword()));
		Stock_User_info mdto = (Stock_User_info) cr.uniqueResult();
		if (mdto != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<Products_info> showprod() {
		// TODO Auto-generated method stub
		// String email=(String) session.getAttribute("email");
		System.out.println("Inside dao");
		Session ss = sf.openSession();
		Criteria cr = ss.createCriteria(Products_info.class);
		List<Products_info> userlist = cr.list();

		if (userlist != null) {
			return userlist;
		} else {
			return null;

		}

	}

	@Override
	public void addproducttodb(Products_info dto, HttpSession session, HttpServletRequest req,
			HttpServletResponse resp) {
		// TODO Auto-generated method stub
		Session ss = sf.openSession();
		ss.save(dto);
		ss.beginTransaction().commit();
		ss.close();

	}

	@Override
	public Products_info modifyprod(HttpServletRequest req) {
		System.out.println("Inside dao");
		Session ss = sf.openSession();
		String sid = req.getParameter("id");
		int id = Integer.parseInt(sid);
		Criteria cr = ss.createCriteria(Products_info.class);
		cr.add(Restrictions.eq("id", id));
		Products_info prodlist = (Products_info) cr.uniqueResult();
		System.out.println(prodlist);
		// TODO Auto-generated method stub
		if (prodlist != null) {
			return prodlist;
		} else {
			return null;
		}
	}

	@Override
	public boolean modifyprodofdb(HttpServletRequest req) {
		// TODO Auto-generated method stub
		Session ss = sf.openSession();
		String sid = req.getParameter("id");
		int id = Integer.parseInt(sid);
		System.out.println(id);
		String Pname = req.getParameter("Pname");
		System.out.println(Pname);
		String price = req.getParameter("price");
		System.out.println(price);
		double pri = Double.parseDouble(price);
		String SQuantity = req.getParameter("Quantity");
		System.out.println(SQuantity);
		int quant = Integer.parseInt(SQuantity);
		String Category = req.getParameter("Category");
		System.out.println(Category);
		String Company = req.getParameter("Company");
		System.out.println(Company);
		Query query = ss.createQuery(
				"Update from Products_info set Pname=:name ,price=:pri,Quantity=:quantity,Category=:cat,Company=:company where id=:pid ");
		query.setParameter("name", Pname);
		query.setDouble("pri", pri);
		query.setInteger("quantity", quant);
		query.setParameter("cat", Category);
		query.setParameter("company", Company);
		query.setParameter("pid", id);
		int updated = query.executeUpdate();
		System.out.println("updated" + updated);
		if (updated > 0) {
			ss.beginTransaction().commit();
			ss.close();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<Products_info> searchproduct(HttpServletRequest req) {
		// TODO Auto-generated method stub
		System.out.println("Inside dao");
		Session ss = sf.openSession();
		String search = req.getParameter("search");
		Criteria cr = ss.createCriteria(Products_info.class);
		Disjunction disCriteria = Restrictions.disjunction(); // stackoverflow
		disCriteria.add(Restrictions.eq("Pname", search));
		disCriteria.add(Restrictions.eq("Category", search));
		disCriteria.add(Restrictions.eq("Company", search));
		cr.add(disCriteria);
		List<Products_info> prodlist = cr.list();
		System.out.println(prodlist);
		// TODO Auto-generated method stub
		if (prodlist != null) {
			return prodlist;
		} else {
			return null;
		}

	}

	@Override
	public Products_info addtocart(HttpServletRequest req) {
		// TODO Auto-generated method stub
		String sid = req.getParameter("id");
		int id = Integer.parseInt(sid);
		System.out.println("Inside dao");
		Session ss = sf.openSession();
		Criteria cr = ss.createCriteria(Products_info.class);
		cr.add(Restrictions.eq("id", id));
		Products_info plist = (Products_info) cr.uniqueResult();
		if (plist != null) {
			return plist;
		}
		return null;

	}

//	@Override
//	public List<Products_info> showcart() {
//		// TODO Auto-generated method stub
//		System.out.println("Inside dao");
//		Session ss = sf.openSession();
//		if (cartlist != null) {
//			return cartlist;
//		} else {
//			return null;
//
//		}

//	}

	@Override
	public List<Products_info> addcartdata(Products_info dto, HttpSession session, HttpServletRequest req) {
		// TODO Auto-generated method stub
		String sid = req.getParameter("id");
		int id = Integer.parseInt(sid);
		String Squantity = req.getParameter("quantity");
		int quant_pur = Integer.parseInt(Squantity);
		Session ss = sf.openSession();
		Criteria cr = ss.createCriteria(Products_info.class);
		cr.add(Restrictions.eq("id", id));
		Products_info prodlist = (Products_info) cr.uniqueResult();
		if (prodlist != null) {
			System.out.println("inside dao if");
			Addcart addcart = new Addcart();
			System.out.println(prodlist.getPname());
			addcart.setPname(prodlist.getPname());

			addcart.setQuant_pur(quant_pur);
			System.out.println(prodlist.getPrice());
			addcart.setPrice(prodlist.getPrice());
			String pur_email = (String) session.getAttribute("email");
			addcart.setPur_email(pur_email);
			double temp = quant_pur * prodlist.getPrice();
			double gst = (10 * temp) / 100;
			System.out.println(gst);
			addcart.setGst(gst);
			double total_money = addcart.getGst() + (prodlist.getPrice() * addcart.getQuant_pur());
			addcart.setTotal_money(total_money);
			System.out.println(total_money);
			ss.save(addcart);
			int updated = prodlist.getQuantity() - quant_pur;

			prodlist.setQuantity(updated);
			ss.beginTransaction().commit();
			Criteria cr1 = ss.createCriteria(Addcart.class);
			cr1.add(Restrictions.eq("pur_email", pur_email));
			List<Products_info> plist = cr1.list();
			return plist;

		} else {
			System.out.println("inside dao else");
			return null;
		}

	}

	@Override
	public List<Addcart> removecart(HttpSession session, HttpServletRequest req) {
		// TODO Auto-generated method stub
		Session ss = sf.openSession();
		String sid = req.getParameter("id");
		int id = Integer.parseInt(sid);
		// int quantity=dt.getQuant_pur();
		Criteria cr = ss.createCriteria(Addcart.class);
		cr.add(Restrictions.eq("id", id));
		Addcart alist = (Addcart) cr.uniqueResult();
		if (alist != null) {
			String Pname = alist.getPname();
			int quantity = alist.getQuant_pur();
			Query qry = ss.createQuery("Delete from Addcart where id=:id");
			qry.setParameter("id", id);
			int deleted = qry.executeUpdate();
			System.out.println("deleted:" + deleted);
			ss.beginTransaction().commit();
			Criteria cr1 = ss.createCriteria(Products_info.class);

			cr1.add(Restrictions.eq("Pname", Pname));
			Products_info plist = (Products_info) cr1.uniqueResult();
			System.out.println(plist);
			if (plist != null) {
				System.out.println("inside if");
				int original_quantity = plist.getQuantity();
				System.out.println(original_quantity);
				original_quantity += quantity;
				System.out.println(original_quantity);
				plist.setQuantity(original_quantity);
				ss.beginTransaction().commit();
				Criteria cr2 = ss.createCriteria(Addcart.class);
				String Pur_email = (String) session.getAttribute("email");
				cr2.add(Restrictions.eq("pur_email", Pur_email));
				List<Addcart> a2list = cr2.list();
				return a2list;
			} else {
				System.out.println("inside else plist");
				return null;

			}

		}

		else {
			System.out.println("inside else alist");
			return null;

		}

	}

	@Override
	public double billgen(HttpSession session, HttpServletRequest req) {
		// TODO Auto-generated method stub
		// String pur_email=req.getParameter("email");
		String pur_email = (String) session.getAttribute("email");
		Session ss = sf.openSession();
		Criteria cr = ss.createCriteria(Addcart.class);
		System.out.println(pur_email);
		Query qry = ss.createQuery("SELECT SUM(total_money) FROM Addcart where pur_email=:pur_email");
		qry.setParameter("pur_email", pur_email);
		List list = qry.list();
		try {
			double total_money = (double) qry.list().get(0);
			Addcart alist = (Addcart) cr.uniqueResult();
			if (total_money > 0) {
				return total_money;
			} else {
				return 0;
			}
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public boolean logout(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw;
		try {
			pw = response.getWriter();
			session = request.getSession(false);
			if (session != null) {
				pw.println("logout success " + session.getAttribute("email"));
				session.invalidate();
				return true;

			} else {
				return false;
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

}
