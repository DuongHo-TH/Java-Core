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
import fa.training.entities.DichVu;

/**
 * Servlet implementation class dichvuSevices
 */
@WebServlet(value = "/dvSevices")
public class dichvuSevices extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dichvuSevices() {
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
		request.setAttribute("listmay", mayDao.displayMay(1));
		request.setAttribute("listdv", dichvuDao.displayKhach(pagenumber));
		RequestDispatcher dispat = request.getRequestDispatcher("/WEB-INF/alldanhsach.jsp");
		dispat.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tendv = request.getParameter("tendichvu");
		String donvi = request.getParameter("donvi");
		float dongia = Float.parseFloat(request.getParameter("dongia"));
		DichVu dv = new DichVu(tendv, donvi, dongia);
		dichvuDao.insertDichVu(dv);
		RequestDispatcher dispat = request.getRequestDispatcher("index.jsp");
		dispat.forward(request, response);
	}

}
