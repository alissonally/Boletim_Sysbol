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

import br.com.classes.Recebedados;
import br.com.conexao.Banco;

public class EditarAluno extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6195178479688718226L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=UTF-8");//Corrige problema de acentuação
		// inclue o cabecalho
		RequestDispatcher dispatcherheader = request.getRequestDispatcher("/header");
		dispatcherheader.include(request, response);
		
		//Inclue o Menu
		RequestDispatcher dispatchermenu = request.getRequestDispatcher("/menu");
		dispatchermenu.include(request, response);
		out.println("<div class=\"span8\">");
		//out.println(request.getParameter("idaluno"));
		try{
			Banco banco = new Banco();
			Recebedados dado = new Recebedados();
			//comando de sql para selecao dos itens
			String sql = "select * from aluno where idAluno="+request.getParameter("idaluno");
			

			ResultSet rs = (ResultSet) banco.getStatement().executeQuery(sql);

			//alteracao do formato da data do formato yyyy-mm-dd
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

			// INSTRUÇÃO DE REPETIÇÃO PARA ALIMENTAR OS DADOS DA TABELA COM O RESULTADO OBTIDO NO BANCO
			
			while (rs.next()) {
			
			//popula dados
				
			dado.setNomeAluno(rs.getString("nmAluno"));	
			dado.setNomeMae(rs.getString("nmMae"));	        
			dado.setDtNascimento(rs.getDate("dtNascimento"));
			dado.setCEP(rs.getString("CEP"));
			dado.setCidade(rs.getString("cidade"));
			dado.setEndereco(rs.getString("endereco"));
			dado.setEstado(rs.getString("estado"));
			dado.setCPF(rs.getString("CPF"));
			dado.setRG(rs.getString("RG"));
			dado.setTelefone(rs.getString("telefone"));
			dado.setSexo(rs.getString("sexo"));
			
			out.println("teste <br />");
			if(dado.getSexo()=="m"){
				out.println("Macho");
			}
			if(dado.getSexo()=="f"){
				out.println("femea");
			}
			
			out.println("<form class=\"form-horizontal\" action=\"atualiza\" method=\"post\">"+
					"<input type=\"hidden\" name=\"idAluno\" value=\""+rs.getString("idAluno")+"\">"+
	                "<div class=\"control-group\">"+
	                  "<label class=\"control-label\" for=\"nome\">Nome</label>"+
	                  "<div class=\"controls\">"+
	                    "<input type=\"text\" name=\"nome\" id=\"nome\" value=\""+dado.getNomeAluno()+"\">" +	                    
	                  "</div>"+
	                "</div>"+
	                "<div class=\"control-group\">"+
	                  "<label class=\"control-label\" for=\"mae\">Mãe</label>"+
	                  "<div class=\"controls\">"+
	                    "<input type=\"text\" name=\"mae\" id=\"carga\" value=\""+dado.getNomeMae()+"\">"+
	                  "</div>"+
	                "</div>"+
	                "<div class=\"control-group\">"+
	                  "<label class=\"control-label\" for=\"dtnascimento\">Data nascimento</label>"+
	                  "<div class=\"controls\">"+
	                    "<input type=\"text\" name=\"dtnascimento\" id=\"dtnascimento\" class=\"data\" value="+format.format(dado.getDtNascimento())+">"+
	                  "</div>"+
	                "</div>"+
	                "<div class=\"control-group\">"+
	                  "<label class=\"control-label\" for=\"cpf\">CPF</label>"+
	                  "<div class=\"controls\">"+
	                    "<input type=\"text\" name=\"cpf\" id=\"cpf\" class=\"cpf\" value=\""+dado.getCPF()+"\">"+
	                  "</div>"+
	                "</div>"+
	                "<div class=\"control-group\">"+
	                  "<label class=\"control-label\" for=\"rg\">RG</label>"+
	                  "<div class=\"controls\">"+
	                    "<input type=\"text\" name=\"rg\" id=\"rg\" value=\""+dado.getRG()+"\">"+
	                  "</div>"+
	                "</div>"+
	                "<div class=\"control-group\">"+
	                  "<label class=\"control-label\" for=\"endereco\">Endereco</label>"+
	                  "<div class=\"controls\">"+
	                    "<input type=\"text\" name=\"endereco\" id=\"endereco\" value=\""+dado.getEndereco()+"\">"+
	                  "</div>"+
	                "</div>"+
	                "<div class=\"control-group\">"+
	                  "<label class=\"control-label\" for=\"cidade\">Cidade</label>"+
	                  "<div class=\"controls\">"+
	                    "<input type=\"text\" name=\"cidade\" id=\"cidade\" value=\""+dado.getCidade()+"\">"+
	                  "</div>"+
	                "</div>"+
	                "<div class=\"control-group\">"+
	                  "<label class=\"control-label\" for=\"cep\">CEP</label>"+
	                  "<div class=\"controls\">"+
	                    "<input type=\"text\" name=\"cep\" id=\"cep\" class=\"cep\" value=\""+dado.getCEP()+"\">"+
	                  "</div>"+
	               " </div>"+
	                "<div class=\"control-group\">"+
	                  "<label class=\"control-label\" for=\"estado\">Estado</label>"+
	                  "<div class=\"controls\">"+
	                    "<select name=\"estado\" class=\"input\">"+
	                        "<option value=\""+dado.getEstado()+"\">"+dado.getEstado()+"</option>"+
	                        "<option value=\"AC\">Acre</option>"+
	                        "<option value=\"AL\">Alagoas</option>"+
	                        "<option value=\"AP\">Amapá</option>"+
	                        "<option value=\"AM\">Amazonas</option>"+
	                        "<option value=\"BA\">Bahia</option>"+
	                        "<option value=\"CE\">Ceará</option>"+
	                        "<option value=\"DF\">Distrito Federal</option>"+
	                        "<option value=\"ES\">Espirito Santo</option>"+
	                        "<option value=\"GO\">Goiás</option>"+
	                        "<option value=\"MA\">Maranhão</option>"+
	                        "<option value=\"MS\">Mato Grosso do Sul</option>"+
	                        "<option value=\"MT\">Mato Grosso</option>"+
	                        "<option value=\"MG\">Minas Gerais</option>"+
	                        "<option value=\"PA\">Pará</option>"+
	                        "<option value=\"PB\">Paraíba</option>"+
	                        "<option value=\"PR\">Paraná</option>"+
	                        "<option value=\"PE\">Pernambuco</option>"+
	                        "<option value=\"PI\">Piauí</option>"+
	                        "<option value=\"RJ\">Rio de Janeiro</option>"+
	                        "<option value=\"RN\">Rio Grande do Norte</option>"+
	                        "<option value=\"RS\">Rio Grande do Sul</option>"+
	                        "<option value=\"RO\">Rondônia</option>"+
	                        "<option value=\"RR\">Roraima</option>"+
	                        "<option value=\"SC\">Santa Catarina</option>"+
	                        "<option value=\"SP\">São Paulo</option>"+
	                        "<option value=\"SE\">Sergipe</option>"+
	                        "<option value=\"TO\">Tocantins</option>"+
	                    "</select>"+
	                  "</div>"+
	                "</div>"+
	                "<div class=\"control-group\">"+
	                  "<label class=\"control-label\" for=\"telefone\">Telefone</label>"+
	                  "<div class=\"controls\">"+
	                    "<input type=\"text\" name=\"telefone\" id=\"telefone\" class=\"fone\" value=\""+dado.getTelefone()+"\">"+
	                  "</div>"+
	                "</div>"+
	                "<div class=\"control-group\">"+
	                  "<label class=\"control-label\" for=\"estado\">Sexo</label>"+
	                  "<div class=\"controls\">"+
	                   "<label class=\"radio\">"+
	                     "<input type=\"radio\" name=\"sexo\" id=\"sexo\" value=\"m\" "+dado.getCheckdM()+">Masculino</label>"+
	                  "<label class=\"radio\">" +
	                     "<input type=\"radio\" name=\"sexo\" id=\"sexo\" value=\"f\" "+dado.getCheckdF()+">Feminino</label>"+
	                  "</div>"+
	                "</div>"+
	                "<div class=\"control-group\">"+
	                  "<div class=\"controls\">"+
	                    "<button type=\"submit\" class=\"btn\">Cadastrar</button>"+
	                  "</div>"+
	                "</div>"+
	              "</form>");
			}
		}catch(Exception e){
			out.println(e.getMessage());
		}
		out.println("</div>");
		//Inclue Rodape
		RequestDispatcher dispatcherfooter = request.getRequestDispatcher("/footer");
		dispatcherfooter.include(request, response);
	}
	// TODO Auto-generated constructor stub
}
