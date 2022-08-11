package ManirAppointment.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import ManirAppointment.model.Patient;
import ManirAppointment.dao.PatientDAO;


/**
 * Servlet implementation class LoginPatController
 */
@WebServlet("/LoginPatController")
public class LoginPatController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PatientDAO dao;
	HttpSession session;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginPatController() {
        super();
        dao= new PatientDAO();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Patient pat = new Patient();
			//retrieve and set email and password
			String pat_icNum =request.getParameter("pat_icnum");
			String pat_password=request.getParameter("pat_password");
			
			pat.setPat_icNum(pat_icNum);
			pat.setPat_password(pat_password);
			pat = dao.LoginPatient(pat);
			
			//set user session if user is valid
			if(pat.isValid()) {
			
				session = request.getSession(true);
				
				
				session.setAttribute("sessionICNum", pat.getPat_icNum()); 
				
				System.out.println("Login Success!");
				request.setAttribute("pat", dao.getPatientByIcNum(pat.getPat_icNum()));   //to retrieve user info
				System.out.print(pat_icNum);
				RequestDispatcher view = request.getRequestDispatcher("patient-homepage.jsp"); 	 // logged-in page
				view.forward(request, response);
			}
			//redirect to invalidLoggin.jsp if user is not valid
			else{
				response.sendRedirect("invalidLogin.jsp");
			}	
		}

		catch (Throwable ex) {
			System.out.println(ex);
		}
	}
}

