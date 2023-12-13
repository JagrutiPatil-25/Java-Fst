
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
// Hard-coded credentials (replace with your own)
private static final String VALID_USERNAME = "user";
private static final String VALID_PASSWORD = "password";
protected void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
String username = request.getParameter("username");
String password = request.getParameter("password");
if (username.equals(VALID_USERNAME) && password.equals(VALID_PASSWORD)) {
// Valid login; create a session
HttpSession session = request.getSession();
session.setAttribute("username", username);
// Redirect to the dashboard page
response.sendRedirect("DashboardServlet");
} else {
// Invalid login; forward to the error page
request.setAttribute("error", "Invalid username or password.");
request.getRequestDispatcher("error.html").forward(request, response);
}
}
}