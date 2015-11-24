package com.huel.dao;

import java.sql.ResultSet;


import com.huel.model.Goods;

public class GoodsDao {
   public static Goods getGoodsById(String id){
	   Goods good = null;
	   MySQL mySQL = new MySQL();
	   good = mySQL.queryById(id);
	return good;
	
   };
   
   public static ResultSet getAllGoods()
   {
	   ResultSet goods = null;
	   MySQL mySQL = new MySQL();
	   mySQL.queryAll();
	   return goods;
   }
}
