/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;

import model.Mutter;
import model.User;
import model.PostMutterLogic;

/**
 *
 * @author matsuikoji
 */
public class Main extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //つぶやきリストをアプリケーションスコープから取得
        ServletContext application = this.getServletContext();
        ArrayList<Mutter> mutterList = (ArrayList<Mutter>) application.getAttribute("mutterList");
        //取得できなかった場合は、つぶやきリストを新規作成して
        //アプリケーションスコープにお保存
        if (mutterList == null) {
            mutterList = new ArrayList<Mutter>();
            application.setAttribute("mutterList", mutterList);

        }
        //ログインしているかを確認するため
        //セッションスコープからユーザー情報を取得
        HttpSession session = request.getSession();
        User loginUser = (User) session.getAttribute("loginUser");

        //ログインしていない場合
        if (loginUser == null) {
            //リダイレクト
            response.sendRedirect("/Twitter_m/");
        } else {
//ログイン済みの場合
            //フォワード
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
            dispatcher.forward(request, response);
            processRequest(request, response);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //リクエストパラメーターの取得
        request.setCharacterEncoding("UTF-8");
        String text = request.getParameter("text");
        //入力値チェック
        if (text != null && text.length() != 0) {
            //アプリケーションスコープに保存されたつぶやきリストを取得
            ServletContext application = this.getServletContext();
            ArrayList<Mutter> mutterList = (ArrayList<Mutter>) application.getAttribute("mutterList");
            //アプリケーションスコープに保存されたユーザー情報を取得
            HttpSession session = request.getSession();
            User loginUser = (User) session.getAttribute("loginUser");

            //つぶやきをつぶやきリストに追加
            Mutter mutter = new Mutter(loginUser.getName(), text);
            PostMutterLogic postMutterLogic = new PostMutterLogic();
            postMutterLogic.execute(mutter, mutterList);

            //アプリケーションスコープにつぶやきリストを保存
            application.setAttribute("mutterList", mutterList);
        }else{
            //エラーメッセージをリクエストスコープに保存
            request.setAttribute("errorMsg", "つぶやきが入力されていません");
        }
        //メイン画面にフォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
        dispatcher.forward(request, response);
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
