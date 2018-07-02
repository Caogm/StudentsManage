package cn.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.dao.StudentDao;
import cn.domain.Student;
import cn.utils.JDBCUtil;

/*
 * 这是StudentDao的实现，针对前面定义的规范，做出具体的实现
 */
public class StudentDaoImpl implements StudentDao {

	// 查询所有学生
	@Override
	public List<Student> findAll() throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		String sql = "select * from students";

		List<Student> list = runner.query(sql, new BeanListHandler<Student>(Student.class));
		return list;
	}

	// 查询单个学生信息，返回Student类型
	@Override
	public Student findstudentbyid(int sid) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		String sql = "select * from students where sid=?";
		return runner.query(sql, new BeanHandler<Student>(Student.class), sid);
	}

	// 增加学生对象
	public void insertstudents(Student stus) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		String sql = "INSERT INTO students(sname,gender,phone,birthday,hobby,info) VALUES(?,?,?,?,?,?)";
		runner.update(sql, stus.getSname(), stus.getGender(), stus.getPhone(), stus.getBirthday(), stus.getHobby(),
				stus.getInfo());
	}

	// 删除学生
	public void deletestudents(int sid) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		String sql = "DELETE FROM students WHERE sid=?;";
		runner.update(sql, sid);
	}

	@Override
	public void updatestudents(Student stus) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		String sql = "UPDATE students SET sname=?,gender=?,phone=?,birthday=?,hobby=?,info=? WHERE sid=?;";
		runner.update(sql, stus.getSname(), stus.getGender(), stus.getPhone(), stus.getBirthday(), stus.getHobby(),
				stus.getInfo(), stus.getSid());
	}

}
