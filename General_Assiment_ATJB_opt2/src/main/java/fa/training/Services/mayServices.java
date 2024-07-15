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
import fa.training.entities.May;

/**
 * Servlet implementation class mayServices
 */
@WebServlet(value = "/mServices")
public class mayServices extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mayServices() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pagenumber  = 1;
		if(request.getParameter("page") != null) {
			pagenumber = Integer.parseInt(request.getParameter("page"));
		}
		request.setAttribute("listkhach", khachhangDao.displayKhach(1));
		request.setAttribute("listmay", mayDao.displayMay(pagenumber));
		request.setAttribute("listdv", dichvuDao.displayKhach(1));
		RequestDispatcher dispat = request.getRequestDispatcher("/WEB-INF/alldanhsach.jsp");
		dispat.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int vitri = Integer.parseInt(request.getParameter("vitri"));
		String trangthai = request.getParameter("trangthai");
		May may = new May(vitri, trangthai);
		mayDao.insertMay(may);
		RequestDispatcher dispat = request.getRequestDispatcher("index.jsp");
		dispat.forward(request, response);
	}

}
