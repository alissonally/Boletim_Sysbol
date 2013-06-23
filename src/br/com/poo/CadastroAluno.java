package br.com.poo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CadastroAluno extends HttpServlet {
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
		out.println("<div class=\"span8\"><form class=\"form-horizontal\" action=\"CadAluno\" method=\"post\">"+
                "<div class=\"control-group\">"+
                  "<label class=\"control-label\" for=\"nome\">Nome</label>"+
                  "<div class=\"controls\">"+
                    "<input type=\"text\" name=\"nome\" id=\"nome\" placeholder=\"Nome do aluno\">"+
                  "</div>"+
                "</div>"+
                "<div class=\"control-group\">"+
                  "<label class=\"control-label\" for=\"mae\">Mãe</label>"+
                  "<div class=\"controls\">"+
                    "<input type=\"text\" name=\"mae\" id=\"carga\" placeholder=\"No da mâe\">"+
                  "</div>"+
                "</div>"+
                "<div class=\"control-group\">"+
                  "<label class=\"control-label\" for=\"dtnascimento\">Data nascimento</label>"+
                  "<div class=\"controls\">"+
                    "<input type=\"text\" name=\"dtnascimento\" id=\"dtnascimento\" class=\"data\" placeholder=\"Data nascimento\">"+
                  "</div>"+
                "</div>"+
                "<div class=\"control-group\">"+
                  "<label class=\"control-label\" for=\"cpf\">CPF</label>"+
                  "<div class=\"controls\">"+
                    "<input type=\"text\" name=\"cpf\" id=\"cpf\" class=\"cpf\" placeholder=\"CPF\">"+
                  "</div>"+
                "</div>"+
                "<div class=\"control-group\">"+
                  "<label class=\"control-label\" for=\"rg\">RG</label>"+
                  "<div class=\"controls\">"+
                    "<input type=\"text\" name=\"rg\" id=\"rg\" placeholder=\"RG\">"+
                  "</div>"+
                "</div>"+
                "<div class=\"control-group\">"+
                  "<label class=\"control-label\" for=\"endereco\">Endereco</label>"+
                  "<div class=\"controls\">"+
                    "<input type=\"text\" name=\"endereco\" id=\"endereco\" placeholder=\"Endereco\">"+
                  "</div>"+
                "</div>"+
                "<div class=\"control-group\">"+
                  "<label class=\"control-label\" for=\"cidade\">Cidade</label>"+
                  "<div class=\"controls\">"+
                    "<input type=\"text\" name=\"cidade\" id=\"cidade\" placeholder=\"Cidade\">"+
                  "</div>"+
                "</div>"+
                "<div class=\"control-group\">"+
                  "<label class=\"control-label\" for=\"cep\">CEP</label>"+
                  "<div class=\"controls\">"+
                    "<input type=\"text\" name=\"cep\" id=\"cep\" class=\"cep\" placeholder=\"CEP\">"+
                  "</div>"+
               " </div>"+
                "<div class=\"control-group\">"+
                  "<label class=\"control-label\" for=\"estado\">Estado</label>"+
                  "<div class=\"controls\">"+
                    "<select name=\"estado\" class=\"input\">"+
                        "<option value=\"\">Selecione o Estado</option>"+
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
                    "<input type=\"text\" name=\"telefone\" id=\"telefone\" class=\"fone\" placeholder=\"Telefone\">"+
                  "</div>"+
                "</div>"+
                "<div class=\"control-group\">"+
                  "<label class=\"control-label\" for=\"estado\">Sexo</label>"+
                  "<div class=\"controls\">"+
                   "<label class=\"radio\">"+
                     "<input type=\"radio\" name=\"sexo\" id=\"sexo\" value=\"m\">Masculino   </label>"+
                  "<label class=\"radio\"><input type=\"radio\" name=\"sexo\" id=\"sexo\" value=\"f\"> Feminino</label>"+
                  "</div>"+
                "</div>"+
                "<div class=\"control-group\">"+
                  "<div class=\"controls\">"+
                    "<button type=\"submit\" class=\"btn\">Cadastrar</button>"+
                  "</div>"+
                "</div>"+
              "</form></div>");
	    
		
		//Inclue Rodape
		RequestDispatcher dispatcherfooter = request.getRequestDispatcher("/footer");
		dispatcherfooter.include(request, response);
	}

}

