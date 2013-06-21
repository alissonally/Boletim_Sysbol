package br.com.poo;

import java.io.IOException;
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
			response.sendRedirect("ListaAluno");

		}catch(Exception e){
			e.printStackTrace();
		}



	}

}
