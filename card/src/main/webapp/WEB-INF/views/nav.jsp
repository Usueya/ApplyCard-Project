<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
	<style>
		ul {
		  list-style-type: none;
		  margin: 0;
		  padding: 0;
		  overflow: hidden;
		  background-color: #333;
		}
		
		li {
		  float: left;
		}
		
		li a {
		  display: block;
		  color: white;
		  text-align: center;
		  padding: 14px 16px;
		  text-decoration: none;
		}
		
		li a:hover {
		  background-color: #111;
		}
	</style>
</head>
<body style="width: 1000px;">
	<ul>
		<li><a href="${path}/">홈</a></li>
		<li><a href="${path}/apply">회원입회신청</a></li>
		<li><a href="${path}/applylist">기간별입회신청조회</a></li>
		<li><a href="${path}/custlist">회원색인조회</a></li>
	</ul>
	<hr>
</body>
</html>