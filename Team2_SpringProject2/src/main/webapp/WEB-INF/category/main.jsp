<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!doctype html>

<head>
<meta charset="utf-8">

<title>카테고리</title>

</head>
<body>
	<div class="container-fluid" style="padding: 0px;">
		<!-- nav 위치 -->
		<tiles:insertAttribute name="nav" />
		<!-- aside 위치 -->
		<tiles:insertAttribute name="aside" />
		<!-- Content(변경) 위치 -->
		<tiles:insertAttribute name="category" />
		<!-- Footer 위치 -->
		<tiles:insertAttribute name="footer" />
		
		
	</div>
</body>
</html>