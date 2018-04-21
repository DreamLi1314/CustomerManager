<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户管理系统-分页查询</title>

<script type="text/javascript">
	function changeLocation(obj, max, fn) {
		var value = obj.value;
		if(isNaN(value)) {
			alert("只能输入数字.");
			obj.value="";
			return;
		} else {
			if(value < 1 || value > max) {
				alert("请输入有效范围的数字:[1, " + max + "].");
				obj.value="";
				return;
			} else {
				fn();
			}
		}
	}
	
	function changePageRows(obj) {
		changeLocation(obj, ${requestScope.pageInfo.rowCount }, function() {
			window.location.href = "${pageContext.request.contextPath }" + "/servlet/PagingQueryCust?currentPage=1"
			+ "&pageRows=" + obj.value;
		});
	}

	function skip(obj) {
		changeLocation(obj, ${requestScope.pageInfo.pageCount }, function() {
			window.location.href = "${pageContext.request.contextPath }" + "/servlet/PagingQueryCust?currentPage=" + obj.value
			+ "&pageRows=${requestScope.pageInfo.pageRows}";
		});
	}
</script>

</head>
<body style="text-align: center;">
	<div align="center">
		<h1>客户管理系统-分页查询</h1><hr/>
	
		<table border="1" width="100%">
  		<tr>
  			<th><input type="checkbox" onclick="checkAll(this)"/>&nbsp;&nbsp;全选</th>
  			<th>客户姓名</th>
  			<th>客户性别</th>
  			<th>出生日期</th>
  			<th>手机号码</th>
  			<th>电子邮箱</th>
  			<th>客户爱好</th>
  			<th>客户类型</th>
  			<th>描述信息</th>
  			<th>修改</th>
  			<th>删除</th>
  		</tr>
  		<c:forEach items="${requestScope.pageInfo.pageCusts}" var="cust">
	  		<tr>
	  			<td><input type="checkbox" name="delId" value="${cust.id }" /></td>
	  			<td><c:out value="${cust.name }"/></td>
	  			<td><c:out value="${cust.gender }"/></td>
	  			<td><c:out value="${cust.birthday }"/></td>
	  			<td><c:out value="${cust.cellphone }"/></td>
	  			<td><c:out value="${cust.email }"/></td>
	  			<td><c:out value="${cust.preference }"/></td>
	  			<td><c:out value="${cust.type }"/></td>
	  			<td><c:out value="${cust.description }"/></td>
	  			<td><a href="${pageContext.request.contextPath }/servlet/CustInfoServlet?id=${cust.id }">修改</a></td>
	  			<td><a href="${pageContext.request.contextPath }/servlet/DelCustServlet?delId=${cust.id }">删除</a></td>
	  		</tr>
  		</c:forEach>
  	</table>

  	<div>
  		<span>共 ${requestScope.pageInfo.pageCount } 页</span>
  		<a href="${pageContext.request.contextPath }/servlet/PagingQueryCust?pageRows=${requestScope.pageInfo.pageRows}">首页</a>

  		<a href="${pageContext.request.contextPath }/servlet/PagingQueryCust?currentPage=${requestScope.pageInfo.prePage}&pageRows=${requestScope.pageInfo.pageRows}">上一页</a>
  		
  		<c:forEach var="i" begin="${requestScope.pageInfo.firstPage }" end="${requestScope.pageInfo.lastPage }">
  			<c:if test="${i ==  requestScope.pageInfo.currentPage}">
  				${i }
  			</c:if>
  			<c:if test="${i !=  requestScope.pageInfo.currentPage}">
	  			<a href="${pageContext.request.contextPath }/servlet/PagingQueryCust?currentPage=${i }&pageRows=${requestScope.pageInfo.pageRows}">${i }</a>
  			</c:if>
  		</c:forEach>
  		
  		<a href="${pageContext.request.contextPath }/servlet/PagingQueryCust?currentPage=${requestScope.pageInfo.nextPage}&pageRows=${requestScope.pageInfo.pageRows}">下一页</a>
  		
  		<a href="${pageContext.request.contextPath }/servlet/PagingQueryCust?currentPage=${requestScope.pageInfo.pageCount}&pageRows=${requestScope.pageInfo.pageRows}">尾页</a>
  		
  		跳转到第 <input type="text" name="skipPageNumber" value="${requestScope.pageInfo.currentPage }" onchange="skip(this)" /> 页
  		每页显示 <input type="text" name="changePageRows" value="${requestScope.pageInfo.pageRows }" onchange="changePageRows(this)" /> 条记录
  	</div>
  	
	</div>
</body>
</html>