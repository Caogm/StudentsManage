package cn.service.impl;

import java.sql.SQLException;
import java.util.List;

import cn.dao.StudentDao;
import cn.dao.impl.StudentDaoImpl;
import cn.domain.Student;
import cn.service.StudentService;

/*
 * 这是学生的业务实现
 */
public class StudnetServiceImpl implements StudentService {

	// 查找所有
	@Override
	public List<Student> findAll() throws SQLException {
		// TODO Auto-generated method stub
		StudentDao dao = new StudentDaoImpl();
		return dao.findAll();
	}

	@Override
	public Student findstudentbyid(int sid) throws SQLException {
		// TODO Auto-generated method stub
		StudentDao dao = new StudentDaoImpl();
		return dao.findstudentbyid(sid);
	}

	@Override
	public void insertstudents(Student stus) throws SQLException {
		StudentDao dao = new StudentDaoImpl();
		dao.insertstudents(stus);
	}

	@Override
	public void deletestudents(int sid) throws SQLException {
		// TODO Auto-generated method stub
		StudentDao dao = new StudentDaoImpl();
		dao.deletestudents(sid);
	}

	@Override
	public void updatestudents(Student stus) throws SQLException {
		// TODO Auto-generated method stub
		StudentDao dao = new StudentDaoImpl();
		dao.updatestudents(stus);
	}

}
