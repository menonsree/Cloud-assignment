<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>

<title>Student Details</title>
</head>
<body>
<h1>Student Details</h1>
<form action="Myapp" method="post">
Name<input type="text" name="name"/><br></br>
Roll number<input type="text" name="rollno"/><br></br>
DOB<input type="text" name="DOB"/><br></br>

<input type="submit" value="Submit" />
</form>
</body>
</html>
