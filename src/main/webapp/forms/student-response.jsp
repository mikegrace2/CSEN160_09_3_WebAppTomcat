<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	First Name = <%=request.getParameter("firstname") %><br/>
	Last Name = <%=request.getParameter("lastname") %><br/>
	<br/>
	The student is confirmed: ${param.firstname} ${param.lastname}<br/>
	The students country is: ${param.country}<br/>
</body>
</html>