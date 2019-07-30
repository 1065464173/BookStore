package sxt.web;

import sxt.dao.impl.UserDaoImpl;
import sxt.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name="LoginServlet", urlPatterns="/LoginServlet")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        UserDaoImpl userimpl = new UserDaoImpl();
        PrintWriter out = response.getWriter();
        User user = null ;
        try {
            String username = request.getParameter("username").trim();
            String password = request.getParameter("password").trim();
            user = userimpl.findUserByUserNameAndPassword(username,password);
            if(user==null){
                out.print("1");//账号密码错误
            }else{
                out.print("2");//登录成功
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
