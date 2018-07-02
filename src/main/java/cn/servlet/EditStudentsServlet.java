package cn.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.domain.Student;
import cn.service.StudentService;
import cn.service.impl.StudnetServiceImpl;

/**
 * Servlet implementation class EditStudentsServlet
 */
@WebServlet("/EditStudentsServlet")
public class EditStudentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// 获得参数
			int sid = Integer.parseInt(request.getParameter("sid"));
			// 操作数据库,查询学生数据
			StudentService service = new StudnetServiceImpl();
			Student stu = service.findstudentbyid(sid);
			request.setAttribute("stu", stu);

			// 3.跳转到列表页
			request.getRequestDispatcher("edit.jsp").forward(request, response);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
