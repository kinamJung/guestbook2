<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.hanains.guestbook.dao.GuestBookDAO" %>
<%@page import="com.hanains.guestbook.vo.GuestBookVo" %>

<%--

					 방명록 애플리케이션 (MVC 패턴 적용)
			
											정기남

 --%>

<% 	
	List<GuestBookVo> list = (List<GuestBookVo>)request.getAttribute("list");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록</title>
</head>
<body>
	<form action="/guestbook2/gs" method="post">
	<input type="hidden" name="a" value="add">
	<table border=1 width=500>
		<tr>
			<td>이름</td><td><input type="text" name="name"></td>
			<td>비밀번호</td><td><input type="password" name="pass"></td>
		</tr>
		<tr>
			<td colspan=4><textarea name="content" cols=60 rows=5 ></textarea></td>
		</tr>
		<tr>
			<td colspan=4 align=right><input type="submit" VALUE=" 확인 "></td>
		</tr>
	</table>
	</form>
	<br>
	<%
		if( list != null )
		{
			for(int i = list.size() ; i > 0 ; i--){
				GuestBookVo vo = list.get(i-1);
				
				String message = vo.getMessage();
				message = message.replaceAll("\r\n", "<br>");				
	%>
	
	<table width=510 border=1>
		<tr>
			<td><%=i %></td>
			<td><%=vo.getName() %></td>
			<td><%=vo.getDate() %></td>
			<td><a href="/guestbook2/gs?no=<%=vo.getNo()%>&a=deleteForm">삭제</a></td>
		</tr>
		<tr>
			<td colspan=4 ><%=message%></td>
		</tr>
	</table>
		<br>
	<%
			}
		}
	%>
	
</body>
</html>