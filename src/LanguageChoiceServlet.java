package controller;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

public class LanguageChoiceServlet extends HttpServlet {

protected void doPost(HttpServletRequest request,
HttpServletResponse response)
throws ServletException, IOException {


String selectedCode = request.getParameter("languageOption");

if(selectedCode == null) {
    response.sendRedirect("index.html");
    return;
}

HttpSession session = request.getSession(true);

session.setAttribute("langKey", selectedCode);

response.sendRedirect("enterName.html");

}
}
