package util;

public class StringUtils {

    // Start SQL Queries
    public static final String INSERT_STUDENT = "INSERT INTO main_student_info "
            + " (user_name, first_name, last_name, dob, role, email, address, phone_number, subject, password) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) ";

    public static final String GET_LOGIN_STUDENT_INFO = "SELECT * FROM main_student_info WHERE user_name = ? AND password = ?";

    public static final String GET_ALL_STUDENT_INFO = "SELECT * FROM main_student_info";
    public static final String GET_USERNAME = "Select COUNT(*) from main_student_info where user_name = ?";
    public static final String GET_PHONE = "Select COUNT(*) FROM main_student_info WHERE phone_number = ?";
    public static final String GET_EMAIL = "Select COUNT(*) FROM main_student_info WHERE email = ?";
    // End SQL Queries

    // Start messages
    public static final String SUCCESS_REGISTER_MESSAGE = "Successfully Registered!";
    public static final String REGISTER_ERROR_MESSAGE = "Please correct the form data. ";
    public static final String SERVER_ERROR_MESSAGE = "An unexpected server error occurred.";
    public static final String SUCCESS_MESSAGE = "successMessage";
    public static final String ERROR_MESSAGE = "errorMessage";
    public static final String USERNAME_ERROR_MESSAGE = "Username already registered";
    public static final String EMAIL_ERROR_MESSAGE = "Email already registered";
    public static final String PHONE_ERROR_MESSAGE = "Phone number already registered";
    public static final String PASSWORD_ERROR_MESSAGE = "Password is not matched";
    public static final String MESSAGE_SUCCESS_LOGIN = "Successfully LoggedIn!";
    // End messages

    // Start JSP Route

    public static final String LOGIN_PAGE = "/pages/login.jsp";
    public static final String REGISTER_PAGE = "/pages/register.jsp";
    public static final String PAGE_URL_WELCOME = "/pages/welcome.jsp";
    public static final String LOGOUT_SERVLET = "/LogoutServlet";
    public static final String LOGIN_SERVLET = "/LoginServlet";

    // End JSP Route

    // Start JSP Route
    public static final String REGISTER_SERVLET = "/RegisterServlet";
    // End JSP Route

    // Start Parameter names
    public static final String USER_NAME = "username";
    public static final String FIRST_NAME = "firstName";
    public static final String LAST_NAME = "lastName";
    public static final String BIRTHDAY = "birthday";
    public static final String ROLE = "role";
    public static final String ADDRESS = "address";
    public static final String EMAIL = "email";
    public static final String PHONE_NUMBER = "phoneNumber";
    public static final String SUBJECT = "subject";
    public static final String PASSWORD = "password";
    public static final String RETYPE_PASSWORD = "retypePassword";

    public static final String USER = "user";
    public static final String JSESSIONID = "JSESSIONID";

}
