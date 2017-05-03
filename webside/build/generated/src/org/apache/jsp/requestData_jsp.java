package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.xml.ws.Service;
import javax.xml.namespace.QName;
import javax.xml.namespace.QName;
import java.net.URL;

public final class requestData_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>Request Data</title>\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <script type=\"text/javascript\" src=\"http://code.jquery.com/jquery.min.js\"></script>\r\n");
      out.write("        <script type=\"text/javascript\">\r\n");
      out.write("        </script>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body background=\"img/background.png\">\r\n");
      out.write("        <ul class=\"nav\">\r\n");
      out.write("\r\n");
      out.write("            <div class=\"login\">\r\n");
      out.write("                <a href=\"#\">LOGIN </a>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"logo\">\r\n");
      out.write("                <a href=\"#\">LOGO </a>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <li> <a href=\"index.html\"> Home </a></li>\r\n");
      out.write("            <li> <a href=\"index.html\"> About </a></li>\r\n");
      out.write("            <li> <a href=\"\"> Services </a></li>\r\n");
      out.write("            <li> <a href=\"\"> Contact</a></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("\r\n");
      out.write("        <script>\r\n");
      out.write("            function openCity(evt, cityName) {\r\n");
      out.write("                var i, tabcontent, tablinks;\r\n");
      out.write("                tabcontent = document.getElementsByClassName(\"tabcontent\");\r\n");
      out.write("                for (i = 0; i < tabcontent.length; i++) {\r\n");
      out.write("                    tabcontent[i].style.display = \"none\";\r\n");
      out.write("                }\r\n");
      out.write("                tablinks = document.getElementsByClassName(\"tablinks\");\r\n");
      out.write("                for (i = 0; i < tablinks.length; i++) {\r\n");
      out.write("                    tablinks[i].className = tablinks[i].className.replace(\" active\", \"\");\r\n");
      out.write("                }\r\n");
      out.write("                document.getElementById(cityName).style.display = \"block\";\r\n");
      out.write("                evt.currentTarget.className += \" active\";\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            // Get the element with id=\"defaultOpen\" and click on it\r\n");
      out.write("            document.getElementById(\"defaultOpen\").click();\r\n");
      out.write("        </script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <script type=\"text/javascript\">\r\n");
      out.write("            $(document).ready(function () {\r\n");
      out.write("                $(\"select\").change(function () {\r\n");
      out.write("                    $(this).find(\"option:selected\").each(function () {\r\n");
      out.write("                        var optionValue = $(this).attr(\"value\");\r\n");
      out.write("                        if (optionValue) {\r\n");
      out.write("                            $(\".box\").not(\".\" + optionValue).hide();\r\n");
      out.write("                            $(\".\" + optionValue).show();\r\n");
      out.write("                        } else {\r\n");
      out.write("                            $(\".box\").hide();\r\n");
      out.write("                        }\r\n");
      out.write("                    });\r\n");
      out.write("                }).change();\r\n");
      out.write("            });\r\n");
      out.write("        </script>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"heading\">Services </div>\r\n");
      out.write("\r\n");
      out.write("        <table align=\"center\" border=\"0\" width=\"3\" cellspacing=\"4\" cellpadding=\"6\">\r\n");
      out.write("            <tbody class=\"table1\">\r\n");
      out.write("            <div class=\"tab\">\r\n");
      out.write("                <button class=\"tablinks\" onclick=\"openCity(event, 'Sensor')\" id=\"defaultOpen\">Sensor</button>\r\n");
      out.write("                <button class=\"tablinks\" onclick=\"openCity(event, 'Location')\">Location</button>\r\n");
      out.write("                <button class=\"tablinks\" onclick=\"openCity(event, 'Tokyo')\">Date</button>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div id=\"Sensor\" class=\"tabcontent\">\r\n");
      out.write("                <span onclick=\"this.parentElement.style.display = 'none'\" class=\"topright\">x</span>\r\n");
      out.write("                <h3>Sensor</h3>\r\n");
      out.write("                <div>\r\n");
      out.write("                    <form method=\"Post\" action=\"myServlet\">\r\n");
      out.write("                        <select name=\"database\">\r\n");
      out.write("                            <option>Choose Database</option>\r\n");
      out.write("                            <option value=\"offdata\">Main</option>\r\n");
      out.write("                            <option value=\"expdata\">Exp</option>\r\n");
      out.write("                        </select>\r\n");
      out.write("                        <select name=\"SensorID\">\r\n");
      out.write("                            <option value=\"0\">0</option>\r\n");
      out.write("                            <option value=\"1\">1</option>\r\n");
      out.write("                            <option value=\"2\">2</option>\r\n");
      out.write("                            <option value=\"3\">3</option>\r\n");
      out.write("                        </select>\r\n");
      out.write("                        <input type='submit' />\r\n");
      out.write("                    </form>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                <textarea rows=\"4\" cols=\"50\">\r\n");
      out.write("                </textarea>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div id=\"Location\" class=\"tabcontent\">\r\n");
      out.write("                <span onclick=\"this.parentElement.style.display = 'none'\" class=\"topright\">x</span>\r\n");
      out.write("                <h3>Location</h3>\r\n");
      out.write("                <div>\r\n");
      out.write("                    <form method=\"Post\" action=\"myServlet\">\r\n");
      out.write("                        <select name=\"database\">\r\n");
      out.write("                            <option>Choose Database</option>\r\n");
      out.write("                            <option value=\"offdata\">Main</option>\r\n");
      out.write("                            <option value=\"expdata\">Exp</option>\r\n");
      out.write("                        </select>\r\n");
      out.write("                        <select name=\"SensorID\">\r\n");
      out.write("                            <option value=\"Lyngby\">Lyngby</option>\r\n");
      out.write("                            <option value=\"Stue\">Stue</option>\r\n");
      out.write("                        </select>\r\n");
      out.write("                        <input type='submit' />\r\n");
      out.write("                    </form>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        </tbody>\r\n");
      out.write("    </table>\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>");
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
