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
	��� ���� �޴�
	<hr/>
	<decorator:body />
	<hr/>
	<div id="footer">�ϴ� ����</div>
	</body>
</html>
