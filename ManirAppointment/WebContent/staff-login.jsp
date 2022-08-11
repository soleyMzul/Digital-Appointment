<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Staff Login | Manir Health Clinic</title>
    <link rel="stylesheet" href="css/Style.css">
      <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
    <link rel="icon" href="img/favicon.png">
</head>

<body>

      <!-- NAVBAR -->

    <nav class="navbar navbar-expand-lg navbar-dark bg-dark px-1 py-3">
        <div class="container-xl">
          <a class="navbar-brand" >
                <img src="img/logo-clinic.png" class="h-20" alt="logo">
            </a>
           
            <!-- Nav -->
                <div class="navbar-nav mx-lg-auto">
                    <a class="nav-item nav-link" aria-current="page" style="font-family:times;font-size:30px; word-spacing:30px; letter-spacing:10px">KLINIK KESIHATAN MANIR</a>
                </div>
                <!-- Right navigation -->
                
       
             </div>
    </nav><br><br><br>
     <div class="patient-login-inner-container">
            <h2>STAFF LOGIN</h2>
            <form action="LoginStaffController" method="POST" class="patient-login-form">
                <input type="text" name="staff_id" placeholder="Staff ID" required />
                <input type="password" name="staff_password" placeholder="Password" required/><br>
                <button>Login</button>
                <p class="message">Not registered? Please reach out to HR Department.</p>
            </form>
     
    </div>
</body>
<footer style="background-color:#004d4d; height:90px; width:auto;">    
<p style="padding:30px; font-family: verdana; color:white; text-align: center;"><i>@Developed by Nur Solehah Mohamad Zulkifli (2020837614)</i>
</footer>
</html>