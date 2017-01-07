package com.menger.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.menger.entity.Contact;
import com.menger.service.ContactService;
import com.menger.service.ContactServiceImpl;

public class UpdateContactServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		if (username==null) {
			response.sendRedirect(request.getContextPath() + "/index.jsp");
			return;
		}
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String age = request.getParameter("age");
		String jiguan = request.getParameter("jiguan");
		String qq = request.getParameter("qq");
		String email = request.getParameter("email");
		Contact contact = new Contact(id, name, gender, Integer.parseInt(age), jiguan, qq, email);
		ContactService contactService = new ContactServiceImpl();
		contactService.updateContact(contact);
		response.sendRedirect(request.getContextPath() + "/list");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

}
