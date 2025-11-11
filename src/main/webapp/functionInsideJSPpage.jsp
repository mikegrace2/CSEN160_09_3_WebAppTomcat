<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
// function declaration
String makeItLower(String data){
	return data.toLowerCase();
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	Lower case "Hello World": <%=makeItLower("Hello World") %>
</body>
</html>