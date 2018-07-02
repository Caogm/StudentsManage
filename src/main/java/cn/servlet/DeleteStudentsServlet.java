package cn.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.service.StudentService;
import cn.service.impl.StudnetServiceImpl;

/**
 * 删除学生
 */
@WebServlet("/DeleteStudentsServlet")
public class DeleteStudentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// 获得参数
			int sid = Integer.parseInt(request.getParameter("sid"));
			// 传入到数据库
			StudentService service = new StudnetServiceImpl();
			service.deletestudents(sid);
			// 3.跳转到列表页
			request.getRequestDispatcher("StudentsListServlet").forward(request, response);
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
