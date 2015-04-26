package com.pigai.dao;

import com.pigai.entity.Student;

public interface StudentDao extends BaseDao<Student>{
	public Student findStudentById(String studentId);
	public Student findStudent(String studentId,String password);

}
