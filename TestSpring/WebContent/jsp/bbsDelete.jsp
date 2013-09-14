<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="css/shop.css">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>글 삭제</title>
<script type="text/javascript">
	function bbsDeleteConfirm(){
		if(confirm('삭제하시겠습니까?') == true){
			document.bbsDelete.submit();
		}
	}
</script>
</head>
<body>
<div align="center" class="body">
	<form name="bbsDelete" action="bbsDelete.frog" method="post">
	<table>
		<tr>
			<td>
				비밀 번호 : <input type="password" name="password" />&nbsp;<input type="button" value="삭제" onClick="bbsDeleteConfirm();" />&nbsp;
				<input type="button" value="취소" onClick="javascript:history.back(-1);" />				
			</td>
		</tr>
	</table>
	<input type="hidden" name="seq" value="<c:out value='${bbsDeleteForm}' />" />
	</form>
</div>	
</body>
</html>