package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;

public class GreetingDisplayServlet extends HttpServlet {

private String fetchGreeting(String code){

if(code==null)
return "Hello";

switch(code){

case "HI": return "Namaste";
case "KN": return "Namaskara";
case "TA": return "Vanakkam";
case "TE": return "Namaskaram";
default: return "Hello";

}
}

protected void doPost(HttpServletRequest request,
HttpServletResponse response)
throws ServletException, IOException {

response.setContentType("text/html");

PrintWriter out=response.getWriter();

String username=request.getParameter("userInputName");

if(username == null || username.trim().isEmpty()) {
    out.println("<h2 style='color:red;'>Please enter your name.</h2>");
    out.println("<a href='enterName.html'>Go Back</a>");
    return;
}
  
HttpSession session=request.getSession(false);

if(session==null){

out.println("<h2 style='color:red;'>Session expired!</h2>");
return;
}

String lang=(String)session.getAttribute("langKey");

String greeting=fetchGreeting(lang);

out.println("<html>");
out.println("<body style='background:#e6ffe6; text-align:center;'>");

out.println("<div style='margin-top:150px;'>");

out.println("<h1 style='color:#006600;'>"
+ greeting + ", " + username + "!"
+ "</h1>");

out.println("<p style='color:#555;'>Welcome to the Language Greeting Application</p>");

out.println("</div>");
out.println("</body>");
out.println("</html>");

}
}
