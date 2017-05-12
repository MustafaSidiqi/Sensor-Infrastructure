<!DOCTYPE html>
<html>

    <head>

        <meta charset="UTF-8">

        <title>CodePen - Log-in</title>


        <link rel="stylesheet" href="style2.css" media="screen" type="text/css" />

    </head>

    <body background="img/background.png">
        <div class="login-card">
            <h1>Sign Up</h1><br>
            <form method="post" action="registerServlet">
                <input type="text" name="user" placeholder="Username" required>
                <input type="password" name="pass" placeholder="Password" required >
                <input type="text" name="email" placeholder="E-mail">
                <input type="submit" name="register" class="login login-submit" value="Register" required>
            </form>

            <div class="login-help">
            </div>
        </div>
        <script src='http://codepen.io/assets/libs/fullpage/jquery_and_jqueryui.js'></script>
    </body>

</html>

