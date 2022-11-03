<%-- 
    Document   : index
    Created on : Oct 26, 2022, 7:34:52 AM
    Author     : himal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>

        <style>

            *{
                box-sizing: border-box;
                margin: 0;
                padding: 0;


            }
            button{
                box-shadow: -1px 13px 27px -12px rgba(0,0,0,0.81);
                -webkit-box-shadow: -1px 13px 27px -12px rgba(0,0,0,0.81);
                -moz-box-shadow: -1px 13px 27px -12px rgba(0,0,0,0.81);
            }

            input{
                border: none;
                outline: none
            }
            .input_container{
                border: 1px black solid;
                width: 95%;
                height: 40px;
                display: flex;
                flex-direction: row;
                align-items: center;
                padding-left: 10px;
                padding-right: 10px;
                border-radius: 20px;
                margin-bottom: 5px
                    

            }


            main{
                width: 100%;
                height: 100vh;
                display: flex;
                flex-direction: row;
                justify-content: center;
                align-items: center;
                align-content: center;
        
                background: url('./assets/css/login_bg.jpg')no-repeat;
                background-size: cover;
                background-position: 100%;
                opacity: 1
                   

            }
            .cart{
                display: flex;
                flex-direction: row;

                align-items: center;
                background-color: green;
                min-height: 450px;
                min-width: 700px;
                background-color: white;

                border-radius: 20px;
            }
            .video_container{
                min-width: 50%;
                min-height:450px;
                background: url("./assets/css/night.gif") no-repeat ;
                background-size: cover;
                background-position: 100%;
                color: white;
                border-top-left-radius: 20px;
                border-bottom-left-radius: 20px;
                padding: 10px;
                padding-left: 20px;
                justify-content: center;
                align-items: start;
                display: flex;
                flex-direction: column;



            }
            .video_container>h2{
                font-size: 35px;
                font-weight: bold;
                margin-bottom:  .5em;

            }
            .video_container>p{
                color:darkgrey;
                font-size: 12px;

            }
            .login_container{

                width: 50%;
                height: 100%;
                display: flex;
                flex-direction: column;
                justify-content: center;
                align-items: center;
            }
            .login_form>h1{
                font-weight: 200;

            }
            .login_info_container_username{
                margin-bottom: 10px
            }

        </style> 
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A==" crossorigin="anonymous" referrerpolicy="no-referrer" />

        <!--        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous"/>-->
    </head>
    <body>

        <main>

            <div class="cart">
                <div class="video_container">
<!--                    <img src="<%=request.getContextPath() + "/assets/css/night.gif"%>" alt="loginImg"  />-->
                    <h2>Welcome back,</h2>
                    <p>to start you future in today !!!</p>
                    <p>please login and start your work shop &#128512;</p> 
                </div>
                <div class="login_container">
                    <form action="login" method="post" class="login_form">
                        <h1>Sign in</h1>
                        <div style=" margin-top: 15px;margin-bottom: 5px;display: flex;flex-direction: column;justify-content: center">
                            <div class="login_info_container_username">
                                <div class="input_container">
                                    <i class="fa-regular fa-user" style=" margin-right: 10px"></i>
                                    <input type="text"  style=" width: 75%" id="username" placeholder="user name" name="username">

                                </div>
                                <label id="lblusernameerror" style="font-size: 13px; background-color:rgba(0, 0, 0, 0.3);padding: 5px;border-radius: 20px;opacity: 0.9;padding-left: 10px;padding-right: 10px ">not available user</label>
                            </div>
                            <div>
                                <div  id="pwcontainer" class="input_container">
                                    <i class="fa-solid fa-lock"style="margin-right: 10px"></i>
                                    <input type="password" style=" width: 75%;" id="password" placeholder="Password" name="password">
                                    <i class="fa-regular fa-eye-slash" id="lblvisiblepassword" style=" margin-left: 5px"></i>

                                </div>
                                <label id="lblpwerror"style="font-size: 13px; background-color:rgba(0, 0, 0, 0.3);padding: 5px;border-radius: 20px;opacity: 0.9;padding-left: 10px;padding-right: 10px ">required min charactor 08</label>
                            </div>


                        </div>
                        <div>
                            <p  style=" color:#57606f;font-size: 13px">Don't have an account?<a href="http://localhost:8080/login/signup.jsp" style=" font-size: 12px">create account</a></p>
                        </div>
                        <div  style="display: flex;flex-direction: column;align-items: center" >
                            <button type="submit" style="color: white; width: 90%; position: relative; left: -3px; text-align: center; border: none;outline: none;margin-top: 25px; padding-top: 10px;padding-bottom: 10px;border-radius: 20px;font-size: 17px; background-color: #5352ed" >Login</button>
                        </div>
                    </form>

                </div>
            </div>
        </main>

        <script src="https://code.jquery.com/jquery-3.6.1.js" integrity="sha256-3zlB5s2uwoUzrXK3BT7AX3FyvojsraNFxCc2vC/7pNI=" crossorigin="anonymous"></script>
        <script type="text/javascript">
            $(document).ready(function () {

                $("#lblpwerror").hide();
                $("#lblusernameerror").hide();

                $('#btnLogin').attr('disabled', 'disabled');




                $("#btnLogin").attr('disabled', 'disabled');




                $("#username").on("change keyup past", function () {

                    var data = {username: $('#username').val(), type: "LOGIN"};

                    $.ajax({
                        type: "get",
                        url: "http://localhost:8080/login/login",
                        data: data,
                        success: function (msg) {

                            if (msg == "true") {
                                $("#lblusernameerror").hide();
                                if ($("#username").val().length > 0 && $("#password").val().length >= 8) {
                                    $('#btnLogin').removeAttr('disabled');
                                }
                            } else {
                                $("#lblusernameerror").show();
                                $('#btnLogin').attr('disabled', 'disabled');
                            }
                        }
                    });
                });

                $("#password").on('change keyup past', function () {
                    if ($(this).val().length < 8) {
                        $("#lblpwerror").show();
                        $('#btnLogin').attr('disabled', 'disabled');

                    } else {
                        $("#lblpwerror").hide();
                        if ($("#username").val().length > 0 && $("#password").val().length >= 8) {
                            $('#btnLogin').removeAttr('disabled');
                        }
                    }
                });


                // send login request

//                $('#btnLogin').click(function () {
//                    var info = {username: $('#username').val(), password: $("#password").val()};
//                    $.ajax({
//                        type: "post",
//                        url: "http://localhost:8080/login/login",
//                        dataType: "text",
//
//                        data: info,
//                        success: function (msg) {
//
//
//
//                            if (msg === "SUCCESS") {
//                            
//                                window.location.href = "dashboard.jsp";
//                            } else if (msg === "USERNAME_INCORRECT") {
//                                alert("Please enter valid user name ");
//                            } else if (msg === "PASSWORD_INCORRECT") {
//                                alert("Please enter valid  password");
//                            } else {
//                                alert("FAILD to LOGIN");
//                            }
//
//                        },
//                        error: function (err) {
//
//                        }
//
//
//                    });
//                });
            });
        </script>
    </body>
</html>
