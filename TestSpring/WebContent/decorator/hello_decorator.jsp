<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<html lang="ko">
<head>
	<title>SiteMesh <decorator:title /></title>
	<style type="text/css">
	#footer {color:red}
	</style>
	<decorator:head />
</head>
<body>
	상단 공통 메뉴
	<hr/>
	<decorator:body />
	<hr/>
	<div id="footer">하단 내용</div>
	</body>
</html>
