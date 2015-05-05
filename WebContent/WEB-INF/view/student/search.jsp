<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>   
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="search" style="text-align: center"> 
	<table border="0" cellpadding="3" cellspacing="3" style="margin: 0 auto;"> 
		<tr>             
            <td style="text-align: right; padding: 10px"> 
                <label>输入老师姓名或课程名称:</label> 
            </td>
        </tr> 
        <tr>                    
            <td> 
                <input id="key" type="text" size="20" /> 
            </td> 
        </tr> 
        <tr align="right"> 
            <td colspan="2"> 
                <input type="submit" id="Search" value="&nbsp;&nbsp;搜&nbsp;索&nbsp;&nbsp;" style="margin-right: 50px">&nbsp;         
            </td> 
        </tr> 
    </table> 
</div> 
<div id="content" class="content-index">
	<c:choose>
		<c:when test="${fn:length(courses)==0}">
			<ul class="no-list">
				<li>没找到匹配的课程，请换个搜索条件重新试一下吧...</li>
			</ul>
		</c:when>
		<c:otherwise>
			<ul class="content-list">
				<p>课程数量：${totalNum}
				</p>
				<c:forEach var="course" items="${courses}">
					<li>
		         	   <i class="name-icon name-icon1">课程</i>	         
		         	   <p class="detail">
		            	    <span class="detail-l">课程名称：${course.courseName}</span>
		            	    <%-- <span class="detail-c">任课老师：${course.teacher.name}</span> --%>
		          	  </p>
	       			 </li>
	       		</c:forEach>
			</ul>
		</c:otherwise>
	</c:choose>
</div>
<script type="text/javascript" src="http://cdn.bootcss.com/jquery/1.11.2/jquery.min.js"></script>
<script type="text/javascript">
$().ready(function () {
	$('#Search').click(function () {
		var key = $('#key').val();
		if (key == "" ) {			
			alert("不能为空！");
		}
		else {
			var data = {"key":key};
			$.ajax({
				type: "get",
				url: "search",
				data: data,
				success: function (msg) {
					if (msg.status == true) {
						location.href = "search";
						alert(msg.message);
					}
					if (msg.status == false) {
						alert(msg.message);
					}
				},
		});
	}
});
});
</script>
</body>
</html>