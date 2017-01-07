package com.menger.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.menger.entity.Contact;
import com.menger.exception.NameExistException;
import com.menger.service.ContactService;
import com.menger.service.ContactServiceImpl;

public class AddContactServlet extends HttpServlet {

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
		//1. 得到表单提交的数据
		String name = request.getParameter("name").trim();
		if (name.equals("")) {
			request.setAttribute("msg", "用户名不能为空");
			request.getRequestDispatcher("/add.jsp").forward(request, response);
			return;
		}
		String gender = request.getParameter("gender");
		String age = request.getParameter("age");
		String jiguan = request.getParameter("jiguan");
		String qq = request.getParameter("qq");
		String email = request.getParameter("email");
		//2. 封装成实例类
		Contact contact = new Contact("", name, gender, Integer.parseInt(age), jiguan, qq, email);
		ContactService contactService = new ContactServiceImpl();
		try {
			contactService.addContact(contact);
			response.sendRedirect(request.getContextPath() + "/list");
		} catch (NameExistException e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/add.jsp").forward(request, response);
			return;
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

}
