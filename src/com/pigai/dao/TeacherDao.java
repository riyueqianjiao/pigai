package com.pigai.dao;

import com.pigai.entity.Teacher;

public interface TeacherDao extends BaseDao{

	Teacher getTeacherByUserNameAndPwd(String username, String pwd) throws Exception;

	Teacher isTeacherExisted(String teacherNo) throws Exception;

}
