package com.company.spring.daolayer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.company.spring.model.Mail_info;

import com.company.spring.model.User_info;

@Component
public class MyDaoImp implements MyDao {
	@Autowired
	SessionFactory sf;

	@Override
	public boolean register(User_info dto) {
		// TODO Auto-generated method stub
		System.out.println("Inside dao");
		Session ss = sf.openSession();
		Criteria cr = ss.createCriteria(User_info.class);
		cr.add(Restrictions.eq("Email", dto.getEmail()));
		User_info mdto = (User_info) cr.uniqueResult();
		if (mdto != null) {
			System.out.println("inside if");
			return false;
		} else if (dto.getPassword().isEmpty() || dto.getEmail().isEmpty() || dto.getSAnswer().isEmpty()) {
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
	public boolean login(User_info dto, HttpSession session) {
		// TODO Auto-generated method stub
		System.out.println("Inside dao");
		Session ss = sf.openSession();
		String email = (String) session.getAttribute("email");
		Criteria cr = ss.createCriteria(User_info.class);
		cr.add(Restrictions.eq("Email", dto.getEmail()));
		cr.add(Restrictions.eq("Password", dto.getPassword()));
		User_info mdto = (User_info) cr.uniqueResult();
		if (mdto != null) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean compose(Mail_info dto, User_info udto, HttpServletRequest request, HttpSession session) {
		// TODO Auto-generated method
		System.out.println("Inside dao");
		Session ss = sf.openSession();
		String email = (String) session.getAttribute("email");
		System.out.println("sender:" + email);

		Criteria cr = ss.createCriteria(User_info.class);
		cr.add(Restrictions.eq("Email", dto.getTo_id()));
		User_info udto1 = (User_info) cr.uniqueResult();
		// Criteria cr1=ss.createCriteria(EmailDT0.class);
		// cr1.add(Restrictions.eq("receiver",dto.getReceiver()));
		// EmailDT0 dto1=(EmailDT0)cr1.uniqueResult();
		dto = new Mail_info();
		if (email != null) {
			String receiver = request.getParameter("To_id");
			if (udto1 == null) {
				String subject = request.getParameter("Subject");
				String body = request.getParameter("Body");
				dto.setBody(body);
				if (dto.getTo_id() == null) {
					dto.setTo_id("0");

				} else {
					dto.setTo_id("receiver" + "0");
				}

				dto.setSubject(subject);
				dto.setForm_id(email);
				dto.setStatus("1");
				ss.save(dto);
				ss.beginTransaction().commit();
				ss.close();
				return true;
			} else {
				String subject = request.getParameter("Subject");
				String body = request.getParameter("Body");
				dto.setBody(body);
				dto.setTo_id(receiver);
				dto.setSubject(subject);
				dto.setForm_id(email);
				dto.setStatus("1");
				ss.save(dto);
				ss.beginTransaction().commit();
				ss.close();
				return true;
			}

		}
		return false;

	}

	@Override
	public List<Mail_info> draft(Mail_info dto, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw;
		String email = (String) session.getAttribute("email");

		try {
			pw = response.getWriter();
			Session ss = sf.openSession();
			if (email != null) {

				Criteria cr = ss.createCriteria(Mail_info.class);
				String check = "0";
				cr.add(Restrictions.eq("To_id", check));
				cr.add(Restrictions.eq("Form_id", email));
				cr.add(Restrictions.eq("Status", "1"));
				// cr.add(Restrictions.ne("Status","0"));
				List<Mail_info> list = cr.list();
				// pw.print("<table border=2 align=center
				// ><tr><th>Body</th><th>Receiver</th><th>Sender</th><th>subject</th></tr>");
//		 for (Mail_info ele : list) {
//			// pw.println("<tr><td>"+ele.getBody()+"</td><td>"+ele.getTo_id()+"</td><td>"+ele.getForm_id()+"</td><td>"+ele.getSubject() +"</td></tr>");
//			
//		}
				System.out.println(list);
				return list;
			} else {
				return null;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public List<Mail_info> inbox(Mail_info dto, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw;
		try {
			pw = response.getWriter();
			Session ss = sf.openSession();
			String email = (String) session.getAttribute("email");
			if (email != null) {
				Query qry = ss.createQuery(
						" from Mail_info where To_id=:receiver and Status IN('1','-4') ");
				qry.setParameter("receiver",email);
			   // int selected = qry.executeUpdate();
				//System.out.println("selected:" + selected);
				//ss.beginTransaction().commit();
				//ss.close();
		        List<Mail_info> list = qry.list();
				for (Mail_info ele : list) {
					System.out.println("TO:" + ele.getTo_id() + "from:" + ele.getForm_id() + "sub:" + ele.getId());

				}
				System.out.println(list);

				System.out.println(list);
				ss.close();
				return list;
			} else {
				return null;
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Mail_info> sentbox(Mail_info dto, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		response.setContentType("text/html");
		PrintWriter pw;
		try {
			pw = response.getWriter();

			Session ss = sf.openSession();
			String email = (String) session.getAttribute("email");
			if (email != null) {
				Query qry = ss.createQuery(" from Mail_info where Form_id=:sender and Status IN('1','-3') ");
				qry.setParameter("sender",email);
			   // int selected = qry.executeUpdate();
				// System.out.println("selected:" + selected);
				// cr.add(Restrictions.ne("Status","0"));
                 List<Mail_info> list = qry.list();
                 System.out.println(list);
                 ss.close();
				return list;
				
			} else {
				return null;
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
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

	@Override
	public boolean forgot(User_info dto, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// TODO Auto-generated method stub
		System.out.println("Inside dao");
		Session ss = sf.openSession();
		String Password = request.getParameter("Password");
		Criteria cr = ss.createCriteria(User_info.class);
		cr.add(Restrictions.eq("Email", dto.getEmail()));
		cr.add(Restrictions.eq("SAnswer", dto.getSAnswer()));
		User_info mdto = (User_info) cr.uniqueResult();
		if (mdto != null) {
			mdto.setPassword(Password);
			ss.save(mdto);
			ss.beginTransaction().commit();
			ss.close();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean change(User_info dto, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// TODO Auto-generated method stub
		System.out.println("Inside dao");
		Session ss = sf.openSession();
		String password = request.getParameter("Password");
		String npassword = request.getParameter("nPassword");
		String cpassword = request.getParameter("cPassword");
		Criteria cr = ss.createCriteria(User_info.class);
		cr.add(Restrictions.eq("Email", dto.getEmail()));
		cr.add(Restrictions.eq("Password", dto.getPassword()));
		User_info mdto = (User_info) cr.uniqueResult();
		if (mdto != null && npassword.equals(cpassword)) {
			mdto.setPassword(npassword);
			ss.save(mdto);
			ss.beginTransaction().commit();
			ss.close();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean deletetempinbdao(Mail_info dto, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// TODO Auto-generated method stub
		String sid = request.getParameter("id");
		Session ss = sf.openSession();
		String email = (String) session.getAttribute("email");
		int id = Integer.parseInt(sid);
		if (sid != null) {
			Criteria cr = ss.createCriteria(Mail_info.class);
			cr.add(Restrictions.eq("id", dto.getId()));
			Mail_info mdto = (Mail_info) cr.uniqueResult();
			if (mdto != null) {
				if(mdto.getForm_id().equals(mdto.getTo_id())) 
				{   if(mdto.getStatus().equals("-4")) {
					mdto.setStatus("-1");
				}
				else {
					mdto.setStatus("-3");
				}
				}else {
				mdto.setStatus("-1");
				}
				ss.save(mdto);
				ss.beginTransaction().commit();
				ss.close();
				return true;
			} else {
				return false;
			}

		} else {
			return false;

		}

	}	public boolean deletetempdraftdao(Mail_info dto, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// TODO Auto-generated method stub
		String sid = request.getParameter("id");
		Session ss = sf.openSession();
		String email = (String) session.getAttribute("email");
		int id = Integer.parseInt(sid);
		if (sid != null) {
			Criteria cr = ss.createCriteria(Mail_info.class);
			cr.add(Restrictions.eq("id", dto.getId()));
			Mail_info mdto = (Mail_info) cr.uniqueResult();
			if (mdto != null) {
				mdto.setStatus("0");
				ss.save(mdto);
				ss.beginTransaction().commit();
				ss.close();
				return true;
			} else {
				return false;
			}

		} else {
			return false;

		}

	}
	
	
	public boolean deletetempsentdao(Mail_info dto, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// TODO Auto-generated method stub
		String sid = request.getParameter("id");
		Session ss = sf.openSession();
		String email = (String) session.getAttribute("email");
		int id = Integer.parseInt(sid);
		if (sid != null) {
			Criteria cr = ss.createCriteria(Mail_info.class);
			cr.add(Restrictions.eq("id", dto.getId()));
			Mail_info mdto = (Mail_info) cr.uniqueResult();
			if (mdto != null) {
				if(mdto.getTo_id().equals(mdto.getForm_id())) {
					if(mdto.getStatus().equals("-3")) {
						mdto.setStatus("-2");
					}
					else {
					    mdto.setStatus("-4");
					}
				}
				else {
				mdto.setStatus("-2");
				}
				ss.save(mdto);
				ss.beginTransaction().commit();
				ss.close();
				return true;
			} else {
				return false;
			}

		} else {
			return false;

		}

	}

	@Override
	public boolean deleteitemperm(Mail_info dto, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// TODO Auto-generated method stub
		String sid = request.getParameter("id");
		Session ss = sf.openSession();
		String email = (String) session.getAttribute("email");
		int id = Integer.parseInt(sid);
		if (sid != null) {
			Criteria cr = ss.createCriteria(Mail_info.class);
			cr.add(Restrictions.eq("id", dto.getId()));
			Mail_info mdto = (Mail_info) cr.uniqueResult();
			if (mdto != null) {
				Query qry = ss.createQuery("Delete from Mail_info where id=:id");
				qry.setParameter("id", id);
				int deleted = qry.executeUpdate();
				System.out.println("deleted:" + deleted);
				ss.beginTransaction().commit();
				ss.close();
				return true;
			}

		} else {
			ss.close();
			return false;
		}
		ss.close();
		return false;

	}

	@Override
	public List<Mail_info> fetchdelete(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub

		response.setContentType("text/html");
		PrintWriter pw;
		try {
			pw = response.getWriter();

			Session ss = sf.openSession();
			String email = (String) session.getAttribute("email");
			System.out.println(email);
			if (email != null) {
				// Criteria cr=ss.createCriteria(Mail_info.class);
				// String check="0";

				// cr.add(Restrictions.eq("Status","0"));
				// cr.add(Restrictions.eq("To_id",email));
				// cr.add(Restrictions.eq("Form_id",email));
				Query qry = ss.createQuery(" from Mail_info where Status IN('0','-1','-2') and Form_id =:From_id or  Status IN('0','-1','-2')and To_id=:To_id ");
				qry.setParameter("From_id", email);
				qry.setParameter("To_id", email);
				List<Mail_info> list = qry.list();
				System.out.println(list);
				return list;
			} else {
				return null;
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("Inside catch");
			return null;

		}

	}

	@Override
	public Mail_info fetchbody(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		String sid = request.getParameter("id");
		Session ss = sf.openSession();
		String email = (String) session.getAttribute("email");
		System.out.println(email);
		int id = Integer.parseInt(sid);
		if (email != null) {
			Criteria cr = ss.createCriteria(Mail_info.class);
			cr.add(Restrictions.eq("id", id));
			Mail_info mdto = (Mail_info) cr.uniqueResult();

			return mdto;

		} else {
			return null;
		}

	}

	@Override
	public boolean composeedit(HttpServletRequest req, HttpSession session) {
		// TODO Auto-generated method stub
		Session ss = sf.openSession();
		String receiver = req.getParameter("To_id");
		Criteria cr = ss.createCriteria(User_info.class);
		cr.add(Restrictions.eq("Email", receiver));
		User_info udto1 = (User_info) cr.uniqueResult();
		if (udto1 != null) {
			String subject = req.getParameter("Subject");
			String body = req.getParameter("Body");

			String sid = req.getParameter("id");
			int id = Integer.parseInt(sid);
			Query qry = ss.createQuery(
					"Update from Mail_info set To_id=:receiver , Subject=:sub ,Body=:body , Status=1 where id=:id");
			qry.setParameter("receiver", receiver);
			qry.setParameter("sub", subject);
			qry.setParameter("body", body);
			qry.setParameter("id", id);
			int updated = qry.executeUpdate();
			System.out.println("updated:" + updated);
			ss.beginTransaction().commit();
			ss.close();
			return true;

		} else {
			String subject = req.getParameter("Subject");
			String body = req.getParameter("Body");

			String sid = req.getParameter("id");
			int id = Integer.parseInt(sid);
			Query qry = ss.createQuery(
					"Update from Mail_info set To_id=:receiver , Subject=:sub ,Body=:body , Status=1 where id=:id");
			qry.setParameter("receiver", "0");
			qry.setParameter("sub", subject);
			qry.setParameter("body", body);
			qry.setParameter("id", id);
			int updated = qry.executeUpdate();
			System.out.println("updated:" + updated);
			ss.beginTransaction().commit();
			ss.close();
			return false;
			
		}

	}

}
