package adminSearch;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SearchBean s = new SearchBean();
		s.getDate(request.getParameter("start-date"),request.getParameter("end-date"));
		s.getType(request.getParameter("nt_organized"));
		s.getType(request.getParameter("nt_conducted"));
		s.getType(request.getParameter("nt_attended"));
		s.getType(request.getParameter("nt_publication"));
		s.getType(request.getParameter("nt_studachieve"));
		s.getType(request.getParameter("nt_project"));
		
		
		s.getValues(request.getParameterValues("paper"));
	}

}
