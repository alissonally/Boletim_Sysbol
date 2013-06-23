package br.com.poo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.conexao.Banco;

public class DeletaAluno extends HttpServlet {

	/**
	 *
	 */
	private static final long serialVersionUID = 7907305766333805680L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {
			//comando de sql para exclusao do dado
			String sql = "delete from aluno where idAluno=?";
			Banco banco = new Banco();

			//criando o statement para inserir os dados do aluno no banco
			PreparedStatement ps = banco.getConexao().prepareStatement(sql);

			ps.setString(1,request.getParameter("idAluno"));

			ps.executeUpdate();

			ps.close();

			//chama a lista de alunos atualizada
			//response.sendRedirect("lista");
			out.println(1);
		}catch(Exception e){
			out.println(0);
			//this.nconfirm();
			//out.println(e.getStackTrace());
			//e.printStackTrace();
			//out.println("<div class=\"alert alert-error\">Erro ao excluir aluno<a class=\"close\" data-dismiss=\"alert\" href=\"#\">&times;</a></div>");
		}
	}

}
