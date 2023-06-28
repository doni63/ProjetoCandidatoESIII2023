<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="dominio.Candidato"%>
<%@ page import="dominio.Curso"%>
<%@ page import="viewHelper.CursoList"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%
CursoList c = new CursoList();
List<Curso> lista = c.getCursos();
%>
<%
String msg = (String)request.getAttribute("mensagem");
%>
<%
	String id ="";
	String nome ="";
	String pai ="";
	String mae ="";
	String residencial ="";
	String celular ="";
	String recado ="";
	String logradouro ="";
	String numero ="";
	String cep ="";
	String cidade ="";
	String estado ="";
	String curso1 ="";
	String curso2 ="";
	String curso3 ="";
	String data = "";
	String idEndereco = "";

   if(!(request.getParameter("id")==null)){
	   id = request.getParameter("id");
   }
   
   if(!(request.getParameter("nome")==null)){
	   nome = request.getParameter("nome");
   }
   
   if(!(request.getParameter("pai")==null)){
	   pai = request.getParameter("pai");
   }
   
   if(!(request.getParameter("mae")==null)){
	   mae =request.getParameter("mae");
   }
   
   if(!(request.getParameter("residencial")==null)){
	   residencial = request.getParameter("residencial");
   }
   
   
   if(!(request.getParameter("celular")==null)){
	   celular = request.getParameter("celular");
   }
   
   
   if(!(request.getParameter("recado")==null)){
	   recado = request.getParameter("recado");
   }
   
   if(!(request.getParameter("logradouro")==null)){
	   logradouro = request.getParameter("logradouro");
   }
   
   
   if(!(request.getParameter("numero")==null)){
	   numero = request.getParameter("numero");
   }
   if(!(request.getParameter("cep")==null)){
	   cep = request.getParameter("cep");
   }
   
   if(!(request.getParameter("cidade")==null)){
	   cidade = request.getParameter("cidade");
   }
   
   if(!(request.getParameter("estado")==null)){
	   estado = request.getParameter("estado");
   }
   
   if(!(request.getParameter("curso1")==null)){
	   curso1 = request.getParameter("curso1");
   }
   
   if(!(request.getParameter("curso2")==null)){
	   curso2 = request.getParameter("curso2");
   }
   
   if(!(request.getParameter("curso3")==null)){
	   curso3 = request.getParameter("curso3");
   }
   
   if(!(request.getParameter("data")==null)){
	   data = request.getParameter("data");
   }
   
   if(!(request.getParameter("idEndereco")==null)){
	   idEndereco = request.getParameter("idEndereco");
   }
   
   // Faça a manipulação do objeto conforme necessário
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Editar Candidato</title>
</head>
<body>
	<h1>Editar Candidato</h1>
	<a href="index.html">Home</a>
	<form name="frmCandidato" action="editarCandidato">
		<table>
		
			<tr><td>ID Candidato:<input type="text" name="id" readonly="readonly" value="<%out.println(id);%>"></td></tr>
			<tr><td>Nome:<input type="text" name="nomeCandidato" placeholder="Nome" value="<%out.println(nome);%>"> </td></tr>
			<tr><td>Pai:<input type="text" name="nomePai" placeholder="Filiação-Pai" value="<%out.println(pai);%>"> </td></tr>
			<tr><td>Mãe:<input type="text" name="nomeMae" placeholder="Filiação-Mãe" value="<%out.println(mae);%>"> </td></tr>
			<tr><td>Residencial:<input type="text" name="telefoneResidencial" placeholder="Tel. Residencial" value="<%out.println(residencial);%>"> </td></tr>
			<tr><td>Celular:<input type="text" name="celular" placeholder="Celular" value="<%out.println(celular);%>"> </td></tr>
			<tr><td>Recado:<input type="text" name="telefoneRecado" placeholder="Tel.Recado" value="<%out.println(recado);%>"> </td></tr>
			<tr><td>Logradouro:<input type="text" name="logradouro" placeholder="Logradouro" value="<%out.println(logradouro);%>"> </td></tr>
			<tr><td>Número:<input type="text" name="numero" placeholder="Número" value="<%out.println(numero);%>"> </td> </tr>
			<tr><td>CEP:<input type="text" name="cep" placeholder="CEP" value="<%out.println(cep);%>"> </td> </tr>
			<tr><td>Cidade:<input type="text" name="cidade" placeholder="Cidade" value="<%out.println(cidade);%>"> </td></tr>
			<tr><td>Estado:<input type="text" name="estado" placeholder="Estado" value="<%out.println(estado);%>"> </td> </tr>
			
			<tr>
  <td>Curso Principal:
    <select name="CursoInteresse" id="CursoInteresse">
      <option value='0'></option>
      <% 

      // Itera sobre a lista de cursos e cria as opções
      for (Curso curso : lista) { %>
        <option value="<%= curso.getId() %>"><%= curso.getDescricao() %></option>
      <%}%>
    </select>
  </td>
</tr>

<tr>
  <td>Curso Alternativa 1:
    <select name="curso2" id="curso2">
      <option value='0'></option>
      <% 

      // Itera sobre a lista de cursos e cria as opções
      for (Curso curso : lista) { %>
        <option value="<%= curso.getId() %>"><%= curso.getDescricao() %></option>
      <%}%>
    </select>
  </td>
</tr>

<tr>
  <td>Curso Alternativa 2:
    <select name="curso3" id="curso3">
      <option value='0'></option>
      <% 

      // Itera sobre a lista de cursos e cria as opções
      for (Curso curso : lista) { %>
        <option value="<%= curso.getId() %>"><%= curso.getDescricao() %></option>
      <%}%>
    </select>
  </td>
</tr>
			<tr><td>Data Cadastro:<input type="text" name="dataCadastro" readonly="readonly" value="<%out.println(data);%>"> </td> </tr>
			<tr><td>ID Endereço:<input type="text" name="idEndereco" readonly="readonly" value="<%out.println(idEndereco);%>"> </td> </tr>		
		</table>
		<input type="submit" name ="operacao" value="Editar Candidato">
		<% if (!(msg==null)){out.println(msg);} %>
	</form>
	<script src="./script.js"></script>
</body>
</html>