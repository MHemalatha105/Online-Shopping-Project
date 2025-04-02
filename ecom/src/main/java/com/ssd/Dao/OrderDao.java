package com.ssd.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ssd.Dbcoonection.DbConnection;
import com.ssd.Dto.OrdersDto;

public class OrderDao {
	
	public Connection conn=null;
	public PreparedStatement ps=null;
	public ResultSet rs=null;
	
	//order_id, product_id, user_id, order_quantity, order_date
	
	public static String INSERTORDERS = "INSERT INTO orders (product_id,  user_id, order_quantity, order_date) VALUES (?,?,?,?)";

    public void placeOrder(OrdersDto dto) {
    	
    	
		 try {
			 conn = DbConnection.getDbConnection();
			ps = conn.prepareStatement(INSERTORDERS);
			
			ps.setInt(1, dto.getId());
			 ps.setInt(2, dto.getUserId());
			 ps.setInt(3, dto.getNoofOrders());
			 ps.setDate(4, dto.getOrderDate());
			
			 ps.executeUpdate();
			 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
		 public void placeAllOrders(List<OrdersDto> orderList) {

				try {
					
					conn = DbConnection.getDbConnection();
					
					for(OrdersDto dto:orderList) {
					
					
					 ps = conn.prepareStatement(INSERTORDERS);
					 ps.setInt(1, dto.getId());
					 ps.setInt(2, dto.getUserId());
					 ps.setInt(3, dto.getNoofOrders());
					 ps.setDate(4, dto.getOrderDate());
					 
					 ps.executeUpdate();
					}

    	
    
				}catch (Exception e) {
					// TODO: handle exception
				}
           }
    }
