package com.ssd.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssd.Dbcoonection.DbConnection;
import com.ssd.Dto.CartDto;
import com.ssd.Dto.ProductDto;

public class CartDao {
	
	public Connection conn = null;
	public PreparedStatement ps=null;
	public ResultSet rs= null;
	
	
	

	public static String ALLPRODUCTS = "select * from products where id=?";
	
	public static String INSERCARTLIST="INSERT INTO cart_list(pId, uId, quantity)values(?,?,?)";
	
	public static String CARTLIST="select * from cart_list where uId=?";
	
	public static String REMOVECARTLIST="delete from cart_list where uId=?";

	public List<CartDto> getAllProducts(List<CartDto> oldCartList) {
		List<CartDto> newproducList = new ArrayList<>();
		try {

			conn = DbConnection.getDbConnection();

			for (CartDto dto : oldCartList) {
				ps = conn.prepareStatement(ALLPRODUCTS);
				ps.setInt(1, dto.getId());
				rs = ps.executeQuery();
				// id, name, category, price, image
				
				CartDto newDto = new CartDto();
				while (rs.next()) {
					
					newDto.setId(rs.getInt("id"));
					newDto.setName(rs.getString("name"));
					newDto.setCategory(rs.getString("category"));
					Double price = rs.getDouble("price");
					newDto.setQuantity(dto.getQuantity());
					Double productPrice = price * dto.getQuantity();
					newDto.setPrice(productPrice);
					
				}newproducList.add(newDto);
			}

		} catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
		}
		return newproducList;

		
	}public void saveCartData(List<CartDto> cartList,Integer uId) {
		
		
		conn=DbConnection.getDbConnection();
		 try {
			 for(CartDto dto:cartList) {
			ps=conn.prepareStatement(INSERCARTLIST);
			
			ps.setInt(1,dto.getId() );
			ps.setInt(2, uId);
			ps.setInt(3, dto.getQuantity());
			
			ps.executeUpdate();
			 }
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		 
	}
	
	public List<CartDto> getCartList(Integer uId){
		List<CartDto> cartList = new ArrayList<>();
		conn=DbConnection.getDbConnection();
		
		try {
			ps=conn.prepareStatement(CARTLIST);
			
			ps.setInt(1, uId);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				CartDto newdto = new CartDto();
				
				newdto.setId(rs.getInt("pId"));
				
				newdto.setQuantity(rs.getInt("quantity"));
				cartList.add(newdto);
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return cartList;
		
	}
public void revomeCartListByUserId(Integer uId) {
		
		try {
			conn=DbConnection.getDbConnection();
			
			ps=conn.prepareStatement(REMOVECARTLIST);
			ps.setInt(1, uId);
			
			ps.executeQuery();
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}

	}


	}
	
	