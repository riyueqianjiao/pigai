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
                <input id="oldpassword" type="text" size="20" /> 
            </td> 
        </tr> 
        <tr> 
            <td style="text-align: right; padding: 10px"> 
                <label>新密码:</label> 
            </td> 
            <td> 
                <input id="newpassword" type="text" size="20" /> 
            </td> 
        </tr> 
        <tr> 
            <td style="text-align: right; padding: 10px"> 
                <label>新密码:</label> 
            </td> 
            <td> 
                <input id="newpasswordagain" type="text" size="20" /> 
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
		var oldpassword = $('#oldpassword').val();
		var newpassword = $('#newpassword').val();
		var newpasswordagain = $('#newpasswordagain').val();
		if (oldpassword == "") {			
			alert("旧密码不能为空！");
		}else if(newpassword == ""){
			alert("新密码不能为空！");
		}else if(newpasswordagain == ""){
			alert("请再次输入新密码！");
		}else if(newpassword != newpasswordagain){
			alert("两次密码输入不一致！");
		}
		else {
			var data = {"oldpassword":oldpassword,"newpassword":newpassword};
			$.ajax({
				type: "post",
				url: "updatepassword",
				data: data,
				success: function (msg) {
					if (msg.status == true) {
						location.href = "updatepassword"; //如果登录成功则跳到管理界面
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