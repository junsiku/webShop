<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean  id="m"  class="com.kosta.controller.pro13.MemberBean"  scope="page"/>


 <jsp:getProperty name="m"  property="id"  /> 
         <jsp:getProperty name="m"  property="pwd"  />               
           <jsp:getProperty name="m"  property="name"     /> 
          <jsp:getProperty name="m"  property="email"  /> 
</body>
</html>