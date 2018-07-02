package cn.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.domain.Student;
import cn.service.StudentService;
import cn.service.impl.StudnetServiceImpl;

/**
 * 添加学生信息
 */
@WebServlet("/AddStudentsServlet")
public class AddStudentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置中文编码
		request.setCharacterEncoding("UTF-8");
		try {
			// 1.获取浏览器上提交的数据
			String sname = request.getParameter("sname");
			String gender = request.getParameter("gender");
			String phone = request.getParameter("phone");
			String birthday = request.getParameter("birthday");
			String[] hob = request.getParameterValues("hobby");
			String info = request.getParameter("info");
			String hobbys = Arrays.toString(hob);
			hobbys = hobbys.substring(1, hobbys.length() - 1);

			// 2.添加到数据库
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
			Student stus = new Student(sname, gender, phone, date, hobbys, info);
			StudentService service = new StudnetServiceImpl();
			service.insertstudents(stus);
			// 3.跳转到列表页
			request.getRequestDispatcher("StudentsListServlet").forward(request, response);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
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
