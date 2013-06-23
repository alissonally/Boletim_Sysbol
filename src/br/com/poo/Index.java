package br.com.poo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Index extends HttpServlet {
	/**
	 *
	 */
	private static final long serialVersionUID = -6761813429303946382L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=UTF-8");//Corrige problema de acentuação
		

		// inicio do codigo html imbutido no servlet -- LEGAL NÉ? HEHEHEHE
		RequestDispatcher dispatcherheader = request.getRequestDispatcher("/header");
		dispatcherheader.include(request, response);
		//Inclui o Menu
	    
		RequestDispatcher dispatchermenu = request.getRequestDispatcher("/menu");
		dispatchermenu.include(request, response);
		out.println("        <div class=\"span8\">");
	    out.println("           <h2>Bem vindo ao SysBol</h2>");		
		out.println("        </div>");
		
		//Inclue Rodape
		RequestDispatcher dispatcherfooter = request.getRequestDispatcher("/footer");
		dispatcherfooter.include(request, response);
	}

}
