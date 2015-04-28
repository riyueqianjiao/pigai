<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="info" style="text-align: center"> 
	<table border="0" cellpadding="3" cellspacing="3" style="margin: 0 auto;"> 
        <tr> 
            <td style="text-align: right; padding: 10px"> 
                <label>学号:</label> 
            </td> 
            <td> 
                <input id="studentId" type="text" size="20" value="${requestScope.student.studentId}" /> 
            </td> 
        </tr> 
        <tr> 
            <td style="text-align: right; padding: 10px"> 
                <label>姓名:</label> 
            </td> 
            <td> 
                <input id="name" type="text" size="20" value="${requestScope.student.name}"/> 
            </td> 
        </tr> 
        <tr> 
            <td style="text-align: right; padding: 10px"> 
                <label>学校:</label> 
            </td> 
            <td> 
                <input id="school" type="text" size="20" value="${requestScope.student.school}"/> 
            </td> 
        </tr>
        <tr> 
            <td style="text-align: right; padding: 10px"> 
                <label>院系:</label> 
            </td> 
            <td> 
                <input id="college" type="text" size="20" value="${requestScope.student.college}"/> 
            </td> 
        </tr> 
        <tr align="right"> 
            <td colspan="2"> 
                <input type="submit" id="Info" value="&nbsp;&nbsp;修&nbsp;改&nbsp;&nbsp;" style="margin-right: 50px">&nbsp;         
            </td> 
        </tr> 
    </table> 
</div>
<script type="text/javascript" src="http://cdn.bootcss.com/jquery/1.11.2/jquery.min.js"></script>
<script type="text/javascript">
$().ready(function () {
	$('#Info').click(function () {
		var studentId = $('#studentId').val();
		var name = $('#name').val();
		var school = $('#school').val();
		var college = $('#college').val();
		if (studentId == "") {			
			alert("学号不能为空！");
		}else if(name == ""){
			alert("姓名不能为空！");
		}else if(school == ""){
			alert("学校不能为空！");
		}else if(college == ""){
			alert("院系不能为空！");
		}
		else {
			var data = {"studentId":studentId,"name":name,"school":school,"college":college};
			$.ajax({
				type: "post",
				url: "updateinfo",
				data: data,
				success: function (msg) {
					if (msg.status == true) {
						alert(msg.message);
						location.href = "student/info"; 						
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