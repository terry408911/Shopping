package com.huel.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huel.dao.GoodsDao;
import com.huel.model.Goods;
@WebServlet("/ListBook")
public class ListGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		//////////////////////////////////////////////////////
		//Collection<Goods> books = BookDB.getAll();
		//接上一次的作业
		
		LinkedList<Goods> allGoods=GoodsDao.getAllGoods();
		req.setAttribute("goods",allGoods);
		req.getRequestDispatcher("ShowGoods.jsp").forward(req, resp);
		//////////////////////////////////////////////////////////
			}
}