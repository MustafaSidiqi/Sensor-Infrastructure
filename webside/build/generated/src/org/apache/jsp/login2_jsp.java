package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login2_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("    <head>\r\n");
      out.write("\r\n");
      out.write("        <meta charset=\"UTF-8\">\r\n");
      out.write("\r\n");
      out.write("        <title>CodePen - Log-in</title>\r\n");
      out.write("\r\n");
      out.write("        <link rel='stylesheet' href='http://codepen.io/assets/libs/fullpage/jquery-ui.css'>\r\n");
      out.write("\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"style2.css\" media=\"screen\" type=\"text/css\" />\r\n");
      out.write("\r\n");
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("    <body background=\"img/background.png\">\r\n");
      out.write("        <div class=\"login-card\">\r\n");
      out.write("            <h1>Log-in</h1><br>\r\n");
      out.write("            <form method=\"post\" action=\"myServlet\">\r\n");
      out.write("                <input type=\"text\" name=\"user\" placeholder=\"Username\" required>\r\n");
      out.write("                <input type=\"password\" name=\"pass\" placeholder=\"Password\" required >\r\n");
      out.write("                <input type=\"submit\" name=\"login\" class=\"login login-submit\" value=\"login\">\r\n");
      out.write("            </form>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"login-help\">\r\n");
      out.write("                <a href=\"register.jsp\">Register</a> ? <a href=\"#\">Forgot Password</a>\r\n");
      out.write("                <br>\r\n");
      out.write("                <textarea rows=\"0\" cols=\"50\" style=\" margin: 0px; height: 40px; width: 265px;\"> \r\n");
      out.write("                    ");

                        
                        int userID = (int) request.getAttribute("loginVal");
                        if (userID != 0) {
                            out.print("User: " + userID);
                        } else {
                            out.print("User: N/A");

                        }
                         

                    
      out.write("\r\n");
      out.write("                </textarea>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <script src='http://codepen.io/assets/libs/fullpage/jquery_and_jqueryui.js'></script>\r\n");
      out.write("    </body>\r\n");
      out.write("\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
