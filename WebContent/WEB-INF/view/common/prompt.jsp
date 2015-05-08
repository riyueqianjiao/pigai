<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="init.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>出现错误<spring:message code="common.title" /></title>
<link href="${pageContext.request.contextPath }/css/error-page.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<div class="">
		<div style="width:619px; margin:0 auto">
			<img src="${pageContext.request.contextPath }/images/page_error.png" width="619" height="391" />
		</div>
		<div style=" font-size:16px; font-weight:bold; color:#666666; text-align:center">
		<c:choose>
			<c:when test="${ERROR_MSG ne null }">${ERROR_MSG }<!-- 程序正常错误提示! --></c:when>
			<c:otherwise>报歉，程序出现异常！请不要灰心，返回上一个页面继续操作试试！</c:otherwise>
		</c:choose>
		</div>
		<div style=" width:200px;margin:30px auto;">
			<span class="button01" style="float: left">
				<a href="${pageContext.request.contextPath }/"> 返回首页</a></span> <span class="button02" style="float:left; margin-left:12px"> 
				<a href="javascript:void(0);" onclick="window.history.back();">返回上一页</a>
			</span>
		</div>
	</div>
	<!-- ${EXCEPTION} -->
</body>
</html>