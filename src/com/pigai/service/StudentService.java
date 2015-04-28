package com.pigai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pigai.dao.StudentDao;
import com.pigai.entity.Student;
import com.pigai.util.EncryptionUtil;

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
	public Student findStudent(String studentId)
  	{
  		return studentDao.findStudentById(studentId);
  	}
  	public Student findStudent(String studentId,String password)
  	{
  		return studentDao.findStudent(studentId, EncryptionUtil.MD5(password));
  	}
  	
  	public void saveStudent(Student student)
  	{
  		student.setPassword(EncryptionUtil.MD5(student.getPassword()));
  		studentDao.save(student);
  	}
  	public void updateStudent(Student student)
  	{
  		studentDao.update(student);
  	}
  	public void updateStudent(Student student,String password)
  	{
  		student.setPassword(EncryptionUtil.MD5(password));
  		studentDao.update(student);
  	}
}
