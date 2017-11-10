<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<a href="helloworld">hello world</a><br/><br/>

<a href="springmvc/testPathVariable/12">testPathVariable</a><br/><br/>

<a href="springmvc/testRequestParam?username=joke&age=20">testRequestParam</a><br/><br/>

<a href="springmvc/testCookieValue">testCookieValue</a><br/><br/>

<a href="springmvc/testRequestHeader">testRequestHeader</a><br/><br/>

<form action="springmvc/testPojo" method="post">
    username: <input type="text" name="username"><br>
    password: <input type="password" name="password"><br>
    email: <input type="text" name="email"><br>
    age: <input type="text" name="age"><br>
    city: <input type="text" name="address.city"><br>
    province: <input type="text" name="address.province"><br>
    <input type="submit" value="submit">
</form><br/><br/>

<a href="springmvc/testModelAndView">testModelAndView</a><br/><br/>	

<a href="list">list all employees</a><br/><br/>	


</body>
</html>