function login(){
	var teacherNo = $('#teacherNo').val();
	var password = $('#password').val();
	if (!stringNotNull(teacherNo) ||!stringNotNull(password)) {		
		alert("工号或密码不能为空！");
	}
	else {
		var data = {"teacherNo":teacherNo,"password":password};
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
}
