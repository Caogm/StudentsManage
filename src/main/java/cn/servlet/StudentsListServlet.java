package cn.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.domain.Student;
import cn.service.StudentService;
import cn.service.impl.StudnetServiceImpl;

/**
 * 负责查询所有的学生信息，然后呈现到list.jsp上
 */
@WebServlet("/StudentsListServlet")
public class StudentsListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		try {
			// 1.查询出来所有的学生
			StudentService service = new StudnetServiceImpl();
			List<Student> list = service.findAll();

			// 2.先把数据存储到作用域中
			request.setAttribute("list", list);
			// 3.跳转页面到显示层
			request.getRequestDispatcher("list.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
