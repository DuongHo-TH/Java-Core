package fa.training.Services;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fa.training.dao.dichvuDao;
import fa.training.dao.khachhangDao;
import fa.training.dao.mayDao;

/**
 * Servlet implementation class seachKhach
 */
@WebServlet(value = "/seachkhach")
public class seachKhach extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public seachKhach() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String seach = request.getParameter("seach");
		request.setAttribute("listkhach", khachhangDao.displaytenKhach(seach));
		int pagenumber  = 1;
		if(request.getParameter("page") != null) {
			pagenumber = Integer.parseInt(request.getParameter("page"));
		}
		request.setAttribute("listdv", dichvuDao.displayKhach(pagenumber));
		request.setAttribute("listmay", mayDao.displayMay(pagenumber));
		RequestDispatcher dispat = request.getRequestDispatcher("/WEB-INF/alldanhsach.jsp");
		dispat.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
