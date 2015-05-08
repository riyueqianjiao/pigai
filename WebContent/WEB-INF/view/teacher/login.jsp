<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="../common/init.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教师登陆</title>
  <%@include file="../common/head.jsp" %>  
<script type="text/javascript" src="${pageContext.request.contextPath }/js/teacher.js"></script>
</head>
<body>
<div id="login" style="text-align: center"> 
	<table border="0" cellpadding="3" cellspacing="3" style="margin: 0 auto;"> 
        <tr> 
            <td style="text-align: right; padding: 10px"> 
                <label>学号:</label> 
            </td> 
            <td> 
                <input id="teacherNo" type="text" size="20" /> 
            </td> 
        </tr> 
        <tr> 
            <td style="text-align: right; padding: 10px"> 
                <label>密码:</label> 
            </td> 
            <td> 
                <input id="password" type="password" size="20" /> 
            </td> 
        </tr> 
        <tr align="right"> 
            <td colspan="2"> 
                <input type="submit" id="login" onclick="login()" value="&nbsp;&nbsp;登&nbsp;录&nbsp;&nbsp;" style="margin-right: 50px">&nbsp;
                <a href="${pageContext.request.contextPath }/teacher/register" onclick="javascript:void();" >注册</a>         
            </td> 
        </tr> 
    </table> 
</div> 
</body>
</html>