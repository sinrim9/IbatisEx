<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" type="text/css" href="css/shop.css">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script lanaguage="javascript">
	function mod(type,value){
		if(type == 'modify'){
			location.href="bbsModifyForm.frog?seq="+value+"&condition="+type;
		}
		else if(type =='delete'){
			if(confirm('�����Ͻðڽ��ϱ�?') == true){
				//location.href="bbsDeleteForm.frog?seq="+value;
				location.href="bbsDelete.frog?seq="+value;
			}
		}
		else if(type =='reply'){
			location.href="bbsReplyForm.frog?seq="+value;
		}
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�Խñ� �� ����</title>
</head>
<body>
	<div align="center" class="body">
		<c:out value="${user.userName}"></c:out> �� ȯ���մϴ�<br />
		<h2>�Խñ� �� ����</h2>
		<table border="1">
			<tr class="header">
				<th align="center" width="80">No</th>
				<th align="center" width="320">TiTle</th>
				<th align="center" width="100">Name</th>
				<th align="center" width="100">Date</th>
			</tr>
			<tr class="record">
				<td align="center">
					<c:out value="${bbsView.seq}" />
				</td>
				<td align="center">
					<c:out value="${bbsView.title}" />
				</td>
				<td align="right">
					<c:out value="${bbsView.name}" />
				</td>
				<td align="right">
					<c:out value="${bbsView.writeDate}" />
				</td>
			</tr>
			<tr>
				<tr>
					<td colspan="4" width="160" height="160">
							<c:out value="${bbsView.description}" />
					</td>
				</tr>
			</tr>
		
		</table>
		<table width="620" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td align="right">					
					<input type="button" name="modify" value="�亯" onClick="javascrpit:mod('reply','${bbsView.seq}')"; /> &nbsp;
				<c:if test="${user.userId == bbsView.userId}">
					<input type="button" name="modify" value="����" onClick="javascrpit:mod('modify','${bbsView.seq}')"; /> &nbsp; 
					<input type="button" name="delete" value="����" onClick="javascrpit:mod('delete','${bbsView.seq}')"; /> &nbsp;
				</c:if>
					<input type="button" value="���" onClick="javascript:location.href='bbsList.frog'"; />
				</td>
			</tr>
		</table>
	</div>
</body>
</html>