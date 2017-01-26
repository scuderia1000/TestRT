package com.valentin.ershov;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Valek on 27.01.2017.
 */
@WebServlet("/getUserServlet")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userName = request.getParameter("userName").trim();
        if (userName == null || "".equals(userName)) {
            userName = "Guest";
        }

        String greetings = "Hello " + userName;

        response.setContentType("text/plain");
        response.getWriter().write(greetings);
    }
}
