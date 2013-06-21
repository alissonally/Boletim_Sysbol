package br.com.poo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MeuServlet extends HttpServlet {
	/**
	 *
	 */
	private static final long serialVersionUID = -6761813429303946382L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		// escreve o texto
		out.println("<html>");
		out.println("<body>");
		out.println("dasdasda");
		out.println("</body>");
		out.println("</html>");
	}

}
