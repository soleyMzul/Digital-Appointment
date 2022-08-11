<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="ManirAppointment.model.Staff,ManirAppointment.dao.StaffDAO,java.sql.*, java.util.*" %>
<%
    	//prevent caching of jsp pages
    	response.setHeader("Cache-Control","no-cache");
    	response.setHeader("Cache-Control","no-store");
    	response.setHeader("Pragma","no-cache");
    	response.setDateHeader("Expires",0);
    	
    	//get the session and check if session is null, redirect to login page 
    	if(session.getAttribute("sessionId")==null){
    		response.sendRedirect("staff-login.jsp");
    	}
    		
    %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>My Profile | Manir Health Clinic</title>
    <link rel="stylesheet" href="css/Style.css">
    <link rel="icon" href="img/favicon.png">
</head>
<body class="register-option-body">
<!-- get session -->
	<!-- received from login page -->
	<% int staff_id = (Integer) session.getAttribute("sessionId");%>  
	<!-- want to get customer details -->
	<% Staff staff = StaffDAO.getStaffById(staff_id); %>
    <!-- NAVBAR -->
    <% System.out.print(staff_id);%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark px-1 py-3">
        <div class="container-xl">
          <a class="navbar-brand" >
                <img src="img/logo-clinic.png" class="h-20" alt="logo">
            </a>
           
            <!-- Nav -->
                <div class="navbar-nav mx-lg-auto">
                    <a class="nav-item nav-link" aria-current="page" style="font-family:times;font-size:30px; word-spacing:30px; letter-spacing:10px">KLINIK KESIHATAN MANIR</a>

                </div>
                </div>
    </nav>
    <!-- NAVBAR -->
    
   <div class="wrapper">
    <div class="sidebar" style="height:auto">
        <h2>Navigation</h2>
        <ul>
            <li><a href="admin-account.jsp">My Profile</a></li>
            <li><a href="PatientListController">List of Patients</a></li>
            <li><a href="StaffListController">List of Staff</a></li>
            <li><a href="admin-ListApp.jsp">Manage Appointments</a></li>
            <li><a href="ViewSlotController">Manage Appointment Slot</a></li>
            <li><a href="staff-register.jsp">Create Staff</a></li>
            <li><a href="LogOutStaffController">Log Out</a></li>
        </ul> 
    </div>
    
       <div class="main_content"><br>
            <div class="patient-register-inner-container" style="width:800px">
        
        <div class="detail-user" style="margin-left:10px"><h1>MY PROFILE</h1><BR><br>
          
            <form class="detail-user-form" action="ProfileStaffController" method="post">
            
                <p>STAFF ID</p>
                <input type="text" name="staff_id" value="<%=staff.getStaff_id()%>"readonly><br>
                 <p>PHONE NO</p>
                <input type="text" name="staff_phoneNum" value="<%=staff.getStaff_phoneNum()%>"> <br>
                <p>NAME</p>
                <input type="text" name="staff_name" value="<%=staff.getStaff_name()%>"readonly><br>
                    
                <p>EMAIL</p>
                <input type="text" name="staff_email" value="<%=staff.getStaff_email()%>" readonly><br>

 				<p>ROLE</p>
                <input type="text" name="staff_role" value="<%=staff.getStaff_role()%>" > <br>


               
                
                <input type="submit" value="UPDATE"><br>
            </form>
            </div>
    </div>
    </div>
    </div>
</body>
</html>