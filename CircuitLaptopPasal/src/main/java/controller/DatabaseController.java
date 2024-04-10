package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.UserModel;
import util.StringUtils;

public class DatabaseController {

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/college_app";
        String user = "root";
        String pass = "";
        return DriverManager.getConnection(url, user, pass);
    }

    public int addStudent(UserModel studentModel) {
        try (Connection con = getConnection()) {

            // Check for existing user name
            PreparedStatement checkUsernameSt = con.prepareStatement(StringUtils.GET_USERNAME);
            checkUsernameSt.setString(1, studentModel.getUsername());
            ResultSet checkUsernameRs = checkUsernameSt.executeQuery();
            checkUsernameRs.next();
            if (checkUsernameRs.getInt(1) > 0) {
                return -2; // User name already exists
            }

            // Check for existing phone number
            PreparedStatement checkPhoneSt = con.prepareStatement(StringUtils.GET_PHONE);
            checkPhoneSt.setString(1, studentModel.getPhoneNumber());
            ResultSet checkPhoneRs = checkPhoneSt.executeQuery();
            checkPhoneRs.next();
            if (checkPhoneRs.getInt(1) > 0) {
                return -4; // Phone number already exists
            }

            // Check for existing email
            PreparedStatement checkEmailSt = con.prepareStatement(StringUtils.GET_EMAIL);
            checkEmailSt.setString(1, studentModel.getEmail());
            ResultSet checkEmailRs = checkEmailSt.executeQuery();
            checkEmailRs.next();
            if (checkEmailRs.getInt(1) > 0) {
                return -3; // Email already exists
            }

            PreparedStatement st = con.prepareStatement(StringUtils.INSERT_STUDENT);

            st.setString(1, studentModel.getUsername());
            st.setString(2, studentModel.getFirstName());
            st.setString(3, studentModel.getLastName());
            st.setDate(4, Date.valueOf(studentModel.getDob()));
            st.setString(5, studentModel.getRole());
            st.setString(6, studentModel.getEmail());
            st.setString(7, studentModel.getPhoneNumber());
            st.setString(8, studentModel.getSubject());
            st.setString(9, studentModel.getPassword());

            int result = st.executeUpdate();
            return result > 0 ? 1 : 0;

        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
            return -1;
        }
    }

    public int getStudentLoginInfo(String username, String password) {
        try (Connection con = getConnection()) {
            PreparedStatement st = con.prepareStatement(StringUtils.GET_LOGIN_STUDENT_INFO);
            st.setString(1, username);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                // User name and password match in the database
                return 1;
            } else {
                // No matching record found
                return 0;
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace(); // Log the exception for debugging
            return -1;
        }
    }
}