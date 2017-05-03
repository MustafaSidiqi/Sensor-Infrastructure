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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Request Data</title>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <script type=\"text/javascript\" src=\"http://code.jquery.com/jquery.min.js\"></script>\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body background=\"img/background.png\">\n");
      out.write("        <ul class=\"nav\">\n");
      out.write("\n");
      out.write("            <div class=\"login\">\n");
      out.write("                <a href=\"#\">LOGIN </a>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"logo\">\n");
      out.write("                <a href=\"#\">LOGO </a>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <li> <a href=\"index.html\"> Home </a></li>\n");
      out.write("            <li> <a href=\"index.html\"> About </a></li>\n");
      out.write("            <li> <a href=\"\"> Services </a></li>\n");
      out.write("            <li> <a href=\"\"> Contact</a></li>\n");
      out.write("        </ul>\n");
      out.write("\n");
      out.write("        <script>\n");
      out.write("            function openCity(evt, cityName) {\n");
      out.write("                var i, tabcontent, tablinks;\n");
      out.write("                tabcontent = document.getElementsByClassName(\"tabcontent\");\n");
      out.write("                for (i = 0; i < tabcontent.length; i++) {\n");
      out.write("                    tabcontent[i].style.display = \"none\";\n");
      out.write("                }\n");
      out.write("                tablinks = document.getElementsByClassName(\"tablinks\");\n");
      out.write("                for (i = 0; i < tablinks.length; i++) {\n");
      out.write("                    tablinks[i].className = tablinks[i].className.replace(\" active\", \"\");\n");
      out.write("                }\n");
      out.write("                document.getElementById(cityName).style.display = \"block\";\n");
      out.write("                evt.currentTarget.className += \" active\";\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            // Get the element with id=\"defaultOpen\" and click on it\n");
      out.write("            document.getElementById(\"defaultOpen\").click();\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            $(document).ready(function () {\n");
      out.write("                $(\"select\").change(function () {\n");
      out.write("                    $(this).find(\"option:selected\").each(function () {\n");
      out.write("                        var optionValue = $(this).attr(\"value\");\n");
      out.write("                        if (optionValue) {\n");
      out.write("                            $(\".box\").not(\".\" + optionValue).hide();\n");
      out.write("                            $(\".\" + optionValue).show();\n");
      out.write("                        } else {\n");
      out.write("                            $(\".box\").hide();\n");
      out.write("                        }\n");
      out.write("                    });\n");
      out.write("                }).change();\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("        <div class=\"heading\">Services </div>\n");
      out.write("\n");
      out.write("        <table align=\"center\" border=\"0\" width=\"3\" cellspacing=\"4\" cellpadding=\"6\">\n");
      out.write("            <tbody class=\"table1\">\n");
      out.write("            <div class=\"tab\">\n");
      out.write("                <button class=\"tablinks\" onclick=\"openCity(event, 'Sensor')\" id=\"defaultOpen\">Sensor</button>\n");
      out.write("                <button class=\"tablinks\" onclick=\"openCity(event, 'Location')\">Location</button>\n");
      out.write("                <button class=\"tablinks\" onclick=\"openCity(event, 'Tokyo')\">Date</button>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div id=\"Sensor\" class=\"tabcontent\">\n");
      out.write("                <span onclick=\"this.parentElement.style.display = 'none'\" class=\"topright\">x</span>\n");
      out.write("                <h3>Sensor</h3>\n");
      out.write("                <div>\n");
      out.write("                    <form method=\"Post\" action=\"myServlet\">\n");
      out.write("                        <select name=\"database\">\n");
      out.write("                            <option>Choose Database</option>\n");
      out.write("                            <option value=\"offdata\">Main</option>\n");
      out.write("                            <option value=\"expdata\">Exp</option>\n");
      out.write("                        </select>\n");
      out.write("                        <select name=\"SensorID\">\n");
      out.write("                            <option value=\"0\">0</option>\n");
      out.write("                            <option value=\"1\">1</option>\n");
      out.write("                            <option value=\"2\">2</option>\n");
      out.write("                            <option value=\"3\">3</option>\n");
      out.write("                        </select>\n");
      out.write("                        <input type='submit' />\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("                        <div id=\"Location\" class=\"tabcontent\">\n");
      out.write("                <span onclick=\"this.parentElement.style.display = 'none'\" class=\"topright\">x</span>\n");
      out.write("                <h3>Location</h3>\n");
      out.write("                <div>\n");
      out.write("                    <form method=\"Post\" action=\"myServlet\">\n");
      out.write("                        <select name=\"database\">\n");
      out.write("                            <option>Choose Database</option>\n");
      out.write("                            <option value=\"offdata\">Main</option>\n");
      out.write("                            <option value=\"expdata\">Exp</option>\n");
      out.write("                        </select>\n");
      out.write("                        <select name=\"SensorID\">\n");
      out.write("                            <option value=\"Lyngby\">Lyngby</option>\n");
      out.write("                            <option value=\"Stue\">Stue</option>\n");
      out.write("                        </select>\n");
      out.write("                        <input type='submit' />\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            \n");
      out.write("        </tbody>\n");
      out.write("    </table>\n");
      out.write("</form>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("\n");
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
