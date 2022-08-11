package ManirAppointment.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ManirAppointment.model.Staff;
import ManirAppointment.dao.StaffDAO;

/**
 * Servlet implementation class LoginStaffController
 */
@WebServlet("/LoginStaffController")
public class LoginStaffController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StaffDAO dao;
	HttpSession session;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginStaffController() {
        super();
        dao= new StaffDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Staff staff = new Staff();
			//retrieve and set id and password
			int staff_id =(Integer.parseInt(request.getParameter("staff_id")));
			String staff_password=request.getParameter("staff_password");
			staff.setStaff_id(staff_id);
			staff.setStaff_password(staff_password);
			staff = dao.LoginStaff(staff);
			
			//set user session if user is valid
			if(staff.isValid()) {
			
				session = request.getSession(true);
				
				
				session.setAttribute("sessionId", staff.getStaff_id()); 
				
				System.out.println("Login Success!");
				request.setAttribute("s", StaffDAO.getStaffById(staff.getStaff_id()));   //to retrieve user info
				System.out.print(staff_id);
				RequestDispatcher view = request.getRequestDispatcher("admin-account.jsp"); 	 // logged-in page
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
