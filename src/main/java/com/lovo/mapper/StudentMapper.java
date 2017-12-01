package com.lovo.mapper;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import com.lovo.beans.ClassBean;
import com.lovo.beans.DateBean;
import com.lovo.beans.Student;

public interface StudentMapper {

	/**
	 * 新增一个学生
	 * @param student
	 */
	@Insert(value="insert into student (id,student_name,fk_class) values (#{student.id},#{student.studentName},#{student.studentClass})")
	public void addStudent(@Param("student")Student student);
	
	
	/**
	 * 根据id查询学生
	 * @param id
	 * @return
	 */
	@Select("select id,student_name,fk_class from student where id = #{id}")
	@Results({
		@Result(id=true,property="id",column="id",javaType=Integer.class),
		@Result(property="studentName",column="student_name",javaType=String.class),
		@Result(property="studentClass",column="fk_class",javaType=Integer.class),
	})
	public Student selectStudent(Long id);
	
	@Select("select id,class_name from class where id = #{id}")
	@Results({
		@Result(id=true,property ="id",column="id",javaType = Long.class),
		@Result(property="className",column = "class_name",javaType = String.class)
	})
	public ClassBean selectClass(Long id);
	
	@Select("select t_id,t_date from t_date where t_id = #{id}")
	@Results({
		@Result(id=true,property="id",column="t_id",javaType=Long.class),
		@Result(property="date",column="t_date",javaType=Date.class),
	})
	public DateBean selectDate(Long id);
}
