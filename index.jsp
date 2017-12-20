<%-- 
    Document   : index.jsp
    Created on : 2017/12/19, 13:58:19
    Author     : matsuikoji
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>twitter(仮)</title>
    </head>
    <body>
        <h1>ようこそ</h1>
        <form action="/twitter_m/Login" method="post">
         ユーザー名:<input type="text" name="name"><br>
         パスワード:<input type="password" name="pass"><br>
         <input type="submit" void="ログイン">
            
        </form>
    </body>
</html>
