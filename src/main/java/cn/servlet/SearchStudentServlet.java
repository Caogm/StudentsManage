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
 * Servlet implementation class SearchStudentServlet
 */
@WebServlet("/SearchStudentServlet")
public class SearchStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 设置中文编码
		request.setCharacterEncoding("UTF-8");
		try {
			// 1.获取参数
			String sname = request.getParameter("sname");
			String gender = request.getParameter("gender");
			// 2.service查询
			StudentService service = new StudnetServiceImpl();
			List<Student> list = service.serarchstudent(sname, gender);
			System.out.println("list的大小是：" + list.size());
			for (Student student : list) {
				System.out.println("stu=" + student);
			}

			request.setAttribute("list", list);

			// 3. 跳转界面。列表界面
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
