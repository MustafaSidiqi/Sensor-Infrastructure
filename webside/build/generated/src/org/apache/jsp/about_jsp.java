package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class about_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<DOCTYPE html>\n");
      out.write("    <html>\n");
      out.write("        <head>\n");
      out.write("            <title> SensorInfrastructure</title>\n");
      out.write("            <link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">\n");
      out.write("        </head>\n");
      out.write("\n");
      out.write("        <body background=\"img/background.png\">\n");
      out.write("            <ul class=\"nav\">\n");
      out.write("\n");
      out.write("                <div class=\"login\">\n");
      out.write("                    <a href=\"loginCheck.jsp\">LOGIN</a>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <li> <a href=\"index.html\"> Home </a></li>\n");
      out.write("                <li> <a href=\"about.jsp\"> About </a></li>\n");
      out.write("                <li> <a href=\"loginCheck.jsp\"> Services </a></li>\n");
      out.write("\n");
      out.write("            </ul>\n");
      out.write("            <div  class=\"heading\"> </div>\n");
      out.write("\n");
      out.write("            <div align=\"center\" class=\"Services\">\n");
      out.write("\n");
      out.write("                    <h1> About Us </h1>\n");
      out.write("                    <p style=\"color: black; font-size: 18px\"><strong> A new era has begun for the library in DTU Lyngby, it?s a transformation in progress. From being a source of knowledge through books to a source of knowledge of something new. As it?s evolving new projects has started to challenge and discover new ways of using this easy access to information the Internet has given us all. One of these projects is called the Smart Library. With the emerge of Internet of Things, sensors becoming cheaper, and many ?plug-and-play? devices are available to everyone, the library wants to take this opportunity to also become a Living Lab meaning both using the ideas in everyday while also experimenting and developing. One of these project is a complete installation of sensors, gathering all kinds of data. This data will be available to student to use in many ways.</strong> </p>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("        </body>\n");
      out.write("\n");
      out.write("    </html>");
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
