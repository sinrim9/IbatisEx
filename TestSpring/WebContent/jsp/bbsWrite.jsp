<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>게시판 글쓰기</title>
<script type="text/javascript">
	// 시퀀스 값이 있을경우 수정으로 처리. 값이 없을경우 글쓰기로 처리
	function submitType(param){

		if(param == 'modify'){
			document.bbsWrite.action = "bbsModify.frog";
		}else if(param == 'reply'){
			document.bbsWrite.action = "bbsReply.frog";
		}
		document.bbsWrite.submit();
	
	}
</script>
</head>
<body>
	<div align="center" class="body">		
		<form name="bbsWrite" action="bbsWrite.frog" method="post">
			<table width="660" border="0" cellspacing="0" cellpadding="0">	
	
	<tr>
		<td   height="55" align="center" valign="top" scope="col"  style="padding:20px 0 0 0">  
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td valign="top"> 
              <table width="100%" border="0" cellspacing="0" cellpadding="0">                
                <tr>                	
                	<c:if test="${empty bbsModifyForm.seq && empty bbsReplyForm.seq}">
                	<td align="center"><u><b> 글쓰기</b></u></td>
                	</c:if>
                	<c:if test="${not empty bbsModifyForm.seq}">
                	<td align="center"><u><b> 글수정</b></u></td>
                	</c:if>
                	<c:if test="${not empty bbsReplyForm.seq}">
                	<td align="center"><u><b> 답변 쓰기</b></u></td>
                	</c:if>
                </tr>
                <tr> 
                  <td align="center" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td>&nbsp;</td>
                </tr>
              </table> 
              <table width="620" border="0" cellpadding="1" cellspacing="1" bordercolor="D3B992" bgcolor="D3B992">
				<tr>
					<td   width="115" align="center" bgcolor="F5EEDD" class="text_9F7237" scope="col">작성자</td>
					<td   align="left" bgcolor="#FFFFFF" scope="col"  class="t02_04 input_padding">
					<c:if test="${not empty bbsModifyForm.seq}">
						<c:out value="${bbsModifyForm.name}" />
					</c:if>
					<c:if test="${not empty bbsReplyForm.seq}">
						<!-- <input type="text" name="name" /> -->
						<c:out value="${user.userName}" />
						<input type="hidden" name="name" value="${user.userName }" />
					</c:if>
					<c:if test="${empty bbsModifyForm.seq && empty bbsReplyForm.seq}">
						<!-- <input type="text" name="name" /> -->
						<c:out value="${user.userName}" />
						<input type="hidden" name="name" value="${user.userName }" />
					</c:if>
					</td>
				</tr>	
				<tr>
					<td   width="115" align="center" bgcolor="F5EEDD" class="text_9F7237" scope="col">제목</td>
					<td   align="left" bgcolor="#FFFFFF" scope="col"  class="t02_04 input_padding">
					<c:if test="${not empty bbsModifyForm.seq}">
						<input type="text" name="title" size="38" value="${bbsModifyForm.title}" />
					</c:if>
					<c:if test="${not empty bbsReplyForm.seq}">
						<input type="text" name="title" size="38" value="Re:${bbsReplyForm.title}" />
					</c:if>
					<c:if test="${empty bbsModifyForm.seq && empty bbsReplyForm.seq}">
						<input type="text" name="title" size="38" />
					</c:if>
					</td>
				</tr>				
				<tr>
					<td   width="115" height="30" align="center" bgcolor="F5EEDD" class="text_9F7237" scope="col">내용</td>
					<td   height="200" align="left" bgcolor="#FFFFFF" style="padding:0px 0px 0px 0px" scope="col">
						<textarea name="description" cols="75" rows="15"><c:out value="${bbsModifyForm.description}" /></textarea><br />								  
					</td>
				</tr>
				<!-- 
				<tr>
					<td   align="center" bgcolor="F5EEDD" class="text_9F7237" scope="col">첨부파일</td>
					<td   align="left" bgcolor="#FFFFFF" scope="col">
						<s:file name="s_file" cssStyle="width:300px" theme="simple"/>
					</td>
				</tr>
				 -->
				 <!-- 
				<tr>
					<td   width="115" align="center" bgcolor="F5EEDD" class="text_9F7237" scope="col">비밀번호</td>
					<td   align="left" bgcolor="#FFFFFF" scope="col">
						<table border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td align="left" scope="col"><span class="t02_04 input_padding">
									<input type="password" name="password" />							
								</span></td>
								<td align="left"  scope="col"><span class="T_org_P">* 삭제.수정시 필요</span></td>
							</tr>
						</table>
					</td>
				</tr>
				 -->				
			</table>
			<table width="620" border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td   height="38" align="right" valign="bottom" scope="col"><input type="button" value="작성완료" onClick="submitType('${condition}')" /></td>
				<c:if test="${empty bbsModifyForm.seq}">
					<td   width="70" align="right" valign="bottom" scope="col"><input type="reset" value="다시작성" /></td>
				</c:if>
					<td   width="70" align="right" valign="bottom" scope="col"><input type="button" value="목록" onClick="javascript:location.href='bbsList.frog';" /></td>
				</tr>
			</table>
			</td>		
		</tr>
		<tr> 
			<td height="19"></td>
		</tr>
      </table>
    </td>
  </tr>
</table>
</table>
<c:if test="${not empty bbsModifyForm.seq}">
	<input type="hidden" name="seq" value="${bbsModifyForm.seq}" />
</c:if>
<c:if test="${not empty bbsReplyForm.seq}">
	<input type="hidden" name="seq" value="${bbsReplyForm.seq}" />
</c:if>
	<input type="hidden" name="userId" value="${user.userId}" />
		</form>
	</div>
</body>
</html>