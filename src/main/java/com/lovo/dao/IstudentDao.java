package com.lovo.dao;

import com.lovo.beans.ClassBean;
import com.lovo.beans.DateBean;
import com.lovo.beans.Student;

public interface IstudentDao {
	
	/**
	 * 新增一个学生
	 * @param student
	 */
	public void addStudent(Student student);
	
	/**
	 * 根据id查询学生
	 * @param id
	 * @return
	 */
	public Student selectStudent(Long id);
	
	public DateBean selectDate(Long id);
	
	public ClassBean selectClass(Long id);

}
