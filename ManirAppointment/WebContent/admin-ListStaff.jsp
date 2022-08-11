<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
    	//prevent caching of jsp pages
    	response.setHeader("Cache-Control","no-cache");
    	response.setHeader("Cache-Control","no-store");
    	response.setHeader("Pragma","no-cache");
    	response.setDateHeader("Expires",0);
    	
    	//get the session and check if session is null, redirect to login page 
    	if(session.getAttribute("sessionId")==null)
    		response.sendRedirect("staff-login.jsp");
 %>
	<!--  import class if using JSTL -->
	<%@ page import="ManirAppointment.model.*,ManirAppointment.dao.*,java.sql.*, java.util.*" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>List Of Staff | Manir Health Clinic</title>
    <link rel="stylesheet" href="css/Style.css">
    <link rel="icon" href="img/favicon.png">
</head>
<body class="register-option-body">

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
    <div class="main_content"><br><div class="patient-register-inner-container" style="width:800px">
            <div class="container-fluid" style="width:100%">
            <h1 style="font-family:times; float:center">List of Staff</h1><br>
            <div class="patient-list-container">
                  <table style="border:1px solid; color:black; background:#e9deed;">
                    <tr style="border:1px solid #bd9cc9; font-family:times; ">
                       <th style=" background:#482d52">STAFF ID</th>
                       <th style=" background:#482d52">NAME</th>
                       <th style=" background:#482d52">PHONE NUMBER</th>
                       <th style=" background:#482d52">EMAIL</th>
                       <th style=" background:#482d52">ROLE</th>
                    </tr> 
           <c:forEach items="${staff}" var="s">
                    
                    <tr>
                        <td><c:out value="${s.staff_id}"/></td><td><c:out value="${s.staff_name}"/></td>
                        
                        <td><c:out value="${s.staff_phoneNum}"/></td><td><c:out value="${s.staff_email}"/></td>
                        
                        <td><c:out value="${s.staff_role}"/></td>
                        
                     </tr>
                    </c:forEach>
         
                </table>
            </div>
            </div>
        </div></div>
    </div>
</body>


</html>