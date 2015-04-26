package com.pigai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pigai.dao.StudentDao;
import com.pigai.entity.Student;

@Service
public class StudentService {

/**
 * public boolean isStudentExisted(String studentId) 
 * public Student findStudent(String studentId,String password)
 * 
 * 
 * 
 * 
 */
	@Autowired
	private StudentDao studentDao;
	
	public boolean isStudentExisted(String studentId){
		Student student = studentDao.findStudentById(studentId);
 		if(student == null)
 		{
 			return false;
 		}else
 			return true;
 	}
  	//查询用户
  	public Student findStudent(String studentId,String password)
  	{
  		return studentDao.findStudent(studentId, password);
  	}
}
