package dempack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import demopack.UserDao;
@WebServlet("/mylogin")
public class DemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname=request.getParameter("username");
		String pss=request.getParameter("password");
		PrintWriter pw=response.getWriter();
		UserDao dao= new UserDao();
		boolean checkuser=dao.getuser(uname, pss);
		if(checkuser) {
			pw.println("<h1 style=color:green>valid user</h1>");
		}
		else {
			pw.println("<h1 style=color:red>invalid user</h1>");
		}
				
	}

}
