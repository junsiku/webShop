<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%

pageContext.setAttribute("major","pageContext");
request.setAttribute("major","request");
session.setAttribute("major","session");
application.setAttribute("major"," application");


%>    
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>저장하기</h1>
<h2>default : ${major }</h2>
<h2>pageContext : ${pageScope.major }</h2>
<h2>request : ${requestScope.major }</h2>
<h2>session : ${sessionScope.major }</h2>
<h2>application : ${applicationScope.major }</h2>
<hr>


<%-- <jsp:forward page="ScopeTest2.jsp"></jsp:forward>
 --%>
 
 <%-- 갔다가 다시온다. --%>
 <jsp:include page="ScopeTest2.jsp"></jsp:include> 
 
 

</body>
</html>