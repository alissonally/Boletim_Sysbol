package br.com.poo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.conexao.Banco;

public class ListaAluno extends HttpServlet {

	/**
	 *
	 */
	private static final long serialVersionUID = 4315449461496798580L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {

		try{
		Banco banco = new Banco();

		//comando de sql para selecao dos itens
		String sql = "select idAluno,nmAluno,dtNascimento from aluno order by nmAluno";


		ResultSet rs = (ResultSet) banco.getStatement().executeQuery(sql);

		//alteracao do formato da data do formato yyyy-mm-dd
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");


		PrintWriter out = response.getWriter();
		
		//Corrige problema de acentuação
		response.setContentType("text/html;charset=UTF-8"); 

		// inicio do codigo html imbutido no servlet -- LEGAL NÉ? HEHEHEHE
		out.println("<!DOCTYPE HTML>");
		out.println("<html lang=\"pt-BR\">");
		out.println("<head>");
		out.println("    <meta charset=\"UTF-8\">");
		out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
		out.println("    <title>Academico  </title>");
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
		out.println("        <div class=\"span2\">");
		out.println("            <ul class=\"nav nav-tabs nav-stacked\">");
		out.println("                <li><a href=\"#\">Cadastrar Aluno<i class=\"icon-chevron-right\"></i></a></li>");
		out.println("               <li><a href=\"#\">Cadastrar Disciplina<i class=\"icon-chevron-right\"></i></a></li>");
		out.println("                <li><a href=\"#\">Cadastrar Professor<i class=\"icon-chevron-right\"></i></a></li>");
		out.println("                <li><a href=\"#\">Cadastrar Notas<i class=\"icon-chevron-right\"></i></a></li>");
		out.println("           </ul>");
		out.println("        </div>");
		out.println("        <div class=\"span8\">");
		out.println("        	<table class=\"table table-bordered table-hover\" >");
		out.println("        		<tr >");
		out.println("        			<th>Nome Aluno</th>");
		out.println("        			<th>Data Nascimento</th>");
		out.println("        			<th>Ação</th>");
		out.println("        		</tr>");


		// INSTRUÇÃO DE REPETIÇÃO PARA ALIMENTAR OS DADOS DA TABELA COM O RESULTADO OBTIDO NO BANCO
		while (rs.next()) {
			out.println("        		<tr>");
			out.println("        			<td>"+rs.getString("nmAluno")+"</td>");
			out.println("        			<td>"+format.format(rs.getDate("dtNascimento"))+"</td>");
			out.println("        			<td><a href=\"/servletsPOO/DeletaAluno?idAluno="+rs.getString("idAluno")+"\">Deleta</a></td>");
			out.println("        		</tr>");
		}

		out.println("        	</table>");
		out.println("        </div>");
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
		out.println("<script src=\"js/functions.js\" type=\"text/javascript\"></script>");
		out.println("</html>");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	// TODO Auto-generated constructor stub

}
