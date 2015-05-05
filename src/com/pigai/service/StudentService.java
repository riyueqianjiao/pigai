package com.pigai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pigai.dao.CourseDao;
import com.pigai.dao.StudentDao;
import com.pigai.entity.Course;
import com.pigai.entity.Student;
import com.pigai.util.EncryptionUtil;

@Service
public class StudentService {

/**
 * public boolean isStudentExisted(String studentNo) 
 * public Student findStudent(String studentNo,String password)
 * 
 * 
 * 
 * 
 */
	@Autowired
	private StudentDao studentDao;
	@Autowired
	private CourseDao courseDao;
	
	public boolean isStudentExisted(String studentNo){
		Student student = studentDao.findStudentById(studentNo);
 		if(student == null)
 		{
 			return false;
 		}else
 			return true;
 	}
  	//查询用户
	public Student findStudent(String studentNo)
  	{
  		return studentDao.findStudentById(studentNo);
  	}
  	public Student findStudent(String studentNo,String password)
  	{
  		return studentDao.findStudent(studentNo, EncryptionUtil.MD5(password));
  	}
  	
  	public void saveStudent(Student student)
  	{
  		student.setPassword(EncryptionUtil.MD5(student.getPassword()));
  		studentDao.save(student);
  	}
  	public void updateStudent(Student student,String password)
  	{
  		student.setPassword(EncryptionUtil.MD5(password));
  		studentDao.update(student);
  	}
  	
  	public Long getTotalNumByKey(String key){
  		return courseDao.getTotalNumByKey(key);
  	}
  	public List<Course> findByKeyByPage(String key,Integer pageNum){
  		return courseDao.findByKeyByPage(key, pageNum);
  	}
}
