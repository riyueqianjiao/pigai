package com.pigai.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pigai.constant.Constants;
import com.pigai.entity.Student;
import com.pigai.service.StudentService;
import com.pigai.util.JSONUtil;
import com.pigai.vo.User;

@Controller
@RequestMapping(value="/student")
public class StudentController {	
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value="/register")
	public String register(){
		return "student/register";
	}
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public void register(HttpServletRequest request,HttpServletResponse response,Student student) throws IOException{
		Boolean exist = studentService.isStudentExisted(student.getStudentId());
		if(exist == true){
			JSONUtil.outputError(Constants.USER_EXIST, response);
		}else{
			studentService.saveStudent(student);
			JSONUtil.outputSuccess(Constants.REGISTER_SECCESS, response);
		}
	}
	
	@RequestMapping(value="/login")
	public String login(){
		System.out.println("进入getlogin");
		return "student/login";
	}
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public void login(HttpServletRequest request,HttpServletResponse response,String studentId,String password) throws IOException{
		System.out.println("进入login");
		Boolean exist = studentService.isStudentExisted(studentId);
		if(exist == true){
			Student student = studentService.findStudent(studentId, password);
			System.out.println(student);
			if(student!=null){
				JSONUtil.outputSuccess(Constants.LOGIN_SUCCESS, response);
				User user = new User(student.getStudentId(),student.getName());
				request.getSession().setAttribute("user",user);
			}else{
				JSONUtil.outputError(Constants.PASSWORD_IS_WRONG, response);
			}
		}else{
			JSONUtil.outputError(Constants.USER_NOT_EXIST, response);
		}		
	}

	@RequestMapping(value="/info")
	public String center(HttpServletRequest request){
		User user = (User)request.getSession().getAttribute("user");
		Student student = studentService.findStudent(user.getUserId());
		request.setAttribute("student", student);
		return "student/info";
	}

	@RequestMapping(value="/updateinfo",method=RequestMethod.POST)
	public void updateinfo(HttpServletResponse response,Student student) throws IOException{
		studentService.updateStudent(student);
		JSONUtil.outputSuccess(Constants.UPDATE_SECCESS, response);		
	}
	
	@RequestMapping(value = "updatepassword")
	public String updatepass(){
		return "student/updatepassword";
	}
	@RequestMapping(value = "updatepassword",method=RequestMethod.POST)
	public void updatepass(HttpServletRequest request,HttpServletResponse response,String oldpassword,String newpassword) throws IOException{
		User user = (User)request.getSession().getAttribute("user");
		Student student = studentService.findStudent(user.getUserId(),oldpassword);
		if(student == null){
			JSONUtil.outputError(Constants.PASSWORD_IS_WRONG, response);
		}else{
			studentService.updateStudent(student, newpassword);
			JSONUtil.outputSuccess(Constants.UPDATE_SECCESS, response);	
		}
				
	}
}
