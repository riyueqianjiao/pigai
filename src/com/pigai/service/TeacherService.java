package com.pigai.service;

import com.pigai.entity.Teacher;


public interface TeacherService extends BaseService<Teacher>{
	
public Teacher getTeacherByUsernameAndPwd(String username,String pwd);

public Boolean isTeacherExisted(String teacherNo);

}
