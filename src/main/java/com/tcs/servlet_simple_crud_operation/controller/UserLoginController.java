package com.tcs.servlet_simple_crud_operation.controller;

import java.io.IOException;

import com.tcs.servlet_simple_crud_operation.dao.UserDao;
import com.tcs.servlet_simple_crud_operation.dto.User;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class UserLoginController extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		UserDao dao = new UserDao();

		String email = req.getParameter("userEmail");
		String password = req.getParameter("password");

		User userr = dao.getUserByUserEmailDao(email);

		if (userr != null) {
			if (userr.getPassword().equals(password)) {
				req.getRequestDispatcher("display.jsp").forward(req, res);
			} else {
				req.setAttribute("msg", "Given password is incorrect");
				req.getRequestDispatcher("login.jsp").forward(req, res);
			}

		} else {
			req.setAttribute("msg", "Given email is incorrect");
			req.getRequestDispatcher("login.jsp").forward(req, res);
		}
	}

}
