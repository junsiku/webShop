<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
 String name2=(String)session.getAttribute("name");
 session.setAttribute("address","서울시 강남구"); 
%>     

<!DOCTYPE html>     
<html>
<head>
<meta charset="UTF-8">
<title>session 내장 객체 테스트1</title>
</head>
<body>
이름은 <%=name2 %>입니다.<br>
<p>이름은 ${ name}</p>
<p>주소은 ${ address}</p>
<p>나이은 ${ age}</p>
<p>이름은 ${ name}</p>
<p>직원정보는 ${ emp}</p>
<p>직원정보는 ${ emp.getFirst_name}</p>
<p>직원정보는 (Employee)session.getAttribute("name");</p>

<a href=session2.jsp>두번째 페이지로 이동</a>
</body>
</html>
