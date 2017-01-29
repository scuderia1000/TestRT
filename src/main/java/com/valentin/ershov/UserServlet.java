package com.valentin.ershov;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

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
        String car = request.getParameter("car").trim();
        String json = new Gson().toJson(getUsers(lastName, firstName, middleName, city, car));
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }

    private Map<Integer, User> getUsers(String lastName, String firstName, String middleName, String city, String userCarModel) {
        User user = null;
        Map<Integer, User> users = new HashMap<>();
        Connection connection = null;
        String sql = "SELECT DISTINCT t1.id, last_name, first_name, middle_name, city, car.model FROM users t1, user_cars car" +
                " WHERE LOWER(last_name) LIKE CASE WHEN ? = '' THEN '%' ELSE LOWER(?) END" +
                " AND LOWER(first_name) LIKE CASE WHEN ? = '' THEN '%' ELSE LOWER(?) END" +
                " AND LOWER(middle_name) LIKE CASE WHEN ? = '' THEN '%' ELSE LOWER(?) END" +
                " AND LOWER(city) LIKE CASE WHEN ? = '' THEN '%' ELSE LOWER(?) END" +
                " AND LOWER(car.model) LIKE CASE WHEN ? = '' THEN '%' ELSE LOWER(?) END" +
                " AND car.user_id = t1.id";
        try {
            connection = DBUtility.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, lastName);
            stmt.setString(2, lastName);
            stmt.setString(3, firstName);
            stmt.setString(4, firstName);
            stmt.setString(5, middleName);
            stmt.setString(6, middleName);
            stmt.setString(7, city);
            stmt.setString(8, city);
            stmt.setString(9, userCarModel);
            stmt.setString(10, userCarModel);

            ResultSet resultSet = stmt.executeQuery();
            LOG.info("Data received");
            while (resultSet.next()) {
                if (users.containsKey(resultSet.getInt("id"))) {
                    users.get(resultSet.getInt("id")).setCarModel(resultSet.getString("model"));
                } else {
                    user = new User();
                    user.setId(resultSet.getInt("id"));
                    user.setLastName(resultSet.getString("last_name"));
                    user.setFirstName(resultSet.getString("first_name"));
                    user.setMiddleName(resultSet.getString("middle_name"));
                    user.setCity(resultSet.getString("city"));
                    user.setCarModel(resultSet.getString("model"));
                    users.put(user.getId(), user);
                }
            }
        } catch (Exception e) {
            LOG.info("Exception when get user");
        }
        return users;
    }

}
