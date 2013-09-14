<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" type="text/css" href="css/shop.css">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>게시글 리스트 화면</title>
</head>
<body>
	<div align="center" class="body">
		<c:out value="${user.userName}"></c:out> 님 환영합니다<br />
		<h2>게시글 리스트 화면</h2>
		<table border="1">
			<tr class="header">
				<th align="center" width="80">No</th>
				<th align="center" width="320">TiTle</th>
				<th align="center" width="100">Name</th>
				<th align="center" width="100">Hit</th>
				<th align="center" width="100">Date</th>
			</tr>
		<c:forEach items="${bbsList}" var="bbsList">
			<tr class="record">
				<td align="center">
					<c:out value="${bbsList.seq}" />
				</td>
				<td align="center">
			<c:if test="${bbsList.position > 0}">
				<c:forEach begin="1" end="${bbsList.position}">
					&nbsp;&nbsp;&nbsp;&nbsp;
				</c:forEach>
					↘
			</c:if>
					<a href="bbsView.frog?seq=${bbsList.seq}"><c:out value="${bbsList.title}" /></a>
				</td>
				<td align="right">
					<c:out value="${bbsList.name}" />
				</td>
				<td align="right">
					<c:out value="${bbsList.readhit}" />
				</td>
				<td align="right">
					<c:out value="${bbsList.writeDate}" />
				</td>
			</tr>			
		</c:forEach>			
		</table>
		<table width="620" border="0" cellpadding="0" cellspacing="0">
			<tr border="0">
				<td border="0" align="right">
					<input type="button" value="글쓰기" onClick="javascript:location.href='bbsWriteForm.frog'"; /></a>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>