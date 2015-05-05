<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="login" style="text-align: center"> 
	<table border="0" cellpadding="3" cellspacing="3" style="margin: 0 auto;"> 
        <tr> 
            <td style="text-align: right; padding: 10px"> 
                <label>学号:</label> 
            </td> 
            <td> 
                <input id="studentNo" type="text" size="20" /> 
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
                <input type="submit" id="Login" value="&nbsp;&nbsp;登&nbsp;录&nbsp;&nbsp;" style="margin-right: 50px">&nbsp;         
            </td> 
        </tr> 
    </table> 
</div> 
<script type="text/javascript" src="http://cdn.bootcss.com/jquery/1.11.2/jquery.min.js"></script>
<script type="text/javascript">
$().ready(function () {
	$('#Login').click(function () {
		var studentNo = $('#studentNo').val();
		var password = $('#password').val();
		if (studentNo == "" || password == "") {			
			alert("学名或密码不能为空！");
		}
		else {
			var data = {"studentNo":studentNo,"password":password};
			$.ajax({
				type: "post",
				url: "login",
				data: data,
				success: function (msg) {
					if (msg.status == true) {
						location.href = "info"; //如果登录成功则跳到管理界面
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