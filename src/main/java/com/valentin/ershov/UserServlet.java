package com.valentin.ershov;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by Valek on 27.01.2017.
 */
@WebServlet("/getUserServlet")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final Logger LOG = LoggerFactory.getLogger(DBUtility.class);


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userName = request.getParameter("userName").trim();
        if (userName == null || "".equals(userName)) {
            userName = "Guest";
        }

        String greetings = "Hello " + userName;

        response.setContentType("text/plain");
        response.getWriter().write(greetings);
    }

    private User getUser(String lastName, String firstName, String middleName, String city) {
        User user = new User();
        String sql = "SELECT * FROM users WHERE last_name = ?";
        try {
            PreparedStatement stmt = DBUtility.getConnection().prepareStatement(sql);
            stmt.setString(1, lastName);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                user.setLastName(resultSet.getString("last_name"));
            }
        } catch (Exception e) {
            LOG.info("Exception when get user");
        }
        return user;

    }
}
