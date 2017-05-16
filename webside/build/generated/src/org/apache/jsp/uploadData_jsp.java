package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import javax.xml.ws.Service;
import javax.xml.namespace.QName;
import javax.xml.namespace.QName;
import java.net.URL;

public final class uploadData_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Request Data</title>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">\n");
      out.write("        <script type=\"text/javascript\" src=\"http://code.jquery.com/jquery.min.js\"></script>\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body background=\"img/background.png\">\n");
      out.write("        <ul class=\"nav\">\n");
      out.write("\n");
      out.write("            <div class=\"login\">\n");
      out.write("                <a href=\"logout.jsp\"> LOGOUT </a>\n");
      out.write("            </div>\n");
      out.write("            <li> <a href=\"index.html\"> Home </a></li>\n");
      out.write("            <li> <a href=\"about.jsp\"> About </a></li>\n");
      out.write("            <li> <a href=\"requestData.jsp\"> Services </a></li>\n");
      out.write("        </ul>\n");
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
      out.write("        <table align=\"center\" border=\"0\" width=\"3\" cellspacing=\"4\" cellpadding=\"6\">\n");
      out.write("            <tbody class=\"table1\">\n");
      out.write("            <div class=\"tab\">\n");
      out.write("                <button class=\"tablinks\" onclick=\"openCity(event, 'Sensor')\" id=\"defaultOpen\">Upload Data</button>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <div id=\"Sensor\" class=\"tabcontent\">\n");
      out.write("                <span onclick=\"this.parentElement.style.display = 'none'\" class=\"topright\"></span>\n");
      out.write("                <div class=\"tab\">\n");
      out.write("                    <button class=\"tablinks\" onclick=\"openCity(event, 'Experimental')\" id=\"defaultOpen\">Experimental Database</button>\n");
      out.write("                    <button class=\"tablinks\" onclick=\"openCity(event, 'Official')\">Official Database</button>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div id=\"Experimental\" class=\"tabcontent\">\n");
      out.write("                <h3>Upload to Experimental Database</h3>\n");
      out.write("                <div>\n");
      out.write("                    <form method=\"post\" action=\"uploadexpdata\">\n");
      out.write("\n");
      out.write("                        <input type=\"number\" name=\"ID\" placeholder=\"Sensor ID\" required>\n");
      out.write("                        <input type=\"text\" name=\"loc\" placeholder=\"Location\" required>\n");
      out.write("                        <br>\n");
      out.write("                        <br>\n");
      out.write("                        <input type=\"text\" name=\"type\" placeholder=\"Type\" required>\n");
      out.write("                        <input type=\"text\" name=\"unit\" placeholder=\"Unit\" required>\n");
      out.write("                        <br>\n");
      out.write("                        <br>\n");
      out.write("                        <input type=\"number\" name=\"value\" placeholder=\"Value\" required>\n");
      out.write("                        <br>\n");
      out.write("                        <br>\n");
      out.write("                        <input type=\"text\" name=\"date\" placeholder=\"YYYY-MM-DD\" required >\n");
      out.write("\n");
      out.write("                        <br>\n");
      out.write("                        <br>\n");
      out.write("                        <input type=\"submit\" name=\"requestSensorByID\" value=\"Send Request\" />\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div id=\"Official\" class=\"tabcontent\">\n");
      out.write("                <h3>Upload to Official Database</h3>\n");
      out.write("                <div>\n");
      out.write("                    <form method=\"post\" action=\"uploadoffdata\">\n");
      out.write("\n");
      out.write("                        <input type=\"number\" name=\"ID\" placeholder=\"Sensor ID\" required>\n");
      out.write("                        <input type=\"text\" name=\"loc\" placeholder=\"Location\" required>\n");
      out.write("                        <br>\n");
      out.write("                        <br>\n");
      out.write("                        <input type=\"text\" name=\"type\" placeholder=\"Type\" required>\n");
      out.write("                        <input type=\"text\" name=\"unit\" placeholder=\"Unit\" required>\n");
      out.write("                        <br>\n");
      out.write("                        <br>\n");
      out.write("                        <input type=\"number\" name=\"value\" placeholder=\"Value\" required>\n");
      out.write("                        <br>\n");
      out.write("                        <br>\n");
      out.write("                        <input type=\"text\" name=\"date\" placeholder=\"YYYY-MM-DD\" required >\n");
      out.write("\n");
      out.write("                        <br>\n");
      out.write("                        <br>\n");
      out.write("                        <input type=\"submit\" name=\"requestSensorByID\" value=\"Send Request\" />\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                </tbody>\n");
      out.write("        </table>\n");
      out.write("    </form>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
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
