package com.lovo.dao.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.lovo.beans.ClassBean;
import com.lovo.beans.DateBean;
import com.lovo.beans.Student;
import com.lovo.dao.IstudentDao;
import com.lovo.mapper.StudentMapper;

@Repository("studentDao")
public class StudentDaoImpl implements IstudentDao{

	@Resource
	private StudentMapper studentMapper;
	
	public void addStudent(Student student) {
		studentMapper.addStudent(student);
		
	}
	@Override
	public Student selectStudent(Long id) {
		// TODO Auto-generated method stub
		return studentMapper.selectStudent(id);
	}

	public DateBean selectDate(Long id) {
		// TODO Auto-generated method stub
		return studentMapper.selectDate(id);
	}

	public ClassBean selectClass(Long id) {
		// TODO Auto-generated method stub
		return studentMapper.selectClass(id);
	}


	

}
