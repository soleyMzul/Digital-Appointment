package ManirAppointment.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ManirAppointment.dao.PatientDAO;
import ManirAppointment.model.Patient;

/**
 * Servlet implementation class ProfileController
 */
@WebServlet("/ProfileController")
public class ProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pat_icNum = request.getParameter("pat_icNum");
		request.setAttribute("pat", PatientDAO.getPatientByIcNum(pat_icNum));
		
		RequestDispatcher view = request.getRequestDispatcher("patient-account.jsp");
		view.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
Patient pat = new Patient();
		
	
		pat.setPat_address(request.getParameter("pat_address"));
		pat.setPat_phoneNum(Integer.parseInt(request.getParameter("pat_phoneNum")));
		
        PatientDAO.updatePatient(pat);
        request.setAttribute("pat",PatientDAO.getPatientByIcNum(pat.getPat_icNum()));
		
        RequestDispatcher view = request.getRequestDispatcher("patient-account.jsp");
        view.forward(request, response);
	}

}
