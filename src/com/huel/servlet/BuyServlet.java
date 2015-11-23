package com.huel.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.huel.dao.GoodsDao;
import com.huel.model.Goods;
import com.huel.model.ShoppingCart;
import com.huel.model.ShoppingCartItem;

public class BuyServlet extends HttpServlet{
  
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// TODO Auto-generated method stub
		   // num
		   //Goods g
		
		   String id=req.getParameter("id");
		   int num=Integer.parseInt(req.getParameter("num"));
		   GoodsDao gd=new GoodsDao();
		   Goods g=gd.getGoodsById(id);
		   
		   
		   
		   ShoppingCartItem si=new ShoppingCartItem();
		   si.setGoods(g);
		   si.setNum(num);
		   HttpSession session=req.getSession();
		   ShoppingCart sc=(ShoppingCart)session.getAttribute("shoppingCart");
		   if(sc==null)
		   {
			   sc=new ShoppingCart();
		   }
		   sc.getShoppingList().add(si);
		   session.setAttribute("shoppingCart", sc);
		    
		}
	
  @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}
