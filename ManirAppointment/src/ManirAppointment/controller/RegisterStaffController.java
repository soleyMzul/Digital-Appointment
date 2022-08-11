package ManirAppointment.controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ManirAppointment.dao.StaffDAO;
import ManirAppointment.model.Staff;

/**
 * Servlet implementation class RegisterStaffController
 */
@WebServlet("/RegisterStaffController")
public class RegisterStaffController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private StaffDAO dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterStaffController() {
        super();
        dao = new StaffDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Staff staff = new Staff();
		//retrieve input and set	
		
		staff.setStaff_name(request.getParameter("staff_name"));
				staff.setStaff_phoneNum(Integer.parseInt(request.getParameter("staff_phonenum")));
				
				staff.setStaff_email(request.getParameter("staff_email"));
				staff.setStaff_role(request.getParameter("staff_role"));
				staff.setStaff_password(request.getParameter("staff_password"));
				staff.setManager_id(Integer.parseInt(request.getParameter("manager_id")));
				try {
					dao.addStaff(staff);
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				request.setAttribute("staff", StaffDAO.getAllStaff());
				RequestDispatcher view = request.getRequestDispatcher("admin-login.jsp");
				view.forward(request, response);
			}
	}

