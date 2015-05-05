package com.pigai.dao;

import com.pigai.entity.Student;

public interface StudentDao extends BaseDao<Student>{
	public Student findStudentById(String studentNo);
	public Student findStudent(String studentNo,String password);

}
