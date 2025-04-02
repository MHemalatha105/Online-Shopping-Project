package com.ssd.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssd.Dbcoonection.DbConnection;
import com.ssd.Dto.ProductDto;

public class ProductDao {

	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	public List<ProductDto> getAllProducts(){
		
		
		  List<ProductDto> AllproductList = new ArrayList<>();
		  
		  try {
			  conn = DbConnection.getDbConnection();
			  
			   String queary ="select * from products";
			   ps=conn.prepareStatement(queary);
			   
			   rs=ps.executeQuery();
			   
			
			while(rs.next()) {
				ProductDto 
					dto = new ProductDto();
				//id, name, category, price, image
      dto.setId(rs.getInt(1));
      dto.setName(rs.getString(2));
      dto.setCategory(rs.getString(3));
      dto.setPrice(rs.getDouble(4));
      dto.setImage(rs.getString(5));
      
      AllproductList.add(dto);
      

			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return AllproductList;
		 	
	}
}

