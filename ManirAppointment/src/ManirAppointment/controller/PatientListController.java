package ManirAppointment.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ManirAppointment.dao.PatientDAO;

/**
 * Servlet implementation class PatientListController
 */
@WebServlet("/PatientListController")
public class PatientListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PatientDAO dao;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatientListController() {
        super();
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("pat", PatientDAO.getAllPatient());
		RequestDispatcher view = request.getRequestDispatcher("admin-ListPat.jsp");
		view.forward(request, response);
	}

}