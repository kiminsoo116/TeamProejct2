<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
</style>



</head>
<body>
	
		<div>
			<tiles:insertAttribute name="nav" />
			<tiles:insertAttribute name="aside"/>
			<tiles:insertAttribute name="search_find" />
			<tiles:insertAttribute name="footer" />
		</div>
	
</body>
</html>