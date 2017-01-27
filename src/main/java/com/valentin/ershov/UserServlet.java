package com.valentin.ershov;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Set;

/**
 * Created by Valek on 27.01.2017.
 */
@WebServlet("/getUserServlet")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final Logger LOG = LoggerFactory.getLogger(DBUtility.class);


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String lastName = request.getParameter("lastName").trim();
        String firstName = request.getParameter("firstName").trim();
        String middleName = request.getParameter("middleName").trim();
        String city = request.getParameter("city").trim();
//        lastName = URLDecoder.decode(lastName, "UTF-8");
//        if (lastName == null || "".equals(lastName)) {
//            lastName = "Guest";
//        }
        User user = getUser(lastName, firstName, middleName, city);

        String greetings = "Hello " + user.getLastName() + " " + user.getFirstName() + " " + user.getMiddleName() + " " + user.getCity();

        response.setContentType("text/plain;charset=UTF-8");
        response.getWriter().write(greetings);
    }

    private User getUser(String lastName, String firstName, String middleName, String city) {
        User user = new User();
        String sql = "SELECT * FROM users WHERE last_name LIKE CASE WHEN ? = '' THEN '%' ELSE ? END" +
                " AND first_name LIKE CASE WHEN ? = '' THEN '%' ELSE ? END" +
                " AND middle_name LIKE CASE WHEN ? = '' THEN '%' ELSE ? END" +
                " AND city LIKE CASE WHEN ? = '' THEN '%' ELSE ? END";
        try {
            PreparedStatement stmt = DBUtility.getConnection().prepareStatement(sql);
            stmt.setString(1, lastName);
            stmt.setString(2, lastName);
            stmt.setString(3, firstName);
            stmt.setString(4, firstName);
            stmt.setString(5, middleName);
            stmt.setString(6, middleName);
            stmt.setString(7, city);
            stmt.setString(8, city);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                user.setLastName(resultSet.getString("last_name"));
                user.setFirstName(resultSet.getString("first_name"));
                user.setMiddleName(resultSet.getString("middle_name"));
                user.setCity(resultSet.getString("city"));
            }
        } catch (Exception e) {
            LOG.info("Exception when get user");
        }
        return user;
    }

    private Set<Car> getCars(Integer userId) {
        return null;
    }
}
