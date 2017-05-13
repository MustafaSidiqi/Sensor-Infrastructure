<!DOCTYPE html>
<html>

    <head>

        <meta charset="UTF-8">

        <title>CodePen - Log-in</title>

        <link rel='stylesheet' href='http://codepen.io/assets/libs/fullpage/jquery-ui.css'>

        <link rel="stylesheet" href="style2.css" media="screen" type="text/css" />

    </head>

    <body background="img/background.png">
        <div class="login-card">
            <h1>Log-in</h1><br>
            <form method="post" action="myServlet">
                <input type="text" name="user" placeholder="Username" required>
                <input type="password" name="pass" placeholder="Password" required >
                <input type="submit" name="login" class="login login-submit" value="login">
            </form>

            <div class="login-help">
                <a href="register.jsp">Register</a> ? <a href="#">Forgot Password</a>
                <br>
                <textarea rows="0" cols="0" style=" margin: 0px; height: 40px; width: 265px;"> 
                </textarea>
            </div>
        </div>

        <script src='http://codepen.io/assets/libs/fullpage/jquery_and_jqueryui.js'></script>
    </body>

</html>



