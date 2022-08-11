<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Slot Management | Manir Health Clinic</title>
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
            <li><a href="admin-ListPat.jsp">List of Patients</a></li>
            <li><a href="admin-ListStaff.jsp">List of Staff</a></li>
            <li><a href="admin-ListApp.jsp">Manage Appointments</a></li>
            <li><a href="admin-viewSlot.jsp">Manage Appointment Slot</a></li>
            <li><a href="staff-register.jsp">Create Staff</a></li>
            <li><a href="LogOutStaffController">Log Out</a></li>
        </ul> 
    </div>
        <div class="main_content"><br>
            <div class="patient-register-inner-container" style="width:800px">

                <h2>CREATE NEW SLOT</h2>
                <p>Please fill in the form to create an account for new staff.</p>
    <hr>
                <form class="patient-register-form" method="POST" action="RegisterStaffController" onsubmit="alert('success');">

                    <label class="name">Name</label><br>
                    <input placeholder="Enter full name as per IC or passport" class="name" type="text" name="staff_name" required><br><br>

                    <label class="phone">Phone Number</label><br>
                    <input placeholder="Enter phone number" class="phone" type="text" name="staff_phonenum" required><br><br>
                    
                    <label class="name">Email</label><br>
                    <input placeholder="Enter email" class="name" type="text" name="staff_email" required><br><br>
                    
                    
                    <label class="role">Role</label><br>
                    <select class="role" name="staff_role" required>
                        <option disabled="disabled" selected="selected">-- Choose option --</option>
                        <option value="Receptionist">Receptionist</option>
                        <option value="Admin">Admin</option>
                        <option value="Doctor">Doctor</option>
                        <option value="Other">Other</option>
                    </select><br>

					<label class="pasword">Password</label><br>
                    <input placeholder="Enter password" class="password" type="password" name="staff_password" required><br><br>
                    <input class="manager_id" type="text" name="manager_id" value="1001" hidden="hidden">
                    
                    <input type="submit" style="margin-left:250px;border:0px;width:90px; height:40px; color:white; background-color:#3973ac" value="Register">
                </form>
               </div>
               </div></div>
       </body>
</html>