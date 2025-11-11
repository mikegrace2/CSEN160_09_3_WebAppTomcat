<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="csen160.DatabaseSimpleClass" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Database Access Example (Servlet)!</h1>
	<table>
		<tr>
			<th>Coffee Name</th>
			<th>Supplier ID</th>
			<th>Price</th>
			<th>Sales</th>
			<th>Total</th>
		</tr>
		<% 
			String[][] myJSPArray = DatabaseSimpleClass.getTable();
			
			if (myJSPArray == null){
				out.println("ERROR ERROR ERROR ERROR ERROR ERROR\n");
			}else{
				for (int i=0;i<myJSPArray.length;i++) {
					out.println("  <tr>\n");									
					out.println("    <td>" + myJSPArray[0][i] + "</td>\n"); 
					out.println("    <td>" + myJSPArray[1][i] + "</td>\n");
					out.println("    <td>" + myJSPArray[2][i] + "</td>\n");
					out.println("    <td>" + myJSPArray[3][i] + "</td>\n");
					out.println("    <td>" + myJSPArray[4][i] + "</td>\n");
					out.println("  </tr>\n");						
				}
			}
		%>			
	</table>
</body>
</html>