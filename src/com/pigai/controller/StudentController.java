package com.pigai.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pigai.entity.Student;
import com.pigai.service.StudentService;
import com.pigai.util.JSONUtil;
import com.pigai.constant.Constants;

@Controller
public class StudentController {	
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public void login(HttpServletRequest request,HttpServletResponse response,String studentId,String password) throws IOException{
		System.out.println("ssss");
		Student student = studentService.findStudent(studentId, password);
		if(student!=null){
			JSONUtil.toJSON(student, response);
		}else{
			JSONUtil.outputError(Constants.PASSWORD_IS_WRONG, response);
		}
		
	}

}
