package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AccountDAO;
import dto.Kadai;

/**
 * Servlet implementation class DeteleMenberServlet
 */
@WebServlet("/DeteleMenberServlet")
public class DeteleMenberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeteleMenberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 	String name = request.getParameter("name");
			String ageStr = request.getParameter("age");
			String gender = request.getParameter("gender");
			String tel = request.getParameter("tel");
			String mail = request.getParameter("mail");
			String pw = request.getParameter("pw");
			
//			int age = Integer.parseInt(ageStr); 
		
	
		// 入力された情報を元にインスタンスを生成
		Kadai menber = new Kadai(-1, name, 0, gender, tel, mail, null, pw ,null);
		
		// SQL実行
		int result = AccountDAO.DeleteMenber(mail);
		
		if(result == 1) {
			String view = "WEB-INF/view/success.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
		} else {
			String view = "WEB-INF/view/fail.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
