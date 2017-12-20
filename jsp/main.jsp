<%-- 
    Document   : main
    Created on : 2017/12/19, 15:41:43
    Author     : matsuikoji
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.User"%>
<%@page import="model.User,model.Mutter,java.util.ArrayList"%>
<%//セッションに保存されたユーザー情報を取得
    User loginUser = (User) session.getAttribute("loginUser");
%>
<%//アプリケーションスコープに保存されたつぶやきリストを取得
    ArrayList<Mutter> mutterList = (ArrayList<Mutter>) application.getAttribute("mutterList");%>
   <% //リクエストスコープに保存されたエラーメッセージを取得
   String errorMsg =(String) request.getAttribute("errorMsg");%>
    
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ツイッター(仮)</title>
    </head>
    <body>
        <h1>メイン画面</h1>
        <p>
            <%= loginUser.getName()%>さん、ログイン中
            <a href="/twitter_m/Logout">ログアウト</a>
        </p>
        <p><a href="/twitter_m/Main">更新</a></p>
        <form action="/twitter_m/Main" method="post">
            <input type="text" name="text">
            <input type="submit" value="つぶやく">
        </form>
        <%if(errorMsg!=null){%>
        <p><%=errorMsg%></p>
        <%}%>
        <%
            for (Mutter mutter : mutterList) {%>
        <p><%=mutter.getText()%></p>
        <%}%>
    </body>
</html>
