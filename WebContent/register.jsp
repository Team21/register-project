<%@ page language="java" 
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
                      <h1 >注册页面</h1>
<form name="frm1" action="${pageContext.request.contextPath }/AdminServlet1?method=register" method="post" >
  		<table>
  			<tr>
  				<td>用户名</td>
  				<td>
  					<input type="text" name="username"/>
  					${requestScope.message } <!-- 如果用户名存在注册失败，给用户提示 -->
  				</td>
  			</tr>
  			<tr>
  				<td>密码</td>
  				<td><input type="password" name="password"/></td>
  			</tr>
  			<tr>
  				<td>编号</td>
  				<td><input type="text" name="id"/></td>
  			</tr>
  			<tr>
  				<td colspan="2">
  					<input type="submit" value="亲，点我注册！">
  				</td>
  			</tr>
  		</table>
  	
  	</form>



</body>
</html>