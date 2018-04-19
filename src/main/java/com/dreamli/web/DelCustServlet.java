package com.dreamli.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dreamli.factory.BasicFactory;
import com.dreamli.service.CustomerService;

@WebServlet("/servlet/DelCustServlet")
public class DelCustServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("html/text;charset=utf-8");
		CustomerService customerService = BasicFactory.getFactory().getInstance(CustomerService.class);

		//1.获取想要删除的所有客户 ID
		String[] delIds = request.getParameterValues("delId");
		//2. 调用Service 删除待删除的客户
		customerService.deleteCustomers(delIds);
		
		//3.转发回客户列表页面
		response.sendRedirect(request.getContextPath() + "/servlet/CustList");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
