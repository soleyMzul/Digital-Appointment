<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="ManirAppointment.model.Patient,ManirAppointment.dao.PatientDAO,java.sql.*, java.util.*" %>
    <%
    	//prevent caching of jsp pages
    	response.setHeader("Cache-Control","no-cache");
    	response.setHeader("Cache-Control","no-store");
    	response.setHeader("Pragma","no-cache");
    	response.setDateHeader("Expires",0);
    	
    	//get the session and check if session is null, redirect to login page 
    	if(session.getAttribute("sessionICNum")==null){
    		response.sendRedirect("login-patient.jsp");
    	}
    		
    %>
    <!--  import class if using JSTL -->
<%@ page import="ManirAppointment.model.Patient,ManirAppointment.dao.PatientDAO,java.sql.*, java.util.*" %>
    
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Account Profile | Manir Health Clinic</title>
    <link rel="stylesheet" href="css/Style.css">
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
    
</head>

<body>
<!-- get session -->
	<!-- received from login page -->
	<% String pat_icNum = (String) session.getAttribute("sessionICNum");%>  
	<!-- want to get customer details -->
	<% Patient pat = PatientDAO.getPatientByIcNum(pat_icNum); %>
    <!-- NAVBAR -->
    <% System.out.print(pat_icNum);%>

     <nav class="navbar navbar-expand-lg navbar-white bg-light px-0 py-2" style="background-color:black">
        <div class="container-xl">
            <!-- Logo -->
            <a class="navbar-brand">
                <img src="img/logo-clinic.png" class="h-20" alt="logo">
            </a>
                      
             <div class="navbar-nav mx-lg-auto">
              <a class="nav-item nav-link active" style="font-size:30px;font-family:georgia;letter-spacing: 8px;text-shadow: 2px 2px 4px #bfbfbf; word-spacing: 20px; font-weight:bold; color:#006666">KLINIK KESIHATAN MANIR</a>
            </div></div></nav>
            
              
            <nav class="navbar navbar-expand-lg navbar-dark bg-dark px-0 py-2">
        <div class="container-xl">
                       
            <!-- Navbar toggle -->
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <!-- Collapse -->
            <div class="collapse navbar-collapse" id="navbarCollapse">
                
                <!-- Nav -->
                <div class="navbar-nav mx-lg-auto">
                    <a class="nav-item nav-link" href="patient-homepage.jsp" aria-current="page" style=" float: left; diaplay:block;  border-right:1px sold white; font-size:16px; font-family:times">BOOK APPOINTMENT</a>
                    <p>&ensp;&ensp;&ensp;&ensp;</p><a class="nav-item nav-link" href="ListAppController?pat_icNum=<%=pat.getPat_icNum()%>" style=" font-size:16px; font-family:times">MY APPOINTMENT</a>
                   <p>&ensp;&ensp;&ensp;&ensp;</p> <a class="nav-item nav-link" href="About.html" style="float:left; font-size:16px; font-family:times">ABOUT US</a>
                    <p>&ensp;&ensp;&ensp;&ensp;</p><a class="nav-item nav-link" href="Contact.html" style="float:left; font-size:16px; font-family:times">CONTACT US</a>

                </div>
                
                                
                <!-- Right navigation -->
                <div class="navbar-nav ms-lg-1">
                    <!-- Action -->
                    <div class="d-flex align-items-lg-center mt-0 mt-lg-0">
                       <a class="btn btn-sm btn-primary w-full w-lg-auto" href="ProfileController?pat_icnum=<%=pat.getPat_icNum()%>">My Profile</a>
                        <p>&ensp;</p>
                        <div class="d-flex align-items-lg-center mt-0 mt-lg-0">
                        <a href="LogoutPatController" class="btn btn-sm btn-primary w-full w-lg-auto">
                            Logout
                        </a>
                    </div>
                </div>
</div>
                </div>
            </div>
            </nav>
            <!-- Navbar toggle -->
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <!-- Collapse -->
            <div class="collapse navbar-collapse" id="navbarCollapse">
                <!-- Nav -->
                <div class="navbar-nav mx-lg-auto">
                      <a class="nav-item nav-link" href="patient-homepage.jsp" aria-current="page">Home</a>
                    <a class="nav-item nav-link active" href="PatientViewController?pat_icNum=<%=pat.getPat_icNum()%>">Account</a>
                    <a class="nav-item nav-link" href="ViewPatAppController?pat_icNum=<%=pat.getPat_icNum()%>">My Appointment</a>
                    <a class="nav-item nav-link" href="CreateAppointmentController?pat_icNum=<%=pat.getPat_icNum()%>">Create Appointment</a>
                    <a class="nav-item nav-link" href="LogoutPatController">Logout</a>
                    
                </div>
                
            </div>
	
<br><br>
            
      <div class="patient-register-inner-container"> 
        
        <div class="detail-user" style="margin-left:10px; font-family:times"><h1>MY PROFILE</h1><BR>
          
            <form class="detail-user-form" action="ProfileController" method="post">
            
                <p>NAME</p>
                <input type="text" name="pat_name" value="<%=pat.getPat_name()%>"readonly><br>
                    
                <p>IC NUMBER</p>
                <input type="text" name="pat_icNum" value="<%=pat.getPat_icNum()%>" readonly><br>

                <p>GENDER</p>
                <input type="text" name="pat_gender" value="<%=pat.getPat_gender()%>" readonly><br>

                <p>DATE OF BIRTH</p>
                <input type="date" name="pat_DOB" value="<%=pat.getPat_DOB()%>" readonly> <br>

                <p>ADDRESS</p>
                <input type="text" name="pat_address" value="<%=pat.getPat_address()%>"> <br>

                <p>PHONE NO</p>
                <input type="number" name="pat_phoneNum" value="0<%=pat.getPat_phoneNum()%>"> <br>
                
                <input type="submit" style="border:0px;width:90px; height:40px; color:white; background-color:#3973ac" value="UPDATE"><br>
            </form>

        </div>
</div>



</body><footer style="background-color:#004d4d; height:90px; width:auto;">    
<p style="padding:30px; font-family: verdana; color:white; text-align: center;"><i>@Developed by Nur Solehah Mohamad Zulkifli (2020837614)</i>
</footer>
</html>