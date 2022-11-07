<%-- 
    Document   : signUp
    Created on : Oct 30, 2022, 6:48:49 AM
    Author     : himal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Account</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
        <style>
            #my{
                background: url('https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQYvFDJf1NcZsfqDnUjGU7aerP43FRKd4wFKg&usqp=CAU');
                background-size: cover;
                background-position: 100%
                
            }
        </style>
    </head>
    <body class="vh-100 vw-100 d-flex position-relative flex-column justify-content-center align-items-center">

        <div id="my"class="col d-flex position-relative flex-column justify-content-center align-items-center">
            <h1 class="text-center row">Create Account</h1>
            <form action="dashboard" method="post">
                <input type="text" placeholder="Enter User Name" id="txtUserName" class="row form-control m-2" name="username"  required="true"/>
                <label id="lblUsernameError" style="color: red">User name Alredy Exists</label>
                <input type="password" placeholder="Enter password"id="txtpassword"class="row form-control m-2" name="password"required="true"/>
                <label id="lblminError">Minum charator 08</label>

                <input type="password" placeholder="Enter  re-enter password "id="txtConfirmPassword"class="row form-control m-2"required="true"/>
                <label id="lblMatch">Password dosn't match</label>
                <input type="text" placeholder="Enter First Name"id="txtFirstName"class="row form-control m-2" name="firstname"required="true"/>
                <input type="text" placeholder="Enter Last Name"id="txtLastName"class="row form-control m-2" name="lastname"required="true"/>
                <input type="text" placeholder="Enter NIC"id="txtNIC" class="row form-control m-2" name="nic"required="true"/>
                <input type="text" placeholder="Enter address"id="txtAddress"class="row form-control m-2"name="address"required="true"/>
                <input type="date" placeholder="Enter DOB"id="txtDOB"class="row form-control m-2" name="dob"required="true"/>
                <input type="email" placeholder="Enter email"id="txtEmail"class="row form-control m-2" name="email"required="true"/>
                <div class="d-flex position-relative flex-column justify-content-center align-items-center m-2">
                    <button type="submit" id="btnAddUser" class="btn btn-primary">Submit</button>
                </div>
            </form>
        </div>

        <script src="https://code.jquery.com/jquery-3.6.1.js" integrity="sha256-3zlB5s2uwoUzrXK3BT7AX3FyvojsraNFxCc2vC/7pNI=" crossorigin="anonymous"></script>
        <script type="text/javascript">
            $(document).ready(function () {
                $('#lblUsernameError').hide();
                $("#lblminError").hide();
                $('#lblMatch').hide();

                $("#txtUserName").on('keyup change past', function () {
                    var data = {username: $('#txtUserName').val(), type: "other"};
                    $.ajax({
                        type: "GET",
                        url: "http://localhost:8080/login/login",
                        data: data,
                        success: function (msg) {

                            if (msg == "true") {
                                $('#lblUsernameError').hide();
                            } else {
                                $('#lblUsernameError').show();
                            }
                        }

                    });
                });

                $('#txtpassword').on('keyup change past', function () {


                    if ($('#txtpassword').val().length >= 8) {
                        $('#lblminError').hide();
                    } else {
                        $('#lblminError').show();
                    }

                });

                $('#txtConfirmPassword').on('keyup change past', function () {



                    if ($('#txtpassword').val() == $('#txtConfirmPassword').val()) {
                        $('#lblMatch').hide();
                    } else {
                        $('#lblMatch').show();
                    }

                });


            });
        </script>
    </body>
</html>
