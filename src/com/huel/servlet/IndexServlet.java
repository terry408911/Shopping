package com.huel.servlet;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huel.dao.GoodsDao;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request,HttpServletResponse response){
		ResultSet books = null;
		books = GoodsDao.getAllGoods();
		request.setAttribute("books", books);
		try {
			request.getRequestDispatcher("ShowGoods.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response){
		this.doGet(request, response);
	}
}
