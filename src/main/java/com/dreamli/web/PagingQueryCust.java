package com.dreamli.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.dreamli.factory.BasicFactory;
import com.dreamli.service.CustomerService;
import com.dreamli.web.model.PageInfo;

/**
 * @Description: 分页查询客户列表 
 * @Warning: 
 * @Author: dreamli
 * @Package: CustomerManager - com.dreamli.web.PagingQueryCust.java
 * @Date: 2018年4月21日 下午4:27:24
 * @Version: 1.0.0
 */
@WebServlet("/servlet/PagingQueryCust")
public class PagingQueryCust extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("html/text;charset=utf-8");
		CustomerService customerService = BasicFactory.getFactory().getInstance(CustomerService.class);

		try {
			//1. 封装数据
			PageInfo page = new PageInfo();
			BeanUtils.populate(page, request.getParameterMap());
			//2. 调用 service 获取 PageInfo 对象,并将其放置在 request 域中
			customerService.pagingQueryCusts(page);
			
			request.setAttribute("pageInfo", page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//3. 请求转发到 pagingCustList.jsp
		request.getRequestDispatcher("/jsp/pagingCustList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
