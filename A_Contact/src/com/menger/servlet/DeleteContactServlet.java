package com.menger.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.menger.service.ContactService;
import com.menger.service.ContactServiceImpl;

public class DeleteContactServlet extends HttpServlet {

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
		ContactService contactService = new ContactServiceImpl();
		contactService.deleteContact(id);
		response.sendRedirect(request.getContextPath() + "/list");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

}
