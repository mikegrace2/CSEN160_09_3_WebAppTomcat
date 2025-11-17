<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			<th>Account Number</th>
			<th>Holder Name</th>
			<th>Balance</th>
			<th>Account Type</th>
		</tr>
		<% 
			String[][] myJSPArray=(String[][])session.getAttribute("myArr");
			
			if (myJSPArray == null || myJSPArray.length == 0) {
				out.println("<h1>ERROR No data found!!! ERROR</h1>\n");
                out.println("<h1>ERROR No data found!!! ERROR</h1>\n");
                out.println("<h1>ERROR No data found!!! ERROR</h1>\n");
			}else{
				for (int i=0;i<myJSPArray.length;i++) {
					if (myJSPArray[i][0] == null)
						continue;
					out.println("  <tr>\n");									
					out.println("    <td>" + myJSPArray[i][0] + "</td>\n"); 
					out.println("    <td>" + myJSPArray[i][1] + "</td>\n");
					out.println("    <td>" + myJSPArray[i][2] + "</td>\n");
					out.println("    <td>" + myJSPArray[i][3] + "</td>\n");
					out.println("  </tr>\n");					
				}
			}
		%>			
	</table>
</body>
</html>