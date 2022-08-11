package ManirAppointment.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ManirAppointment.dao.StaffDAO;
import ManirAppointment.model.Staff;

/**
 * Servlet implementation class ProfileStaffController
 */
@WebServlet("/ProfileStaffController")
public class ProfileStaffController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileStaffController() {
        super();
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
		Staff staff = new Staff();
		
		staff.setStaff_phoneNum(Integer.parseInt(request.getParameter("staff_phoneNum")));
		
        StaffDAO.updateStaff(staff);
        request.setAttribute("staff",StaffDAO.getStaffById(staff.getStaff_id()));
		
        RequestDispatcher view = request.getRequestDispatcher("admin-account.jsp");
        view.forward(request, response);
	}

}
