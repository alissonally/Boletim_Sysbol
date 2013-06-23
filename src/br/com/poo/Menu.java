package br.com.poo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Menu extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param args
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=UTF-8");//Corrige problema de acentuação
		// Menu Genérico
		out.println("        <div class=\"span2\">");
		out.println("            <ul class=\"nav nav-tabs nav-stacked\">");
		out.println("                <li><a href=\"/servletsPOO\">Início<i class=\"icon-chevron-right\"></i></a></li>");
		out.println("                <li><a href=\"/servletsPOO/cadastrar\">Cadastrar Aluno<i class=\"icon-chevron-right\"></i></a></li>");
		out.println("                <li><a href=\"/servletsPOO/lista\">Listar Alunos<i class=\"icon-chevron-right\"></i></a></li>");
		out.println("           </ul>");
		out.println("        </div>");
	}

}
