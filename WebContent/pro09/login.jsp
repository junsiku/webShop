<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
</head>
<body>
  <form name="frmLogin" method="post" action="loginpost"  encType="UTF-8">
	   아이디  :<input type="text" name="user_id"><br>
       비밀번호:<input type="password" name="user_pw" ><br>
    <input type="submit" value="로그인후 직원조회">  
    <input type="reset" value="다시입력">
    <input type="hidden" name="phone" value="010-1234-7889">
    <input type="hidden" name="address" value="서울시 노원구">
    <input type="hidden" name="email" value="zzilre1004@daum.net">
  </form>
 
</body>
</html>