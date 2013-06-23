package br.com.poo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.conexao.Banco;

public class AtualizaAluno extends HttpServlet {


	private static final long serialVersionUID = 731982001564061951L;

	/**
	 *
	 */
	

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		Banco banco;
		try {
			String sql = "UPDATE  aluno SET nmAluno=?,endereco=?,cidade=?,estado=?,CEP=?,dtNascimento=?,CPF=?,nmMae=?,"
					+ "telefone=?,RG=?,SEXO=? WHERE idAluno="+request.getParameter("idAluno");
			banco = new Banco();

			//criando o statement para inserir os dados do aluno no banco
			PreparedStatement ps = banco.getConexao().prepareStatement(sql);

			ps.setString(1, request.getParameter("nome"));
			ps.setString(2, request.getParameter("endereco"));
			ps.setString(3, request.getParameter("cidade"));
			ps.setString(4, request.getParameter("estado"));
    
			//nesse caso a mascara manda tudo inclusive os caracteres que queremos desprezar.
			// é necessario removelos do texto. usando o replace
			ps.setString(5, request.getParameter("cep").replace(".", "").replace("-", "").trim());

			// Mudança do formato da data para o que é reconhecido no mysql
			Date data = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("dtnascimento"));
			String dataBanco = new SimpleDateFormat("yyyy-MM-dd").format(data);
			ps.setString(6, dataBanco);

			//nesse caso a mascara manda tudo inclusive os caracteres que queremos desprezar.
			// é necessario removelos do texto. usando o replace
			ps.setString(7, request.getParameter("cpf").replace(".", "").replace("-", "").trim());
			ps.setString(8, request.getParameter("mae"));

			//nesse caso a mascara manda tudo inclusive os caracteres que queremos desprezar.
			// é necessario removelos do texto. usando o replace
			ps.setString(9, request.getParameter("telefone").replace(")", "").replace("(", "").replace("-", "").trim());
			ps.setString(10, request.getParameter("rg"));
			ps.setString(11, request.getParameter("sexo"));
			ps.executeUpdate();

			ps.close();

			//redireciona o controle da pagina para a LISTA DE ALUNOS
			response.sendRedirect("lista");
		}catch(Exception e){
			out.println(e.getMessage());
			out.println("<br />"+request.getParameter("rg"));
			//this.nconfirm();
			//out.println(e.getStackTrace());
			//e.printStackTrace();
			//out.println("<div class=\"alert alert-error\">Erro ao excluir aluno<a class=\"close\" data-dismiss=\"alert\" href=\"#\">&times;</a></div>");
		}
	}

}
