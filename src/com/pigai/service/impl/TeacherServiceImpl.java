package com.pigai.service.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pigai.dao.CommonDao;
import com.pigai.dao.TeacherDao;
import com.pigai.entity.Teacher;
import com.pigai.service.TeacherService;

@Service("teacherService")
public class TeacherServiceImpl extends BaseServiceImpl<Teacher> implements TeacherService{

	protected static final Class<Teacher> entityClass = Teacher.class;
	
	@Autowired
	private CommonDao commonDao;
	
	@Autowired
	private TeacherDao teacherDao;
	
	@SuppressWarnings("unchecked")
	@Override
	public void delete(Serializable objkey) throws Exception {
	
		commonDao.delete(entityClass, objkey);
	}

	@Override
	public Teacher get(Serializable primaryKey) throws Exception {
	
		return (Teacher) commonDao.get(entityClass, primaryKey);
	}

	@Override
	public Teacher getTeacherByUsernameAndPwd(String username, String pwd) {
		Teacher teacher=new Teacher();
		try{
			teacher= teacherDao.getTeacherByUserNameAndPwd(username,pwd);
		}catch(Exception e){
			e.printStackTrace();
		}
		return teacher;
	}

	@Override
	public Boolean isTeacherExisted(String teacherNo) {
		
		try {
			return null!=teacherDao.isTeacherExisted(teacherNo);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return false;
	}

}
