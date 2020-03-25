package com.javaeetest.dao.impl;

import java.util.List;

import com.javaeetest.common.dao.impl.BaseDaoImpl;
import com.javaeetest.dao.OrdersBookDao;
import com.javaeetest.entity.Order;
import com.javaeetest.entity.OrdersBook;

public class OrdersBookDaoImpl extends BaseDaoImpl<OrdersBook> implements OrdersBookDao {
	public List<OrdersBook> allOrdersbookByOrders(int id)
	{
			
			String hql="select * from tb_ordersBook as ordersBook where ordersBook.orderId=?0";
			        List<OrdersBook> ordersBook=find(hql,id);
					if(ordersBook!=null&&ordersBook.size()>0)
					{   
						return ordersBook;
						
					}
					
					return null;
					
		}

		
	public void addOrdersbook(OrdersBook ordersbook){
		save(ordersbook);
	}
	
	

}
