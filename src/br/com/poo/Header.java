package br.com.poo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Header extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8810342733649978596L;

	/**
	 * @param args
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=UTF-8");//Corrige problema de acentuação
		// Header
		out.println("<!DOCTYPE HTML>");
		out.println("<html lang=\"pt-BR\">");
		out.println("<head>");
		out.println("    <meta charset=\"UTF-8\">");
		out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
		out.println("    <title>Academico - Alisson </title>");
		out.println("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
		out.println("    <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\" media=\"screen\">");
		out.println("    <link href=\"css/bootstrap-responsive.min.css\" rel=\"stylesheet\" media=\"screen\">");
		out.println("    <link href=\"css/style.css\" rel=\"stylesheet\" media=\"screen\">");
		out.println("    <!--[if lt IE 9]>");
		out.println("        <script src=\"js/html5shiv.js\"></script>");
		out.println("     <![endif]-->");
		out.println("</head>");
		out.println("<body>");
		out.println("    <div class=\"navbar navbar-fixed-top\">");
		out.println("      <div class=\"navbar-inner\">");
		out.println("        <div class=\"container-fluid\">");
		out.println("          <a class=\"brand\" href=\"#\">Boletim On-line</a>");
		out.println("          </div><!--/.nav-collapse -->");
		out.println("        </div>");
		out.println("      </div>");
		out.println("    <div class=\"container-fluid\">");
		out.println("    <div class=\"row-fluid\">");
	}

}
 