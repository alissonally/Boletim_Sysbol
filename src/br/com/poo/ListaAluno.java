package br.com.poo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.conexao.Banco;

public class ListaAluno extends HttpServlet {

	/**
	 *
	 */
	private static final long serialVersionUID = 4315449461496798580L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String success = (String) session.getAttribute("success");
		String erro = (String) session.getAttribute("erro");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=UTF-8");//Corrige problema de acentuação
		// inclue cabeçalho
		RequestDispatcher dispatcherheader = request.getRequestDispatcher("/header");
		dispatcherheader.include(request, response);
		//Inclui o Menu
	    
		RequestDispatcher dispatchermenu = request.getRequestDispatcher("/menu");
		dispatchermenu.include(request, response);
		try{
		Banco banco = new Banco();

		//comando de sql para selecao dos itens
		String sql = "select idAluno,nmAluno,dtNascimento from aluno order by nmAluno";


		ResultSet rs = (ResultSet) banco.getStatement().executeQuery(sql);

		//alteracao do formato da data do formato yyyy-mm-dd
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");


		out.println("        <div class=\"span8\">");
		out.println("            <div id=\"msg\"></div>");
		out.println(          success !=null ? success :"" );
		out.println(          erro !=null ? erro :"" );
		out.println("        	<table class=\"table table-bordered table-hover\" >");
		out.println("        		<tr >");
		out.println("        			<th>Aluno</th>");
		out.println("        			<th>Data de Nascimento</th>");
		out.println("        			<th>Ação</th>");
		out.println("        		</tr>");


		// INSTRUÇÃO DE REPETIÇÃO PARA ALIMENTAR OS DADOS DA TABELA COM O RESULTADO OBTIDO NO BANCO
		while (rs.next()) {
			out.println("        		<tr id="+rs.getString("idAluno")+">");
			out.println("        			<td>"+rs.getString("nmAluno")+"</td>");
			out.println("        			<td>"+format.format(rs.getDate("dtNascimento"))+"</td>");
			out.println("        			<td><a href=\"javascript:void(0)\" onclick=\"javascript:deletar("+rs.getString("idAluno")+")\"><i class=\"icon-remove\"></i>Deleta</a> | "+
											"<a href=\"/servletsPOO/editaraluno?idaluno="+rs.getString("idAluno")+"\"><i class=\"icon-pencil\"></i>Editar</a></td>");
			out.println("        		</tr>");
			out.println("        		<tr id="+rs.getString("idAluno")+"_rows>");
			out.println("        		</tr>");
		}
		out.println("        	</table>");
		out.println("        </div>");
		session.removeAttribute("success");
		session.removeAttribute("erro");

		}catch(Exception e){
			e.printStackTrace();
		}
		//Inclue Rodape
		RequestDispatcher dispatcherfooter = request.getRequestDispatcher("/footer");
		dispatcherfooter.include(request, response);
	}
	// TODO Auto-generated constructor stub

}
