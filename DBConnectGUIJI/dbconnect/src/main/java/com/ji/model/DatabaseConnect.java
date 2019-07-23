package com.ji.model;

/**
 * @author JI
 *
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DatabaseConnect {
	private Connection conn = null;
	private Statement stmt = null;

	private static final String USERNAME = "username";
	private static final String PASSWORD = "password";
	private static final String URL 
	= "jdbc:oracle:thin:@localhost:1521:orcl";

	public DatabaseConnect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			System.out.println("DB Connection OK!");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("DB Driver Error!");
		}catch(SQLException se) {
			se.printStackTrace();
			System.out.println("DB Connection Error!");
			
		}
	}
	
	public ArrayList<CustomerVO> selectCustomer(String condition) {
		String sql = "select * from Customer ";
		sql+=condition;
		PreparedStatement pstmt = null;
		ArrayList<CustomerVO> arrCustomerVO = new ArrayList<CustomerVO>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				CustomerVO tempCustomerVO = new CustomerVO(rs.getString("cusID"),
						 rs.getString("cusName"),
						 rs.getInt("age"),
						 rs.getString("rank"),
						 rs.getString("job"),
						 rs.getInt("reserve"));
				arrCustomerVO.add(tempCustomerVO);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return arrCustomerVO;
	}
	
	public ArrayList<ProductVO> selectProduct(String condition) {
		String sql = "select * from Product ";
		sql+=condition;
		PreparedStatement pstmt = null;
		ArrayList<ProductVO> arrProductVO = new ArrayList<ProductVO>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ProductVO tempProductVO = new ProductVO(rs.getString("prodNo"),
						 rs.getString("prodName"),
						 rs.getInt("invertory"),
						 rs.getInt("price"),
						 rs.getString("manufacturer"));
				arrProductVO.add(tempProductVO);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return arrProductVO;
	}
	
	public ArrayList<CusOrderVO> selectCusOrder(String condition) {
		String sql = "select * from CusOrder ";
		sql+=condition;
		PreparedStatement pstmt = null;
		ArrayList<CusOrderVO> arrCusOrderVO = new ArrayList<CusOrderVO>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				CusOrderVO tempCustomerVO = new CusOrderVO(rs.getString("orderNo"),
						 rs.getString("orderCus"),
						 rs.getString("orderPro"),
						 rs.getInt("quantity"),
						 rs.getString("address"),
						 rs.getString("orderDate"));
				arrCusOrderVO.add(tempCustomerVO);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return arrCusOrderVO;
	}
	
	public ArrayList<DescribeTableVO> getTableDescription(String tableName) {
		String sql = "select COLUMN_NAME from COLS where table_name=?";
		PreparedStatement pstmt = null;
		ArrayList<DescribeTableVO> arrDescribeTableVO = new ArrayList<DescribeTableVO>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tableName.toUpperCase());
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.println("getTableDescription");
				System.out.println(rs.getString("COLUMN_NAME"));
				DescribeTableVO tempDescribeTableVO = new DescribeTableVO(rs.getString("COLUMN_NAME"));
				arrDescribeTableVO.add(tempDescribeTableVO);
			}
	
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return arrDescribeTableVO;
	}

	public void insertCustomer(String cusID, String cusName, int age, 
															String rank, String job, int reserve) {
		String sql = "insert into Customer values (?,?,?,?,?,?)";
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cusID);
			pstmt.setString(2, cusName);
			pstmt.setInt(3, age);
			pstmt.setString(4, rank);
			pstmt.setString(5, job);
			pstmt.setInt(6, reserve);
			pstmt.executeUpdate();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void insertProduct(String prodNo, String prodName, int invertory, int price, String manufacturer) {
		String sql = "insert into Product values (?,?,?,?,?)";
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, prodNo);
			pstmt.setString(2, prodName);
			pstmt.setInt(3, invertory);
			pstmt.setInt(4, price);
			pstmt.setString(5, manufacturer);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void insertCusOrder(String orderNo, String orderCus, String orderPro, int quantity, String address, String orderDate) {
		String sql = "insert into CusOrder values (?,?,?,?,?,?)";
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, orderNo);
			pstmt.setString(2, orderCus);
			pstmt.setString(3, orderPro);
			pstmt.setInt(4, quantity);
			pstmt.setString(5, address);
			pstmt.setString(6, orderDate);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	

}
