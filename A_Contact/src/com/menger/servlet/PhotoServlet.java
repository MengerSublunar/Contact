package com.menger.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.menger.entity.Contact;
import com.menger.service.ContactService;
import com.menger.service.ContactServiceImpl;

public class PhotoServlet extends HttpServlet {

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
		ContactService contactService = new ContactServiceImpl();
		String id = request.getParameter("id");
		Contact contact = contactService.findById(id);
		InputStream in = null;
		ServletOutputStream out = null;
		try {
			in = contact.getPhoto().getBinaryStream();
			out = response.getOutputStream();
			byte[] b = new byte[1024];
			int len = 0;
			while((len=in.read(b))!=-1){
				out.write(b, 0, len);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if (in!=null) {
				in.close();
			}
			if (out!=null) {
				in.close();
			}
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

}
