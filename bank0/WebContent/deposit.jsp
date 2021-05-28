<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%		
		String msg = (String)request.getAttribute("error");
		if(msg==null)
			msg="";
	%>
	<%= msg %>
	<form action="deposit.do" method="post">
		MONEY : <input type="text" name="money" /><br>		
		<input type="submit" value="DEPOSIT" />
	</form>	
</body>
</html>