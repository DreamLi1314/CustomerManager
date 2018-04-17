package com.dreamli.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.dreamli.util.DaoUtil;

/**
 * @Description: 添加用户 
 * @Warning: 
 * @Author: dreamli
 * @Package: CustomerManager - com.dreamli.web.AddCustomerServlet.java
 * @Date: 2018年4月18日 上午12:08:27
 * @Version: 1.0.0
 */
@WebServlet("/servlet/addCustomer")
public class AddCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DataSource dataSource = DaoUtil.getDataSource();
		System.out.println(dataSource);
		try {
			Connection connection = dataSource.getConnection();
			System.out.println(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
