<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello World JSP</h1>

	JSPExpressions<br/>
	Server Time: <%=new java.util.Date()%><br/>
	Converting String to upper case: <%=new String("Hello World").toUpperCase() %><br/>
	25 times 5 = <%=25*5 %><br/>
	Boolean: <%=75 < 6 %><br/>
	<br/>
	Output 100 times HelloWorld<br/>
	<%
		for (int i=0;i<100;i++){
			out.println(""+i+". HelloWorld<br/>");
		}
	%>
</body>
</html>