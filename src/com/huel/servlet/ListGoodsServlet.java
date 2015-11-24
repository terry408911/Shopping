package com.huel.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huel.dao.GoodsDao;
@WebServlet("/ListBook")
public class ListGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		@SuppressWarnings("unused")
		PrintWriter out = resp.getWriter();
		//////////////////////////////////////////////////////
		//Collection<Goods> books = BookDB.getAll();
		//����һ�ε���ҵ
		
		ResultSet allGoods=GoodsDao.getAllGoods();
		req.setAttribute("goods",allGoods);
		req.getRequestDispatcher("ShowGoods.jsp").forward(req, resp);
		
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp){
		try {
			this.doGet(req,resp);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}