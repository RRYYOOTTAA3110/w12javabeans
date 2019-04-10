package jp.webschool.javaweb.chapter12;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.webschool.javaweb.chapter12.bean.ResBean;

/**
 * Servlet implementation class Controller
 */
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");

		if(name.length() == 0 || title.length() == 0 || contents.length() == 0){
			response.sendRedirect("/w12javabeans/bbs.jsp");
		}else{
			//記事を追加する
			List<ResBean> list = ResList.getInstance(name, title, contents);

			//記事一覧をsessionに保存
			HttpSession session = request.getSession(true);
			session.setAttribute("list", list);

			response.sendRedirect("/w12javabeans/bbs.jsp");
		}

	}

}
