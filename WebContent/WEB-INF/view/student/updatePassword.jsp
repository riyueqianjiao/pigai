<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="updatepass" style="text-align: center"> 
	<table border="0" cellpadding="3" cellspacing="3" style="margin: 0 auto;"> 
        <tr> 
            <td style="text-align: right; padding: 10px"> 
                <label>旧密码:</label> 
            </td> 
            <td> 
                <input id="oldPassword" type="text" size="20" /> 
            </td> 
        </tr> 
        <tr> 
            <td style="text-align: right; padding: 10px"> 
                <label>新密码:</label> 
            </td> 
            <td> 
                <input id="newPassword" type="text" size="20" /> 
            </td> 
        </tr> 
        <tr> 
            <td style="text-align: right; padding: 10px"> 
                <label>新密码:</label> 
            </td> 
            <td> 
                <input id="newPasswordAgain" type="text" size="20" /> 
            </td> 
        </tr>
        <tr align="right"> 
            <td colspan="2"> 
                <input type="submit" id="Updatepass" value="&nbsp;&nbsp;登&nbsp;录&nbsp;&nbsp;" style="margin-right: 50px">&nbsp;         
            </td> 
        </tr> 
    </table> 
</div> 
<script type="text/javascript" src="http://cdn.bootcss.com/jquery/1.11.2/jquery.min.js"></script>
<script type="text/javascript">
$().ready(function () {
	$('#Updatepass').click(function () {
		var oldPassword = $('#oldPassword').val();
		var newPassword = $('#newPassword').val();
		var newPasswordagain = $('#newPasswordAgain').val();
		if (oldPassword == "") {			
			alert("旧密码不能为空！");
		}else if(newPassword == ""){
			alert("新密码不能为空！");
		}else if(newPasswordagain == ""){
			alert("请再次输入新密码！");
		}else if(newPassword != newPasswordagain){
			alert("两次密码输入不一致！");
		}
		else {
			var data = {"oldPassword":oldPassword,"newPassword":newPassword};
			$.ajax({
				type: "post",
				url: "updatePassword",
				data: data,
				success: function (msg) {
					if (msg.status == true) {
						location.href = "updatePassword"; //如果登录成功则跳到管理界面
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