package controller.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.DatabaseController;
import model.UserModel;
import util.StringUtils;

@WebServlet(asyncSupported = true, urlPatterns = { "/RegisterServlet" })
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    DatabaseController dbController = new DatabaseController();

    public RegisterServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter printOut = response.getWriter();
        response.setContentType("text/html");
        printOut.print("Hello World!");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userName = request.getParameter(StringUtils.USER_NAME);
        String firstName = request.getParameter(StringUtils.FIRST_NAME);
        String lastName = request.getParameter(StringUtils.LAST_NAME);
        String dobString = request.getParameter(StringUtils.BIRTHDAY);
        LocalDate dob = LocalDate.parse(dobString);
        String role = request.getParameter(StringUtils.ROLE);
        String email = request.getParameter(StringUtils.EMAIL);
        String address = request.getParameter(StringUtils.ADDRESS);
        String phoneNumber = request.getParameter(StringUtils.PHONE_NUMBER);
        String subject = request.getParameter(StringUtils.SUBJECT);
        String password = request.getParameter(StringUtils.PASSWORD);
        String retypePassword = request.getParameter(StringUtils.RETYPE_PASSWORD);

        // Additional code to handle registration
        UserModel studentModel = new UserModel(firstName, lastName, dob, address, email, phoneNumber, subject, userName,
                password);

        int result = dbController.addStudent(studentModel);

        if (password.equals(retypePassword)) {
            switch (result) {
                case 1:
                    request.setAttribute(StringUtils.SUCCESS_MESSAGE, StringUtils.SUCCESS_REGISTER_MESSAGE);
                    response.sendRedirect(request.getContextPath() + StringUtils.LOGIN_PAGE);
                    break;
                case 0:
                    request.setAttribute(StringUtils.ERROR_MESSAGE, StringUtils.REGISTER_ERROR_MESSAGE);
                    request.getRequestDispatcher(StringUtils.REGISTER_PAGE).forward(request, response);
                    break;
                case -1:
                    request.setAttribute(StringUtils.ERROR_MESSAGE, StringUtils.SERVER_ERROR_MESSAGE);
                    request.getRequestDispatcher(StringUtils.REGISTER_PAGE).forward(request, response);
                    break;
                case -2:
                    request.setAttribute(StringUtils.ERROR_MESSAGE, StringUtils.USERNAME_ERROR_MESSAGE);
                    request.getRequestDispatcher(StringUtils.REGISTER_PAGE).forward(request, response);
                    break;
                case -3:
                    request.setAttribute(StringUtils.ERROR_MESSAGE, StringUtils.EMAIL_ERROR_MESSAGE);
                    request.getRequestDispatcher(StringUtils.REGISTER_PAGE).forward(request, response);
                    break;
                case -4:
                    request.setAttribute(StringUtils.ERROR_MESSAGE, StringUtils.PHONE_ERROR_MESSAGE);
                    request.getRequestDispatcher(StringUtils.REGISTER_PAGE).forward(request, response);
                    break;
                default:
                    request.setAttribute(StringUtils.ERROR_MESSAGE, StringUtils.SERVER_ERROR_MESSAGE);
                    request.getRequestDispatcher(StringUtils.REGISTER_PAGE).forward(request, response);
                    break;
            }
        } else {
            request.setAttribute(StringUtils.ERROR_MESSAGE, StringUtils.PASSWORD_ERROR_MESSAGE);
            request.getRequestDispatcher(StringUtils.REGISTER_PAGE).forward(request, response);
        }

    }
}
