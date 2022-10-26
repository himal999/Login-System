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
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css" />
       
    <body>
        <main >
            <div>
            <div >
                <img src="<%=request.getContextPath()+"/assets/login_img.png"%>" alt="loginImg"  />
            </div>
            <div class="">
                <form method="post" action="LoginServelet">
                    <h1>Welcome</h1>
                    <div>
                        <input type="text" placeholder="user name or email" name="username" />
                        <input type="password" placeholder="password" name="password" />
                    </div>
                    <div >
                    <p >Don't have an account?<a href="#">create account</a></p>
                    </div>
                    <div >
                        <button type="submit" >Login</button>
                    </div>
                </form>
                
            </div>
        </div>
            </main>
    </body>
</html>
