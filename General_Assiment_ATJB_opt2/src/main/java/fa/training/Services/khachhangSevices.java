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
import fa.training.entities.Khach;

/**
 * Servlet implementation class khachhangSevices
 */
@WebServlet(value = "/khSevices")
public class khachhangSevices extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public khachhangSevices() {
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
		request.setAttribute("listkhach", khachhangDao.displayKhach(pagenumber));
		request.setAttribute("listmay", mayDao.displayMay(1));
		request.setAttribute("listdv", dichvuDao.displayKhach(1));
		RequestDispatcher dispat = request.getRequestDispatcher("/WEB-INF/alldanhsach.jsp");
		dispat.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("tenkhach");
		String diachi = request.getParameter("diachi");
		String sdt = request.getParameter("sdt");
		String email = request.getParameter("email");
		Khach khach = new Khach(name, diachi, sdt, email);
		khachhangDao.insertKhach(khach);
		RequestDispatcher dispat = request.getRequestDispatcher("index.jsp");
		dispat.forward(request, response);
		
	}

}
