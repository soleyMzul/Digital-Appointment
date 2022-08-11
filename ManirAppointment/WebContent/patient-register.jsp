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
    <title>Register Account | Manir Health Clinic</title>
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
                    <a class="nav-item nav-link" href="Index.html" aria-current="page" style="font-size:18px">Home</a>
                    <a class="nav-item nav-link" href="AboutUs.html" style="font-size:18px">About Us</a>
                    <a class="nav-item nav-link" href="ContactUs.html" style="font-size:18px">Contact Us</a>

                </div>
                <!-- Right navigation -->
                <div class="navbar-nav ms-lg-1">
                    <!-- Action -->
                    <div class="d-flex align-items-lg-center mt-0 mt-lg-0">
                        <a href="patient-register.jsp" class="btn btn-sm btn-primary w-full w-lg-auto">
                            Register
                        </a><p>&ensp;</p>
                        <div class="d-flex align-items-lg-center mt-0 mt-lg-0">
                        <a href="login-patient.jsp" class="btn btn-sm btn-primary w-full w-lg-auto">
                            Sign In
                        </a>
                    </div>
                </div>
                </div>
                		</div>
    </nav><br><br>
   
            <div class="patient-register-inner-container">
                <img src="img/logo.png" alt="">
                <h2>REGISTER</h2>
                <p>Please fill in this form to create an account.</p>
    <hr>
                <form class="patient-register-form" method="POST" action="RegisterPatientController" onsubmit="alert('success');">

                    <label class="ic">IC Number</label><br>
                    <input placeholder="Enter IC Number (e.g 990323115148)" class="ic" type="text" name="pat_icnum" required><br><br>

                    <label class="name">Name</label><br>
                    <input placeholder="Enter full name as per IC or passport" class="name" type="text" name="pat_name" required><br><br>

                    <label class="DOB">Date of Birth:</label><br>
                    <input class="DOB" type="date" name="pat_DOB" required><br><br>

                    <label class="gender">Gender</label><br>
                    <select class="gender" name="pat_gender" required>
                        <option disabled="disabled" selected="selected">-- Choose option --</option>
                        <option value="Male">Male</option>
                        <option value="Female">Female</option>
                        <option value="Other">Other</option>
                    </select><br>

                    <label class="phone">Phone Number</label><br>
                    <input placeholder="Enter phone number" class="phone" type="text" name="pat_phonenum" required><br><br>

                    <label class="address">Address</label><br>
                    <textarea placeholder="Enter Address" class="address" type="text" name="pat_address" required></textarea><br>
					
					<label class="pasword">Password</label><br>
                    <input placeholder="Enter password" class="password" type="password" name="pat_password" required><br><br>
                    
                    <input type="submit" style="margin-left:250px;border:0px;width:90px; height:40px; color:white; background-color:#3973ac" value="Register">
                </form>
                <p class="message">Already have an account? <a href="login-patient.jsp"><b>Log In</b></a></p>
            </div>
       </body>
<footer style="background-color:#004d4d; height:90px; width:auto;">    
<p style="padding:30px; font-family: verdana; color:white; text-align: center;"><i>@Developed by Nur Solehah Mohamad Zulkifli (2020837614)</i>
</footer>
</html>