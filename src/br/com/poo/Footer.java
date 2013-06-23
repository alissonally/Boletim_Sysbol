package br.com.poo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Footer extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6233538803297504889L;

	/**
	 * @param args
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=UTF-8");//Corrige problema de acentuação
		// Rodapé
		out.println("    </div>");
		out.println("</div>");
		out.println("<hr>");
		out.println("<div class=\"container-fluid\">");
		out.println("<footer class=\"well\">");
		out.println("        <p>© Sybol 2013</p>");
		out.println("</footer>");
		out.println("</div>");
		out.println("</body>");
		out.println("<script src=\"js/jquery.js\" type=\"text/javascript\"></script>");
		out.println("<script src=\"js/bootstrap.min.js\" type=\"text/javascript\"></script>");
		out.println("<script src=\"js/jquery.maskedinput.js\" type=\"text/javascript\"></script>");
		out.println("<script src=\"js/functions.js\" type=\"text/javascript\" charset=\"utf-8\"></script>");
		out.println("</html>");
	}

}
