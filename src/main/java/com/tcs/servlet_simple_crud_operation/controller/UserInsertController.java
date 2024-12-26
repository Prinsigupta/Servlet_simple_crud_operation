package com.tcs.servlet_simple_crud_operation.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.tcs.servlet_simple_crud_operation.dao.UserDao;
import com.tcs.servlet_simple_crud_operation.dto.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class UserInsertController implements Servlet{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		UserDao dao = new UserDao();
		res.setContentType("text/html");
		System.out.println("Service Method");
		
		int id=Integer.parseInt(req.getParameter("userId"));
		String name=req.getParameter("userName");
		String email=req.getParameter("userEmail");
		LocalDate dob = LocalDate.parse(req.getParameter("userDob"));
		String gender = req.getParameter("gender");
		String password = req.getParameter("password");
		
		User userr=new User(id, name, email, dob, gender, password);
		User user2=dao.saveUserDao(userr);
		PrintWriter p=res.getWriter();
		if(user2!=null) {
			
		
		p.write("<html><body><h5  style='color:green'>today date = " +LocalDateTime.now()+"</h5></body></html>");
		p.write("<html><body><h5  style='color:green'>current time = "+LocalTime.now() +"</h5></body></html>");
		p.write("successfull");
		p.write("<html><body><h5  style='color:green'>successfull</h5></body></html>");
		RequestDispatcher dispatcher=req.getRequestDispatcher("register.jsp");
		dispatcher.include(req, res);
		}
		else {
			p.write("<html><body><h5  style='color:blue'>Data-Not-Stored</h5></body></html>");
			RequestDispatcher dispatcher=req.getRequestDispatcher("register.jsp");
			dispatcher.include(req, res);
		}
		
	}

}
