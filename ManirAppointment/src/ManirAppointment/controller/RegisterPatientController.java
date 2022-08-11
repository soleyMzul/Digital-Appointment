package ManirAppointment.controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
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

@WebServlet("/RegisterPatientController")
public class RegisterPatientController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PatientDAO dao;
	DateFormat formatter;
       
    public RegisterPatientController() {
        super();
        dao = new PatientDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Patient patient = new Patient();
		
		//retrieve input and set
		patient.setPat_icNum(request.getParameter("pat_icnum"));
		patient.setPat_name(request.getParameter("pat_name"));
		patient.setPat_gender(request.getParameter("pat_gender"));
		String date = request.getParameter("pat_DOB");
		Date dt;
		try {
			dt = new SimpleDateFormat("yyyy-MM-dd").parse(date);
            java.sql.Date sqlDate = new java.sql.Date(dt.getTime());
            patient.setPat_DOB(sqlDate);
		}
		catch (ParseException e) {
            e.printStackTrace();
        }
		patient.setPat_address(request.getParameter("pat_address"));
		patient.setPat_phoneNum(Integer.parseInt(request.getParameter("pat_phonenum")));
		patient.setPat_password(request.getParameter("pat_password"));
		
		try {
			dao.addPatient(patient);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("pat", PatientDAO.getAllPatient());
		RequestDispatcher view = request.getRequestDispatcher("login-patient.jsp");
		view.forward(request, response);
	}

}