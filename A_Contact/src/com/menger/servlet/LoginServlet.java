package com.menger.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		String name = request.getParameter("name");
		String psw = request.getParameter("password");
		if ("root".equals(name)&&"root".equals(psw)) {
			session.setAttribute("username", name);
			response.sendRedirect(request.getContextPath() + "/list");
			return;
		}else{
			request.setAttribute("msg", "用户名或者密码错误");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

}
