package sxt.web;

import sxt.Util.VerifyCode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

@WebServlet(name = "RegisterServlet", urlPatterns = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        /*
        验证码
         */
        VerifyCode vc = new VerifyCode();
        BufferedImage verifyCodeimage = vc.getImage();
        String verifyCode = vc.getText();
        vc.outputImage(verifyCodeimage, verifyCode);
        System.out.println(verifyCode);
        request.setAttribute("verifyCode",verifyCode);
        request.setAttribute("verifyCodeimage",verifyCodeimage);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doPost(request,response);
    }
}
