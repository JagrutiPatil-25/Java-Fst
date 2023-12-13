
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/DashboardServlet")
public class DashboardServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
HttpSession session = request.getSession();
String username = (String) session.getAttribute("username");
if (username != null) {
// User is logged in; display the dashboard
response.getWriter().println("<h1>Welcome to the Dashboard, " + username + "!</h1>");
response.getWriter().println("<a href='LogoutServlet'>Logout</a>");
} else {
// User is not logged in; redirect to the login page
response.sendRedirect("index.html");
}
}
}