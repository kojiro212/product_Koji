<%-- 
    Document   : loginResult
    Created on : 2017/12/19, 14:45:46
    Author     : matsuikoji
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.User"%>
<%
//セッションスコープからユーザー情報を取得
    User loginUser = (User) session.getAttribute("loginUser");%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ツイッター(仮)</title>
    </head>
    <body>
        <h1>ログイン</h1>
        <%if (loginUser != null) {%>
        <p>ログインに成功しました</p>
        <p>ようこそ<%=loginUser.getName()%>さん</p>
        <a href="/twitter_m/Main">つぶやき投稿・閲覧へ</a>
        <% } else { %>
        <p>ログインに失敗しました。</p>
        <a href="/twitter_m/">TOPへ</a>
        <% }%>
    </body>
</html>
