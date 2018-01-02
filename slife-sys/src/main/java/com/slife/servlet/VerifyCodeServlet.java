package com.slife.servlet;

import com.slife.util.VerifyCode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

//注解实现
@WebServlet(urlPatterns = "/verifyCodeServlet", description = "验证码接口")
public class VerifyCodeServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        /*
        * 1.生成图片
        * 2.保存图片上的文本到session域中
        * 3.把图片响应给客户端
        */
        VerifyCode vc=new VerifyCode();
        BufferedImage image=vc.getImage();
        //保存图片上的文本到session域
        request.getSession().setAttribute("session_code", vc.getText());

        VerifyCode.output(image, response.getOutputStream());

    }
}
