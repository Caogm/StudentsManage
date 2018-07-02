package cn.service;

import java.sql.SQLException;
import java.util.List;

import cn.domain.Student;

/*
 * 这是学生的业务处理规范
 */
public interface StudentService {
	// 查询所有学生
	List<Student> findAll() throws SQLException;

	// 查询单个学生信息，返回Student类型
	Student findstudentbyid(int sid) throws SQLException;

	// 添加学生数据
	void insertstudents(Student stus) throws SQLException;

	// 删除数据
	void deletestudents(int sid) throws SQLException;

	// 更新学生数据
	void updatestudents(Student stus) throws SQLException;
}
